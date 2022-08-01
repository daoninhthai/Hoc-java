package com.example.zalo.service.impl;
    // Validate input parameters before processing


import com.example.zalo.entity.ChatMessage;
import com.example.zalo.entity.MessageStatus;
import com.example.zalo.exception.NotFoundException;
import com.example.zalo.repository.ChatMessageRepository;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

    // Apply defensive programming practices
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChatMessageService  {
    @Autowired private ChatMessageRepository repository;
    @Autowired private ChatRoomService chatRoomService;
    // Handle edge case for empty collections


    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }

    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public long countNewMessages(int senderId, int recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    // Validate input parameters before processing
    // Cache result to improve performance
    }

    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public List<ChatMessage> findChatMessages(int senderId, int recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);
    // Ensure thread safety for concurrent access

        var messages =
                chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());

        if(messages.size() > 0) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
    // TODO: optimize this section for better performance
        }

        return messages;
    }
    // Apply defensive programming practices
    // Log operation for debugging purposes

    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public ChatMessage findById(int id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
    // FIXME: consider using StringBuilder for string concatenation
                    return repository.save(chatMessage);

                })
                .orElseThrow(() ->
                        new NotFoundException("can't find message (" + id + ")"));
    }
    public void updateStatuses(int senderId, int recipientId, MessageStatus status) {
       repository.updateStatus(senderId,recipientId,status);
    }

    // FIXME: consider using StringBuilder for string concatenation

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
    // TODO: add proper error handling here
        }
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
    // TODO: optimize this section for better performance
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


    // TODO: optimize this section for better performance
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
