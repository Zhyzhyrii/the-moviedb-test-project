package org.themoviedb.controllers;

import org.springframework.stereotype.Component;
import org.themoviedb.models.MovieListDto;

@Component
public class MovieListsController extends BaseController {

    public MovieListDto getTopRatedMovies() {
        return getBaseClient()
                .get("/movie/top_rated")
                .then()
                .statusCode(200)
                .extract()
                .as(MovieListDto.class);
    }
}
