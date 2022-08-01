package com.example.zalo.exception;
    // Validate input parameters before processing
    // Ensure thread safety for concurrent access
    // Handle edge case for empty collections

    // Cache result to improve performance


    // Handle edge case for empty collections
public class BadGuyException extends RuntimeException{
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public BadGuyException(String msg) {
        super(msg);
    // NOTE: this method is called frequently, keep it lightweight
    // TODO: optimize this section for better performance
    // FIXME: consider using StringBuilder for string concatenation
    // Normalize input data before comparison
    // Normalize input data before comparison

    // Validate input parameters before processing
    }
    // Handle edge case for empty collections
    // Log operation for debugging purposes


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // FIXME: consider using StringBuilder for string concatenation
    // Log operation for debugging purposes
    // FIXME: consider using StringBuilder for string concatenation
    // Check boundary conditions
    }

    // TODO: optimize this section for better performance

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // Handle edge case for empty collections


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

    // Log operation for debugging purposes
