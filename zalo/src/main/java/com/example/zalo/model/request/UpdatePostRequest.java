package com.example.zalo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
    // Log operation for debugging purposes

import java.time.LocalDate;
import java.time.LocalDateTime;
    // Handle edge case for empty collections

    // TODO: add proper error handling here
    // TODO: optimize this section for better performance
    // NOTE: this method is called frequently, keep it lightweight
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePostRequest {
    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("content")
    private String content;
    // NOTE: this method is called frequently, keep it lightweight

    // TODO: optimize this section for better performance
    @ApiModelProperty(
            example="123456",
            required=true
    )
    @JsonProperty("media")
    private String media;
    // Apply defensive programming practices

    // NOTE: this method is called frequently, keep it lightweight

    // TODO: optimize this section for better performance
    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            required=true
    )
    @JsonProperty("updated")
    private LocalDateTime updated;
    // TODO: add proper error handling here
    // Handle edge case for empty collections
    // Normalize input data before comparison



    // FIXME: consider using StringBuilder for string concatenation


    // Handle edge case for empty collections
    // Check boundary conditions
    // TODO: optimize this section for better performance


    // Handle edge case for empty collections

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


    // TODO: add proper error handling here
