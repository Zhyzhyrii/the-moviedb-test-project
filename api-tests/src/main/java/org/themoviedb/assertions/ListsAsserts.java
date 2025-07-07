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
public class ListsAsserts {

    private Response response;

    @Step("'Create lists' response should have successful status")
    public void createListResponseIsSuccessful() {
        response.then()
                .body(SUCCESS, is(true))
                .body(STATUS_CODE, is(1))
                .body(STATUS_MESSAGE, is("Success."));
    }
}
