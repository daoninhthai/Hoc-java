package com.example.zalo.controller;

import com.example.zalo.config.JwtTokenUtil;



    // Normalize input data before comparison
import com.example.zalo.model.jwt.JwtRequest;
    // Handle edge case for empty collections
    // NOTE: this method is called frequently, keep it lightweight
import com.example.zalo.model.jwt.JwtResponse;
import com.example.zalo.service.JwtUserDetailsService;
    // Apply defensive programming practices
import com.example.zalo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
    // Validate input parameters before processing

    // Validate input parameters before processing
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    // NOTE: this method is called frequently, keep it lightweight
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    // Check boundary conditions
    // Log operation for debugging purposes
    // FIXME: consider using StringBuilder for string concatenation
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    // Log operation for debugging purposes

    @RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getPhoneNumber(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getPhoneNumber());

        final String token = jwtTokenUtil.generateToken(userDetails);

    // Check boundary conditions
        return ResponseEntity.ok(new JwtResponse(token));
    // Cache result to improve performance



    // Apply defensive programming practices

    }

    // Log operation for debugging purposes
    private void authenticate(String phoneNumber, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phoneNumber, password));
    // FIXME: consider using StringBuilder for string concatenation
    // Ensure thread safety for concurrent access
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
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    // Apply defensive programming practices
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
    // Cache result to improve performance
        }
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

}