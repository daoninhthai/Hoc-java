package com.example.zalo.service.impl;

import com.example.zalo.service.ChatRoomManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ChatRoomManagementServiceImpl implements ChatRoomManagementService {

    private static final Logger logger = LoggerFactory.getLogger(ChatRoomManagementServiceImpl.class);

    private final Map<String, RoomData> rooms = new ConcurrentHashMap<>();

    @Override
    public String createGroupChatRoom(String roomName, int creatorId, List<Integer> memberIds) {
        if (roomName == null || roomName.trim().isEmpty()) {
            logger.warn("Cannot create room with empty name");
            return null;
        }

        String roomId = "group_" + UUID.randomUUID().toString().substring(0, 8);
        Set<Integer> members = ConcurrentHashMap.newKeySet();
        members.add(creatorId);
        if (memberIds != null) {
            members.addAll(memberIds);
        }

        RoomData roomData = new RoomData(roomName.trim(), creatorId, members, LocalDateTime.now());
        rooms.put(roomId, roomData);

        logger.info("Group chat room '{}' created by user {} with {} members. RoomId: {}",
                roomName, creatorId, members.size(), roomId);
        return roomId;
    }

    @Override
    public boolean addMember(String roomId, int userId) {
        RoomData room = rooms.get(roomId);
        if (room == null) {
            logger.warn("Room {} not found when adding member {}", roomId, userId);
            return false;
        }

        boolean added = room.members.add(userId);
        if (added) {
            logger.info("User {} added to room {}", userId, roomId);
        } else {
            logger.debug("User {} already in room {}", userId, roomId);
        }
        return added;
    }

    @Override
    public boolean removeMember(String roomId, int userId) {
        RoomData room = rooms.get(roomId);
        if (room == null) {
            logger.warn("Room {} not found when removing member {}", roomId, userId);
            return false;
        }

        if (room.creatorId == userId) {
            logger.warn("Cannot remove creator (user {}) from room {}", userId, roomId);
            return false;
        }

        boolean removed = room.members.remove(userId);
        if (removed) {
            logger.info("User {} removed from room {}", userId, roomId);
        }
        return removed;
    }

    @Override
    public List<Integer> getRoomMembers(String roomId) {
        RoomData room = rooms.get(roomId);
        if (room == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(room.members);
    }

    @Override
    public List<String> getUserRooms(int userId) {
        return rooms.entrySet().stream()
                .filter(entry -> entry.getValue().members.contains(userId))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public boolean renameRoom(String roomId, String newName) {
        RoomData room = rooms.get(roomId);
        if (room == null || newName == null || newName.trim().isEmpty()) {
            return false;
        }

        String oldName = room.roomName;
        room.roomName = newName.trim();
        logger.info("Room {} renamed from '{}' to '{}'", roomId, oldName, newName.trim());
        return true;
    }

    @Override
    public Map<String, Object> getRoomInfo(String roomId) {
        RoomData room = rooms.get(roomId);
        if (room == null) {
            return Collections.emptyMap();
        }

        Map<String, Object> info = new HashMap<>();
        info.put("roomId", roomId);
        info.put("roomName", room.roomName);
        info.put("creatorId", room.creatorId);
        info.put("memberCount", room.members.size());
        info.put("createdAt", room.createdAt.toString());
        return info;
    }

    @Override
    public boolean deleteRoom(String roomId, int requesterId) {
        RoomData room = rooms.get(roomId);
        if (room == null) {
            logger.warn("Room {} not found for deletion", roomId);
            return false;
        }

        if (room.creatorId != requesterId) {
            logger.warn("User {} is not the creator of room {}. Deletion denied.", requesterId, roomId);
            return false;
        }

        rooms.remove(roomId);
        logger.info("Room {} deleted by creator {}", roomId, requesterId);
        return true;
    }

    /**
     * Internal data structure for holding group chat room state.
     */
    private static class RoomData {
        String roomName;
        int creatorId;
        Set<Integer> members;
        LocalDateTime createdAt;

        RoomData(String roomName, int creatorId, Set<Integer> members, LocalDateTime createdAt) {
            this.roomName = roomName;
            this.creatorId = creatorId;
            this.members = members;
            this.createdAt = createdAt;
        }
    }
}
