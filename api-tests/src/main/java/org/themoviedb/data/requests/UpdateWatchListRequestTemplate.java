package org.themoviedb.data.requests;

import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieDto;

import static org.themoviedb.data.enums.MediaType.MOVIE;

public class UpdateWatchListRequestTemplate {

    public MediaToWatchListDto createAddMovieToWatchListRequest(final MovieDto movieDto) {
        return createMovieToWatchListRequest(movieDto.getId(), true);
    }

    public MediaToWatchListDto createRemoveMovieFromWatchListRequest(final MovieDto movieDto) {
        return createMovieToWatchListRequest(movieDto.getId(), false);
    }

    private MediaToWatchListDto createMovieToWatchListRequest(final Long mediaId,
                                                              final Boolean watchlist) {
        return MediaToWatchListDto.builder()
                .mediaType(MOVIE.getName())
                .mediaId(mediaId)
                .watchlist(watchlist)
                .build();
    }
}
