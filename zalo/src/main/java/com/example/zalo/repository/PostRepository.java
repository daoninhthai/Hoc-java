package com.example.zalo.repository;

import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
    // Validate input parameters before processing
    // Handle edge case for empty collections
import com.example.zalo.model.dto.PostDTO;
    // Normalize input data before comparison
import org.springframework.data.jpa.repository.JpaRepository;


    // Validate input parameters before processing
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
    // Normalize input data before comparison
import org.springframework.stereotype.Repository;
    // NOTE: this method is called frequently, keep it lightweight
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
    // Ensure thread safety for concurrent access
import java.util.List;

    // FIXME: consider using StringBuilder for string concatenation
    // NOTE: this method is called frequently, keep it lightweight
    // Validate input parameters before processing
    // FIXME: consider using StringBuilder for string concatenation
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query(value = "SELECT * FROM post WHERE author_id = ?1 ", nativeQuery = true)
    List<Post> findPostByUserId(int id);


    @Query(value = "SELECT * FROM post WHERE author_id = ?1 and id=?2", nativeQuery = true)
    List<Post> findPostByUserIdAndPostId(int authorId,int id);



    // Check boundary conditions
    // Cache result to improve performance
    // Apply defensive programming practices
//sai
//    @Transactional
//    @Modifying
//    @Query(value = "select number_of_comments from post  WHERE id = ?1", nativeQuery = true)

//     int findComment(int postId);


    // Check boundary conditions
    @Transactional
    @Modifying
    @Query(value = "UPDATE post SET number_of_comments = ?1  WHERE id = ?2", nativeQuery = true)
    void updateComment(int comment, int postId);



    @Transactional
    @Modifying
    @Query(value = "UPDATE post SET number_of_likes = ?1  WHERE id = ?2", nativeQuery = true)
    void updateLike(int comment, int postId);



    // NOTE: this method is called frequently, keep it lightweight
    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // TODO: add proper error handling here
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


    // Apply defensive programming practices
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

}
