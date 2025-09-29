package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.ApiPaths;
import org.themoviedb.models.RatingDto;

@Component
public class MoviesController extends BaseController {

    public Response addRating(final long movieId,
                              final RatingDto body,
                              final int statusCode) {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.MOVIE_ID, movieId)
                .body(body)
                .post(ApiPaths.Movies.RATING)
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public Response removeRating(final long movieId, final int statusCode) {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.MOVIE_ID, movieId)
                .delete(ApiPaths.Movies.RATING)
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
