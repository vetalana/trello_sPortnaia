package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> listBoards = new ArrayList<>();
        listBoards.add(new Object[]{"NAme1"});
        listBoards.add(new Object[]{"777"});
        listBoards.add(new Object[]{"про это"});
        listBoards.add(new Object[]{"@#$%^"});

        return listBoards.listIterator();
    }

    @Test(dataProvider = "validBoards")
    public void testBoardCreationDataProvider(String boardName) {
        int beforeCreation = app.getBoardHelper().getPersnalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(new BoardData().setBoardName(boardName));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();


        int afterCreation = app.getBoardHelper().getPersnalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }

    @Test
    public void testBoardCreation() {
        int beforeCreation = app.getBoardHelper().getPersnalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(new BoardData().setBoardName("Happiness"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper().getPersnalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }


}
