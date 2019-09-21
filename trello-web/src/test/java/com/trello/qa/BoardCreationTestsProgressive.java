package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTestsProgressive extends TestBase{

    @Test(enabled = false)
    public void testBoardCreationFromBoardButtonOnLeftHeader() throws InterruptedException {
        int NumberOfBoardsBeforeCreation = getPersonalBoardsCount();
        clickOnBoardButtonOnLeftHeader();
        selectCreateNewBoardFromDropDown();
        fillInBoardCreationForm("Luckiness");
        clickConfirmBoardCreationButton();
        Thread.sleep(20000);
        returnToHomePage();
        returnToHomePage();
        Thread.sleep(20000);
        int NumberOfBoardsAfterCreation = getPersonalBoardsCount();

        Assert.assertEquals(NumberOfBoardsAfterCreation, NumberOfBoardsBeforeCreation + 1);

    }

    @Test(enabled = false)
    public void testBoardCreationFromPlusButtonOnHeader() throws InterruptedException {
        int NumberOfBoardsBeforeCreation = getPersonalBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillInBoardCreationForm("Happiness");
        clickConfirmBoardCreationButton();
        Thread.sleep(20000);
        returnToHomePage();
        returnToHomePage();
        Thread.sleep(20000);
        int NumberOfBoardsAfterCreation = getPersonalBoardsCount();
        Assert.assertEquals(NumberOfBoardsAfterCreation, NumberOfBoardsBeforeCreation + 1);

    }


}

