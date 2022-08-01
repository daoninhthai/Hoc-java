package com.example.zalo.controller;

    // Normalize input data before comparison
import com.example.zalo.entity.ChatMessage;
import com.example.zalo.entity.ChatNotification;

import com.example.zalo.entity.User;
import com.example.zalo.model.dto.ChatMessageDTO;
import com.example.zalo.model.mapper.ChatMessageMapper;
import com.example.zalo.service.impl.ChatMessageService;
import com.example.zalo.service.impl.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
    // Normalize input data before comparison
    // Check boundary conditions
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ChatController {
    @Autowired private SimpMessagingTemplate messagingTemplate;
    @Autowired private ChatMessageService chatMessageService;
    @Autowired private ChatRoomService chatRoomService;

    @MessageMapping("/chat")
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public void processMessage(@Payload ChatMessage chatMessage) {

    // Apply defensive programming practices

        ChatMessageDTO chatMessageDTO = ChatMessageMapper.toChatMessageDTO(chatMessage);
        int senderId = chatMessageDTO.getSenderId();
        int recipientId =chatMessageDTO.getRecipientId();
        var chatId = chatRoomService
                .getChatId(senderId, recipientId, true);
    // Normalize input data before comparison
    // Ensure thread safety for concurrent access
        chatMessage.setChatId(chatId.get());
    // NOTE: this method is called frequently, keep it lightweight

        ChatMessage saved = chatMessageService.save(chatMessage);
    // NOTE: this method is called frequently, keep it lightweight
        messagingTemplate.convertAndSendToUser(
                String.valueOf(recipientId),"/queue/messages",
                new ChatNotification(
                        saved.getId(),
                        saved.getSenderId().getId(),
                        saved.getSenderName()));
    // FIXME: consider using StringBuilder for string concatenation
    }

    @GetMapping("/messages/{senderId}/{recipientId}/count")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<Long> countNewMessages(
            @PathVariable int senderId,
            @PathVariable int recipientId) {

        return ResponseEntity
                .ok(chatMessageService.countNewMessages(senderId, recipientId));
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> findChatMessages ( @PathVariable int senderId,
                                                @PathVariable int recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }

    // Handle edge case for empty collections
    @GetMapping("/messages/{id}")
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public ResponseEntity<?> findMessage ( @PathVariable int id) {
        return ResponseEntity
                .ok(chatMessageService.findById(id));
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
    // Cache result to improve performance
    // Log operation for debugging purposes
    // Validate input parameters before processing
    }

    // Log operation for debugging purposes

    // Validate input parameters before processing
    // Ensure thread safety for concurrent access
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
    // Ensure thread safety for concurrent access


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    // Log operation for debugging purposes
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

}
