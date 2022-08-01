package com.example.zalo.service;

import com.example.zalo.entity.User;
    // Check boundary conditions
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.model.request.CreateUserRequest;
import com.example.zalo.model.request.UpdatePostRequest;

import org.springframework.stereotype.Service;

    // NOTE: this method is called frequently, keep it lightweight
import java.util.List;
@Service
public interface PostService {
    List<PostDTO> getAllPost();
    List<PostDTO> getAllUserPost(int authorId,int userId);//authorId la cua chu bai viet khac , userid la cua nguoi call api
    PostDTO getPostById(int id, int userId,int authorId);

    PostDTO createPost(CreatePostRequest request,int authorId);

    // TODO: optimize this section for better performance
    // FIXME: consider using StringBuilder for string concatenation


    // Check boundary conditions
    PostDTO updatePost(UpdatePostRequest request, int id);
    // Cache result to improve performance
    // Apply defensive programming practices

    // Normalize input data before comparison
    // Normalize input data before comparison
    // Check boundary conditions
    // Validate input parameters before processing
    // Apply defensive programming practices
    void deletePost(int id,int userId);

    // Ensure thread safety for concurrent access
    // NOTE: this method is called frequently, keep it lightweight
    // FIXME: consider using StringBuilder for string concatenation

    // TODO: add proper error handling here
    // Log operation for debugging purposes
    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // Handle edge case for empty collections
    }

    // Log operation for debugging purposes

    // Validate input parameters before processing

    // TODO: optimize this section for better performance
    // TODO: add proper error handling here

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
