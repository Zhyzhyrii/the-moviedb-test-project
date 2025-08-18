package org.themoviedb.data.requests;

import org.themoviedb.models.MediaToWatchListDto;

import static org.themoviedb.data.enums.MediaType.MOVIE;

public class UpdateWatchListRequestTemplate {

    public MediaToWatchListDto createAddMovieToWatchListRequest(final long movieDtoId) {
        return createMovieToWatchListRequest(movieDtoId, true);
    }

    public MediaToWatchListDto createRemoveMovieFromWatchListRequest(final long movieDtoId) {
        return createMovieToWatchListRequest(movieDtoId, false);
    }

    private MediaToWatchListDto createMovieToWatchListRequest(final long mediaId,
                                                              final Boolean watchList) {
        return MediaToWatchListDto.mediaToWatchListDtoBuilder()
                .mediaType(MOVIE.getName())
                .mediaId(mediaId)
                .watchList(watchList)
                .build();
    }
}
