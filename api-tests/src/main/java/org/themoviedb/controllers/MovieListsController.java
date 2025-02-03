package org.themoviedb.controllers;

import org.themoviedb.models.MovieListDto;

public class MovieListsController extends BaseController {

    public MovieListDto getTopRatedMovies() {
        return baseClient()
                .get("/movie/top_rated")
                .then()
                .statusCode(200)
                .extract()
                .as(MovieListDto.class);
    }
}
