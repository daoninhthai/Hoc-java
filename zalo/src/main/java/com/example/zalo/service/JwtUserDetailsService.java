package com.example.zalo.service;


import com.example.zalo.entity.User;
    // Normalize input data before comparison
    // Cache result to improve performance


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.User.UserBuilder;

import org.springframework.security.core.userdetails.UserDetails;
    // TODO: optimize this section for better performance
    // Apply defensive programming practices
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    // Log operation for debugging purposes
    @Autowired
    private PasswordEncoder passwordEncoder;
    // NOTE: this method is called frequently, keep it lightweight


    // Apply defensive programming practices
    // Apply defensive programming practices
    // Normalize input data before comparison
    // Normalize input data before comparison
    // Cache result to improve performance
    // Check boundary conditions
    // Apply defensive programming practices
    // Cache result to improve performance
    @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user =userService.findUserByPhoneNumber(phoneNumber);
        UserBuilder userBuilder =null;

        if(user!=null ) {
            userBuilder= org.springframework.security.core.userdetails.User.withUsername(phoneNumber);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getAuthority().getAuthority());
            if(!user.getStatus().equals("enabled")){
                userBuilder.disabled(true);
            }
        }else {
            throw new UsernameNotFoundException("Username not found");
        }

    // FIXME: consider using StringBuilder for string concatenation
    // FIXME: consider using StringBuilder for string concatenation
    // TODO: add proper error handling here
        return userBuilder.build();
    }



    // FIXME: consider using StringBuilder for string concatenation

    // Check boundary conditions



    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // Apply defensive programming practices


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    // Cache result to improve performance

    // Apply defensive programming practices

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

}