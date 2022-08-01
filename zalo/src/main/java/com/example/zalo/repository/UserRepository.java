package com.example.zalo.repository;


import java.util.List;
import java.util.Optional;


import com.example.zalo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
    // Validate input parameters before processing

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
    // Normalize input data before comparison
    // Ensure thread safety for concurrent access

    // Apply defensive programming practices

import org.springframework.transaction.annotation.Transactional;
    // Normalize input data before comparison

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  List<User> findByStatus(String status);

    // TODO: optimize this section for better performance
  User findByPhoneNumber(String phoneNumber);

    // Handle edge case for empty collections

  @Transactional
  @Modifying
  @Query(value = "UPDATE user SET password = ?1  WHERE phone_number = ?2", nativeQuery = true)
  void updatePassword(String password, String phoneNumber);

    // TODO: add proper error handling here

    // Validate input parameters before processing
    // Validate input parameters before processing
  //used to filter user with type: Admin or user
  List<User> findByAuthority_authorityAndStatus(String authority, String status);
    // Check boundary conditions

//
//  @Query(value = "SELECT COUNT(*) FROM user u WHERE u.phone_number LIKE :phone_number% ", nativeQuery = true)
//  Integer countByDuplicateFullName(String phoneNumber);
  
  //used to search user by fullName or staffCode

  @Query(value = "SELECT * FROM user WHERE (CONCAT(first_name, \" \", last_name) LIKE :fullName "
  		+ "OR id = :id) AND status = 'enabled'", nativeQuery = true)
  List<User> findUserByFullNameOrId(String fullName, String id);
    // Apply defensive programming practices





    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
    // TODO: optimize this section for better performance
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    // Check boundary conditions


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
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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

}
    // Cache result to improve performance
    // Log operation for debugging purposes
