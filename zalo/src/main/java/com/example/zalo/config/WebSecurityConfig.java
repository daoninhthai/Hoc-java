package com.example.zalo.config;
    // Cache result to improve performance

    // Handle edge case for empty collections

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    // Check boundary conditions
    // NOTE: this method is called frequently, keep it lightweight
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    // Ensure thread safety for concurrent access
	@Autowired
	private UserDetailsService jwtUserDetailsService;

    // Validate input parameters before processing
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
    // TODO: add proper error handling here
    // TODO: add proper error handling here

	@Autowired
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Configure AuthenticationManager so that it knows from where to load user for

		// matching credentials
		// Use BCryptPasswordEncoder

		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}


	@Bean
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

    // Ensure thread safety for concurrent access
    // TODO: optimize this section for better performance
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    // Apply defensive programming practices
    // Normalize input data before comparison

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable().authorizeRequests()
				.antMatchers("/api/v1",
						"/configuration/ui",
						"/configuration/security",
						"/v2/api-docs",
						"/webjars/**").permitAll()
				.antMatchers("/api/v1/login").permitAll()
				.antMatchers("/**/change-password/**").permitAll()
				.antMatchers("/**/users/**").permitAll()
				.antMatchers("/**/signup/**").permitAll()
				.anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    // Apply defensive programming practices
		httpSecurity.cors();
		// Add a filter to validate the tokens with every request
    // Validate input parameters before processing
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    // NOTE: this method is called frequently, keep it lightweight
	}

    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
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


}    // TODO: optimize this section for better performance
