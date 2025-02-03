package org.themoviedb.steps;

import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();

    private PostResponseDto postResponseDto;

    public AccountSteps addMovieToWatchlist(final MovieDto movieDto) {
        postResponseDto = accountControllerFacade.addMovieToWatchlist(movieDto);
        return this;
    }

    public void removeMovieFromWatchlist(final MovieDto movieDto) {
        postResponseDto = accountControllerFacade.removeMovieFromWatchlist(movieDto);
    }

    public MovieDto getFirstWatchlistMovie() {
        return accountControllerFacade.getFirstWatchlistMovie();
    }
}
