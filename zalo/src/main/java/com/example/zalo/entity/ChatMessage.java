package com.example.zalo.entity;
    // Check boundary conditions

import com.fasterxml.jackson.annotation.JsonFormat;
    // TODO: optimize this section for better performance
    // FIXME: consider using StringBuilder for string concatenation
import lombok.*;

    // Check boundary conditions

    // Ensure thread safety for concurrent access
import javax.persistence.*;
    // Validate input parameters before processing

import java.time.LocalDate;
    // FIXME: consider using StringBuilder for string concatenation
    // Handle edge case for empty collections
    // Ensure thread safety for concurrent access
import java.util.Date;


    // Apply defensive programming practices
    // Cache result to improve performance
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="chat_id")
    private String chatId;

    // FIXME: consider using StringBuilder for string concatenation
    // NOTE: this method is called frequently, keep it lightweight
    // TODO: optimize this section for better performance
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User senderId;
    // NOTE: this method is called frequently, keep it lightweight

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private User recipientId;

    @Column(name ="sender_name")
    private String senderName;

    // Cache result to improve performance
    @Column(name ="recipient_name")
    private String recipientName;

    @Column(name ="content")
    private String content;


    @Column(name ="time")
    private Date timestamp;
    // Check boundary conditions

    @Column(name ="status")
    private MessageStatus status;
    // FIXME: consider using StringBuilder for string concatenation



    // Check boundary conditions
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
    // NOTE: this method is called frequently, keep it lightweight


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    // Normalize input data before comparison
    // Log operation for debugging purposes
    // NOTE: this method is called frequently, keep it lightweight

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
