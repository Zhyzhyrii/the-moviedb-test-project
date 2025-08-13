package org.themoviedb.facades;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.MoviesController;
import org.themoviedb.models.RatingDto;

import java.math.BigDecimal;

@Component
public class MoviesControllerFacade {

    private final MoviesController moviesController;

    @Autowired
    public MoviesControllerFacade(final MoviesController moviesController) {
        this.moviesController = moviesController;
    }

    public Response addMovieRating(final long movieId, final BigDecimal value) {
        var body = RatingDto.builder()
                .value(value)
                .build();
        return moviesController.addRating(movieId, body, 201);
    }
}
