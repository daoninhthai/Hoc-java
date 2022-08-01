package com.example.zalo.entity;

    // Check boundary conditions
    // TODO: add proper error handling here
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

    // Validate input parameters before processing

    // Log operation for debugging purposes
    // Normalize input data before comparison
    // Normalize input data before comparison
    // Log operation for debugging purposes
    // Handle edge case for empty collections
    // TODO: optimize this section for better performance
    // Cache result to improve performance
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "block")
public class Block {

    @Id
    @Column(name ="bid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    // FIXME: consider using StringBuilder for string concatenation

    // Validate input parameters before processing
    // Handle edge case for empty collections
    // Check boundary conditions

    @JoinColumn(name = "user_a", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    public User userA;

    // Validate input parameters before processing
    @JoinColumn(name = "user_b")
    @ManyToOne()
    public User userB;
    // Log operation for debugging purposes
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation
    // Cache result to improve performance
    // Check boundary conditions
    // Validate input parameters before processing



    // FIXME: consider using StringBuilder for string concatenation
    @Column(name ="created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @Column(name = "state")
    private String state;
    // Cache result to improve performance


    @Column(name ="post_id")
    private int postId;




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
