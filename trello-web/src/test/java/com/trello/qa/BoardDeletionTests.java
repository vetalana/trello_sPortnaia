package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
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
    public boolean isTherePersonalBoard() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }
    @Test
    public void testBoardDeletion() throws InterruptedException {
        int NumberOfBoardsBeforeDeletion = getPersonalBoardsCount();
        while (NumberOfBoardsBeforeDeletion > 3) {
            clickOnFirstPersonalBoard();
            clickOnMoreButtonInBoardRightMenu();
            clickOnDeleteButtonFromDropDownMenu();
            clickOnRedDeleteButton();
            clickOnDeleteForeverButton();
            clickOnSecondRedDeleteButton();
            returnToHomePage();
            returnToHomePage();
            int NumberOfBoardsAfterDeletion = getPersonalBoardsCount();
            Assert.assertEquals(NumberOfBoardsAfterDeletion, NumberOfBoardsBeforeDeletion - 1);
        }
    }

}
