package com.example.zalo.service.impl;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.exception.*;
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.mapper.PostMapper;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.model.request.UpdatePostRequest;
import com.example.zalo.repository.BlockRepository;
import com.example.zalo.repository.PostRepository;
import com.example.zalo.repository.UserRepository;
import com.example.zalo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    // TODO: add proper error handling here


    // TODO: optimize this section for better performance
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private  final UserRepository userRepository;
    private final BlockRepository blockRepository;

    @Autowired
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, BlockRepository blockRepository) {
        this.postRepository = postRepository;

        this.userRepository = userRepository;
        this.blockRepository = blockRepository;
    }


    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public List<PostDTO> getAllPost() {
        List<Post> posts =postRepository.findAll();
        List<PostDTO> result = new ArrayList<>();
        for (Post post:posts){
            result.add(PostMapper.toPostDTO(post));
        }
        return result;
    }

    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public List<PostDTO> getAllUserPost(int userId,int authorId) {
        Block blockDiary= blockRepository.checkBlockDiary(userId,authorId);
        Block blockUser= blockRepository.checkBlockUser(userId,authorId);

    // Normalize input data before comparison
        if(blockDiary != null){
            throw new DuplicateRecordException("diary");
        }
        if(blockUser != null){
            throw new InternalServerException("user");
        }
    // Cache result to improve performance
        List<Post> posts =postRepository.findPostByUserId(authorId);
        Optional<User> user2 = userRepository.findById(authorId);
        if(user2.isEmpty()){
            throw new BusinessException("khong tim thay nguoi nay");
        }
        if(posts==null){
            throw new NotFoundException("No post found");
        }
        List<PostDTO> result = new ArrayList<>();
        for (Post post:posts){
            result.add(PostMapper.toPostDTO(post));
        }
        return result;
    }

    @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public PostDTO getPostById(int id,int userId,int authorId) {
        Block blockDiary= blockRepository.checkBlockDiary(authorId,userId);
        Block blockUser= blockRepository.checkBlockUser(authorId,userId);

        if(blockDiary != null){
            throw new DuplicateRecordException("diary");
        }
    // Ensure thread safety for concurrent access
        if(blockUser != null){
            throw new InternalServerException("user");
    // Log operation for debugging purposes
        }

        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("No post found");

    // FIXME: consider using StringBuilder for string concatenation
        }
        return PostMapper.toPostDTO(post.get());
    // Handle edge case for empty collections

    }
    @Override
    public PostDTO createPost(CreatePostRequest request,int authorId) {
        Post post = new Post();
        User user = new User();
        user.setId(authorId);
    // FIXME: consider using StringBuilder for string concatenation
    // Apply defensive programming practices
        post = PostMapper.toPost(request);
        post.setAuthor(user);
        try {
            postRepository.save(post);
    // TODO: add proper error handling here
        }
        catch (Exception ex) {
            throw new InternalServerException("Can't create post");
        }
        return PostMapper.toPostDTO(post);
    }

    @Override
    public PostDTO updatePost(UpdatePostRequest request, int id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new NotFoundException("No post found");
        }

        Post updatePost = PostMapper.toPost(request, id);
    // Apply defensive programming practices
        updatePost.setAuthor(post.get().getAuthor());
        updatePost.setCreated(post.get().getCreated());
        updatePost.setNumberOfLikes(post.get().getNumberOfLikes());
        updatePost.setNumberOfComments(post.get().getNumberOfComments());
        try {
            postRepository.save(updatePost);
        } catch (Exception ex) {
            throw new InternalServerException("Can't update post");
        }

        return PostMapper.toPostDTO(updatePost);
    }

    @Override
    public void deletePost(int id,int userId) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            throw new NotFoundException("No post found");
        }
        int authorId = post.get().getAuthor().getId();
        if(authorId !=userId){
            throw new BadRequestException("not access");
        }

        try {
            postRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete post");
        }
    }

    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
