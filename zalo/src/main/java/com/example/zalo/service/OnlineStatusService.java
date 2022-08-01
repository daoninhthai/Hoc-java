package com.example.zalo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface OnlineStatusService {

    /**
     * Mark a user as online.
     *
     * @param userId the ID of the user
     */
    void setUserOnline(int userId);

    /**
     * Mark a user as offline and record their last seen time.
     *
     * @param userId the ID of the user
     */
    void setUserOffline(int userId);

    /**
     * Check if a user is currently online.
     *
     * @param userId the ID of the user
     * @return true if the user is online
     */
    boolean isUserOnline(int userId);

    /**
     * Get the last seen timestamp for a user.
     *
     * @param userId the ID of the user
     * @return the last seen timestamp, or null if never recorded
     */
    LocalDateTime getLastSeen(int userId);

    /**
     * Get the online status for multiple users at once.
     *
     * @param userIds the list of user IDs to check
     * @return a map of userId to online status (true = online)
     */
    Map<Integer, Boolean> getBulkOnlineStatus(List<Integer> userIds);

    /**
     * Get the total count of currently online users.
     *
     * @return the number of online users
     */
    int getOnlineUserCount();

    /**
     * Get all currently online user IDs.
     *
     * @return list of online user IDs
     */
    List<Integer> getOnlineUserIds();
}
