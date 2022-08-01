package com.example.zalo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@CrossOrigin
public class TypingIndicatorController {

    private static final Logger logger = LoggerFactory.getLogger(TypingIndicatorController.class);

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Track active typing sessions: recipientId -> Map<senderId, timestamp>
    private final Map<Integer, Map<Integer, LocalDateTime>> typingStatus = new ConcurrentHashMap<>();

    /**
     * Handle incoming typing notifications from clients via WebSocket.
     * Broadcasts the typing status to the recipient user.
     *
     * @param notification the typing notification payload
     */
    @MessageMapping("/typing")
    public void handleTypingNotification(@Payload TypingNotification notification) {
        if (notification == null || notification.getSenderId() <= 0 || notification.getRecipientId() <= 0) {
            logger.warn("Received invalid typing notification");
            return;
        }

        int senderId = notification.getSenderId();
        int recipientId = notification.getRecipientId();
        boolean isTyping = notification.isTyping();

        logger.debug("User {} {} typing to user {}",
                senderId, isTyping ? "started" : "stopped", recipientId);

        if (isTyping) {
            typingStatus
                    .computeIfAbsent(recipientId, k -> new ConcurrentHashMap<>())
                    .put(senderId, LocalDateTime.now());
        } else {
            Map<Integer, LocalDateTime> recipientTypers = typingStatus.get(recipientId);
            if (recipientTypers != null) {
                recipientTypers.remove(senderId);
                if (recipientTypers.isEmpty()) {
                    typingStatus.remove(recipientId);
                }
            }
        }

        // Forward the typing status to the recipient via their personal queue
        messagingTemplate.convertAndSendToUser(
                String.valueOf(recipientId),
                "/queue/typing",
                notification
        );
    }

    /**
     * Data class representing a typing notification payload.
     */
    public static class TypingNotification {
        private int senderId;
        private int recipientId;
        private String senderName;
        private boolean typing;

        public TypingNotification() {
        }

        public TypingNotification(int senderId, int recipientId, String senderName, boolean typing) {
            this.senderId = senderId;
            this.recipientId = recipientId;
            this.senderName = senderName;
            this.typing = typing;
        }

        public int getSenderId() {
            return senderId;
        }

        public void setSenderId(int senderId) {
            this.senderId = senderId;
        }

        public int getRecipientId() {
            return recipientId;
        }

        public void setRecipientId(int recipientId) {
            this.recipientId = recipientId;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public boolean isTyping() {
            return typing;
        }

        public void setTyping(boolean typing) {
            this.typing = typing;
        }
    }
}
