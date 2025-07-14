package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.models.ListDto;
import org.themoviedb.models.MediaToListDto;
import org.themoviedb.models.listdetails.ListDetailsWithItemsDto;

import static org.themoviedb.PathQueryParameters.LIST_ID;

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

    public void deleteList(final long listId,
                           final int statusCode) {
        getRequestSpecification()
                .pathParam(LIST_ID, listId)
                .delete("/list/{list_id}")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public Response addMovieToList(final MediaToListDto body,
                                   final long listId,
                                   final int statusCode) {
        return getRequestSpecification()
                .body(body)
                .pathParam(LIST_ID, listId)
                .post("/list/{list_id}/add_item")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public Response removeMovieFromList(final MediaToListDto body,
                                        final long listId,
                                        final int statusCode) {
        return getRequestSpecification()
                .body(body)
                .pathParam(LIST_ID, listId)
                .post("/list/{list_id}/remove_item")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public ListDetailsWithItemsDto getListDetails(final long listId) {
        return getRequestSpecification()
                .pathParam(LIST_ID, listId)
                .get("/list/{list_id}")
                .then()
                .statusCode(200)
                .extract()
                .as(ListDetailsWithItemsDto.class);
    }
}
