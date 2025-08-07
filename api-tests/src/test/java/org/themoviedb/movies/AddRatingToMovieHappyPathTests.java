package org.themoviedb.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;
import org.themoviedb.steps.MoviesSteps;

import static org.themoviedb.utils.DataGeneratorUtil.generateMovieRatingRange;
import static org.themoviedb.utils.RandomUtil.getRandomElement;

public class AddRatingToMovieHappyPathTests extends BaseTest {

    @Autowired
    private MovieListsSteps movieListsSteps;

    @Autowired
    private AccountSteps accountSteps;

    @Autowired
    private MoviesSteps moviesSteps;

    private MovieDto randomMovieDto;

    @BeforeMethod
    public void setUp() {
        randomMovieDto = movieListsSteps.getRandomTopRatedMovie();
    }

    @Test
    public void addRatingToMovieAndVerifySuccessfulResponse() {
        moviesSteps
                .addMovieRating(randomMovieDto.getId(), getRandomElement(generateMovieRatingRange()))
                .assertThat()
                .addRatingToMovieResponseIsSuccessful();
    }

    @Test
    public void addRatingToMovieAndVerifyRatingIsAdded() {
        var rating = getRandomElement(generateMovieRatingRange());
        moviesSteps
                .addMovieRating(randomMovieDto.getId(), rating);
        accountSteps
                .waitAndGetRatedMovies()
                .assertThat()
                .ratedMovieListContainsExpectedRatedMovie(randomMovieDto, rating);
    }

    @AfterMethod
    public void tearDown() {
        moviesSteps.removeMovieRating(randomMovieDto.getId());
    }
}
