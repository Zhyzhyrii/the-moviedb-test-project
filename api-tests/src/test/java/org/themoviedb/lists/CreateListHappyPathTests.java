package org.themoviedb.lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.movie.MovieDto;
import org.themoviedb.steps.ListsSteps;
import org.themoviedb.steps.MovieListsSteps;

import java.util.List;

public class CreateListHappyPathTests extends BaseTest {

    @Autowired
    private MovieListsSteps movieListsSteps;

    @Autowired
    private ListsSteps listsSteps;

    private MovieDto randomMovieDto;

    @BeforeMethod
    public void setUp() {
        randomMovieDto = movieListsSteps.getRandomTopRatedMovie();
    }

    @Test
    public void createListAndVerifySuccessfulResponse() {
        listsSteps
                .createList()
                .assertThat()
                .createListResponseIsSuccessful();
    }

    @Test
    public void createListAddRandomMovieFromTopRatedToCreatedListAndVerifyPresence() {
        listsSteps
                .createList()
                .addMovieToList(randomMovieDto.getId())
                .getListMovies()
                .assertThat()
                .listContainsExpectedMovies(List.of(randomMovieDto));
    }

    @Test
    public void createListAddRandomMovieFromTopRatedToCreatedListRemoveMovieFromListAndVerifyListIsEmpty() {
        var movieId = randomMovieDto.getId();
        listsSteps
                .createList()
                .addMovieToList(movieId)
                .removeMovieFromList(movieId)
                .getListMovies()
                .assertThat()
                .listIsEmpty();
    }

    @AfterMethod
    public void tearDown() {
        listsSteps.removeList(listsSteps.getListId());
    }
}
