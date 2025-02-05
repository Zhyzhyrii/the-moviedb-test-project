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
                .watchListContainsExpectedMovie(randomMovieDto);
    }

    @AfterMethod
    public void tearDown() {
        accountSteps.removeMovieFromWatchlist(randomMovieDto.getId());
    }
}
