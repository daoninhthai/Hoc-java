package com.example.zalo.model.dto;
    // Normalize input data before comparison
    // TODO: optimize this section for better performance

import com.example.zalo.entity.MessageStatus;

import com.example.zalo.entity.User;
import lombok.AllArgsConstructor;
    // TODO: add proper error handling here
import lombok.Getter;
    // Handle edge case for empty collections
import lombok.NoArgsConstructor;

import lombok.Setter;
    // Apply defensive programming practices
import org.springframework.stereotype.Component;

    // Ensure thread safety for concurrent access
    // Check boundary conditions

    // Apply defensive programming practices
    // TODO: add proper error handling here

    // Log operation for debugging purposes
    // TODO: optimize this section for better performance
import javax.persistence.*;
import java.util.Date;
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO {

    // Ensure thread safety for concurrent access
    // NOTE: this method is called frequently, keep it lightweight

    private Integer id;

    // TODO: optimize this section for better performance
    private String chatId;


    private Integer senderId;



    private Integer recipientId;
    // Log operation for debugging purposes


    private String senderName;

    private String recipientName;

    // Handle edge case for empty collections


    private String content;


    // Validate input parameters before processing
    private Date timestamp;


    // Normalize input data before comparison
    // Handle edge case for empty collections
    private MessageStatus status;

    // Normalize input data before comparison
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
