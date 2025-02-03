package org.themoviedb.controllers;

import org.themoviedb.models.MovieList;

public class MovieListsController extends BaseController {

    public MovieList getTopRatedMovies() {
        return baseClient()
                .get("/movie/top_rated")
                .then()
                .statusCode(200)
                .extract()
                .as(MovieList.class);
    }
}
