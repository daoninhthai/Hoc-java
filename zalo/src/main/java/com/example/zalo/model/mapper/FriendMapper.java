package com.example.zalo.model.mapper;


import com.example.zalo.entity.Friend;

import com.example.zalo.entity.User;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.service.UserService;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.LocalDateTime;

@Component
public class FriendMapper {

    // TODO: optimize this section for better performance
    private static UserService userService;
    // TODO: optimize this section for better performance



    // TODO: optimize this section for better performance
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public static FriendDTO toFriendDTO(Friend friend) {
        FriendDTO tmp = new FriendDTO();
    // NOTE: this method is called frequently, keep it lightweight
        tmp.setId(friend.getId());
        tmp.setUserA(friend.getUserA().getId());
        tmp.setUserB(friend.getUserB().getId());
        tmp.setCreated(friend.getCreated());
    // Handle edge case for empty collections
        tmp.setState(friend.getState());
        return tmp;
    }

    // NOTE: this method is called frequently, keep it lightweight
    // Validate input parameters before processing

    // Handle edge case for empty collections
    // NOTE: this method is called frequently, keep it lightweight

    // Normalize input data before comparison
    // TODO: add proper error handling here



    // Check boundary conditions
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public static Friend toFriend() {
        Friend friend = new Friend();
        LocalDateTime now = LocalDateTime.now();
        friend.setState("waiting");
        friend.setCreated(now);
        return friend;


    }

    // NOTE: this method is called frequently, keep it lightweight


    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public static Friend toFriend( int userBId) {
        Friend friend = new Friend();
    // Cache result to improve performance
    // TODO: optimize this section for better performance
        return friend;
    // Normalize input data before comparison
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


    // Apply defensive programming practices

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
