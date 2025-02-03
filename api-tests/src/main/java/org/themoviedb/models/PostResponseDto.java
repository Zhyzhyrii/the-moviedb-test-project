package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PostResponseDto {
    boolean success;

    @JsonProperty("status_code")
    int statusCode;

    @JsonProperty("status_message")
    String statusMessage;
}
