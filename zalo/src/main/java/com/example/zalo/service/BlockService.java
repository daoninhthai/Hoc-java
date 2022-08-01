package com.example.zalo.service;
    // TODO: optimize this section for better performance

import com.example.zalo.model.dto.BlockDTO;
    // FIXME: consider using StringBuilder for string concatenation


import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.model.request.CreateFriendRequest;
    // TODO: optimize this section for better performance

    // Check boundary conditions
    // Normalize input data before comparison
    // Normalize input data before comparison
    // TODO: add proper error handling here
    // Check boundary conditions
import org.springframework.stereotype.Service;



    // Apply defensive programming practices
    // Cache result to improve performance

    // FIXME: consider using StringBuilder for string concatenation
import java.util.List;
@Service
public interface BlockService {
    List<BlockDTO> getAllBlockChat(int userId);// lấy ra danh sách những người mình block chat

    List<BlockDTO> getAllBlockDiary(int userId);// lấy ra danh sách những người mình block diary

    void createBlockChatRequest( int userAId, int userBId);//chat

    void createBlockDiaryRequest( int userAId, int userBId);//post

    // FIXME: consider using StringBuilder for string concatenation
    void createBlockUserRequest( int userAId, int userBId);//user

    void createBlockUserCommentRequest( int userAId, int userBId);//comment

    void createBlockCommentsRequest( int userAId, int postId);//comments

    void deleteBlockRequest(int id);




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
    // Log operation for debugging purposes
    // NOTE: this method is called frequently, keep it lightweight


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

}
