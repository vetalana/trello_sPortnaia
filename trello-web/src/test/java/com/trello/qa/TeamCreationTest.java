package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @Test
    public void testTeamCreationFromPlusButtonOnHeader(){
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("qa21", "description qa21");
        clickContinueButton();

        Assert.assertTrue(isUserLoggedIn());
    }
    @Test(enabled=false)
    public void testTeamCancelCreationFromPlusButtonOnHeader(){
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("qa21", "description qa21");
        clickXButton();

        Assert.assertTrue(isUserLoggedIn());
    }

    public void clickXButton() {
    }
}
