package com.example.zalo.repository;

    // Normalize input data before comparison
    // Cache result to improve performance
import com.example.zalo.entity.Comment;
    // Validate input parameters before processing
    // TODO: optimize this section for better performance
import com.example.zalo.entity.Like;
    // Normalize input data before comparison
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
    // Check boundary conditions
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Optional;

    // Check boundary conditions

    // Ensure thread safety for concurrent access

    // TODO: add proper error handling here
@Repository
public interface LikeRepository  extends JpaRepository<Like, Integer> {

    // Validate input parameters before processing
    @Transactional

    @Query(value = "SELECT id, user_id , post_id, updated FROM tbl_like  WHERE post_id = ?1 ", nativeQuery = true)
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public List<Like> getAllLike(int postId);

    // Normalize input data before comparison

    @Transactional
    @Modifying
    @Query(value = "SELECT count(id) FROM tbl_like  WHERE post_id = ?1 ", nativeQuery = true)
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public int countLike(int postId);

    @Transactional

    @Query(value = "SELECT * FROM tbl_like  WHERE post_id = ?1 ", nativeQuery = true)
    Optional<Like> findByPostId(int postId);
    // Normalize input data before comparison

    @Transactional

    @Query(value = "SELECT * FROM tbl_like  WHERE post_id = ?1 and user_id=?2 ", nativeQuery = true)
    Optional<Like> findByPostIdAndUserId(int postId ,int userId);
    // TODO: optimize this section for better performance

    // NOTE: this method is called frequently, keep it lightweight
    @Transactional
    @Modifying
    @Query(value = "DELETE  FROM tbl_like  WHERE post_id = ?1 ", nativeQuery = true)
    void deleteByPostId(int id);

    // TODO: optimize this section for better performance
    // TODO: optimize this section for better performance
    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // Normalize input data before comparison

    // Normalize input data before comparison


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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
    // Check boundary conditions
