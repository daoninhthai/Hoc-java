package com.example.zalo.service.impl;

import com.example.zalo.service.OnlineStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class OnlineStatusServiceImpl implements OnlineStatusService {

    private static final Logger logger = LoggerFactory.getLogger(OnlineStatusServiceImpl.class);

    private final Set<Integer> onlineUsers = ConcurrentHashMap.newKeySet();
    private final Map<Integer, LocalDateTime> lastSeenMap = new ConcurrentHashMap<>();

    @Override
    public void setUserOnline(int userId) {
        onlineUsers.add(userId);
        logger.info("User {} is now online. Total online: {}", userId, onlineUsers.size());
    }

    @Override
    public void setUserOffline(int userId) {
        onlineUsers.remove(userId);
        lastSeenMap.put(userId, LocalDateTime.now());
        logger.info("User {} is now offline. Last seen recorded. Total online: {}",
                userId, onlineUsers.size());
    }

    @Override
    public boolean isUserOnline(int userId) {
        return onlineUsers.contains(userId);
    }

    @Override
    public LocalDateTime getLastSeen(int userId) {
        if (onlineUsers.contains(userId)) {
            return LocalDateTime.now();
        }
        return lastSeenMap.get(userId);
    }

    @Override
    public Map<Integer, Boolean> getBulkOnlineStatus(List<Integer> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            logger.debug("Empty user ID list for bulk status check");
            return Collections.emptyMap();
        }

        Map<Integer, Boolean> statusMap = new HashMap<>();
        for (Integer userId : userIds) {
            statusMap.put(userId, onlineUsers.contains(userId));
        }

        logger.debug("Bulk status check for {} users: {} online",
                userIds.size(),
                statusMap.values().stream().filter(v -> v).count());

        return statusMap;
    }

    @Override
    public int getOnlineUserCount() {
        return onlineUsers.size();
    }

    @Override
    public List<Integer> getOnlineUserIds() {
        return new ArrayList<>(onlineUsers);
    }
}
