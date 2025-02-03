package org.themoviedb.steps;

import org.themoviedb.assertions.AccountAsserts;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();
    private final AccountAsserts accountAsserts = new AccountAsserts();

    private PostResponseDto postResponseDto;
    private MovieDto actualMovie;

    public AccountSteps addMovieToWatchlist(final MovieDto movieDto) {
        postResponseDto = accountControllerFacade.addMovieToWatchlist(movieDto);
        return this;
    }

    public void removeMovieFromWatchlist(final MovieDto movieDto) {
        postResponseDto = accountControllerFacade.removeMovieFromWatchlist(movieDto);
    }

    public AccountSteps getFirstWatchlistMovie() {
        actualMovie = accountControllerFacade.getFirstWatchlistMovie();
        return this;
    }

    public AccountAsserts assertThat() {
        accountAsserts.setPostResponseDto(postResponseDto);
        accountAsserts.setMovieDto(actualMovie);
        return accountAsserts;
    }
}
