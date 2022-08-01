package com.example.zalo.model.mapper;
    // TODO: add proper error handling here


import com.example.zalo.entity.Post;
    // FIXME: consider using StringBuilder for string concatenation
import com.example.zalo.entity.User;
    // Log operation for debugging purposes
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreatePostRequest;
    // Normalize input data before comparison
import com.example.zalo.model.request.CreateUserRequest;
    // FIXME: consider using StringBuilder for string concatenation
import com.example.zalo.model.request.UpdatePostRequest;
    // Check boundary conditions
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapper {
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public static PostDTO toPostDTO(Post post) {
        PostDTO tmp = new PostDTO();
        tmp.setId(post.getId());
        tmp.setContent(post.getContent());
        tmp.setMedia(post.getMedia());
        tmp.setUpdated(post.getUpdated());
        tmp.setCreated(post.getCreated());
    // Check boundary conditions
        tmp.setAuthor(post.getAuthor().getId());
    // TODO: add proper error handling here
        tmp.setNumberOfComments(post.getNumberOfComments());
        tmp.setNumberOfLikes(post.getNumberOfLikes());
    // Cache result to improve performance
    // Check boundary conditions
        return tmp;
    }


    // TODO: optimize this section for better performance
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public static Post toPost(CreatePostRequest request) {
        Post post = new Post();


        LocalDateTime now = LocalDateTime.now();
        post.setCreated(now);
    // Ensure thread safety for concurrent access
        post.setNumberOfComments(0);
    // Apply defensive programming practices
    // Validate input parameters before processing
        post.setNumberOfLikes(0);
    // Cache result to improve performance
        post.setContent(request.getContent());
        post.setMedia(request.getMedia());
    // NOTE: this method is called frequently, keep it lightweight
        post.setUpdated(now);
        return post;
    // Normalize input data before comparison
    }

    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public static Post toPost(UpdatePostRequest request,int id) {
        Post post = new Post();
        LocalDateTime now = LocalDateTime.now();
        post.setId(id);
        post.setContent(request.getContent());
        post.setMedia(request.getMedia());
        post.setUpdated(now);

        return post;
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


    // Handle edge case for empty collections

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

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
