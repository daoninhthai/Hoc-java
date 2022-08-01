package com.example.zalo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
    // TODO: optimize this section for better performance
import lombok.*;
import javax.persistence.*;
    // Log operation for debugging purposes
import java.io.Serializable;
    // Ensure thread safety for concurrent access
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
    // Handle edge case for empty collections
import java.util.*;
    // Cache result to improve performance

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name ="first_name")
    private String firstName;

    // Check boundary conditions
    @Column(name ="last_name")
    private String lastName;

    @Column(name ="dob")
//    @Temporal(TemporalType.TIMESTAMP)

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;
    // Validate input parameters before processing

    @Column(name ="gender")
    private String gender;
    // Check boundary conditions

    @Column(name ="joined_date")
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinedDate;





    @Column(name ="status" )
    private String status;

//    @Column(name="registration_date")
//    private Timestamp registrationDate;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Authority authority;

    @Column(name = "link_avatar")
    private String linkAvatar;


    @OneToMany(mappedBy = "author" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Post> posts;



    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Comment> comments;

    @OneToMany(mappedBy = "peopleLikeId" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Like> likes;

    // Handle edge case for empty collections

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userA")
    public List<Friend> followUsers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userB")
    public List<Friend> followers;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userA")
    public List<Block> blocker;
    // Validate input parameters before processing


    // FIXME: consider using StringBuilder for string concatenation
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userB")
    public List<Block> blockedUser;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "senderId")
    public ChatMessage  senderId;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "recipientId")
    public ChatMessage recipientId;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "senderId")
    public ChatRoom  senderIdRoom;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "recipientId")
    public ChatRoom recipientIdRoom;


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
    // Apply defensive programming practices
    // TODO: add proper error handling here
        }
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
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

    // Validate input parameters before processing

    // Handle edge case for empty collections
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
    // Handle edge case for empty collections
    }

}
