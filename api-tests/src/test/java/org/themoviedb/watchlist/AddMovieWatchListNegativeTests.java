package org.themoviedb.watchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.themoviedb.Application;
import org.themoviedb.models.MediaToWatchListDto;
import org.themoviedb.steps.AccountSteps;

import static org.themoviedb.data.enums.MediaType.MOVIE;

//TODO make base test and move all this staff there. Other tests should extend base test
@SpringBootTest(classes = Application.class)
public class AddMovieWatchListNegativeTests extends AbstractTestNGSpringContextTests {

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
                .watchListIsEmpty();
    }

    @DataProvider
    public Object[][] passWrongRequestToAddToWatchlistAndVerifyUnsuccessfulResponse() {
        return new Object[][]{
                {
                        MediaToWatchListDto.builder()
                                .mediaType(MOVIE.getName())
                                .watchlist(true)
                                .build(),
                        6,
                        "Invalid id: The pre-requisite id is invalid or not found."
                },
                {
                        MediaToWatchListDto.builder()
                                .mediaType("audio")
                                .mediaId(2L)
                                .watchlist(true)
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
                        MediaToWatchListDto.builder()
                                .mediaType(MOVIE.getName())
                                .watchlist(true)
                                .build()
                },
                {
                        MediaToWatchListDto.builder()
                                .mediaType("audio")
                                .mediaId(2L)
                                .watchlist(true)
                                .build()
                }
        };
    }
}
