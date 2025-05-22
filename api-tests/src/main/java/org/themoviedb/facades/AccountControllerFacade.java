package org.themoviedb.facades;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.AccountController;
import org.themoviedb.data.requests.UpdateWatchListRequestTemplate;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieDto;

import java.util.List;

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

    public Response addMovieToWatchlist(final Long movieDtoId) {
        var body = updateWatchListRequestTemplate.createAddMovieToWatchListRequest(movieDtoId);
        return addMovieToWatchlist(body, 201);
    }

    public Response removeMovieFromWatchlist(final Long movieDtoId) {
        var body = updateWatchListRequestTemplate.createRemoveMovieFromWatchListRequest(movieDtoId);
        return accountController.updateWatchlist(body, 200);
    }

    public List<MovieDto> getWatchListMovies() {
        return accountController
                .getWatchlistMovies()
                .getResults();
    }
}
