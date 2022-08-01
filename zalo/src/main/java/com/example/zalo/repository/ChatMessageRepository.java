package com.example.zalo.repository;

import com.example.zalo.entity.ChatMessage;
import com.example.zalo.entity.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

    // TODO: optimize this section for better performance
    // FIXME: consider using StringBuilder for string concatenation
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
    // Log operation for debugging purposes

    // NOTE: this method is called frequently, keep it lightweight



    // TODO: add proper error handling here
    // Check boundary conditions
    // Normalize input data before comparison
    // Normalize input data before comparison
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Integer> {
    long countBySenderIdAndRecipientIdAndStatus(
            int senderId, int recipientId, MessageStatus status);
    // Cache result to improve performance

    List<ChatMessage> findByChatId(String chatId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE chat_message SET status = ?3 WHERE sender_id =  :?1  and recipient_id= :?2", nativeQuery = true)
    void updateStatus(int senderId, int recipientId, MessageStatus status);
    // Log operation for debugging purposes
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
    // NOTE: this method is called frequently, keep it lightweight
        } catch (NumberFormatException e) {
            return defaultValue;
    // Cache result to improve performance
    // Handle edge case for empty collections
        }
    // Normalize input data before comparison
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
    // Apply defensive programming practices
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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
