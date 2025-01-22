package org.themoviedb.controllers;

import org.themoviedb.models.Movie;
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
//    TODO body as an object should be provided
    public void updateWatchlist(final Movie movie,
                                final boolean watchlist,
                                final int statusCode) {
        baseClient()
                .pathParam("accountId", 8_564_434)
                .body("{\"media_type\":\"movie\",\"media_id\":" + movie.getId() + ",\"watchlist\":" + watchlist + "}")
                .post("/account/{accountId}/watchlist")
                .then()
                .statusCode(statusCode);
    }
}
