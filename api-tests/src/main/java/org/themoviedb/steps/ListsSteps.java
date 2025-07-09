package org.themoviedb.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.assertions.ListsAsserts;
import org.themoviedb.controllers.ListsController;
import org.themoviedb.facades.ListsControllerFacade;
import org.themoviedb.models.listdetails.ItemDto;

import java.util.List;

@Component
public class ListsSteps {

    private final ListsControllerFacade listsControllerFacade;
    private final ListsController listsController;
    private final ListsAsserts listsAsserts;

    @Getter
    private long listId;
    private Response responseDto;
    private List<ItemDto> listMovies;

    @Autowired
    public ListsSteps(final ListsControllerFacade listsControllerFacade,
                      final ListsController listsController,
                      final ListsAsserts listsAsserts) {
        this.listsControllerFacade = listsControllerFacade;
        this.listsController = listsController;
        this.listsAsserts = listsAsserts;
    }

    @Step("Create list")
    public ListsSteps createList() {
        responseDto = listsControllerFacade.createList();
        listId = responseDto.getBody().jsonPath().getLong("list_id");
        return this;
    }

    @Step("Add movie to list")
    public ListsSteps addMovieToList(final Long movieDtoId) {
        responseDto = listsControllerFacade.addMovieToList(movieDtoId, listId);
        return this;
    }

    @Step("Get movies of the list")
    public ListsSteps getListMovies() {
        listMovies = listsControllerFacade.getListMovies(listId);
        return this;
    }

    @Step("Remove list '{listId}'")
    public void removeList(final long listId) {
        listsController.deleteList(listId, 200);
    }

    public ListsAsserts assertThat() {
        listsAsserts.setListId(listId);
        listsAsserts.setResponse(responseDto);
        listsAsserts.setListMovies(listMovies);
        return listsAsserts;
    }
}
