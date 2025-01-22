package org.themoviedb;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.themoviedb.facades.AccountControllerFacade;
import org.themoviedb.facades.MovieListsControllerFacade;

public class WatchListTests {

    @Test
    public void addRandomMovieFromTopRatedToWatchListAndVerifyThatItWasAdded() {
//        PRECONDITION
        var movieListsControllerFacade = new MovieListsControllerFacade();
        var randomMovie = movieListsControllerFacade.getRandomTopRatedMovie();

//        TEST
        var accountControllerFacade = new AccountControllerFacade();
        accountControllerFacade.addMovieToWatchlist(randomMovie);

        var actualMovie = accountControllerFacade.getFirstWatchlistMovie();
        Assert.assertEquals(actualMovie, randomMovie, "Wrong movie was added to watchlist");//TODO

//        POST condition
        accountControllerFacade.removeMovieFromWatchlist(randomMovie);
    }
}
