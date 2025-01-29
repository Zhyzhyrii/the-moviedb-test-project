package org.themoviedb.steps;

import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.Movie;

public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();

    public AccountSteps addMovieToWatchlist(final Movie movie) {
        accountControllerFacade.addMovieToWatchlist(movie);
        return this;
    }

    public void removeMovieFromWatchlist(final Movie movie) {
        accountControllerFacade.removeMovieFromWatchlist(movie);
    }

    public Movie getFirstWatchlistMovie() {
        return accountControllerFacade.getFirstWatchlistMovie();
    }
}
