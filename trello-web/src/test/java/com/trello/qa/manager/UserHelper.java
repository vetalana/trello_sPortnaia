package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class UserHelper extends  HelperBase {

    public Object initAvatarChanging;

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void openProfileFromDropDown() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void initAvatarChanging() {
        new Actions(driver)
                .moveToElement(driver.findElement(By.cssSelector(".rsiNque2CCqtPE")))
                .click().perform();
    }

    public void addPicture() throws InterruptedException {
        attach(new File("C:/Users/lana/Documents/GitHub/trello_sPortnaia/trello-web/src/test/resources/cat.jpg"));
    Thread.sleep(10000);
    }

    private void attach(File file) {
        driver.findElement(By.name("file")).sendKeys(file.getAbsolutePath());
    }
}
