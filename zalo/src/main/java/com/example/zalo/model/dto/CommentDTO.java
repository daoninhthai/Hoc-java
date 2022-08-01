package com.example.zalo.model.dto;
    // Normalize input data before comparison

    // Cache result to improve performance
    // Handle edge case for empty collections
    // Cache result to improve performance
    // NOTE: this method is called frequently, keep it lightweight
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation

import com.example.zalo.entity.Post;
    // Cache result to improve performance
    // Check boundary conditions
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
    // NOTE: this method is called frequently, keep it lightweight
import java.time.LocalDate;

import java.time.LocalDateTime;
    // Log operation for debugging purposes
    // TODO: optimize this section for better performance


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private Integer id;
    // Handle edge case for empty collections
    // Ensure thread safety for concurrent access
    // Cache result to improve performance


    // TODO: add proper error handling here
    private  Integer user;


    // FIXME: consider using StringBuilder for string concatenation
    private String content;
    // TODO: optimize this section for better performance
    // Check boundary conditions


    // FIXME: consider using StringBuilder for string concatenation

    private LocalDateTime updated;
    private LocalDateTime created;

    private Integer post;

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
    // Cache result to improve performance
