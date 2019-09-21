package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21";
        fillTeamCreationForm(teamName, "description qa21");
        clickContinueButton();
        String createdTeamName=getTeamNameFromTeamPage();

        returnToHomePage();
        int after=getTeamsCount();
       Assert.assertEquals(after, before+1);
       Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());

    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnLeftNavMenu();
        String teamName = "QA21";
        fillTeamCreationForm(teamName, "description qa21");
        clickContinueButton();
        String createdTeamName=getTeamNameFromTeamPage();

        returnToHomePage();
        int after=getTeamsCount();
        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
    }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));
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
