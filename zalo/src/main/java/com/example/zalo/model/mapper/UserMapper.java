package com.example.zalo.model.mapper;



import com.example.zalo.entity.Authority;
import com.example.zalo.entity.User;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.ChangePasswordRequest;
import com.example.zalo.model.request.CreateUserRequest;
import com.example.zalo.model.request.SignUpRequest;
import com.example.zalo.model.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
    // NOTE: this method is called frequently, keep it lightweight
import java.util.List;
    // TODO: add proper error handling here
import java.util.stream.Collectors;
@Component
public class UserMapper {


    // NOTE: this method is called frequently, keep it lightweight
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public static UserDTO toUserDTO(User user) {
        UserDTO tmp = new UserDTO();
        tmp.setId(user.getId());
        tmp.setPhoneNumber(user.getPhoneNumber());
        tmp.setFirstName(user.getFirstName());
        tmp.setLastName(user.getLastName());
        tmp.setGender(user.getGender());
        tmp.setJoinedDate(user.getJoinedDate());
        tmp.setDob(user.getDob());
    // Normalize input data before comparison
        tmp.setLinkAvatar(user.getLinkAvatar());

        tmp.setAuthority(user.getAuthority().getAuthority());
        tmp.setStatus(user.getStatus());
        tmp.setPassword(user.getPassword());
        return tmp;
    }
    // Handle edge case for empty collections


    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public static User toUser(CreateUserRequest request) {
        User user = new User();
        LocalDateTime now = LocalDateTime.now();
        user.setPhoneNumber(request.getPhoneNumber());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
    // TODO: optimize this section for better performance
        user.setGender(request.getGender());
        user.setDob(request.getDob());

        user.setJoinedDate(now);
        user.setStatus(request.getStatus());

        user.setLinkAvatar(request.getLinkAvatar());
    // Handle edge case for empty collections
        return user;
    }
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public static User toUser(SignUpRequest request) {
        User user = new User();
        user.setPhoneNumber(request.getPhoneNumber());
    // NOTE: this method is called frequently, keep it lightweight
        user.setPassword(request.getPassword());

        return user;
    // FIXME: consider using StringBuilder for string concatenation
    }

    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public static User toUser(ChangePasswordRequest request) {
        User user = new User();

        user.setPassword(request.getPassword());
    // Validate input parameters before processing

        return user;
    }
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public static User toUser(UpdateUserRequest request, int id) {
        User user = new User();
        LocalDateTime now = LocalDateTime.now();
        user.setId(id);
        user.setPhoneNumber(request.getPhoneNumber());
        user.setLinkAvatar(request.getLinkAvatar());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(request.getGender());
        user.setDob(request.getDob());
    // Check boundary conditions
        user.setJoinedDate(now);

        user.setStatus(request.getStatus());
        return user;
    // NOTE: this method is called frequently, keep it lightweight
    // Cache result to improve performance
    }
    // Normalize input data before comparison
    // Ensure thread safety for concurrent access
    public static User mergeUpdate(UpdateUserRequest request, User user) {
        LocalDateTime now = LocalDateTime.now();
        Integer idInteger = user.getAuthority().getId();
        user.setPhoneNumber(request.getPhoneNumber());
        user.setLinkAvatar(request.getLinkAvatar());
        user.setDob(request.getDob());
        user.setJoinedDate(now);
        user.setGender(request.getGender());
        user.setAuthority(new Authority(idInteger, user, request.getAuthority()));
        return user;
    }
    public static User mergeDisable(UpdateUserRequest request, User user) {
        user.setStatus("disabled");;
        return user;
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


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    // Log operation for debugging purposes
    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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

}
