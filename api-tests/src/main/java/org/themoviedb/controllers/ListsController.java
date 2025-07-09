package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.models.ListDto;
import org.themoviedb.models.MediaToListDto;
import org.themoviedb.models.listdetails.ListDetailsDto;

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

    public Response addMovieToList(final MediaToListDto body,
                                   final long listId,
                                   final int statusCode) {
        return getRequestSpecification()
                .body(body)
                .pathParam("list_id", listId)
                .post("/list/{list_id}/add_item")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public ListDetailsDto getListDetails(final long listId) {
        return getRequestSpecification()
                .pathParam("list_id", listId)
                .get("/list/{list_id}")
                .then()
                .statusCode(200)
                .extract()
                .as(ListDetailsDto.class);
    }
}
