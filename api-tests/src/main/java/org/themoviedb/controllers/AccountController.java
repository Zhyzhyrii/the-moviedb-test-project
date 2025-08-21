package org.themoviedb.controllers;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.movie.RatedMovieDto;
import org.themoviedb.models.wrappers.PaginatedResponse;

import static org.themoviedb.PathQueryParameters.ACCOUNT_ID;

@Component
public class AccountController extends BaseController {

    public PaginatedResponse<MovieDto> getWatchlistMovies() {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, getApiConfig().getAccountId())
                .get("/account/{accountId}/watchlist/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public PaginatedResponse<ListDetailsDto> getUserLists() {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, getApiConfig().getAccountId())
                .get("/account/{accountId}/lists")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public PaginatedResponse<RatedMovieDto> getRatedMovies() {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, getApiConfig().getAccountId())
                .get("/account/{accountId}/rated/movies")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public Response updateWatchlist(final MediaToWatchListDto body,
                                    final int statusCode) {
        return getRequestSpecification()
                .pathParam(ACCOUNT_ID, getApiConfig().getAccountId())
                .body(body)
                .post("/account/{accountId}/watchlist")
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
