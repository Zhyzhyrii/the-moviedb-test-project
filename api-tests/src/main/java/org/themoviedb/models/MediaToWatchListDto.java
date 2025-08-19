package org.themoviedb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

@ToString
public class MediaToWatchListDto extends MediaToListDto {

    @JsonProperty("media_type")
    private final String mediaType;

    @JsonProperty("watchlist")
    private final Boolean watchList;

    @Builder(builderMethodName = "mediaToWatchListDtoBuilder")
    public MediaToWatchListDto(final long mediaId,
                               final String mediaType,
                               final Boolean watchList) {
        super(mediaId);
        this.mediaType = mediaType;
        this.watchList = watchList;
    }
}
