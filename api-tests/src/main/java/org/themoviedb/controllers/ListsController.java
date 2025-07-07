package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.models.ListDto;

@Component
public class ListsController extends BaseController {

    public Response createList(final ListDto body,
                               final int statusCode) {
        return getRequestSpecification()
                .body(body)
                .post("/list")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public Response deleteList(final long listId,
                               final int statusCode) {
        return getRequestSpecification()
                .pathParam("list_id", listId)
                .delete("/list/{list_id}")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
