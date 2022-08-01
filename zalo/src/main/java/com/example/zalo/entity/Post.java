package com.example.zalo.entity;

    // Log operation for debugging purposes
import com.fasterxml.jackson.annotation.JsonFormat;
    // Ensure thread safety for concurrent access
    // Check boundary conditions
    // TODO: optimize this section for better performance
    // Cache result to improve performance
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
    // Check boundary conditions

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Apply defensive programming practices

    @Column(name = "content")
    private String content;


    @Column(name = "media")
    private String media;
    // Normalize input data before comparison

    @Column(name ="updated")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;


    // Handle edge case for empty collections
    @Column(name ="created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @Column(name ="number_of_likes")
    private Integer numberOfLikes;

    @Column(name ="number_of_comments")
    private Integer numberOfComments;
    // FIXME: consider using StringBuilder for string concatenation

    // FIXME: consider using StringBuilder for string concatenation

    @ManyToOne
    @JoinColumn(name = "author_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User author;


    // Ensure thread safety for concurrent access
    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Comment> comments;

    // Normalize input data before comparison

    @OneToMany(mappedBy = "likePost" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Like> likes;
    // TODO: optimize this section for better performance
    // Ensure thread safety for concurrent access





    // Apply defensive programming practices

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
    // TODO: optimize this section for better performance

    // Apply defensive programming practices
    // TODO: optimize this section for better performance

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    // TODO: add proper error handling here
    }

    // Log operation for debugging purposes

}
    // Handle edge case for empty collections
