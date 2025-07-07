package org.themoviedb.facades;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.themoviedb.controllers.ListsController;
import org.themoviedb.data.requests.CreateListRequestTemplate;

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
}
