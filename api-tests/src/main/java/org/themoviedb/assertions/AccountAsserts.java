package org.themoviedb.assertions;

import io.restassured.response.Response;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;
import org.themoviedb.models.MovieDto;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.themoviedb.data.BodyPaths.STATUS_CODE;
import static org.themoviedb.data.BodyPaths.STATUS_MESSAGE;
import static org.themoviedb.data.BodyPaths.SUCCESS;

@Setter
@Component
public class AccountAsserts {

    private Response response;
    private List<MovieDto> watchListMovies;

    public void addMovieResponseIsSuccessful() {
        response.then()
                .body(SUCCESS, is(true))
                .body(STATUS_CODE, is(1))
                .body(STATUS_MESSAGE, is("Success."));
    }

    public void addMovieResponseIsUnsuccessful(final int statusCode, final String statusMessage) {
        response.then()
                .body(SUCCESS, is(false))
                .body(STATUS_CODE, is(statusCode))
                .body(STATUS_MESSAGE, is(statusMessage));
    }

    public void watchListContainsExpectedMovie(final MovieDto expectedMovie) {
        Assertions.assertThat(watchListMovies)
                .overridingErrorMessage("Expected the watchlist to contain the movie %s, but it was not found.", expectedMovie)
                .contains(expectedMovie);
    }

    public void watchListIsEmpty() {
        Assertions.assertThat(watchListMovies)
                .overridingErrorMessage("Watchlist is not empty")
                .isEmpty();
    }
}
