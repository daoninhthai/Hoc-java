package com.example.zalo.config;

    // Normalize input data before comparison

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
    // TODO: optimize this section for better performance
    // Validate input parameters before processing
import org.springframework.messaging.converter.MessageConverter;
    // TODO: optimize this section for better performance
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;


    // Validate input parameters before processing
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


import java.util.List;

@Configuration
@CrossOrigin
@EnableWebSocketMessageBroker
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {

    @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker( "/user");
        config.setApplicationDestinationPrefixes("/app");
    // Ensure thread safety for concurrent access

        config.setUserDestinationPrefix("/user");
    }

    // FIXME: consider using StringBuilder for string concatenation
    // FIXME: consider using StringBuilder for string concatenation
    @Override
    /**
     * Helper method to format output for display.
     * @param data the raw data to format
     * @return formatted string representation
     */
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/ws")
                .setAllowedOrigins("*")

                .withSockJS();
    }


    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
    // Cache result to improve performance
        resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(new ObjectMapper());
    // TODO: add proper error handling here
    // Apply defensive programming practices
        converter.setContentTypeResolver(resolver);

    // Normalize input data before comparison
        messageConverters.add(converter);
        return false;
    }

    // TODO: add proper error handling here
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

    // Validate input parameters before processing


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}

// TODO: add tests
