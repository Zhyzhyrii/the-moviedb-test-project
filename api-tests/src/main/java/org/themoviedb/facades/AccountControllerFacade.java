package org.themoviedb.facades;

import org.themoviedb.controllers.AccountController;
import org.themoviedb.models.Movie;

import java.util.List;

public class AccountControllerFacade {

    private final AccountController accountController = new AccountController();

    public void addMovieToWatchlist(final Movie movie) {
        accountController.updateWatchlist(movie, true, 201);
    }

    public void removeMovieFromWatchlist(final Movie movie) {
        accountController.updateWatchlist(movie, false, 200);
    }

    public Movie getFirstWatchlistMovie() {
        return getWatchListMovies().getFirst();
    }

    private List<Movie> getWatchListMovies() {
        return accountController.getWatchlistMovies()
                .getResults();
    }
}
