package org.themoviedb.controllers;

import org.themoviedb.models.MediaToWatchList;
import org.themoviedb.models.MovieList;

public class AccountController extends BaseController {

    //    TODO account id should be provided by the user
    public MovieList getWatchlistMovies() {
        return baseClient()
                .pathParam("accountId", 8_564_434)
                .get("/account/{accountId}/watchlist/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(MovieList.class);
    }

    //    TODO account id should be provided by the user
    public void updateWatchlist(final MediaToWatchList body,
                                final int statusCode) {
        baseClient()
                .pathParam("accountId", 8_564_434)
                .body(body)
                .post("/account/{accountId}/watchlist")
                .then()
                .statusCode(statusCode);
    }
}
