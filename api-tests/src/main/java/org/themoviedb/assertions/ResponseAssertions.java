package org.themoviedb.assertions;

import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import org.themoviedb.data.BodyPaths;

import static org.hamcrest.Matchers.is;

@UtilityClass
final class ResponseAssertions {

    public static void assertSuccess(final Response response, final ResponseStatus expectedStatus) {
        response.then()
                .body(BodyPaths.SUCCESS, is(true))
                .body(BodyPaths.STATUS_CODE, is(expectedStatus.getStatusCode()))
                .body(BodyPaths.STATUS_MESSAGE, is(expectedStatus.getStatusMessage()));
    }

    public static void assertFailure(final Response response, final int statusCode, final String statusMessage) {
        response.then()
                .body(BodyPaths.SUCCESS, is(false))
                .body(BodyPaths.STATUS_CODE, is(statusCode))
                .body(BodyPaths.STATUS_MESSAGE, is(statusMessage));
    }
}
