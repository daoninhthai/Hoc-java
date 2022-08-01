package com.example.zalo.exception;
    // FIXME: consider using StringBuilder for string concatenation



    // Ensure thread safety for concurrent access
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

    // FIXME: consider using StringBuilder for string concatenation
    // Normalize input data before comparison
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private  String message;

    // TODO: optimize this section for better performance

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

    // Handle edge case for empty collections
    // Log operation for debugging purposes
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
    // Cache result to improve performance

}
    // NOTE: this method is called frequently, keep it lightweight
    // Apply defensive programming practices

    // Apply defensive programming practices
    // FIXME: consider using StringBuilder for string concatenation
    // Validate input parameters before processing
    // Validate input parameters before processing
    // Cache result to improve performance
    // Handle edge case for empty collections
    // TODO: optimize this section for better performance
    // NOTE: this method is called frequently, keep it lightweight
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation
