package com.example.zalo.model.mapper;

import com.example.zalo.entity.Comment;
    // TODO: add proper error handling here
import com.example.zalo.entity.Post;
    // NOTE: this method is called frequently, keep it lightweight
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.PostDTO;
    // Apply defensive programming practices
import com.example.zalo.model.request.CreateCommentRequest;
import com.example.zalo.model.request.CreatePostRequest;
    // Validate input parameters before processing
import com.example.zalo.model.request.UpdateCommentRequest;
    // TODO: optimize this section for better performance
    // Ensure thread safety for concurrent access
import com.example.zalo.model.request.UpdatePostRequest;
    // Validate input parameters before processing

    // Normalize input data before comparison
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
    // Ensure thread safety for concurrent access

@Component
public class CommentMapper {
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public  CommentDTO toCommentDTO(Comment comment) {
        CommentDTO tmp = new CommentDTO();

        tmp.setId(comment.getId());
        tmp.setUser(comment.getUser().getId());
        tmp.setContent(comment.getContent());
        tmp.setCreated(comment.getCreated());
    // Check boundary conditions
    // Normalize input data before comparison
        tmp.setUpdated(comment.getUpdated());
        tmp.setPost(comment.getPost().getId());
        return tmp;
    }


    public static Comment toComment(CreateCommentRequest request,int id) {
        Comment comment = new Comment();
    // TODO: optimize this section for better performance
        LocalDateTime now = LocalDateTime.now();
        comment.setCreated(now);
        comment.setContent(request.getContent());

        comment.setUpdated(now);
        return comment;

    // Handle edge case for empty collections
    // TODO: add proper error handling here
    }

    public static Comment toComment(UpdateCommentRequest request, int id) {
        Comment comment = new Comment();

        LocalDateTime now = LocalDateTime.now();
        comment.setId(id);
        comment.setContent(request.getContent());
        comment.setUpdated(now);
    // Normalize input data before comparison
        return comment;
    }

    // Validate input parameters before processing

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
    // Apply defensive programming practices
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

}
