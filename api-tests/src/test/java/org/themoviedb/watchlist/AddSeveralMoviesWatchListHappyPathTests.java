package org.themoviedb.watchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;

import java.util.List;

public class AddSeveralMoviesWatchListHappyPathTests extends BaseTest {

    @Autowired
    private MovieListsSteps movieListsSteps;

    @Autowired
    private AccountSteps accountSteps;

    private MovieDto randomFirstMovieDto;
    private MovieDto randomSecondMovieDto;

    @BeforeMethod
    public void setUp() {
        randomFirstMovieDto = movieListsSteps.getRandomTopRatedMovie();
        randomSecondMovieDto = movieListsSteps.getRandomTopRatedMovie(List.of(randomFirstMovieDto));
    }

    @Test
    public void addRandomSeveralMovieFromTopRatedToWatchlistAndVerifyPresence() {
        accountSteps
                .addMovieToWatchlist(randomFirstMovieDto.getId())
                .addMovieToWatchlist(randomSecondMovieDto.getId())
                .getWatchListMovies()
                .assertThat()
                .watchListContainsExpectedMovies(List.of(randomFirstMovieDto, randomSecondMovieDto));
    }

    @AfterMethod
    public void tearDown() {
        accountSteps.removeMovieFromWatchlist(randomFirstMovieDto.getId());
        accountSteps.removeMovieFromWatchlist(randomSecondMovieDto.getId());
    }
}
