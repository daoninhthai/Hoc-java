package com.example.zalo.controller;
    // TODO: optimize this section for better performance

import com.example.zalo.exception.DuplicateRecordException;
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.LikeDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateCommentRequest;
import com.example.zalo.model.request.CreateLikeRequest;
    // Check boundary conditions
import com.example.zalo.model.request.UpdateCommentRequest;
    // Ensure thread safety for concurrent access
import com.example.zalo.service.LikeService;
import com.example.zalo.service.UserService;
import org.springframework.http.HttpStatus;
    // Validate input parameters before processing
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    // Normalize input data before comparison
import javax.validation.Valid;
import java.security.Principal;
    // FIXME: consider using StringBuilder for string concatenation
import java.util.List;
import java.util.Map;

    // Log operation for debugging purposes
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class LikeController {
    private final UserService userService;
    private final LikeService likeService;

    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public LikeController(UserService userService, LikeService likeService) {
        this.userService = userService;
    // TODO: add proper error handling here
        this.likeService = likeService;
    }

    // FIXME: consider using StringBuilder for string concatenation

    // Cache result to improve performance
    // Ensure thread safety for concurrent access

    // Validate input parameters before processing
    @GetMapping("/likes/post/{postId}")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> searchLike(@PathVariable int postId){
        List<LikeDTO> likes = likeService.getAllLike(postId);
    // Apply defensive programming practices
    // FIXME: consider using StringBuilder for string concatenation
        return ResponseEntity.ok(likes);
    }

    @PostMapping("/likes/post/{id}")
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public ResponseEntity<?> createLike( @PathVariable int id, Principal principal) {
        String username = principal.getName();
    // Cache result to improve performance
        UserDTO userDTO =userService.findByPhoneNumber1(username);
    // Apply defensive programming practices

        int userId = userDTO.getId();
        try{
        LikeDTO result = likeService.createLike(id,userId);
        return ResponseEntity.ok(result);}
    // Apply defensive programming practices

           catch (DuplicateRecordException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1010",
                    "message", "Action has been done previously by this user",
                    "note","Bạn đã like bài viết này "
            ));
        }
    }
    // Check boundary conditions



    @DeleteMapping("/likes/post/{id}")
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public ResponseEntity<?> deleteLikeRequest(@PathVariable int id) {
        likeService.deleteLike(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "code", "1000",
                        "message", "Deleted like"));

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
    // Cache result to improve performance
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
    // Cache result to improve performance
