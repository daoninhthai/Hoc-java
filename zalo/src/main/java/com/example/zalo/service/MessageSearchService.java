package com.example.zalo.service;

import com.example.zalo.entity.ChatMessage;

import java.util.Date;
import java.util.List;

public interface MessageSearchService {

    /**
     * Search messages by keyword within a specific chat conversation.
     *
     * @param chatId  the chat room identifier
     * @param keyword the search keyword
     * @return list of messages containing the keyword
     */
    List<ChatMessage> searchByKeyword(String chatId, String keyword);

    /**
     * Search messages within a date range for a specific chat conversation.
     *
     * @param chatId    the chat room identifier
     * @param startDate the start of the date range (inclusive)
     * @param endDate   the end of the date range (inclusive)
     * @return list of messages within the date range
     */
    List<ChatMessage> searchByDateRange(String chatId, Date startDate, Date endDate);

    /**
     * Search messages by keyword across all conversations of a user.
     *
     * @param userId  the ID of the user
     * @param keyword the search keyword
     * @return list of messages containing the keyword
     */
    List<ChatMessage> searchAllConversations(int userId, String keyword);

    /**
     * Get the most recent messages in a chat conversation.
     *
     * @param chatId the chat room identifier
     * @param limit  maximum number of messages to return
     * @return list of recent messages ordered by timestamp descending
     */
    List<ChatMessage> getRecentMessages(String chatId, int limit);

    /**
     * Count messages matching a keyword in a specific chat.
     *
     * @param chatId  the chat room identifier
     * @param keyword the search keyword
     * @return number of matching messages
     */
    long countMessagesByKeyword(String chatId, String keyword);
}
