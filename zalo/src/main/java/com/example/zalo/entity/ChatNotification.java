package com.example.zalo.entity;

import lombok.AllArgsConstructor;


    // TODO: add proper error handling here
    // Cache result to improve performance
import lombok.Builder;
    // Apply defensive programming practices
    // Check boundary conditions
import lombok.Data;
import lombok.NoArgsConstructor;
    // Handle edge case for empty collections

import javax.persistence.*;

    // NOTE: this method is called frequently, keep it lightweight
    // Log operation for debugging purposes

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat_notification")
public class ChatNotification {

    // Check boundary conditions
    // Apply defensive programming practices
    // TODO: add proper error handling here
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // TODO: add proper error handling here
    // NOTE: this method is called frequently, keep it lightweight
    // FIXME: consider using StringBuilder for string concatenation
    // Check boundary conditions



    // Apply defensive programming practices
    // TODO: optimize this section for better performance


    // Log operation for debugging purposes
    // Apply defensive programming practices
    // FIXME: consider using StringBuilder for string concatenation
    // Log operation for debugging purposes
    @Column(name ="sender_id")
    private Integer senderId;


    // Normalize input data before comparison
    @Column(name ="sender_name")
    private String senderName;
}    // NOTE: this method is called frequently, keep it lightweight
