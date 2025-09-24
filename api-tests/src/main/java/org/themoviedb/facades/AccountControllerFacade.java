package org.themoviedb.facades;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.AccountController;
import org.themoviedb.data.requests.UpdateWatchListRequestTemplate;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.movie.RatedMovieDto;
import org.themoviedb.utils.WaitUtil;

import java.util.List;
import java.util.function.Predicate;

@Component
public class AccountControllerFacade {

    private final AccountController accountController;
    private final UpdateWatchListRequestTemplate updateWatchListRequestTemplate = new UpdateWatchListRequestTemplate();

    @Autowired
    public AccountControllerFacade(final AccountController accountController) {
        this.accountController = accountController;
    }

    public Response addMovieToWatchlist(final MediaToWatchListDto body, final int statusCode) {
        return accountController.updateWatchlist(body, statusCode);
    }

    public Response addMovieToWatchlist(final long movieDtoId) {
        var body = updateWatchListRequestTemplate.createAddMovieToWatchListRequest(movieDtoId);
        return addMovieToWatchlist(body, 201);
    }

    public Response removeMovieFromWatchlist(final long movieDtoId) {
        var body = updateWatchListRequestTemplate.createRemoveMovieFromWatchListRequest(movieDtoId);
        return accountController.updateWatchlist(body, 200);
    }

    public List<MovieDto> getWatchListMovies() {
        return accountController
                .getWatchlistMovies()
                .getResults();
    }

    public List<ListDetailsDto> getUsersLists() {
        return accountController
                .getUserLists()
                .getResults();
    }

    public List<RatedMovieDto> waitMovieRatingIsAddedAndGetRatedMovies(final long movieId) {
        Predicate<List<RatedMovieDto>> predicate = movies -> movies.stream()
                .anyMatch(movie -> movie.getId() == movieId);
        return waitAndGetRatedMovies(predicate);
    }

    public List<RatedMovieDto> waitMovieRatingIsRemovedAndGetRatedMovies(final long movieId) {
        Predicate<List<RatedMovieDto>> predicate = movies -> movies.stream()
                .noneMatch(movie -> movie.getId() == movieId);
        return waitAndGetRatedMovies(predicate);
    }

    private List<RatedMovieDto> waitAndGetRatedMovies(final Predicate<List<RatedMovieDto>> predicate) {
        return WaitUtil.waitUntil(
                this::getRatedMovies,
                predicate,
                10_000,
                1_000
        );
    }

    private List<RatedMovieDto> getRatedMovies() {
        return accountController
                .getRatedMovies()
                .getResults();
    }
}
