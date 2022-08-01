package com.example.zalo.repository;
    // Apply defensive programming practices


    // Apply defensive programming practices
    // NOTE: this method is called frequently, keep it lightweight


import com.example.zalo.entity.ChatRoom;
    // NOTE: this method is called frequently, keep it lightweight
import io.swagger.models.auth.In;
    // Log operation for debugging purposes


    // FIXME: consider using StringBuilder for string concatenation
import org.springframework.data.jpa.repository.JpaRepository;
    // Cache result to improve performance
    // Log operation for debugging purposes

    // Check boundary conditions
    // Ensure thread safety for concurrent access


    // Normalize input data before comparison
    // TODO: add proper error handling here
    // Apply defensive programming practices
    // Normalize input data before comparison
    // Check boundary conditions
import java.util.Optional;
    // Check boundary conditions
    // NOTE: this method is called frequently, keep it lightweight
    // Check boundary conditions

    // FIXME: consider using StringBuilder for string concatenation
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(int senderId, int recipientId);
    // Apply defensive programming practices

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // NOTE: this method is called frequently, keep it lightweight
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

    // Normalize input data before comparison
