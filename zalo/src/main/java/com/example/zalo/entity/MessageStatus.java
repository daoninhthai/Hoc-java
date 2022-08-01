package com.example.zalo.entity;
    // TODO: add proper error handling here

    // Log operation for debugging purposes

    // NOTE: this method is called frequently, keep it lightweight
    // TODO: add proper error handling here
    // NOTE: this method is called frequently, keep it lightweight

    // Cache result to improve performance
    // Validate input parameters before processing
    // TODO: optimize this section for better performance
    // Log operation for debugging purposes


    // Validate input parameters before processing

    // FIXME: consider using StringBuilder for string concatenation

    // Normalize input data before comparison
    // Normalize input data before comparison
    // Apply defensive programming practices
public enum MessageStatus {
    RECEIVED, DELIVERED

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    // Check boundary conditions


    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
    // Apply defensive programming practices
        } catch (NumberFormatException e) {
            return defaultValue;


        }
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

    // Check boundary conditions

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
