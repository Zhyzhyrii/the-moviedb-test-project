package org.themoviedb.data.requests;

import org.themoviedb.models.MediaToWatchList;
import org.themoviedb.models.Movie;

import static org.themoviedb.data.enums.MediaType.MOVIE;

public class UpdateWatchListRequestTemplate {

    public MediaToWatchList createAddMovieToWatchListRequest(final Movie movie) {
        return createMovieToWatchListRequest(movie.getId(), true);
    }

    public MediaToWatchList createRemoveMovieFromWatchListRequest(final Movie movie) {
        return createMovieToWatchListRequest(movie.getId(), false);
    }

    private MediaToWatchList createMovieToWatchListRequest(final Long mediaId,
                                                           final Boolean watchlist) {
        return MediaToWatchList.builder()
                .mediaType(MOVIE.getName())
                .mediaId(mediaId)
                .watchlist(watchlist)
                .build();
    }
}
