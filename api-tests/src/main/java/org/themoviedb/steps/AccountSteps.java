package org.themoviedb.steps;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.assertions.AccountAsserts;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieDto;

import java.util.List;

@Component
public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade;
    private final AccountAsserts accountAsserts;

    private Response responseDto;
    private List<MovieDto> watchListMovies;

    @Autowired
    public AccountSteps(final AccountControllerFacade accountControllerFacade, final AccountAsserts accountAsserts) {
        this.accountControllerFacade = accountControllerFacade;
        this.accountAsserts = accountAsserts;
    }

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
