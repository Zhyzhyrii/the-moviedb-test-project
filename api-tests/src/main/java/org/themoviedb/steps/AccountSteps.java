package org.themoviedb.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.assertions.AccountAsserts;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.RatedMovieDto;

import java.util.List;
import java.util.function.Predicate;

@Component
public class AccountSteps {

    private final AccountControllerFacade accountControllerFacade;
    private final AccountAsserts accountAsserts;

    private Response responseDto;
    private List<MovieDto> watchListMovies;
    private List<ListDetailsDto> userLists;
    private List<RatedMovieDto> ratedMovies;

    @Autowired
    public AccountSteps(final AccountControllerFacade accountControllerFacade,
                        final AccountAsserts accountAsserts) {
        this.accountControllerFacade = accountControllerFacade;
        this.accountAsserts = accountAsserts;
    }

    @Step("Add movie '{body}' to watch list")
    public AccountSteps addMovieToWatchlist(final MediaToWatchListDto body, final int statusCode) {
        responseDto = accountControllerFacade.addMovieToWatchlist(body, statusCode);
        return this;
    }

    @Step("Add movie '{movieDtoId}' to watch list")
    public AccountSteps addMovieToWatchlist(final Long movieDtoId) {
        responseDto = accountControllerFacade.addMovieToWatchlist(movieDtoId);
        return this;
    }

    @Step("Remove movie '{movieDtoId}' from watch list")
    public void removeMovieFromWatchlist(final Long movieDtoId) {
        responseDto = accountControllerFacade.removeMovieFromWatchlist(movieDtoId);
    }

    @Step("Get watch list movies")
    public AccountSteps getWatchListMovies() {
        watchListMovies = accountControllerFacade.getWatchListMovies();
        return this;
    }

    @Step("Get user lists")
    public AccountSteps getUserLists() {
        userLists = accountControllerFacade.getUsersLists();
        return this;
    }

    @Step("Wait and get rated movies")
    public AccountSteps waitAndGetRatedMovies(final Predicate<List<RatedMovieDto>> predicate) {//todo add that specific movie is added or not to List?
        ratedMovies = accountControllerFacade.waitAndGetRatedMovies(predicate);
        return this;
    }

    public AccountAsserts assertThat() {
        accountAsserts.setResponse(responseDto);
        accountAsserts.setWatchListMovies(watchListMovies);
        accountAsserts.setUserLists(userLists);
        accountAsserts.setRatedMovies(ratedMovies);
        return accountAsserts;
    }
}
