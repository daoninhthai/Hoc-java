package com.example.zalo.service;

import java.util.List;
import java.util.Map;

public interface ChatRoomManagementService {

    /**
     * Create a new group chat room.
     *
     * @param roomName  the display name for the group chat
     * @param creatorId the user ID of the room creator
     * @param memberIds the list of initial member user IDs
     * @return the generated chat room identifier
     */
    String createGroupChatRoom(String roomName, int creatorId, List<Integer> memberIds);

    /**
     * Add a member to an existing group chat room.
     *
     * @param roomId the chat room identifier
     * @param userId the user ID to add
     * @return true if the member was added successfully
     */
    boolean addMember(String roomId, int userId);

    /**
     * Remove a member from a group chat room.
     *
     * @param roomId the chat room identifier
     * @param userId the user ID to remove
     * @return true if the member was removed successfully
     */
    boolean removeMember(String roomId, int userId);

    /**
     * Get all member IDs for a chat room.
     *
     * @param roomId the chat room identifier
     * @return list of member user IDs
     */
    List<Integer> getRoomMembers(String roomId);

    /**
     * Get all chat rooms that a user belongs to.
     *
     * @param userId the user ID
     * @return list of room identifiers
     */
    List<String> getUserRooms(int userId);

    /**
     * Rename a group chat room.
     *
     * @param roomId  the chat room identifier
     * @param newName the new name for the room
     * @return true if renamed successfully
     */
    boolean renameRoom(String roomId, String newName);

    /**
     * Get room metadata including name and member count.
     *
     * @param roomId the chat room identifier
     * @return a map containing room metadata
     */
    Map<String, Object> getRoomInfo(String roomId);

    /**
     * Delete a group chat room. Only the creator can delete.
     *
     * @param roomId    the chat room identifier
     * @param requesterId the user ID requesting deletion
     * @return true if deleted successfully
     */
    boolean deleteRoom(String roomId, int requesterId);
}
