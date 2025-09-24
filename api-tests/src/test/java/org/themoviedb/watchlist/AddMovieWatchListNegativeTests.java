package org.themoviedb.watchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.steps.AccountSteps;

import java.util.List;

import static org.themoviedb.data.enums.MediaType.MOVIE;

public class AddMovieWatchListNegativeTests extends BaseTest {

    @Autowired
    private AccountSteps accountSteps;

    @Test(dataProvider = "passWrongRequestToAddToWatchlistAndVerifyUnsuccessfulResponse")
    public void passWrongRequestToAddToWatchlistAndVerifyUnsuccessfulResponse(final MediaToWatchListDto body,
                                                                              final int statusCode,
                                                                              final String statusMessage) {
        accountSteps
                .addMovieToWatchlist(body, 404)
                .assertThat()
                .addMovieResponseIsUnsuccessful(statusCode, statusMessage);
    }

    @Test(dataProvider = "passWrongRequestToAddToWatchlistAndVerifyWatchListIsNotUpdated")
    public void passWrongRequestToAddToWatchlistAndVerifyWatchListIsNotUpdated(final MediaToWatchListDto body) {
        accountSteps
                .addMovieToWatchlist(body, 404)
                .getWatchListMovies()
                .assertThat()
                .watchListDoesNotContainExpectedMovieIds(List.of(body.getMediaId()));
    }

    @DataProvider
    public Object[][] passWrongRequestToAddToWatchlistAndVerifyUnsuccessfulResponse() {
        return new Object[][]{
                {
                        MediaToWatchListDto.mediaToWatchListDtoBuilder()
                                .mediaType(MOVIE.getName())
                                .watchList(true)
                                .build(),
                        6,
                        "Invalid id: The pre-requisite id is invalid or not found."
                },
                {
                        MediaToWatchListDto.mediaToWatchListDtoBuilder()
                                .mediaType("audio")
                                .mediaId(2L)
                                .watchList(true)
                                .build(),
                        34,
                        "The resource you requested could not be found."
                }
        };
    }

    @DataProvider
    public Object[][] passWrongRequestToAddToWatchlistAndVerifyWatchListIsNotUpdated() {
        return new Object[][]{
                {
                        MediaToWatchListDto.mediaToWatchListDtoBuilder()
                                .mediaType(MOVIE.getName())
                                .watchList(true)
                                .build()
                },
                {
                        MediaToWatchListDto.mediaToWatchListDtoBuilder()
                                .mediaType("audio")
                                .mediaId(2L)
                                .watchList(true)
                                .build()
                }
        };
    }
}
