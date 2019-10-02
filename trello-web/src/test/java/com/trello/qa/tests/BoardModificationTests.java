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
  public void changeBoardName() {

    app.getBoardHelper().clickOnFirstPrivateBoard();
    String boardName = "STATISTICS";
    app.getBoardHelper().changeBoardName(boardName);

    Assert.assertTrue(app.getBoardHelper().findBoardByName(boardName));
}
}
