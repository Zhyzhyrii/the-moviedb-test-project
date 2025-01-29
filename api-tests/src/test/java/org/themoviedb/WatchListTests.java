package org.themoviedb;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.facades.MovieListsControllerFacade;
import org.themoviedb.models.Movie;

public class WatchListTests {

    private final MovieListsControllerFacade movieListsControllerFacade = new MovieListsControllerFacade();
    private final AccountControllerFacade accountControllerFacade = new AccountControllerFacade();

    private Movie randomMovie;

    @BeforeMethod
    public void setUp() {
        randomMovie = movieListsControllerFacade.getRandomTopRatedMovie();
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchListAndVerifyThatItWasAdded() {
        accountControllerFacade.addMovieToWatchlist(randomMovie);

        var actualMovie = accountControllerFacade.getFirstWatchlistMovie();
        Assert.assertEquals(actualMovie, randomMovie, "Wrong movie was added to watchlist");
    }

    @AfterMethod
    public void tearDown() {
        accountControllerFacade.removeMovieFromWatchlist(randomMovie);
    }
}
