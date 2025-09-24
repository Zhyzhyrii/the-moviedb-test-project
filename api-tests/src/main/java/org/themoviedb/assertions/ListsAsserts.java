package org.themoviedb.assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.themoviedb.data.BodyPaths;
import org.themoviedb.mappers.ItemDtoMapper;
import org.themoviedb.models.listdetails.ItemDto;
import org.themoviedb.models.movie.MovieDto;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Setter
@Component
@Scope(SCOPE_PROTOTYPE)
public class ListsAsserts {

    @Autowired
    private ItemDtoMapper itemDtoMapper;

    private Response response;
    private List<ItemDto> listMovies;
    private long listId;

    @Step("'Create list' response should have successful status")
    public void createListResponseIsSuccessful() {
        response.then()
                .body(BodyPaths.SUCCESS, is(true))
                .body(BodyPaths.STATUS_CODE, is(1))
                .body(BodyPaths.STATUS_MESSAGE, is("Success."));
    }

    @Step("List '{listId}' should contain '{movieDtoList}' movies")
    public void listContainsMovies(final List<MovieDto> movieDtoList) {
        var expectedListMovies = itemDtoMapper.movieDtoListToItemDtoList(movieDtoList);
        Assertions.assertThat(listMovies)
                .as("Expected the list '%d' to contain the movies '%s', but it contains '%s'", listId, movieDtoList, listMovies)
                .containsAnyElementsOf(expectedListMovies);
    }

    @Step("List '{listId}' should be empty")
    public void listIsEmpty() {
        Assertions.assertThat(listMovies)
                .as("Expected the list '%d' is empty, but it contains '%s'", listId, listMovies)
                .isEmpty();
    }
}
