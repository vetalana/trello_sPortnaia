package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("qa21", "description qa21");
        clickContinueButton();

        returnToHomePage();
        Thread.sleep(20000);
        int after=getTeamsCount();
       Assert.assertEquals(after, before+1);

    }

    @Test(enabled=false)
    public void testTeamCancelCreationFromPlusButtonOnHeader(){
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("qa21", "description qa21");
        clickXButton();
        Assert.assertTrue(isUserLoggedIn());
    }

}
