package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.mappers.RatedMovieDtoMapper;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.movie.RatedMovieDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.themoviedb.data.BodyPaths.STATUS_CODE;
import static org.themoviedb.data.BodyPaths.STATUS_MESSAGE;
import static org.themoviedb.data.BodyPaths.SUCCESS;

@Setter
@Component
public class AccountAsserts {

    @Autowired
    private RatedMovieDtoMapper ratedMovieDtoMapper;

    private Response response;
    private List<MovieDto> watchListMovies;
    private List<ListDetailsDto> userLists;
    private List<RatedMovieDto> ratedMovies;

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
                .as("Expected the watchlist to contain the movies %s, but it contains %s", expectedMovieDtoList, watchListMovies)
                .containsExactlyElementsOf(expectedMovieDtoList);
    }

    @Step("Watch list should be empty")
    public void watchListIsEmpty() {
        Assertions.assertThat(watchListMovies)
                .as("Watchlist is not empty")
                .isEmpty();
    }

    @Step("Users custom lists should not contain list '{listId}'")
    public void usersCustomListsDoNotContainSpecificList(final long listId) {
        var usersCustomListIds = userLists.stream().map(ListDetailsDto::getId).collect(Collectors.toList());
        Assertions.assertThat(usersCustomListIds)
                .as("Expected the users custom lists not to contain the list '%d', but it contains '%s'", listId, usersCustomListIds)
                .doesNotContain(listId);
    }

    @Step("Users list of rated movies should contain '{movieDto}' movie with '{}' rating")
    public void ratedMovieListContainsExpectedRatedMovie(final MovieDto movieDto,
                                                         final BigDecimal rating) {
        var expectedRatedMovies = List.of(ratedMovieDtoMapper.movieDtoToRatedMovieDto(movieDto, rating));
        Assertions.assertThat(ratedMovies)
                .as("Expected user list of rated movies to contain the movie %s, but it contains %s", expectedRatedMovies, ratedMovies)
                .containsExactlyElementsOf(expectedRatedMovies);
    }

    @Step("Users list of rated movies should not contain movie with id '{movieId}'")
    public void ratedMovieListDoesNotContainMovie(final long movieId) {
        var ratedMovieIds = ratedMovies.stream().map(RatedMovieDto::getId).toList();
        Assertions.assertThat(ratedMovieIds)
                .as("Expected the users list of rated movies not to contain the movie '%d', but it contains '%s'", movieId, ratedMovieIds)
                .doesNotContain(movieId);
    }
}
