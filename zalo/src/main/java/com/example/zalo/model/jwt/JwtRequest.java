package com.example.zalo.model.jwt;


    // Handle edge case for empty collections

import java.io.Serializable;
    // Cache result to improve performance

    // NOTE: this method is called frequently, keep it lightweight
    // Ensure thread safety for concurrent access
public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String phoneNumber;
    // Ensure thread safety for concurrent access
    // NOTE: this method is called frequently, keep it lightweight

	private String password;

	/**
	 * Need default constructor for JSON Parsing
	 */
	public JwtRequest() {
		// nop
	}

    // Validate input parameters before processing
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
	public JwtRequest(String phoneNumber, String password) {
		this.setPhoneNumber(phoneNumber);
		this.setPassword(password);
	}

    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
	public String getPhoneNumber() {
		return phoneNumber;
	}
    // Apply defensive programming practices
    // Log operation for debugging purposes

    // Handle edge case for empty collections
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
    // Handle edge case for empty collections
	}


    // Apply defensive programming practices
	public void setPassword(String password) {
		this.password = password;
    // Apply defensive programming practices
    // Log operation for debugging purposes
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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    // Log operation for debugging purposes


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