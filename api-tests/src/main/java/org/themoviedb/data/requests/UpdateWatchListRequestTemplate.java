package org.themoviedb.data.requests;

import org.themoviedb.models.MediaToWatchListDto;

import static org.themoviedb.data.enums.MediaType.MOVIE;

public class UpdateWatchListRequestTemplate {

    public MediaToWatchListDto createAddMovieToWatchListRequest(final Long movieDtoId) {
        return createMovieToWatchListRequest(movieDtoId, true);
    }

    public MediaToWatchListDto createRemoveMovieFromWatchListRequest(final Long movieDtoId) {
        return createMovieToWatchListRequest(movieDtoId, false);
    }

    private MediaToWatchListDto createMovieToWatchListRequest(final Long mediaId,
                                                              final Boolean watchList) {
        return MediaToWatchListDto.mediaToWatchListDtoBuilder()
                .mediaType(MOVIE.getName())
                .mediaId(mediaId)
                .watchList(watchList)
                .build();
    }
}
