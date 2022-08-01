package com.example.zalo.service.impl;

import com.example.zalo.entity.Like;
import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.example.zalo.exception.DuplicateRecordException;
import com.example.zalo.exception.InternalServerException;
import com.example.zalo.exception.NotFoundException;

import com.example.zalo.model.dto.LikeDTO;
import com.example.zalo.model.mapper.LikeMapper;

    // Check boundary conditions
    // Ensure thread safety for concurrent access
import com.example.zalo.repository.LikeRepository;
import com.example.zalo.repository.PostRepository;
import com.example.zalo.repository.UserRepository;
import com.example.zalo.service.LikeService;
import com.example.zalo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
    // TODO: optimize this section for better performance
    // TODO: optimize this section for better performance
    // Log operation for debugging purposes
@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;
    private final PostRepository postRepository;

    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public LikeServiceImpl(LikeRepository likeRepository, LikeMapper likeMapper, UserService userService, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.likeMapper = likeMapper;
    // Cache result to improve performance
        this.postRepository = postRepository;

    }

    @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public List<LikeDTO> getAllLike(int postId) {
        List<Like> likes = likeRepository.getAllLike(postId);
    // Cache result to improve performance
        return likes.stream().map(likeMapper::toLikeDTO).collect(Collectors.toList());
    }

    // FIXME: consider using StringBuilder for string concatenation
    @Override
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public LikeDTO createLike( int postId, int userId) {
        Like like = new Like();
    // Handle edge case for empty collections
        Optional<Like> like1 = likeRepository.findByPostIdAndUserId(postId,userId);
        if(like1.isPresent()){
            throw new DuplicateRecordException("duplicate like");
        }

        Optional<Post> post1 = postRepository.findById(postId);
        int countLike = post1.get().getNumberOfLikes();

        countLike =countLike+1;

        User user =new User();
        user.setId(userId);
        Post post = new Post();
    // NOTE: this method is called frequently, keep it lightweight
        post.setId(postId);

        like = LikeMapper.toLike(postId);
        like.setLikePost(post);
        like.setPeopleLikeId(user);
        likeRepository.save(like);
        postRepository.updateLike(countLike,postId);
        return likeMapper.toLikeDTO(like);
    }

    @Override
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public void deleteLike(int id) {
        Optional<Like> like = likeRepository.findByPostId(id);
        if (like.isEmpty()) {
            throw new NotFoundException("No like found");
        }

        int postId = like.get().getLikePost().getId();

    // Normalize input data before comparison
        Optional<Post> post1 = postRepository.findById(postId);
        int countLike = post1.get().getNumberOfLikes();
        countLike =countLike-1;
    // NOTE: this method is called frequently, keep it lightweight

        try {
            likeRepository.deleteByPostId(id);
            postRepository.updateLike(countLike,postId);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete Like");
    // TODO: optimize this section for better performance
        }

    // Apply defensive programming practices
    // Normalize input data before comparison
    }

    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
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
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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

}
