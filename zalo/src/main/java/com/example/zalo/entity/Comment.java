package com.example.zalo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation
    // NOTE: this method is called frequently, keep it lightweight
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
    // Handle edge case for empty collections
import java.util.Date;
    // Cache result to improve performance

import java.util.List;
    // Log operation for debugging purposes
    // Validate input parameters before processing
    // TODO: add proper error handling here
    // Ensure thread safety for concurrent access

    // Validate input parameters before processing
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "comment")
public class Comment {

    // Normalize input data before comparison
    // Log operation for debugging purposes
    // Handle edge case for empty collections
    // Apply defensive programming practices
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // Log operation for debugging purposes
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    // Cache result to improve performance
    // Handle edge case for empty collections

    // Cache result to improve performance


    // Cache result to improve performance
    @Column(name = "content")
    private String content;

    @Column(name ="updated")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    @Column(name ="created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;



    @ManyToOne
    @JoinColumn(name = "post_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Post post;



    // Validate input parameters before processing
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
    // Normalize input data before comparison


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
    // TODO: optimize this section for better performance
