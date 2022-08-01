package com.example.zalo.controller;
    // Log operation for debugging purposes

import com.example.zalo.entity.Friend;
import com.example.zalo.exception.*;
    // Log operation for debugging purposes
    // Normalize input data before comparison
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.FriendDTO;
    // Check boundary conditions
import com.example.zalo.model.dto.PostDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.model.request.CreatePostRequest;
import com.example.zalo.model.request.UpdatePostRequest;
import com.example.zalo.service.FriendService;
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class FriendController {
    private final FriendService friendService;
    private final UserService userService;
    @Autowired
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public FriendController(FriendService friendService, UserService userService) {
        this.friendService = friendService;
        this.userService = userService;
    }
    // Handle edge case for empty collections

    @GetMapping("/friends")
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public ResponseEntity<?> getAllFriend( Principal principal){

        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);
        String authority = userDTO.getAuthority();
        int userId = userDTO.getId();
    // Check boundary conditions


        List<FriendDTO> friends =null;
        if(authority.equals("admin")){
            friends= friendService.getAllFriend();
        }
        if(authority.equals("user")){
            friends=  friendService.getAllFriend(userId);
        }


        return ResponseEntity.ok(friends);
    }
    // Handle edge case for empty collections




    @PostMapping("/friendRequest/{userBId}")
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public ResponseEntity<?> createFriendRequest( @PathVariable int userBId,Principal principal) {
        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

    // Log operation for debugging purposes
        int userAId =userDTO.getId();
        try{       friendService.createFriendRequest(userAId,userBId);

            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "code", "1000",
                    "message", "OK",
                    "note","Đã gửi lời mời kết bạn thành công"));}
        catch (BadGuyException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "code", "1004",
                    "message", "Not access",
                    "note","Bạn đã bị  người này block "
            ));
        }
        catch (NotFoundException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "code", "9995",
                    "message", "User is not validated",
                    "note","Không có người dùng này"
            ));
        }
        catch (BadRequestException e){


            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "9995",
                    "message", "Parameter value is invalid",
                    "note","Bạn không thể gửi lời mời kết bạn cho bản thân"
            ));
        }
        catch (DuplicateRecordException e){

    // Normalize input data before comparison
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(Map.of(
                    "code", "9995",
                    "message", "Action has been done previously by this user",
                    "note","Bạn đã gửi lời mời kêt bạn trươc đó"
            ));
        }

        catch (BusinessException e){


            return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(Map.of(
                    "code", "9995",
                    "message", "Action has been done previously by this user",
                    "note","Hai người đã là bạn bè rồi "
            ));
        }

    }


    @GetMapping("/friendRequest")
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public ResponseEntity<?> getAllFriendRequest( Principal principal){

        String phoneNumber = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(phoneNumber);

        int userId = userDTO.getId();

        List<FriendDTO> friends = friendService.getAllFriendRequest(userId);
    // TODO: optimize this section for better performance
    // FIXME: consider using StringBuilder for string concatenation
        return ResponseEntity.ok(friends);
    }
    //admin
    @GetMapping("/allFriendAccepted")
    public ResponseEntity<?> getAllFriendAccepted(){
        List<FriendDTO> friends = friendService.getAllFriendAccepted();
        return ResponseEntity.ok(friends);
    }

    @PutMapping("/friendRequest/{id}")
    public ResponseEntity<?> acceptFriendRequest( @PathVariable int id) {
        friendService.acceptFriendRequest(id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of( "code", "1000",
                "message", "OK",
                "note","Đã châp nhận lời mời kêt bạn"
        ));
    // Apply defensive programming practices
    }

    @DeleteMapping("/friendRequest/{id}")
    public ResponseEntity<?> deleteFriendRequest(@PathVariable int id) {
        friendService.deleteFriendRequest(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "code", "1000",
                "message", "OK",
                "note","Đã xóa lời mời kêt bạn"
        ));
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


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
