package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.themoviedb.data.BodyPaths;

import static org.hamcrest.Matchers.is;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Setter
@Component
@Scope(SCOPE_PROTOTYPE)
public class MoviesAsserts {

    private Response response;

    @Step("'Add rating to movie' response should have successful status")
    public void addRatingToMovieResponseIsSuccessful() {
        response.then()
                .body(BodyPaths.SUCCESS, is(true))
                .body(BodyPaths.STATUS_CODE, is(1))
                .body(BodyPaths.STATUS_MESSAGE, is("Success."));//todo to template. I have already used it
    }

    @Step("'Update movie rating' response should have successful status")
    public void updateMovieRatingResponseIsSuccessful() {
        response.then()
                .body(BodyPaths.SUCCESS, is(true))
                .body(BodyPaths.STATUS_CODE, is(12))
                .body(BodyPaths.STATUS_MESSAGE, is("The item/record was updated successfully."));
    }
}
