package org.themoviedb.controllers;

import io.restassured.common.mapper.TypeRef;
import org.springframework.stereotype.Component;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.wrappers.PaginatedResponse;

@Component
public class MovieListsController extends BaseController {

    private static final String PAGE = "page";

    public PaginatedResponse<MovieDto> getTopRatedMovies(final int page) {
        return getRequestSpecification()
                .queryParams(PAGE, page)
                .get("/movie/top_rated")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public PaginatedResponse<MovieDto> getTopRatedMovies() {
        return getRequestSpecification()
                .get("/movie/top_rated")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }
}
