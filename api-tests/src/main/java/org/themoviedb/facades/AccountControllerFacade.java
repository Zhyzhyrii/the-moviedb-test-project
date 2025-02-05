package org.themoviedb.facades;

import org.themoviedb.controllers.AccountController;
import org.themoviedb.data.requests.UpdateWatchListRequestTemplate;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

import java.util.List;

public class AccountControllerFacade {

    private final AccountController accountController = new AccountController();
    private final UpdateWatchListRequestTemplate updateWatchListRequestTemplate = new UpdateWatchListRequestTemplate();

    public PostResponseDto addMovieToWatchlist(final MediaToWatchListDto body, final int statusCode) {
        return accountController.updateWatchlist(body, statusCode);
    }

    public PostResponseDto addMovieToWatchlist(final Long movieDtoId) {
        var body = updateWatchListRequestTemplate.createAddMovieToWatchListRequest(movieDtoId);
        return addMovieToWatchlist(body, 201);
    }

    public PostResponseDto removeMovieFromWatchlist(final Long movieDtoId) {
        var body = updateWatchListRequestTemplate.createRemoveMovieFromWatchListRequest(movieDtoId);
        return accountController.updateWatchlist(body, 200);
    }

    public List<MovieDto> getWatchListMovies() {
        return accountController
                .getWatchlistMovies()
                .getResults();
    }
}
