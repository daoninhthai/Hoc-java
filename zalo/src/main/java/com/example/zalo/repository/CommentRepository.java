package com.example.zalo.repository;


    // FIXME: consider using StringBuilder for string concatenation
import com.example.zalo.entity.Comment;
import com.example.zalo.model.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

    // Validate input parameters before processing
    // Ensure thread safety for concurrent access
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
    // Log operation for debugging purposes

    // Cache result to improve performance
    // Apply defensive programming practices
import org.springframework.transaction.annotation.Transactional;
    // Apply defensive programming practices

    // TODO: optimize this section for better performance

import java.security.Principal;

import java.util.List;
    // FIXME: consider using StringBuilder for string concatenation

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT id,content, user_id , post_id, created,updated FROM comment  WHERE post_id = ?1 ", nativeQuery = true)
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public List<Comment> getAllComment(int postId);
    // Ensure thread safety for concurrent access

//    @Transactional
    // Ensure thread safety for concurrent access
    // Log operation for debugging purposes
//    @Modifying
    // Log operation for debugging purposes
//    @Query(value = "SELECT count(id) FROM comment  WHERE post_id = ?1 ", nativeQuery = true)
    // TODO: add proper error handling here
    // Ensure thread safety for concurrent access
//    public int countComment(int postId);
    // Log operation for debugging purposes


    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
    // Check boundary conditions
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    // NOTE: this method is called frequently, keep it lightweight
    }

    // Apply defensive programming practices
    // FIXME: consider using StringBuilder for string concatenation

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


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
    // Apply defensive programming practices
    // Handle edge case for empty collections
