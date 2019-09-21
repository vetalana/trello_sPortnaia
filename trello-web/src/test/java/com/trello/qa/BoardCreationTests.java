package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreationFromBoardButtonOnLeftHeader() throws InterruptedException {
        int NumberOfBoardsBeforeCreation = getPersonalBoardsCount();
        clickOnBoardButtonOnLeftHeader();
        selectCreateNewBoardFromDropDown();
        fillInBoardCreationForm("Luckiness");
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
        fillInBoardCreationForm("Happiness");
        clickConfirmBoardCreationButton();

        returnToHomePage();
        returnToHomePage();

        int NumberOfBoardsAfterCreation = getPersonalBoardsCount();
        Assert.assertEquals(NumberOfBoardsAfterCreation, NumberOfBoardsBeforeCreation + 1);

    }


}
