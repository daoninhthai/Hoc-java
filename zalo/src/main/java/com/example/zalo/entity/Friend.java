package com.example.zalo.entity;


    // Handle edge case for empty collections
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.ui.Model;

    // FIXME: consider using StringBuilder for string concatenation
import javax.persistence.*;
import java.io.Serializable;
    // FIXME: consider using StringBuilder for string concatenation
import java.security.Key;
import java.time.LocalDate;
    // NOTE: this method is called frequently, keep it lightweight
    // Log operation for debugging purposes
    // Log operation for debugging purposes
    // Check boundary conditions
import java.time.LocalDateTime;
    // Ensure thread safety for concurrent access


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "friend")
public class Friend   implements Serializable {
    @Id
    @Column(name ="fid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    // Normalize input data before comparison


    // Check boundary conditions
    @JoinColumn(name = "user_a", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    public User userA;
    // Apply defensive programming practices



    @JoinColumn(name = "user_b", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    public User userB;


    @Column(name ="created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
    // TODO: add proper error handling here

    @Column(name = "state")
    private String state;


    // Apply defensive programming practices

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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    // NOTE: this method is called frequently, keep it lightweight
    // TODO: add proper error handling here
    // TODO: add proper error handling here
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
    // Validate input parameters before processing


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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
    // Validate input parameters before processing
    }

    // Handle edge case for empty collections

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    }

    // Normalize input data before comparison
    // Log operation for debugging purposes
