package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class PostResponseDto {
    boolean success;

    @JsonProperty("status_code")
    int statusCode;

    @JsonProperty("status_message")
    String statusMessage;
}
