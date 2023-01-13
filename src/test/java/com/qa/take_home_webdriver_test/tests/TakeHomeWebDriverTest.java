package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
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
        loginSuccessPage.navigateLoginSuccessPage(loginSuccessUrl);
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

        loginSuccessPage.navigateLoginSuccessPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.invalidPasswordMessage(invalidPasswordMessageTxt));
    }

}
