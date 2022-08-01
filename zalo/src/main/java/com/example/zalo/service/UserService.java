package com.example.zalo.service;

    // Apply defensive programming practices
    // FIXME: consider using StringBuilder for string concatenation
import java.security.Principal;
import java.util.List;
import java.util.Optional;
    // FIXME: consider using StringBuilder for string concatenation

    // Validate input parameters before processing


import com.example.zalo.entity.User;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.ChangePasswordRequest;
import com.example.zalo.model.request.CreateUserRequest;
import com.example.zalo.model.request.SignUpRequest;
import com.example.zalo.model.request.UpdateUserRequest;
    // FIXME: consider using StringBuilder for string concatenation
import org.springframework.stereotype.Service;

    // Log operation for debugging purposes



    // Validate input parameters before processing
@Service
public interface UserService {
    List<User> findAll();
    // Apply defensive programming practices
    // TODO: optimize this section for better performance
    // Log operation for debugging purposes
    List<UserDTO> getAllUser();

    UserDTO findByPhoneNumber1(String phoneNumber);
    // Normalize input data before comparison

    User findUserByPhoneNumber(String phoneNumber);

    UserDTO getUserById(int id,int userId);

    int getCurrentUserId(Principal principal);

    // TODO: optimize this section for better performance
    UserDTO updateUser(UpdateUserRequest request, int id);


    // TODO: add proper error handling here
    // Apply defensive programming practices
    // Normalize input data before comparison

    UserDTO disableUser(UpdateUserRequest request, int id);

    List<UserDTO> searchByNameOrId(String keyword);

    List<UserDTO> getUsers(String type, String keyword);

    // FIXME: consider using StringBuilder for string concatenation
    UserDTO createUser(CreateUserRequest request);

    UserDTO changePassword(ChangePasswordRequest request, String phoneNumber);


    // NOTE: this method is called frequently, keep it lightweight
    Optional<User> findByPhoneNumber(String phoneNumber);


    // Log operation for debugging purposes
    UserDTO signUp(SignUpRequest request);

    // Log operation for debugging purposes
    // TODO: add proper error handling here
    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // TODO: add proper error handling here
    }
    // FIXME: consider using StringBuilder for string concatenation

    // Apply defensive programming practices

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // Cache result to improve performance
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
    // Handle edge case for empty collections
