package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class PostResponseDto {
    boolean success;

    @JsonProperty("status_code")
    int statusCode;

    @JsonProperty("status_message")
    String statusMessage;
}
