package org.themoviedb.controllers;

import io.restassured.common.mapper.TypeRef;
import org.springframework.stereotype.Component;
import org.themoviedb.ApiPaths;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.wrappers.PaginatedResponse;

@Component
public class MovieListsController extends BaseController {

    public PaginatedResponse<MovieDto> getTopRatedMovies(final int page) {
        return getRequestSpecification()
                .queryParams(ApiPaths.PARAM.PAGE, page)
                .get(ApiPaths.MovieLists.TOP_RATED)
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public PaginatedResponse<MovieDto> getTopRatedMovies() {
        return getRequestSpecification()
                .get(ApiPaths.MovieLists.TOP_RATED)
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }
}
