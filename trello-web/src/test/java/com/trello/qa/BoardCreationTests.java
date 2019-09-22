package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions() {
        if (!isUserLoggedIn()) {
            logIn("svetlana.portnaia@gmail.com", "196819651968s");
        }
    }

    @BeforeMethod
    public void isOnHomePage() {
        if (!isTherePersonalBoard()) {
            returnToHomePage();
        }

    }


    @Test
    public void testBoardCreationFromBoardButtonOnLeftHeader() throws InterruptedException {
        int NumberOfBoardsBeforeCreation = getPersonalBoardsCount();
        clickOnBoardButtonOnLeftHeader();
        selectCreateNewBoardFromDropDown();
        String boardName = "Joy" + System.currentTimeMillis();
        fillInBoardCreationForm(boardName);
        clickConfirmBoardCreationButton();
        returnToHomePage();
        returnToHomePage();
        int NumberOfBoardsAfterCreation = getPersonalBoardsCount();

        Assert.assertEquals(NumberOfBoardsAfterCreation, NumberOfBoardsBeforeCreation + 1);
    }

    @Test
    public void testBoardCreationFromPlusButtonOnHeader() throws InterruptedException {
        int NumberOfBoardsBeforeCreation = getPersonalBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        String boardName = "Happiness" + System.currentTimeMillis();
        fillInBoardCreationForm(boardName);
        clickConfirmBoardCreationButton();
        returnToHomePage();
        returnToHomePage();
        int NumberOfBoardsAfterCreation = getPersonalBoardsCount();
        Assert.assertEquals(NumberOfBoardsAfterCreation, NumberOfBoardsBeforeCreation + 1);

    }


}
