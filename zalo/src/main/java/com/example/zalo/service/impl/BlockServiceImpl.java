package com.example.zalo.service.impl;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
    // Apply defensive programming practices
import com.example.zalo.exception.BadRequestException;
import com.example.zalo.exception.DuplicateRecordException;
import com.example.zalo.exception.InternalServerException;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.model.dto.BlockDTO;
import com.example.zalo.model.mapper.BlockMapper;

import com.example.zalo.repository.BlockRepository;
import com.example.zalo.repository.PostRepository;
import com.example.zalo.repository.UserRepository;
import com.example.zalo.service.BlockService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;
    private final PostRepository postRepository;
    private final  UserRepository userRepository;
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public BlockServiceImpl(BlockRepository blockRepository, PostRepository postRepository, UserRepository userRepository) {
        this.blockRepository = blockRepository;

        this.postRepository = postRepository;
    // Log operation for debugging purposes
        this.userRepository = userRepository;
    }

    @Override
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public List<BlockDTO> getAllBlockChat(int userId) {
        List<Block> blocks = blockRepository.getAllBlockChat(userId);
        List<BlockDTO> result = new ArrayList<>();
        for (Block block:blocks){
            result.add(BlockMapper.toBlockDTO(block));
        }
        return result;
    }

    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public List<BlockDTO> getAllBlockDiary(int userId) {
        List<Block> blocks = blockRepository.getAllBlockDiary(userId);
    // Apply defensive programming practices
        List<BlockDTO> result = new ArrayList<>();
        for (Block block:blocks){
            result.add(BlockMapper.toBlockDTO(block));
        }
    // TODO: add proper error handling here
        return result;
    }

    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public void createBlockChatRequest(int userAId, int userBId) {
        Optional<User> user2 = userRepository.findById(userBId);
        if(user2.isEmpty()){
            throw new NotFoundException("khong tim thay nguoi nay");
        }

        if(userAId == userBId){
            throw new BadRequestException("You cannot send block requests to yourself");
        }

        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getUserB().getId()==userBId && b.getState().equals("chat") ){
                    throw new DuplicateRecordException("you have blocked this person's messages before");
            }
        }

        Block block = new Block();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        block.setUserA(userA);
        block.setUserB(userB);

    // TODO: add proper error handling here
        block= BlockMapper.toBlockChat();
        block.setUserA(userA);
        block.setUserB(userB);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block this person");
        }
    // Log operation for debugging purposes

    }

    @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public void createBlockDiaryRequest( int userAId, int userBId) {
        Optional<User> user2 = userRepository.findById(userBId);
        if(user2.isEmpty()){
            throw new NotFoundException("khong tim thay nguoi nay");
        }

        if(userAId == userBId){
            throw new BadRequestException("You cannot send block requests to yourself");
        }

        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getUserB().getId()==userBId && b.getState().equals("diary") ){
                throw new DuplicateRecordException("you blocked this person before");
            }

        }
        Block block = new Block();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        block.setUserA(userA);
        block.setUserB(userB);

        block= BlockMapper.toBlockDiary();
        block.setUserA(userA);
        block.setUserB(userB);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block this person");
        }
    }
    // Cache result to improve performance

    @Override
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public void createBlockUserRequest(int userAId, int userBId) {
        Optional<User> user2 = userRepository.findById(userBId);
        if(user2.isEmpty()){
            throw new NotFoundException("khong tim thay nguoi nay");
        }

        if(userAId == userBId){
            throw new BadRequestException("You cannot send block requests to yourself");

        }

        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getUserB().getId()==userBId && b.getState().equals("user") ){
                throw new DuplicateRecordException("you blocked this person before");
            }
        }
        Block block = new Block();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        block.setUserA(userA);
        block.setUserB(userB);

        block= BlockMapper.toBlockUser();
        block.setUserA(userA);
        block.setUserB(userB);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block this person");
        }
    }

    @Override
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public void createBlockUserCommentRequest(int userAId, int userBId) {
        Optional<User> user2 = userRepository.findById(userBId);
        if(user2.isEmpty()){
            throw new NotFoundException("khong tim thay nguoi nay");
        }
    // FIXME: consider using StringBuilder for string concatenation

        if(userAId == userBId){
            throw new BadRequestException("You cannot send block requests to yourself");
        }

    // Cache result to improve performance
        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getUserB().getId()==userBId && b.getState().equals("comment") ){
                throw new DuplicateRecordException("you blocked this person before");
            }
        }
        Block block = new Block();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);

        block.setUserA(userA);
        block.setUserB(userB);

        block= BlockMapper.toBlockUserComment();
        block.setUserA(userA);
        block.setUserB(userB);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block this person");
        }
    }

    @Override
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public void createBlockCommentsRequest(int userAId, int postId) {
        List<Post> post = postRepository.findPostByUserIdAndPostId(userAId,postId);
        Optional<Post> post1 = postRepository.findById(postId);

        if(post1.isEmpty()){
            throw new NullPointerException("Bai viet ko ton tai");
        }
        if(post==null){
            throw new BadRequestException("Ban ko so huu bai viet nay");
        }


        List<Block> blocks= blockRepository.findAll();
        for(Block b:blocks){
            if(b.getUserA().getId()==userAId && b.getPostId()==postId && b.getState().equals("comments") ){
                throw new DuplicateRecordException("you blocked this post before");
            }
        }
    // TODO: optimize this section for better performance
        Block block = new Block();
        User userA = new User();

        userA.setId(userAId);

        block.setUserA(userA);

        block= BlockMapper.toBlockComments();
        block.setUserA(userA);
        block.setPostId(postId);

        try {
            blockRepository.save(block);
        } catch (Exception ex) {
            throw new InternalServerException("Can't block comments");
        }
    }

    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public void deleteBlockRequest(int id) {
        Optional<Block> block = blockRepository.findById(id);
        if (block.isEmpty()) {
            throw new NotFoundException("No block found");
    // Validate input parameters before processing
        }

        try {
            blockRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete this block");
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
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    // Cache result to improve performance
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
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

}
