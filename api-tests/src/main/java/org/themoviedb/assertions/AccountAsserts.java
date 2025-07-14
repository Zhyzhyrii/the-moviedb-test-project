package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;
import org.themoviedb.models.MovieDto;
import org.themoviedb.models.listdetails.ListDetailsDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.themoviedb.data.BodyPaths.STATUS_CODE;
import static org.themoviedb.data.BodyPaths.STATUS_MESSAGE;
import static org.themoviedb.data.BodyPaths.SUCCESS;

@Setter
@Component
public class AccountAsserts {

    private Response response;
    private List<MovieDto> watchListMovies;
    private List<ListDetailsDto> userLists;

    @Step("'Add movie' response should have successful status")
    public void addMovieResponseIsSuccessful() {
        response.then()
                .body(SUCCESS, is(true))
                .body(STATUS_CODE, is(1))
                .body(STATUS_MESSAGE, is("Success."));
    }

    @Step("'Add movie' response should have unsuccessful status: '{statusCode}' status code and '{statusMessage}' status message")
    public void addMovieResponseIsUnsuccessful(final int statusCode, final String statusMessage) {
        response.then()
                .body(SUCCESS, is(false))
                .body(STATUS_CODE, is(statusCode))
                .body(STATUS_MESSAGE, is(statusMessage));
    }

    @Step("Watch list should contain '{expectedMovieDtoList}' movies")
    public void watchListContainsExpectedMovies(final List<MovieDto> expectedMovieDtoList) {
        Assertions.assertThat(watchListMovies)
                .overridingErrorMessage("Expected the watchlist to contain the movies %s, but it contains %s", expectedMovieDtoList, watchListMovies)
                .containsExactlyElementsOf(expectedMovieDtoList);
    }

    @Step("Watch list should be empty")
    public void watchListIsEmpty() {
        Assertions.assertThat(watchListMovies)
                .overridingErrorMessage("Watchlist is not empty")
                .isEmpty();
    }

    @Step("Users custom lists do not contain list '{listId}'")
    public void usersCustomListsDoNotContainSpecificList(final long listId) {
        var usersCustomListIds = userLists.stream().map(ListDetailsDto::getId).collect(Collectors.toList());
        Assertions.assertThat(usersCustomListIds)
                .as("Expected the users custom lists not to contain the list '%d', but it contains '%s'", listId, usersCustomListIds)
                .doesNotContain(listId);
    }
}
