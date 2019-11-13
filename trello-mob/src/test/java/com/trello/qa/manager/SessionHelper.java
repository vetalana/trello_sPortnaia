package com.trello.qa.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionHelper extends HelperBase {
    public SessionHelper(AppiumDriver driver){
        super(driver);

    }
    public void login(String email, String password) throws InterruptedException {

        click(By.id("log_in_button"));
        type(By.id("user"), email);
        type(By.id("password"), password);
        click(By.id("authenticate"));
        Thread.sleep(10000);
    }


}
