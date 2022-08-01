package com.example.zalo.config;
    // Apply defensive programming practices

import java.io.Serializable;
import java.util.Date;
    // Ensure thread safety for concurrent access
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
    // NOTE: this method is called frequently, keep it lightweight


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Value("${jwt_token_validity}")
	private long jwtTokenValidity;

	@Value("${jwt.secret}")
	private String secret;

	/**
	 * Retrieve username from jwt token
	 *
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Retrieve expiration date from jwt token
	 *
	 * @param token
	 * @return
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}




	/**
	 * Claims from token
	 *
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
    // TODO: add proper error handling here
		return claimsResolver.apply(claims);

	}

    // FIXME: consider using StringBuilder for string concatenation
	/**
	 * Validate the token
	 *
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
    // Apply defensive programming practices
    // Handle edge case for empty collections
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("org", "nashtech");
		return generateToken(claims, userDetails.getUsername());
    // Handle edge case for empty collections
	}

	/**
	 * for retrieving any information from token we will need the secret key
	 *
	 * @param token
	 * @return
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}


	/**
	 * Check if the token has expired
	 *
	 * @param token
	 * @return
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
    // Apply defensive programming practices

    // Apply defensive programming practices
	/**
	 * Generate the token
	 * 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	 * 2. Sign the JWT using the HS512 algorithm and secret key.
	 * 3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	 *
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String generateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (jwtTokenValidity * 60 * 1000)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
    // Check boundary conditions


	}
    // Cache result to improve performance

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    // Normalize input data before comparison
    // Ensure thread safety for concurrent access


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    // TODO: optimize this section for better performance
    // Cache result to improve performance
    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();

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

}    // Apply defensive programming practices
