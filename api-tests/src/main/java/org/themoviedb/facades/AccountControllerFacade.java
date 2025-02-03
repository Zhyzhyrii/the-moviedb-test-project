package org.themoviedb.facades;

import org.themoviedb.controllers.AccountController;
import org.themoviedb.data.requests.UpdateWatchListRequestTemplate;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

import java.util.List;

public class AccountControllerFacade {

    private final AccountController accountController = new AccountController();
    private final UpdateWatchListRequestTemplate updateWatchListRequestTemplate = new UpdateWatchListRequestTemplate();

    public PostResponseDto addMovieToWatchlist(final MovieDto movieDto) {
        var body = updateWatchListRequestTemplate.createAddMovieToWatchListRequest(movieDto);
        return accountController.updateWatchlist(body, 201);
    }

    public PostResponseDto removeMovieFromWatchlist(final MovieDto movieDto) {
        var body = updateWatchListRequestTemplate.createRemoveMovieFromWatchListRequest(movieDto);
        return accountController.updateWatchlist(body, 200);
    }

    public MovieDto getFirstWatchlistMovie() {
        return getWatchListMovies().getFirst();
    }

    private List<MovieDto> getWatchListMovies() {
        return accountController.getWatchlistMovies()
                .getResults();
    }
}
