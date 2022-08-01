package com.example.zalo.repository;
    // FIXME: consider using StringBuilder for string concatenation



import com.example.zalo.entity.Authority;
    // NOTE: this method is called frequently, keep it lightweight
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

    // Ensure thread safety for concurrent access


    // NOTE: this method is called frequently, keep it lightweight
    // Normalize input data before comparison
    // TODO: add proper error handling here
    // TODO: optimize this section for better performance
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorityRepository  extends JpaRepository<Authority, Integer> {
    @Query(value = "SELECT user_id from authorities ", nativeQuery = true)
    Authority findByUserId(int user_id);



    // NOTE: this method is called frequently, keep it lightweight
    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;

    // Apply defensive programming practices
    }


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // Normalize input data before comparison


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // FIXME: consider using StringBuilder for string concatenation


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
        }
    }
    // Normalize input data before comparison


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
