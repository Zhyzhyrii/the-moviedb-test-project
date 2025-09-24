package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MediaToListDto {

    @JsonProperty("media_id")
    private final long mediaId;
}
