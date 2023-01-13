package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.CheckBoxesPage;
import com.qa.take_home_webdriver_test.pages.ContextMenuPage;
import com.qa.take_home_webdriver_test.pages.LoginSuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakeHomeWebDriverTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User with valid credentials can log in successfully.")
    public void loginSuccessTest() {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        String loginSuccessUrl = prop.getProperty("loginSuccessUrl");
        String successLoginMessageTxt = prop.getProperty("successLoginMsg");

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        loginSuccessPage.navigateToPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.successLoginMessage(successLoginMessageTxt));
    }

    @Test(priority = 2, groups = {"Smoke"}, description = "User with invalid credentials can't log in successfully.")
    public void loginFailureTest() {
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        String userName = prop.getProperty("userName").toUpperCase();
        String password = prop.getProperty("password").toLowerCase();
        String loginSuccessUrl = prop.getProperty("loginSuccessUrl");
        String invalidPasswordMessageTxt = prop.getProperty("invalidPassword");

        loginSuccessPage.navigateToPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.invalidPasswordMessage(invalidPasswordMessageTxt));
    }

    @Test(priority = 3, groups = {"Smoke"}, description = "User clicks on the 'checkbox 1' .")
    public void checkBox_1Test() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        String checkBoxUrl = prop.getProperty("checkBoxUrl");

        checkBoxesPage.navigateToPage(checkBoxUrl);
        Assert.assertTrue(checkBoxesPage.validateCheckBox_1());
    }

    @Test(priority = 4, groups = {"Smoke"}, description = "User clicks on the 'checkbox 2' .")
    public void checkBox_2Test() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        String checkBoxUrl = prop.getProperty("checkBoxUrl");

        checkBoxesPage.navigateToPage(checkBoxUrl);
        Assert.assertTrue(checkBoxesPage.validateCheckBox_2());
    }

    @Test(priority = 5, groups = {"Smoke"}, description = "User performs right-click and handles javascript alert .")
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
