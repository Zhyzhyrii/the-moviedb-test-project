package org.themoviedb;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.models.Movie;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;

public class WatchListTests {

    private final MovieListsSteps movieListsSteps = new MovieListsSteps();
    private final AccountSteps accountSteps = new AccountSteps();
    private Movie randomMovie;

    @BeforeMethod
    public void setUp() {
        randomMovie = movieListsSteps.getRandomTopRatedMovie();
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchListAndVerifyThatItWasAdded() {
        var actualMovie = accountSteps
                .addMovieToWatchlist(randomMovie)
                .getFirstWatchlistMovie();
        Assert.assertEquals(actualMovie, randomMovie, "Wrong movie was added to watchlist");
    }

    @AfterMethod
    public void tearDown() {
        accountSteps.removeMovieFromWatchlist(randomMovie);
    }
}
