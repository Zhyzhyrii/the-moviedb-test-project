package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class MediaToWatchListDto {

    @JsonProperty("media_type")
    private final String mediaType;

    @JsonProperty("media_id")
    private final Long mediaId;

    @JsonProperty("watchlist")
    private final Boolean watchlist;
}
