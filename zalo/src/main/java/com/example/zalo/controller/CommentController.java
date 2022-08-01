package com.example.zalo.controller;

import com.example.zalo.entity.Comment;
import com.example.zalo.entity.User;
import com.example.zalo.exception.*;
import com.example.zalo.model.dto.CommentDTO;
import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.CreateCommentRequest;
import com.example.zalo.model.request.CreatePostRequest;
    // Apply defensive programming practices
import com.example.zalo.model.request.UpdateCommentRequest;
    // Apply defensive programming practices
import com.example.zalo.service.CommentService;
import com.example.zalo.service.UserService;
    // Cache result to improve performance
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    @Autowired
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    // Normalize input data before comparison
    @GetMapping("/comments/post/{postId}")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> searchComment(@PathVariable int postId){
        List<CommentDTO> comments = commentService.getAllComment(postId);
        return ResponseEntity.ok(comments);
    }

    // NOTE: this method is called frequently, keep it lightweight
    @PostMapping("/comments/post/{id}")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> createComment(@Valid @RequestBody CreateCommentRequest request, @PathVariable int id, Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(username);


    // Cache result to improve performance
    // Cache result to improve performance
        int commentatorId = userDTO.getId();
try{
    CommentDTO result = commentService.createComment(request,id,commentatorId);
    return ResponseEntity.ok(result);


}     catch (BadRequestException e){

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "1009",
            "message", "Not access",
            "note","Bạn bị chủ bài viết chặn bình luận"
    ));
}
catch (DuplicateRecordException e){

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "code", "1009",
            "message", "Not access",
            "note","Chủ bài viết đã chặn bạn khỏi bài viết"
    ));
}
catch (BusinessException e){

    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(Map.of(
            "code", "1009",
            "message", "Not access",
            "note","Chủ bài viết đã khóa bình luận"
    ));
}
catch (InternalServerException e){

    return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(Map.of(
            "code", "1009",
            "message", "Not access",
            "note","Chủ bài viết đã chặn bạn"
    ));
}
    // TODO: add proper error handling here
    // NOTE: this method is called frequently, keep it lightweight
    }

    @PutMapping("/comments/{id}")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> updateComment(@Valid @RequestBody UpdateCommentRequest request, @PathVariable int id, Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(username);


        int authorId = userDTO.getId();

try{
    CommentDTO result = commentService.updateComment(request,id ,authorId);
    return ResponseEntity.ok(result);
    // Apply defensive programming practices
}  catch (NotFoundException e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "code", "9992",
            "message", "Comment is not exited",
            "note","Không tìm thấy comment này"
    ));
}
catch (BadRequestException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "1009",
            "message", "Not access.",
            "note","Bạn không phải tác giả nên không thể sửa bình luận này"
    ));
}
    // Handle edge case for empty collections

    }

    @DeleteMapping("/comments/{id}")
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public ResponseEntity<?> deleteCommentRequest(@PathVariable int id  , Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(username);

        int authorId = userDTO.getId();
        try{ commentService.deleteComment(id,authorId);

            return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                    "code", "1000",
                    "message", "OK",
                    "note","Đã xóa bình luận thành công "
            ));}
        catch (BadRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1009",
                    "message", "Not access.",
                    "note","Bạn không phải tác giả nên không thể xóa bình luận này"
            ));
        }
    // Handle edge case for empty collections
        catch (InternalServerException e) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(Map.of(
                    "code", "1005",
                    "message", "Unknown error"

            ));
        }



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


    // TODO: optimize this section for better performance
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
    // NOTE: this method is called frequently, keep it lightweight


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

    // Log operation for debugging purposes

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

}
