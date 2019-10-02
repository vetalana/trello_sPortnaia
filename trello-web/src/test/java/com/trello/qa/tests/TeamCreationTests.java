package com.trello.qa.tests;

import com.trello.qa.manager.TeamData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditionsLogin() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().login("svetlana.portnaia@gmail.com", "196819651968s");
        }
    }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "Joy" + System.currentTimeMillis();
        app.getTeamHelper().fillTeamCreationForm(new TeamData(teamName, "smile"));
        app.getTeamHelper().clickContinueButton();
        //  String createdTeamName = getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        //  Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
    }

    @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new TeamData("h", "g"));
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        //  refreshPage();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, "h");
    }

    @Test(enabled = false)
    public void testTeamCuncellCreationFromPlusButtonOnHeader() throws InterruptedException {
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().fillTeamCreationForm(new TeamData("qa21", "descr qa 21"));
        app.getTeamHelper().clickXButton();

        //Assert


        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
    }

    @AfterClass
    public void postActions() throws InterruptedException {
        app.getTeamHelper().cleanTeams();
    }

}