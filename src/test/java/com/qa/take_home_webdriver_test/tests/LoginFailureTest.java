package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.LoginSuccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailureTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User with invalid credentials can't log in successfully.")
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

}
