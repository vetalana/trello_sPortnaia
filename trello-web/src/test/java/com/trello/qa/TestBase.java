package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openSite("https://trello.com");
        logIn("svetlana.portnaia@gmail.com", "196819651968s");
    }

    public void logIn(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type(By.cssSelector("[type=password]"), password);
        click(By.id("login"));

    }

    public void click(By locator) {
        driver.findElement(locator).click();

    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isUserLoggedIn() {
        return driver.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }


    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);

    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void selectCreateBoardFromDropDown()  {
     //   Thread.sleep(15000);
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test-id='header-create-board-button']")));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void fillInBoardCreationForm(String boardName) {
        new WebDriverWait(driver,15)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test-id='header-create-board-title-input']")));
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
        if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
            //Thread.sleep(5000);
            // new WebDriverWait(driver, 10).
            //until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".W6rMLOx8U0MrPx")));
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            //Thread.sleep(5000);
            //new WebDriverWait(driver,10).
            //until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]")));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));// no team
        }
    }

    public void clickConfirmBoardCreationButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id='header-create-board-submit-button']")));
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public void selectCreateNewBoardFromDropDown() {
        driver.findElement(By.cssSelector("[data-test-id='header-boards-menu-create-board']")).click();

    }

    public void clickOnBoardButtonOnLeftHeader() {
        driver.findElement(By.cssSelector("[data-test-id='header-boards-menu-button']")).click();
    }

       public void returnToHomePage() {
        if (isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))) {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }

    public int getTeamsCount() {
        //Thread.sleep(10000);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton() {
    }

    public int getPersonalBoardsCount() throws InterruptedException {
        // Thread.sleep(20000);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public String getTeamNameFromTeamPage() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }



    public void clickOnSecondRedDeleteButton() {
        click(By.cssSelector("[.js-confirm.full.negate]"));
    }

    public void clickOnDeleteForeverButton() {
        click(By.cssSelector("[.quiet.js-delete]"));
    }

    public void clickOnRedDeleteButton() {
        click(By.cssSelector("[.js-confirm.full.negate]"));
    }

    public void clickOnDeleteButtonFromDropDownMenu() {
        new WebDriverWait(driver,25)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[.board-menu-navigation-item-link.js-close-board]")));
        click(By.cssSelector("[.board-menu-navigation-item-link.js-close-board]"));
    }

    public void clickOnMoreButtonInBoardRightMenu() throws InterruptedException {
//        Thread.sleep(5000);
//        click(By.cssSelector("[.board-menu-navigation-item-link.js-open-more]"));

            WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
            System.out.println(menuButton.getCssValue("visibility"));
            if (menuButton.getCssValue("visibility").equals("visible")) {
                click(By.cssSelector(".mod-show-menu"));
                click(By.cssSelector(".js-open-more"));
            } else {
                click(By.cssSelector(".js-open-more"));
            }
        }

    public void clickOnFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));

    }
}
