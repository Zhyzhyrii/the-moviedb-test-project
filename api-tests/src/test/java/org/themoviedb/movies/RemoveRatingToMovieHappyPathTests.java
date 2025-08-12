package org.themoviedb.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.MovieListsSteps;
import org.themoviedb.steps.MoviesSteps;

import java.util.List;

import static org.themoviedb.utils.DataGeneratorUtil.generateMovieRatingRange;
import static org.themoviedb.utils.RandomUtil.getRandomElement;

public class RemoveRatingToMovieHappyPathTests extends BaseTest {

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
    public void addRatingToMovieAndVerifyRatingIsAdded() {
        var movieId = randomMovieDto.getId();
        var rating = getRandomElement(generateMovieRatingRange());
        moviesSteps
                .addMovieRating(movieId, rating);
        accountSteps
                .waitAndGetRatedMovies(movies -> !movies.isEmpty());
        moviesSteps
                .removeMovieRating(movieId);
        accountSteps
                .waitAndGetRatedMovies(List::isEmpty)
                .assertThat()
                .ratedMovieListDoesNotContainMovie(movieId);
    }
}
