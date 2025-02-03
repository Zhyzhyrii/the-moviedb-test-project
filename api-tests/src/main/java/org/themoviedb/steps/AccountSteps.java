package org.themoviedb.steps;

import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MovieDto;

public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();

    public AccountSteps addMovieToWatchlist(final MovieDto movieDto) {
        accountControllerFacade.addMovieToWatchlist(movieDto);
        return this;
    }

    public void removeMovieFromWatchlist(final MovieDto movieDto) {
        accountControllerFacade.removeMovieFromWatchlist(movieDto);
    }

    public MovieDto getFirstWatchlistMovie() {
        return accountControllerFacade.getFirstWatchlistMovie();
    }
}
