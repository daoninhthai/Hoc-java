package com.example.zalo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePostRequest {
    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("content")
    private String content;

    @ApiModelProperty(
            example="123456",
            required=true
    )
    @JsonProperty("media")
    private String media;


    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            required=true
    )
    @JsonProperty("updated")
    private LocalDateTime updated;



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
