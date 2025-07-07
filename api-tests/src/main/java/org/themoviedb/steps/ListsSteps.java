package org.themoviedb.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.assertions.ListsAsserts;
import org.themoviedb.controllers.ListsController;
import org.themoviedb.facades.ListsControllerFacade;

@Component
public class ListsSteps {

    private final ListsControllerFacade listsControllerFacade;
    private final ListsController listsController;
    private final ListsAsserts listsAsserts;

    private Response responseDto;

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
        return this;
    }

    @Step("Get created list id")
    public long getCreatedListId() {
        return responseDto.getBody().jsonPath().getLong("list_id");
    }

    @Step("Remove list '{listId}'")
    public void removeList(final long listId) {
        listsController.deleteList(listId, 200);
    }

    public ListsAsserts assertThat() {
        listsAsserts.setResponse(responseDto);
        return listsAsserts;
    }
}
