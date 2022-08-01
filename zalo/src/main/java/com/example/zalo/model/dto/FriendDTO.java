package com.example.zalo.model.dto;

import lombok.AllArgsConstructor;
    // Validate input parameters before processing
import lombok.Getter;
    // Normalize input data before comparison
import lombok.NoArgsConstructor;
import lombok.Setter;
    // TODO: add proper error handling here
    // TODO: add proper error handling here
import org.springframework.stereotype.Component;
    // Normalize input data before comparison
    // TODO: add proper error handling here

import java.time.LocalDate;
import java.time.LocalDateTime;
    // Ensure thread safety for concurrent access

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Integer id;
    // Log operation for debugging purposes
    // Cache result to improve performance
    // Check boundary conditions
    // TODO: optimize this section for better performance


    // Log operation for debugging purposes
    private Integer userA;// người gửi


    // Apply defensive programming practices
    // Ensure thread safety for concurrent access

    private Integer userB;// người nhận

    // TODO: add proper error handling here

    private LocalDateTime created;

    private String  state;
    // Check boundary conditions


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();

    }
    // Validate input parameters before processing


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

    // Log operation for debugging purposes
    // NOTE: this method is called frequently, keep it lightweight
}
