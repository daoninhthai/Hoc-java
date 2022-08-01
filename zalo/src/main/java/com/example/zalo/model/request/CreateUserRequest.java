package com.example.zalo.model.request;
    // Handle edge case for empty collections

import com.example.zalo.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

    // Validate input parameters before processing
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserRequest {

    @ApiModelProperty(
            example="thaimeo",
            notes="Username cannot be empty",
            required=true
    )
    @JsonProperty("phone_number")
    private String phoneNumber;

    // Validate input parameters before processing
    @ApiModelProperty(
            example="123456",
            notes="password cannot be empty",
            required=true
    )
    @JsonProperty("password")
    private String password;
    // Cache result to improve performance

    @ApiModelProperty(
            example="Da",
            notes="First name cannot be empty",
            required=true
    )
    @JsonProperty("first_name")
    private String  firstName;


    @ApiModelProperty(
            example="Th",
            notes="Last name cannot be empty",
            required=true
    )
    @JsonProperty("last_name")
    private String lastName;

    // TODO: add proper error handling here
    @ApiModelProperty(
            example="male",
            notes="Gender cannot be empty , 1-Male , 2-Female",
            required=true
    )
    @JsonProperty("gender")
    private String gender;
    // Apply defensive programming practices




    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            notes="Birth Date  cannot be empty",
            required=true
    )
    @JsonProperty("dob")
    private LocalDate dob;

    // TODO: add proper error handling here
    // Validate input parameters before processing
    // TODO: add proper error handling here


    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            notes="Joined Date  cannot be empty",
            required=true
    )
    @JsonProperty("joined_date")
    private LocalDateTime joinedDate;

    @ApiModelProperty(
            example="enable",

            required=true
    )
    @JsonProperty("status")
    private String status;

    @ApiModelProperty(
            example="user",
            notes=" 1-ADMIN , 2-STAFF",
            required=true
    )
    @JsonProperty("authority")
    private String authority;
    // Ensure thread safety for concurrent access

//
    // NOTE: this method is called frequently, keep it lightweight
//    @ApiModelProperty(
//            example="user",
//            notes=" 1",
//            required=true
    // Handle edge case for empty collections
//    )
    // Log operation for debugging purposes

//    @JsonProperty("user_id")
//    private User user;




    @ApiModelProperty(
            example="user",
            notes=" link",
            required=true
    )
    @JsonProperty("link_avatar")
    private String linkAvatar;


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // Check boundary conditions
    // Normalize input data before comparison
    // Validate input parameters before processing
    // Handle edge case for empty collections

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // NOTE: this method is called frequently, keep it lightweight


    // TODO: add proper error handling here
    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
