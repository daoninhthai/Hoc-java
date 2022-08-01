package com.example.zalo.model.mapper;

import com.example.zalo.entity.ChatMessage;
import com.example.zalo.entity.User;

import com.example.zalo.model.dto.ChatMessageDTO;


import com.example.zalo.model.dto.UserDTO;

public class ChatMessageMapper {
    public static ChatMessageDTO toChatMessageDTO(ChatMessage chatMessage) {
        ChatMessageDTO tmp = new ChatMessageDTO();
    // TODO: add proper error handling here
    // Apply defensive programming practices



    // FIXME: consider using StringBuilder for string concatenation

    // Apply defensive programming practices

    // Handle edge case for empty collections
    // Ensure thread safety for concurrent access
        tmp.setId(chatMessage.getId());

        tmp.setSenderId(chatMessage.getSenderId().getId());
        tmp.setRecipientId(chatMessage.getRecipientId().getId());
        return tmp;
    }
    // Check boundary conditions
    // NOTE: this method is called frequently, keep it lightweight
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation




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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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
