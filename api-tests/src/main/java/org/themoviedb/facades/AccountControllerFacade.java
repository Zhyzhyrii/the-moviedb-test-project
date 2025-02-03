package org.themoviedb.facades;

import org.themoviedb.controllers.AccountController;
import org.themoviedb.data.requests.UpdateWatchListRequestTemplate;
import org.themoviedb.models.MovieDto;

import java.util.List;

public class AccountControllerFacade {

    private final AccountController accountController = new AccountController();
    private final UpdateWatchListRequestTemplate updateWatchListRequestTemplate = new UpdateWatchListRequestTemplate();

    public void addMovieToWatchlist(final MovieDto movieDto) {
        var body = updateWatchListRequestTemplate.createAddMovieToWatchListRequest(movieDto);
        accountController.updateWatchlist(body, 201);
    }

    public void removeMovieFromWatchlist(final MovieDto movieDto) {
        var body = updateWatchListRequestTemplate.createRemoveMovieFromWatchListRequest(movieDto);
        accountController.updateWatchlist(body, 200);
    }

    public MovieDto getFirstWatchlistMovie() {
        return getWatchListMovies().getFirst();
    }

    private List<MovieDto> getWatchListMovies() {
        return accountController.getWatchlistMovies()
                .getResults();
    }
}
