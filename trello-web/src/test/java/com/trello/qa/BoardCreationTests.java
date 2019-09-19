package com.trello.qa;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreationFromPlusButtonOnHeader() {
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillInBoardCreationForm("Luckyness", "LuckyBoard");
        clickConfirmBoardCreationButton();

        Assert.assertTrue(isUserLoggedIn());
    }


}
