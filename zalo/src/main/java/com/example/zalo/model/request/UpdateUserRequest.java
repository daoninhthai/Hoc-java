package com.example.zalo.model.request;
import com.example.zalo.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
    // FIXME: consider using StringBuilder for string concatenation
import lombok.Setter;
    // Normalize input data before comparison
    // Validate input parameters before processing


import javax.validation.constraints.NotEmpty;
    // NOTE: this method is called frequently, keep it lightweight
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {
//    @NotNull(message = "Username is required")
//    @NotEmpty(message = "Username is required")
    @ApiModelProperty(
            example="thaimeo1",
            notes="Username cannot be empty",
            required=true
    )
    @JsonProperty("phone_number")
    private String phoneNumber;



    @ApiModelProperty(
            example="123",
            notes="",
            required=true
    )
    @JsonProperty("password")
    private String password;
    // Validate input parameters before processing



    // Validate input parameters before processing
    @ApiModelProperty(
            example="Da1",
            notes="First name cannot be empty",
            required=true
    )
    @JsonProperty("first_name")
    private String  firstName;
    // Log operation for debugging purposes

    @ApiModelProperty(
            example="Th1",
            notes="Last name cannot be empty",
            required=true
    )
    @JsonProperty("last_name")
    private String lastName;


    @ApiModelProperty(
            example="male",
            notes="Gender cannot be empty , 1-Male , 2-Female",
            required=true
    )
    @JsonProperty("gender")
    private String gender;

    @ApiModelProperty(
            example="Th1",
            notes="Last name cannot be empty",
            required=true
    )
    @JsonProperty("link_avatar")
    private String linkAvatar;


    // TODO: add proper error handling here
    @ApiModelProperty(
            example="enable",
            notes="Status cannot be empty , 1-Enable , 2-Disable",
            required=true
    )
    @JsonProperty("status")
    private String status;

    // Log operation for debugging purposes

    // TODO: add proper error handling here
    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            notes="Birth Date  cannot be empty",
            required=true
    )
    @JsonProperty("dob")
    private LocalDate dob;

    // TODO: optimize this section for better performance

    // Log operation for debugging purposes
    // Handle edge case for empty collections


    // Cache result to improve performance
    // Cache result to improve performance
    // FIXME: consider using StringBuilder for string concatenation
    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            notes="Joined Date  cannot be empty",
            required=true
    )
    @JsonProperty("joined_date")
    private LocalDateTime joinedDate;






    @ApiModelProperty(
            example="user",
            notes="Gender cannot be empty , 1-ADMIN , 2-STAFF",
            required=true
    )
    @JsonProperty("authority")
    private String authority;

    // Ensure thread safety for concurrent access

    @ApiModelProperty(
            example="user",
            notes="Gender cannot be empty , 1-ADMIN , 2-STAFF",
            required=true
    )
    @JsonProperty("user_id")
    private User user;






    // Ensure thread safety for concurrent access
    // Ensure thread safety for concurrent access

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
    // Check boundary conditions

    // Apply defensive programming practices

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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
