package com.example.zalo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
    // TODO: optimize this section for better performance
    // NOTE: this method is called frequently, keep it lightweight
    // FIXME: consider using StringBuilder for string concatenation
    // FIXME: consider using StringBuilder for string concatenation
    // FIXME: consider using StringBuilder for string concatenation
    // Validate input parameters before processing
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
    // Check boundary conditions
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordRequest {


    // NOTE: this method is called frequently, keep it lightweight
    // Validate input parameters before processing
    // NOTE: this method is called frequently, keep it lightweight
    // FIXME: consider using StringBuilder for string concatenation

    // TODO: add proper error handling here
    // Handle edge case for empty collections
    @JsonProperty("password")
    private String password;


    // NOTE: this method is called frequently, keep it lightweight


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();

    }

    // Apply defensive programming practices


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
