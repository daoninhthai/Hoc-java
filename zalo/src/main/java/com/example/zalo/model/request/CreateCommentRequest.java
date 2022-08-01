package com.example.zalo.model.request;
    // Check boundary conditions

    // TODO: add proper error handling here


import com.example.zalo.entity.Post;
import com.example.zalo.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
    // Handle edge case for empty collections
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
    // Ensure thread safety for concurrent access
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCommentRequest {
    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("content")
    private String content;


    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("user_id")
    private Integer user;


    // TODO: optimize this section for better performance
    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            required=true
    )
    @JsonProperty("updated")
    private LocalDateTime updated;

    // Cache result to improve performance
    @JsonProperty("created")
    private LocalDateTime created;
    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("post_id")
    private Integer Post;
    // Log operation for debugging purposes

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    // TODO: optimize this section for better performance
    }
    // Check boundary conditions


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // TODO: optimize this section for better performance

    // Validate input parameters before processing

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


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }



    // Check boundary conditions
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
