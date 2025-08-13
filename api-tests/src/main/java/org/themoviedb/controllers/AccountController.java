package org.themoviedb.controllers;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.RatedMovieDto;
import org.themoviedb.models.wrappers.PaginatedResponse;

import static org.themoviedb.PathQueryParameters.ACCOUNT_ID;

@Component
public class AccountController extends BaseController {

    //    TODO account id should be provided by the user
    public PaginatedResponse<MovieDto> getWatchlistMovies() {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, 8_564_434)
                .get("/account/{accountId}/watchlist/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {});
    }

    //    TODO account id should be provided by the user
    public PaginatedResponse<ListDetailsDto> getUserLists() {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, 8_564_434)
                .get("/account/{accountId}/lists")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {});
    }

    //    TODO account id should be provided by the user
    public PaginatedResponse<RatedMovieDto> getRatedMovies() {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, 8_564_434)
                .get("/account/{accountId}/rated/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {});
    }

    //    TODO account id should be provided by the user
    public Response updateWatchlist(final MediaToWatchListDto body,
                                    final int statusCode) {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, 8_564_434)
                .body(body)
                .post("/account/{accountId}/watchlist")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
