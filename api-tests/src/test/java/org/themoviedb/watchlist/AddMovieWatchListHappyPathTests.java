package org.themoviedb.watchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;

import java.util.List;

public class AddMovieWatchListHappyPathTests extends BaseTest {

    @Autowired
    private MovieListsSteps movieListsSteps;

    @Autowired
    private AccountSteps accountSteps;

    private MovieDto randomMovieDto;

    @BeforeMethod
    public void setUp() {
        randomMovieDto = movieListsSteps.getRandomTopRatedMovie();
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchlistAndVerifySuccessfulResponse() {
        accountSteps
                .addMovieToWatchlist(randomMovieDto.getId())
                .assertThat()
                .addMovieResponseIsSuccessful();
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchlistAndVerifyPresence() {
        accountSteps
                .addMovieToWatchlist(randomMovieDto.getId())
                .getWatchListMovies()
                .assertThat()
                .watchListContainsExpectedMovies(List.of(randomMovieDto));
    }

    @AfterMethod
    public void tearDown() {
        accountSteps.removeMovieFromWatchlist(randomMovieDto.getId());
    }
}
