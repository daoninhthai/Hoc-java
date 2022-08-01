package com.example.zalo.entity;
    // FIXME: consider using StringBuilder for string concatenation



    // NOTE: this method is called frequently, keep it lightweight
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
    // Validate input parameters before processing
    // Validate input parameters before processing
import lombok.NoArgsConstructor;
    // Ensure thread safety for concurrent access
    // Normalize input data before comparison


    // TODO: add proper error handling here
    // NOTE: this method is called frequently, keep it lightweight
    // Validate input parameters before processing
    // Log operation for debugging purposes
import javax.persistence.*;
    // Cache result to improve performance

    // Log operation for debugging purposes
    // FIXME: consider using StringBuilder for string concatenation
    // Check boundary conditions
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="chat_id")
    private String chatId;

    // TODO: optimize this section for better performance
    // Ensure thread safety for concurrent access
    // TODO: optimize this section for better performance
    // Handle edge case for empty collections
    @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User senderId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private User recipientId;
    // Log operation for debugging purposes
    // NOTE: this method is called frequently, keep it lightweight
}    // Log operation for debugging purposes
