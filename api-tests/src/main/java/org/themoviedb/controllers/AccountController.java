package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieListDto;

public class AccountController extends BaseController {

    //    TODO account id should be provided by the user
    public MovieListDto getWatchlistMovies() {
        return getBaseClient()
                .pathParam("accountId", 8_564_434)
                .get("/account/{accountId}/watchlist/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(MovieListDto.class);
    }

    //    TODO account id should be provided by the user
    public Response updateWatchlist(final MediaToWatchListDto body,
                                    final int statusCode) {
        return getBaseClient()
                .pathParam("accountId", 8_564_434)
                .body(body)
                .post("/account/{accountId}/watchlist")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
