package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static org.hamcrest.Matchers.is;
import static org.themoviedb.data.BodyPaths.STATUS_CODE;
import static org.themoviedb.data.BodyPaths.STATUS_MESSAGE;
import static org.themoviedb.data.BodyPaths.SUCCESS;

@Setter
@Component
public class MoviesAsserts {

    private Response response;

    @Step("'Create list' response should have successful status")
    public void addRatingToMovieResponseIsSuccessful() {
        response.then()
                .body(SUCCESS, is(true))
                .body(STATUS_CODE, is(1))
                .body(STATUS_MESSAGE, is("Success."));//todo to template. I have already used it
    }
}
