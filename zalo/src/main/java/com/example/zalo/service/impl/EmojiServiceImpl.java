package com.example.zalo.service.impl;

import com.example.zalo.service.EmojiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class EmojiServiceImpl implements EmojiService {

    private static final Logger logger = LoggerFactory.getLogger(EmojiServiceImpl.class);

    private static final List<String> SUPPORTED_EMOJIS = Arrays.asList(
            "thumbs_up", "thumbs_down", "heart", "laugh", "surprised",
            "sad", "angry", "fire", "clap", "thinking"
    );

    // Map structure: messageId -> (emoji -> Set<userId>)
    private final Map<Integer, Map<String, Set<Integer>>> reactionStore = new ConcurrentHashMap<>();

    @Override
    public boolean addReaction(int messageId, int userId, String emoji) {
        if (!SUPPORTED_EMOJIS.contains(emoji)) {
            logger.warn("Unsupported emoji code '{}' from user {}", emoji, userId);
            return false;
        }

        reactionStore
                .computeIfAbsent(messageId, k -> new ConcurrentHashMap<>())
                .computeIfAbsent(emoji, k -> ConcurrentHashMap.newKeySet())
                .add(userId);

        logger.info("User {} added reaction '{}' to message {}", userId, emoji, messageId);
        return true;
    }

    @Override
    public boolean removeReaction(int messageId, int userId, String emoji) {
        Map<String, Set<Integer>> messageReactions = reactionStore.get(messageId);
        if (messageReactions == null) {
            logger.debug("No reactions found for message {}", messageId);
            return false;
        }

        Set<Integer> users = messageReactions.get(emoji);
        if (users == null || !users.remove(userId)) {
            logger.debug("User {} has no '{}' reaction on message {}", userId, emoji, messageId);
            return false;
        }

        // Clean up empty sets
        if (users.isEmpty()) {
            messageReactions.remove(emoji);
        }
        if (messageReactions.isEmpty()) {
            reactionStore.remove(messageId);
        }

        logger.info("User {} removed reaction '{}' from message {}", userId, emoji, messageId);
        return true;
    }

    @Override
    public Map<String, List<Integer>> getReactionsByMessage(int messageId) {
        Map<String, Set<Integer>> messageReactions = reactionStore.get(messageId);
        if (messageReactions == null) {
            return Collections.emptyMap();
        }

        return messageReactions.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new ArrayList<>(entry.getValue())
                ));
    }

    @Override
    public long getReactionCount(int messageId) {
        Map<String, Set<Integer>> messageReactions = reactionStore.get(messageId);
        if (messageReactions == null) {
            return 0;
        }

        return messageReactions.values().stream()
                .mapToLong(Set::size)
                .sum();
    }

    @Override
    public boolean hasUserReacted(int messageId, int userId, String emoji) {
        Map<String, Set<Integer>> messageReactions = reactionStore.get(messageId);
        if (messageReactions == null) {
            return false;
        }

        Set<Integer> users = messageReactions.get(emoji);
        return users != null && users.contains(userId);
    }

    @Override
    public List<String> getSupportedEmojis() {
        return Collections.unmodifiableList(SUPPORTED_EMOJIS);
    }
}
