package org.themoviedb.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.themoviedb.BaseTest;
import org.themoviedb.steps.ListsSteps;

public class CreateListHappyPathTests extends BaseTest {

    @Autowired
    private ListsSteps listsSteps;

    @Test
    public void createListAndVerifySuccessfulResponse() {
        listsSteps
                .createList()
                .assertThat()
                .createListResponseIsSuccessful();
    }

    @AfterMethod
    public void tearDown() {
        listsSteps.removeList(listsSteps.getCreatedListId());
    }
}
