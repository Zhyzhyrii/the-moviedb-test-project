package org.themoviedb.steps;

import io.restassured.response.Response;
import org.themoviedb.assertions.AccountAsserts;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieDto;

import java.util.List;

public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();
    private final AccountAsserts accountAsserts = new AccountAsserts();

    private Response responseDto;
    private List<MovieDto> watchListMovies;

    public AccountSteps addMovieToWatchlist(final MediaToWatchListDto body, final int statusCode) {
        responseDto = accountControllerFacade.addMovieToWatchlist(body, statusCode);
        return this;
    }

    public AccountSteps addMovieToWatchlist(final Long movieDtoId) {
        responseDto = accountControllerFacade.addMovieToWatchlist(movieDtoId);
        return this;
    }

    public void removeMovieFromWatchlist(final Long movieDtoId) {
        responseDto = accountControllerFacade.removeMovieFromWatchlist(movieDtoId);
    }

    public AccountSteps getWatchListMovies() {
        watchListMovies = accountControllerFacade.getWatchListMovies();
        return this;
    }

    public AccountAsserts assertThat() {
        accountAsserts.setResponse(responseDto);
        accountAsserts.setWatchListMovies(watchListMovies);
        return accountAsserts;
    }
}
