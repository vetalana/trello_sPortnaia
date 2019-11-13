package com.trello.qa.tests;

import org.testng.annotations.Test;

public class UserModificationTests extends TestBase {
    @Test
    public void changeAvatarTest() throws InterruptedException {
        app.getUserHelper().clickOnAvatar();
        app.getUserHelper().openProfileFromDropDown();
        app.getUserHelper().initAvatarChanging();
        app.getUserHelper().addPicture();

    }
}
