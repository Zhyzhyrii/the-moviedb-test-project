package org.themoviedb.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.assertions.MoviesAsserts;
import org.themoviedb.controllers.MoviesController;
import org.themoviedb.facades.MoviesControllerFacade;

import java.math.BigDecimal;

@Component
public class MoviesSteps {

    private final MoviesControllerFacade moviesControllerFacade;
    private final MoviesController moviesController;
    private final MoviesAsserts moviesAsserts;

    @Getter
    private Response responseDto;

    @Autowired
    public MoviesSteps(final MoviesController moviesController,
                       final MoviesControllerFacade moviesControllerFacade,
                       final MoviesAsserts moviesAsserts) {
        this.moviesControllerFacade = moviesControllerFacade;
        this.moviesController = moviesController;
        this.moviesAsserts = moviesAsserts;
    }

    @Step("Add rating '{value}' to movie '{movieId}'")
    public MoviesSteps addMovieRating(final long movieId, final BigDecimal value) {
        responseDto = moviesControllerFacade.addMovieRating(movieId, value);
        return this;
    }

    @Step("Remove rating for movie '{movieId}'")
    public MoviesSteps removeMovieRating(final long movieId) {
        responseDto = moviesController.removeRating(movieId, 200);
        return this;
    }

    public MoviesAsserts assertThat() {
        moviesAsserts.setResponse(responseDto);
        return moviesAsserts;
    }
}
