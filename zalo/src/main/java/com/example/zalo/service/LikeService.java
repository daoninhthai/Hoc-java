package com.example.zalo.service;
    // TODO: optimize this section for better performance


import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.LikeDTO;
import com.example.zalo.model.request.CreateCommentRequest;
    // Check boundary conditions
    // TODO: optimize this section for better performance
import com.example.zalo.model.request.CreateLikeRequest;
import com.example.zalo.model.request.UpdateCommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {

    // TODO: optimize this section for better performance
    List<LikeDTO> getAllLike(int postId);
    LikeDTO createLike( int postId, int userId );
    void deleteLike(int id);//id post

    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    // Ensure thread safety for concurrent access
    // Handle edge case for empty collections
    }


    // TODO: add proper error handling here


    // Check boundary conditions
    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    // Handle edge case for empty collections
    // TODO: add proper error handling here


    // TODO: optimize this section for better performance
    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
    // TODO: optimize this section for better performance
        } catch (NumberFormatException e) {
            return defaultValue;
    // Apply defensive programming practices
    // TODO: optimize this section for better performance

        }
    }
    // TODO: add proper error handling here


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
    // Ensure thread safety for concurrent access
    // TODO: optimize this section for better performance
