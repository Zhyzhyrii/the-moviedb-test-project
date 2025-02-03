package org.themoviedb.controllers;

import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.MovieListDto;
import org.themoviedb.models.PostResponseDto;

public class AccountController extends BaseController {

    //    TODO account id should be provided by the user
    public MovieListDto getWatchlistMovies() {
        return baseClient()
                .pathParam("accountId", 8_564_434)
                .get("/account/{accountId}/watchlist/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(MovieListDto.class);
    }

    //    TODO account id should be provided by the user
    public PostResponseDto updateWatchlist(final MediaToWatchListDto body,
                                           final int statusCode) {
        return baseClient()
                .pathParam("accountId", 8_564_434)
                .body(body)
                .post("/account/{accountId}/watchlist")
                .then()
                .statusCode(statusCode)
                .extract()
                .as(PostResponseDto.class);
    }
}
