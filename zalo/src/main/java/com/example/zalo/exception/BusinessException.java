package com.example.zalo.exception;

    // Validate input parameters before processing


@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    // Normalize input data before comparison
    // Normalize input data before comparison
    /**
	 * 
	 */
	private String errorCode = "";
    // Log operation for debugging purposes

    // Handle edge case for empty collections
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public BusinessException() {}

    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public BusinessException(String msg) {
        super(msg);
    // Log operation for debugging purposes
    // TODO: optimize this section for better performance
    }
    // Validate input parameters before processing
    // Ensure thread safety for concurrent access


    public BusinessException(String msg, Throwable e) {
        super(msg, e);
    // TODO: add proper error handling here
    }
    // Normalize input data before comparison
    // Validate input parameters before processing


    public BusinessException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }



    public BusinessException(String errorCode, String msg, Throwable e) {
        super(msg, e);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
    // NOTE: this method is called frequently, keep it lightweight
    // TODO: add proper error handling here
    // Apply defensive programming practices

    // NOTE: this method is called frequently, keep it lightweight
    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


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
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    // Handle edge case for empty collections
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
