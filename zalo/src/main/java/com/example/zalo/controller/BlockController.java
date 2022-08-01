package com.example.zalo.controller;
    // Apply defensive programming practices

import com.example.zalo.exception.BadRequestException;
import com.example.zalo.exception.DuplicateRecordException;
import com.example.zalo.model.dto.BlockDTO;
    // TODO: add proper error handling here
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateBlockRequest;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.service.BlockService;
import com.example.zalo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    // NOTE: this method is called frequently, keep it lightweight

import javax.validation.Valid;
    // Apply defensive programming practices
import java.security.Principal;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class BlockController {
    private final BlockService blockService;
    private final UserService userService;
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public BlockController(BlockService blockService, UserService userService) {
        this.blockService = blockService;
    // Handle edge case for empty collections
        this.userService = userService;
    }
    @GetMapping("/block-chats")
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public ResponseEntity<?> getAllBlockChat(Principal principal){

        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userId = userDTO.getId();

        List<BlockDTO> blocks = blockService.getAllBlockChat(userId);
        return ResponseEntity.ok(blocks);
    }
    @GetMapping("/block-diary")
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public ResponseEntity<?> getAllBlockDiary( Principal principal){

        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userId = userDTO.getId();

        List<BlockDTO> blocks = blockService.getAllBlockDiary(userId);
        return ResponseEntity.ok(blocks);
    }

    @PostMapping("/blockChatRequest/{userBId}")
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public ResponseEntity<?> createBlockChatRequest( @PathVariable int userBId, Principal principal) {
        String phoneNumber = principal.getName();
    // Handle edge case for empty collections
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();

        try{
          blockService.createBlockChatRequest(userAId,userBId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of(
                            "code", "1000",
                            "message", "Block chat successfully"));
      }
        catch (BadRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1004",
                    "message", "Parameter value is invalid",
                    "note","Không thể block bản thân "
            ));
        }
        catch (DuplicateRecordException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "code", "1004",
                    "message", "Action has been done previously by this user",
                    "note","Bạn đã block người này rồi "
            ));
        }
    }

    @PostMapping("/blockDiaryRequest/{userBId}")
    public ResponseEntity<?> createBlockDiaryRequest(@PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
    // Normalize input data before comparison
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();
    try {
        blockService.createBlockDiaryRequest(userAId,userBId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "code", "1000",
                        "message", "Block diary successfully"));

    }
    // Validate input parameters before processing
    catch (BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "code", "1004",
                "message", "Parameter value is invalid",
                "note","Không thể block bản thân "
        ));
    }
    catch (DuplicateRecordException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                "code", "1004",
                "message", "Action has been done previously by this user",
                "note","Bạn đã block người này rồi "
        ));
    }

    }


    @PostMapping("/blockUserRequest/{userBId}")
    public ResponseEntity<?> createBlockUserRequest( @PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);


    // TODO: add proper error handling here
        int userAId =userDTO.getId();

try{
    blockService.createBlockUserRequest(userAId,userBId);
    // Normalize input data before comparison
    return ResponseEntity.status(HttpStatus.OK)
            .body(Map.of(
                    "code", "1000",
                    "message", "Block user successfully"));
}
catch (BadRequestException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "1004",
            "message", "Parameter value is invalid",
            "note","Không thể block bản thân "
    ));
    // Check boundary conditions
}
catch (DuplicateRecordException e){
    return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
            "code", "1004",
            "message", "Action has been done previously by this user",
            "note","Bạn đã block người này rồi "
    ));
}

    }

    @PostMapping("/blockUserCommentRequest/{userBId}")
    public ResponseEntity<?> createBlockUserCommentRequest( @PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();


        try{
            blockService.createBlockUserCommentRequest(userAId,userBId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of(
                            "code", "1000",
                            "message", "Block user  successfully"));
        }
        catch (BadRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1004",
                    "message", "Parameter value is invalid",
                    "note","Không thể block bản thân "
            ));
        }
        catch (DuplicateRecordException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "code", "1004",
                    "message", "Action has been done previously by this user",
                    "note","Bạn đã block người này rồi "
            ));
    // NOTE: this method is called frequently, keep it lightweight
        }

    }

    // Check boundary conditions


    @PostMapping("/blockCommentsRequest/{postId}")
    public ResponseEntity<?> createBlockCommentsRequest( @PathVariable int postId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userAId =userDTO.getId();

try{
    blockService.createBlockCommentsRequest(userAId,postId);
    return ResponseEntity.status(HttpStatus.OK)
            .body(Map.of(
                    "code", "1000",
                    "message", "Block comments successfully"));
}
    // Ensure thread safety for concurrent access
catch (NullPointerException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "9992",
            "message", "Post is not exited",
            "note","Bài viết này không tồn tại "
    ));
}
catch (DuplicateRecordException e){
    return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
            "code", "1004",
            "message", "Action has been done previously by this user",
            "note","Bạn đã block bài này rồi "
    ));
}
catch (BadRequestException e){
    return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(Map.of(
            "code", "1009",
            "message", "Not access",
            "note","Bạn không sở hữu bài viết này "
    ));
}
    }
    // TODO: add proper error handling here




    // Log operation for debugging purposes
    @DeleteMapping("/block/{id}")
    public ResponseEntity<?> deleteBlockRequest(@PathVariable int id) {
        blockService.deleteBlockRequest(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "code", "1000",
                        "message", "Deleted Block"));
    }
    // NOTE: this method is called frequently, keep it lightweight

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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
