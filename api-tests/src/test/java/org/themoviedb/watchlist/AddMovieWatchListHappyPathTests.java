package org.themoviedb.watchlist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.models.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;

public class AddMovieWatchListHappyPathTests {

    private final MovieListsSteps movieListsSteps = new MovieListsSteps();
    private final AccountSteps accountSteps = new AccountSteps();
    private MovieDto randomMovieDto;

    @BeforeMethod
    public void setUp() {
        randomMovieDto = movieListsSteps.getRandomTopRatedMovie();
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchlistAndVerifyPresence() {
        accountSteps
                .addMovieToWatchlist(randomMovieDto)
                .getFirstWatchlistMovie()
                .assertThat()
                .watchListContainsExpectedMovie(randomMovieDto);
    }

    @Test
    public void addRandomMovieFromTopRatedToWatchlistAndVerifySuccessfulResponse() {
        accountSteps
                .addMovieToWatchlist(randomMovieDto)
                .assertThat()
                .addMovieResponseIsSuccessful();
    }

    @AfterMethod
    public void tearDown() {
        accountSteps.removeMovieFromWatchlist(randomMovieDto);
    }
}
