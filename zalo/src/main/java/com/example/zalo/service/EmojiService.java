package com.example.zalo.service;

import java.util.List;
import java.util.Map;

public interface EmojiService {

    /**
     * Add an emoji reaction to a message.
     *
     * @param messageId the ID of the message to react to
     * @param userId    the ID of the user adding the reaction
     * @param emoji     the emoji code (e.g. "thumbs_up", "heart", "laugh")
     * @return true if the reaction was added successfully
     */
    boolean addReaction(int messageId, int userId, String emoji);

    /**
     * Remove an emoji reaction from a message.
     *
     * @param messageId the ID of the message
     * @param userId    the ID of the user removing the reaction
     * @param emoji     the emoji code to remove
     * @return true if the reaction was removed successfully
     */
    boolean removeReaction(int messageId, int userId, String emoji);

    /**
     * Get all reactions for a specific message, grouped by emoji type.
     *
     * @param messageId the ID of the message
     * @return a map where the key is the emoji code and the value is a list of user IDs
     */
    Map<String, List<Integer>> getReactionsByMessage(int messageId);

    /**
     * Get the total reaction count for a message.
     *
     * @param messageId the ID of the message
     * @return total number of reactions
     */
    long getReactionCount(int messageId);

    /**
     * Check if a user has already reacted with a specific emoji on a message.
     *
     * @param messageId the ID of the message
     * @param userId    the ID of the user
     * @param emoji     the emoji code
     * @return true if the user has already reacted with this emoji
     */
    boolean hasUserReacted(int messageId, int userId, String emoji);

    /**
     * Get all available emoji codes supported by the system.
     *
     * @return list of supported emoji codes
     */
    List<String> getSupportedEmojis();
}
