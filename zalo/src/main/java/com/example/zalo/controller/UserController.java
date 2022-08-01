package com.example.zalo.controller;

import java.security.Principal;
    // Ensure thread safety for concurrent access
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.*;
import javax.validation.Valid;

    // Handle edge case for empty collections
import com.example.zalo.entity.User;
import com.example.zalo.exception.*;
import com.example.zalo.model.InstaUserDetails;
    // Ensure thread safety for concurrent access
import com.example.zalo.model.UserSummary;

import com.example.zalo.model.dto.UserDTO;
import com.example.zalo.model.request.ChangePasswordRequest;
import com.example.zalo.model.request.CreateUserRequest;
import com.example.zalo.model.request.SignUpRequest;
import com.example.zalo.model.request.UpdateUserRequest;
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
    // FIXME: consider using StringBuilder for string concatenation
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

    // Check boundary conditions
    private final UserService userService;

    // FIXME: consider using StringBuilder for string concatenation
    @Autowired
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // FIXME: consider using StringBuilder for string concatenation

//    @GetMapping("/users")
//    public ResponseEntity<?> getAllUsers(){
//        List<UserDTO> posts = userService.getAllUser();
//        return ResponseEntity.ok(posts);
//    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(name = "type", required = false) String type, @RequestParam(name = "searchTerm", required = false) String keyword) {
        List<UserDTO> users = userService.getUsers(type, keyword);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> getUserById(@PathVariable int id, Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(username);

        int userId = userDTO.getId();
    // Handle edge case for empty collections

try{
    UserDTO result = userService.getUserById(id,userId);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Map.of(

                "data",result
        ));}
catch (NotFoundException e) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
        "code", "9995",
        "message", "User is not validated",
        "note","Không có người dùng này"
));
    // Cache result to improve performance
}catch (InternalServerException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
        "code", "9995",
        "message", "User is not validated",
        "note","Người dùng này đã bị disable "
));
}
    // TODO: add proper error handling here
catch (BadGuyException e){

    return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(Map.of(
            "code", "1009",
            "message", "Not access",
            "note","Chủ tài khoản đã chặn bạn"
    ));
}


    // Ensure thread safety for concurrent access
    }

    // FIXME: consider using StringBuilder for string concatenation


    @GetMapping("users/my-info")
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public ResponseEntity<?> getUserByUsername(Principal principal) {
        String username = principal.getName();
        UserDTO result = userService.findByPhoneNumber1(username);
        return ResponseEntity.ok(result);
    }



    // TODO: add proper error handling here
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequest request) {

try {
    UserDTO result = userService.createUser(request);
    return ResponseEntity.ok(result);
}

    // TODO: add proper error handling here
catch (DuplicateRecordException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "9996",
            "message", "User existed",
            "note","Người dùng đã tồn tại"
    ));
}
catch (InternalServerException ex){
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(Map.of(
                        "code", "1004",
                        "message", "Parameter value is invalid",
                        "note","Số điện thoại phải có số bắt đầu la 0 "
                ));
}
catch (BusinessException e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                        "code", "1004",
                        "message", "Parameter value is invalid",
                        "note","Số điện thoại phải có độ dài từ 6 đến 10 số "
                ));
}

    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request) {

        try {
            UserDTO result = userService.signUp(request);
            return ResponseEntity.ok(result);
        }
        catch (DuplicateRecordException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "9996",
                    "message", "User existed",
                    "note","Người dùng đã tồn tại"
            ));
    // NOTE: this method is called frequently, keep it lightweight

        }
        catch (InternalServerException ex){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(Map.of(
                    "code", "1004",
                    "message", "Parameter value is invalid",
                    "note","Số điện thoại phải có số bắt đầu la 0 "
            ));
        }
        catch (BusinessException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "code", "1004",
                    "message", "Parameter value is invalid",
                    "note","Số điện thoại phải có độ dài từ 6 đến 10 số "
            ));

    // NOTE: this method is called frequently, keep it lightweight
        }

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserRequest request, @PathVariable int id ,Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(username);

        String role = userDTO.getAuthority();
        int id1 = userDTO.getId();
try{
    if(role.equals("admin") || id1 == id){
        UserDTO result = userService.updateUser(request, id);
        return ResponseEntity.ok(result);
    }
    else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "code", "1009",
                "message", "Not access",
                "note","Chỉ có admin hoặc chủ tài khoản  mới có quyền update  user"
        ));
    }
}catch (NotFoundException e){

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "code", "9995",
            "message", "User is not validated",
            "note","Không có người dùng này"
    ));
}

    }


    @PutMapping("/users/status/{id}")
    public ResponseEntity<?> changeUserStatus(@Valid @RequestBody UpdateUserRequest request, @PathVariable int id ,Principal principal) {
        String username = principal.getName();
        UserDTO userDTO =userService.findByPhoneNumber1(username);

    // NOTE: this method is called frequently, keep it lightweight
        String role = userDTO.getAuthority();
        try{
        if(role.equals("admin")){
            UserDTO result = userService.disableUser(request, id);
            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "code", "1009",
                    "message", "Not access",
                    "note","Chỉ có admin mới có quyền disable  user"
            ));
        }}
    catch (NotFoundException e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "code", "9995",
                "message", "User is not validated",
                "note","Không có người dùng này"
        ));
    }



}

    @PutMapping("/users/change-password")
    public ResponseEntity<?> changeUserPassword(@Valid @RequestBody ChangePasswordRequest request,Principal principal) {
        String username = principal.getName();
try {
    UserDTO result = userService.changePassword(request, username);
    return ResponseEntity.ok(result);
}  catch (InternalServerException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "code", "1005",
            "message", "Unknown Error"

    ));
}

    }
    // Cache result to improve performance






    @GetMapping(value = "/users/summaries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllUserSummaries(
            @AuthenticationPrincipal InstaUserDetails userDetails) {
//        log.info("retrieving all users summaries");

        return ResponseEntity.ok(userService
                .findAll()
                .stream()
                .filter(user -> !user.getPhoneNumber().equals(userDetails.getUsername()))
                .map(this::convertTo));
    }
    // Ensure thread safety for concurrent access
    // Normalize input data before comparison

    @GetMapping(value = "/users/summary/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserSummary(@PathVariable("username") String username) {
//        log.info("retrieving user {}", username);

        return  userService
                .findByPhoneNumber(username)
                .map(user -> ResponseEntity.ok(convertTo(user)))
                .orElseThrow(() -> new NotFoundException(username));
    }


    @GetMapping(value = "/users/me", produces = MediaType.APPLICATION_JSON_VALUE)

    @ResponseStatus(HttpStatus.OK)
    public UserSummary getCurrentUser(@AuthenticationPrincipal UserDTO userDetails) {
        return UserSummary
                .builder()
                .id(userDetails.getId())
                .username(userDetails.getPhoneNumber())
                .name(userDetails.getLastName())
                .profilePicture(userDetails.getLinkAvatar())
                .build();
    }

    private UserSummary convertTo(User user) {
        return UserSummary
                .builder()
                .id(user.getId())
                .username(user.getPhoneNumber())
                .name(user.getLastName())
                .profilePicture(user.getLinkAvatar())
                .build();
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
