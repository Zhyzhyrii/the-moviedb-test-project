package org.themoviedb.facades;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.ListsController;
import org.themoviedb.data.requests.CreateListRequestTemplate;
import org.themoviedb.models.MediaToListDto;
import org.themoviedb.models.listdetails.ItemDto;

import java.util.List;

@Component
public class ListsControllerFacade {

    private final ListsController listsController;
    private final CreateListRequestTemplate createListRequestTemplate = new CreateListRequestTemplate();

    @Autowired
    public ListsControllerFacade(final ListsController listsController) {
        this.listsController = listsController;
    }

    public Response createList() {
        var body = createListRequestTemplate.createListRequest();
        return listsController.createList(body, 201);
    }

    @Step("Add movie '{movieDtoId}' to list '{listId}'")
    public Response addMovieToList(final long movieDtoId, final long listId) {
        var body = MediaToListDto.builder()
                .mediaId(movieDtoId)
                .build();
        return listsController.addMovieToList(body, listId, 201);
    }

    @Step("Remove movie '{movieDtoId}' from list '{listId}'")
    public Response removeMovieFromList(final long movieDtoId, final long listId) {
        var body = MediaToListDto.builder()
                .mediaId(movieDtoId)
                .build();
        return listsController.removeMovieFromList(body, listId, 200);
    }

    @Step("Get movies of the list '{listId}'")
    public List<ItemDto> getListMovies(final long listId) {
        return listsController
                .getListDetails(listId)
                .getItems();
    }
}
