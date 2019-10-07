package com.trello.qa.tests;

import com.trello.qa.model.BoardData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    Logger logger = LoggerFactory.getLogger(BoardCreationTests.class); //simple logger fasad for java
   @BeforeMethod
    public void startLogger(){
       logger.info("start test BoardCreationTests");
    }

    @AfterMethod
    public void stopLogger(){
        logger.info("stop test BoardCreationTests");
       // logger.info("===================================================");
       System.out.println("================================================");
    }
    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> listBoards = new ArrayList<>();
        listBoards.add(new Object[]{"NAme1"});
        listBoards.add(new Object[]{"777"});
       // listBoards.add(new Object[]{"про_это"});
       // listBoards.add(new Object[]{"@#$%^"});

        return listBoards.listIterator();
    }

    @Test(dataProvider = "validBoards")
    public void testBoardCreationDataProvider(String boardName) throws InterruptedException {

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
    public void testBoardCreation() throws InterruptedException {
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
