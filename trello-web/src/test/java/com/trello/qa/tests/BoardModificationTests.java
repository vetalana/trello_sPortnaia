package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!app.getBoardHelper().isTherePersonalBoards()){
            app.getBoardHelper().createBoard();
        }
    }
@Test
  public void changeBoardName() throws InterruptedException {

    app.getBoardHelper().clickOnFirstPrivateBoard();
    String boardName = "STATE";
    app.getBoardHelper().changeBoardName(boardName);
    Thread.sleep(5000);
   // Assert.assertTrue(app.getBoardHelper().findBoardByName(boardName));
}
}
