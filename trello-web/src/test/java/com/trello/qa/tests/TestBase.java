package com.trello.qa.tests;

import com.trello.qa.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class TestBase {
    Logger logger = LoggerFactory.getLogger(BoardCreationTests.class); //simple logger fasad for java
    @BeforeMethod
    public void startLogger(Method m){
     logger.info("start test " + m.getName());
    }

    @AfterMethod
    public void stopLogger(Method m){
        logger.info("stop test " + m.getName());
        // logger.info("===================================================");
        System.out.println("================================================");
    }

    public static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}