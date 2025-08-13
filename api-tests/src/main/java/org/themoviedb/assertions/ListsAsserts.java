package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.mappers.ItemDtoMapper;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.listdetails.ItemDto;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.themoviedb.data.BodyPaths.STATUS_CODE;
import static org.themoviedb.data.BodyPaths.STATUS_MESSAGE;
import static org.themoviedb.data.BodyPaths.SUCCESS;

@Setter
@Component
public class ListsAsserts {

    @Autowired
    private ItemDtoMapper itemDtoMapper;

    private long listId;
    private Response response;
    private List<ItemDto> listMovies;

    @Step("'Create list' response should have successful status")
    public void createListResponseIsSuccessful() {
        response.then()
                .body(SUCCESS, is(true))
                .body(STATUS_CODE, is(1))
                .body(STATUS_MESSAGE, is("Success."));
    }

    @Step("List should contain movies")
    public void listContainsExpectedMovies(final List<MovieDto> movieDtoList) {
        listContainsExpectedMovies(listId, movieDtoList);
    }

    @Step("List should be empty")
    public void listIsEmpty() {
        listIsEmpty(listId);
    }

    @Step("List '{listId}' should contain '{movieDtoList}' movies")
    private void listContainsExpectedMovies(final long listId,
                                            final List<MovieDto> movieDtoList) {
        var expectedListMovies = itemDtoMapper.movieDtoListToItemDtoList(movieDtoList);
        Assertions.assertThat(listMovies)
                .as("Expected the list '%d' to contain the movies '%s', but it contains '%s'", listId, movieDtoList, listMovies)
                .containsExactlyElementsOf(expectedListMovies);
    }

    @Step("List '{listId}' should be empty")
    private void listIsEmpty(final long listId) {
        Assertions.assertThat(listMovies)
                .as("Expected the list '%d' is empty, but it contains '%s'", listId, listMovies)
                .isEmpty();
    }
}
