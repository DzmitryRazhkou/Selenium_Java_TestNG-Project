package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User performs right-click and handles a javascript alert.")
    public void contextMenuTest() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        String contextMenuUrl = prop.getProperty("contextMenuUrl");

        contextMenuPage.navigateToPage(contextMenuUrl);
        contextMenuPage.performRightClick();
        String expAlertJSMessage = prop.getProperty("alertJSMessage");
        String actAlertJSMessage = contextMenuPage.handleJSAlert();
        Assert.assertEquals(expAlertJSMessage, actAlertJSMessage);

    }

}
