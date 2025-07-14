package org.themoviedb.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.models.MovieDto;
import org.themoviedb.steps.AccountSteps;
import org.themoviedb.steps.ListsSteps;
import org.themoviedb.steps.MovieListsSteps;

public class RemoveListHappyPathTests extends BaseTest {

    @Autowired
    private AccountSteps accountSteps;

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
    public void createListAddRandomMovieFromTopRatedToCreatedListRemoveListAndVerifyListIsRemoved() {
        var movieId = randomMovieDto.getId();
        listsSteps
                .createList()
                .addMovieToList(movieId)
                .removeList();
        accountSteps
                .getUserLists()
                .assertThat()
                .usersCustomListsDoNotContainSpecificList(listsSteps.getListId());
    }
}
