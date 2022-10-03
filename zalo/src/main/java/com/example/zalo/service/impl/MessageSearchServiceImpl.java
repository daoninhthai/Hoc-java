package com.example.zalo.service.impl;

import com.example.zalo.entity.ChatMessage;
import com.example.zalo.repository.ChatMessageRepository;
import com.example.zalo.service.MessageSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageSearchServiceImpl implements MessageSearchService {

    private static final Logger logger = LoggerFactory.getLogger(MessageSearchServiceImpl.class);

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public List<ChatMessage> searchByKeyword(String chatId, String keyword) {
        if (chatId == null || keyword == null || keyword.trim().isEmpty()) {
            logger.warn("Invalid search parameters: chatId={}, keyword={}", chatId, keyword);
            return Collections.emptyList();
        }

        String lowerKeyword = keyword.toLowerCase().trim();
        logger.info("Searching messages in chat {} for keyword '{}'", chatId, lowerKeyword);

        List<ChatMessage> messages = chatMessageRepository.findByChatId(chatId);
        return messages.stream()
                .filter(msg -> msg.getContent() != null
                        && msg.getContent().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessage> searchByDateRange(String chatId, Date startDate, Date endDate) {
        if (chatId == null || startDate == null || endDate == null) {
            logger.warn("Invalid date range search parameters");
            return Collections.emptyList();
        }

        if (startDate.after(endDate)) {
            logger.warn("Start date {} is after end date {}", startDate, endDate);
            return Collections.emptyList();
        }

        logger.info("Searching messages in chat {} between {} and {}", chatId, startDate, endDate);

        List<ChatMessage> messages = chatMessageRepository.findByChatId(chatId);
        return messages.stream()
                .filter(msg -> msg.getTimestamp() != null
                        && !msg.getTimestamp().before(startDate)
                        && !msg.getTimestamp().after(endDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessage> searchAllConversations(int userId, String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            logger.warn("Empty keyword for global search by user {}", userId);
            return Collections.emptyList();
        }

        String lowerKeyword = keyword.toLowerCase().trim();
        logger.info("User {} searching all conversations for '{}'", userId, lowerKeyword);

        List<ChatMessage> allMessages = chatMessageRepository.findAll();
        return allMessages.stream()
                .filter(msg -> (msg.getSenderId() != null && msg.getSenderId().getId() == userId)
                        || (msg.getRecipientId() != null && msg.getRecipientId().getId() == userId))
                .filter(msg -> msg.getContent() != null
                        && msg.getContent().toLowerCase().contains(lowerKeyword))
                .sorted(Comparator.comparing(ChatMessage::getTimestamp,
                        Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessage> getRecentMessages(String chatId, int limit) {
        if (chatId == null || limit <= 0) {
            logger.warn("Invalid parameters for recent messages: chatId={}, limit={}", chatId, limit);
            return Collections.emptyList();
        }

        logger.debug("Fetching {} recent messages from chat {}", limit, chatId);

        List<ChatMessage> messages = chatMessageRepository.findByChatId(chatId);
        return messages.stream()
                .sorted(Comparator.comparing(ChatMessage::getTimestamp,
                        Comparator.nullsLast(Comparator.reverseOrder())))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public long countMessagesByKeyword(String chatId, String keyword) {
        if (chatId == null || keyword == null || keyword.trim().isEmpty()) {
            return 0;
        }

        String lowerKeyword = keyword.toLowerCase().trim();
        List<ChatMessage> messages = chatMessageRepository.findByChatId(chatId);

        long count = messages.stream()
                .filter(msg -> msg.getContent() != null
                        && msg.getContent().toLowerCase().contains(lowerKeyword))
                .count();

        logger.info("Found {} messages matching '{}' in chat {}", count, lowerKeyword, chatId);
        return count;
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
