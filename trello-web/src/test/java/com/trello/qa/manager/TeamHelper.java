package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(TeamData team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        type(By.cssSelector("textarea"), team.getDescription());
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public String getTeamNameFromTeamPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public int getTeamsCount() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton() {

    }

    public void openSettings() throws InterruptedException {
        //waitForElementAndClick(By.xpath("//*[@class='icon-gear icon-sm OiX3P2i2J92Xat']/../../.."), 20);
        Thread.sleep(5000);
        //click(By.xpath("//*[@class='icon-gear icon-sm OiX3P2i2J92Xat']/../../.."));
        click(By.cssSelector("ul .icon-gear.icon-sm"));
        //   click(By.cssSelector("[href$=account]"));
        //waitForElementAndClick(By.cssSelector("li .icon-gear.icon-sm.OiX3P2i2J92Xat"), 30);
    }

    public void deleteTeam() throws InterruptedException {
//    new WebDriverWait(driver, 10)
//            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        Thread.sleep(10000);
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm"));
    }

    public void clickOnFirstTeam() {
//waitForElementAndClick(By.cssSelector("[data-test-id^='home-team-tab-section-']"), 20);
        //click(By.xpath("//*[@data-test-id='home-team-tab-name']"));
        click(By.cssSelector("[data-test-id^='home-team-tab-section-']"));
    }

    protected void confirmCloseButton() {
        click(By.cssSelector(".js-confirm.full.negate"));
    }

    public void cleanTeams() throws InterruptedException {
        int count = getTeamsCount();
        while (count > 5) {
            clickOnFirstTeam();
            openSettings();
            deleteTeam();
            // returnToHomePage();
            refreshPage();
            count = getTeamsCount();
            System.out.println(count);
        }
    }

    public void initEditTeamProfile() {
        click(By.cssSelector(".js-edit-profile"));
       // waitForElementAndClick(By.cssSelector(".js-edit-profile"),15);
    }

    public void changeTeamProfile(String name, String description) {
        type(By.name("displayName"),name);
        type(By.name("desc"), description);
    }

    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));

    }
}
