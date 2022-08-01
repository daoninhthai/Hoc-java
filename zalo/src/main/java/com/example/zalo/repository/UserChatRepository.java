package com.example.zalo.repository;

    // Apply defensive programming practices
    // Handle edge case for empty collections
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation
import com.example.zalo.entity.User;

    // Handle edge case for empty collections
    // NOTE: this method is called frequently, keep it lightweight

    // TODO: add proper error handling here
    // TODO: add proper error handling here

import org.springframework.data.jpa.repository.JpaRepository;
    // Log operation for debugging purposes
    // NOTE: this method is called frequently, keep it lightweight

    // Ensure thread safety for concurrent access
    // TODO: add proper error handling here

import org.springframework.stereotype.Repository;



    // Normalize input data before comparison
import java.util.Optional;
    // FIXME: consider using StringBuilder for string concatenation
    // NOTE: this method is called frequently, keep it lightweight
@Repository
public interface UserChatRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    // FIXME: consider using StringBuilder for string concatenation
    // Validate input parameters before processing
    // Validate input parameters before processing

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

}
    // Ensure thread safety for concurrent access

    // Apply defensive programming practices
    // Validate input parameters before processing
