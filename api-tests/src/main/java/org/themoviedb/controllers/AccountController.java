package org.themoviedb.controllers;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.themoviedb.ApiPaths;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.models.listdetails.ListDetailsDto;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.models.movie.RatedMovieDto;
import org.themoviedb.models.wrappers.PaginatedResponse;

@Component
public class AccountController extends BaseController {

    public PaginatedResponse<MovieDto> getWatchlistMovies() {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.ACCOUNT_ID, getApiConfig().getAccountId())
                .get(ApiPaths.Account.WATCH_LIST_MOVIES)
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public PaginatedResponse<ListDetailsDto> getUserLists() {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.ACCOUNT_ID, getApiConfig().getAccountId())
                .get(ApiPaths.Account.LISTS_MOVIES)
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public PaginatedResponse<RatedMovieDto> getRatedMovies() {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.ACCOUNT_ID, getApiConfig().getAccountId())
                .get(ApiPaths.Account.RATED_MOVIES)
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {
                });
    }

    public Response updateWatchlist(final MediaToWatchListDto body,
                                    final int statusCode) {
        return getRequestSpecification()
                .pathParam(ApiPaths.PARAM.ACCOUNT_ID, getApiConfig().getAccountId())
                .body(body)
                .post(ApiPaths.Account.WATCH_LIST)
                .then()
                .statusCode(statusCode)
                .extract()
                .response();
    }
}
