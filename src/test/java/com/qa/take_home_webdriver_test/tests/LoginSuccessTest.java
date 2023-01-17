package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSuccessTest extends BaseTest {

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
}
