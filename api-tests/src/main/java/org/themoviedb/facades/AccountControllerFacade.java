package org.themoviedb.facades;

import org.themoviedb.controllers.AccountController;
import org.themoviedb.data.requests.UpdateWatchListRequestTemplate;
import org.themoviedb.models.Movie;

import java.util.List;

public class AccountControllerFacade {

    private final AccountController accountController = new AccountController();
    private final UpdateWatchListRequestTemplate updateWatchListRequestTemplate = new UpdateWatchListRequestTemplate();

    public void addMovieToWatchlist(final Movie movie) {
        var body = updateWatchListRequestTemplate.createAddMovieToWatchListRequest(movie);
        accountController.updateWatchlist(body, 201);
    }

    public void removeMovieFromWatchlist(final Movie movie) {
        var body = updateWatchListRequestTemplate.createRemoveMovieFromWatchListRequest(movie);
        accountController.updateWatchlist(body, 200);
    }

    public Movie getFirstWatchlistMovie() {
        return getWatchListMovies().getFirst();
    }

    private List<Movie> getWatchListMovies() {
        return accountController.getWatchlistMovies()
                .getResults();
    }
}
