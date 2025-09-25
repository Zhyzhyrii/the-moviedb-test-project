package org.themoviedb.controllers;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.ApiPaths;
import org.themoviedb.models.ListDto;
import org.themoviedb.models.MediaToListDto;
import org.themoviedb.models.listdetails.ListDetailsWithItemsDto;

@Component
public class ListsController extends BaseController {

    public Response createList(final ListDto body,
                               final int statusCode) {
        return getRequestSpecification()
                .body(body)
                .post(ApiPaths.Lists.ROOT)
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public void deleteList(final long listId,
                           final int statusCode) {
        getRequestSpecification()
                .pathParam(ApiPaths.PARAM.LIST_ID, listId)
                .delete(ApiPaths.Lists.BY_ID)
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
                .pathParam(ApiPaths.PARAM.LIST_ID, listId)
                .post(ApiPaths.Lists.ADD_ITEM)
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
                .pathParam(ApiPaths.PARAM.LIST_ID, listId)
                .post(ApiPaths.Lists.REMOVE_ITEM)
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }

    public ListDetailsWithItemsDto getListDetails(final long listId) {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.LIST_ID, listId)
                .get(ApiPaths.Lists.BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .as(ListDetailsWithItemsDto.class);
    }
}
