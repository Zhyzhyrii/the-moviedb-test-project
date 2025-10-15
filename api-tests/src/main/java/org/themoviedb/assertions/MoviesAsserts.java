package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;
import static org.themoviedb.assertions.ResponseAssertions.assertSuccess;

@Setter
@Component
@Scope(SCOPE_PROTOTYPE)
public class MoviesAsserts {

    private Response response;

    @Step("'Add rating to movie' response should have successful status")
    public void addRatingToMovieResponseIsSuccessful() {
        assertSuccess(response, ResponseStatus.SUCCESS);
    }

    @Step("'Update movie rating' response should have successful status")
    public void updateMovieRatingResponseIsSuccessful() {
        assertSuccess(response, ResponseStatus.UPDATED_SUCCESS);
    }
}
