package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.models.RatingDto;

import static org.themoviedb.PathQueryParameters.MOVIE_ID;

@Component
public class MoviesController extends BaseController {

    public Response addRating(final long movieId,
                              final RatingDto body,
                              final int statusCode) {
        return getRequestSpecification()
                .pathParam(MOVIE_ID, movieId)
                .body(body)
                .post("/movie/{movie_id}/rating")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public Response removeRating(final long movieId, final int statusCode) {
        return getRequestSpecification()
                .pathParam(MOVIE_ID, movieId)
                .delete("/movie/{movie_id}/rating")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
