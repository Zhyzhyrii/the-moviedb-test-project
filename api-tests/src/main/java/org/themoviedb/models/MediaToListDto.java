package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class MediaToListDto {

    @JsonProperty("media_id")
    private final long mediaId;
}
