package org.themoviedb.steps;

import org.themoviedb.assertions.AccountAsserts;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.PostResponseDto;

import java.util.List;

public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();
    private final AccountAsserts accountAsserts = new AccountAsserts();

    //TODO to WrapperResponse
    private PostResponseDto postResponseDto;
    private List<MovieDto> watchListMovies;

    public AccountSteps addMovieToWatchlist(final MediaToWatchListDto body, final int statusCode) {
        postResponseDto = accountControllerFacade.addMovieToWatchlist(body, statusCode);
        return this;
    }

    public AccountSteps addMovieToWatchlist(final Long movieDtoId) {
        postResponseDto = accountControllerFacade.addMovieToWatchlist(movieDtoId);
        return this;
    }

    public void removeMovieFromWatchlist(final Long movieDtoId) {
        postResponseDto = accountControllerFacade.removeMovieFromWatchlist(movieDtoId);
    }

    public AccountSteps getWatchListMovies() {
        watchListMovies = accountControllerFacade.getWatchListMovies();
        return this;
    }

    public AccountAsserts assertThat() {
        accountAsserts.setPostResponseDto(postResponseDto);
        accountAsserts.setWatchListMovies(watchListMovies);
        return accountAsserts;
    }
}
