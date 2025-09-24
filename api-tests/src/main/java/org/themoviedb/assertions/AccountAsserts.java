package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.themoviedb.data.BodyPaths;
import org.themoviedb.mappers.RatedMovieDtoMapper;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.movie.RatedMovieDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Setter
@Component
@Scope(SCOPE_PROTOTYPE)
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
                .body(BodyPaths.SUCCESS, is(true))
                .body(BodyPaths.STATUS_CODE, is(1))
                .body(BodyPaths.STATUS_MESSAGE, is("Success."));
    }

    @Step("'Add movie' response should have unsuccessful status: '{statusCode}' status code and '{statusMessage}' status message")
    public void addMovieResponseIsUnsuccessful(final int statusCode, final String statusMessage) {
        response.then()
                .body(BodyPaths.SUCCESS, is(false))
                .body(BodyPaths.STATUS_CODE, is(statusCode))
                .body(BodyPaths.STATUS_MESSAGE, is(statusMessage));
    }

    @Step("Watch list should contain '{expectedMovieDtoList}' movies")
    public void watchListContainsExpectedMovies(final List<MovieDto> expectedMovieDtoList) {
        Assertions.assertThat(watchListMovies)
                .as("Expected the watchlist to contain the movies %s, but it contains %s", expectedMovieDtoList, watchListMovies)
                .containsAnyElementsOf(expectedMovieDtoList);
    }

    @Step("Watch list should not contain '{expectedMovieDtoList}' movies")
    public void watchListDoesNotContainExpectedMovieIds(final List<Long> expectedMovieIdList) {
        var watchListMovieIds = watchListMovies.stream().map(MovieDto::getId).toList();
        Assertions.assertThat(watchListMovieIds)
                .as("Expected the watchlist not to contain the movie ids %s, but it contains %s", expectedMovieIdList, watchListMovieIds)
                .doesNotContainAnyElementsOf(expectedMovieIdList);
    }

    @Step("Users custom lists should not contain list '{listId}'")
    public void usersCustomListsDoNotContainSpecificList(final long listId) {
        var usersCustomListIds = userLists.stream().map(ListDetailsDto::getId).collect(Collectors.toList());
        Assertions.assertThat(usersCustomListIds)
                .as("Expected the users custom lists not to contain the list '%d', but it contains '%s'", listId, usersCustomListIds)
                .doesNotContain(listId);
    }

    @Step("Users list of rated movies should contain '{movieDto}' movie with '{rating}' rating")
    public void ratedMovieListContainsExpectedRatedMovie(final MovieDto movieDto,
                                                         final BigDecimal rating) {
        var expectedRatedMovies = ratedMovieDtoMapper.movieDtoToRatedMovieDto(movieDto, rating);
        Assertions.assertThat(ratedMovies)
                .as("Expected user list of rated movies to contain the movie %s, but it contains %s", expectedRatedMovies, ratedMovies)
                .contains(expectedRatedMovies);
    }
}