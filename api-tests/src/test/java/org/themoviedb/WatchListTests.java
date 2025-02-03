package org.themoviedb;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.models.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;

public class WatchListTests {

    private final MovieListsSteps movieListsSteps = new MovieListsSteps();
    private final AccountSteps accountSteps = new AccountSteps();
    private MovieDto randomMovieDto;

    @BeforeMethod
    public void setUp() {
        randomMovieDto = movieListsSteps.getRandomTopRatedMovie();
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchListAndVerifyThatItWasAdded() {
        var actualMovie = accountSteps
                .addMovieToWatchlist(randomMovieDto)
                .getFirstWatchlistMovie();
        Assert.assertEquals(actualMovie, randomMovieDto, "Wrong movie was added to watchlist");
    }

    @AfterMethod
    public void tearDown() {
        accountSteps.removeMovieFromWatchlist(randomMovieDto);
    }
}
