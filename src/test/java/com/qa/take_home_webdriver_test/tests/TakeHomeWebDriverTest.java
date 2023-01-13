package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.LoginSuccessPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakeHomeWebDriverTest extends BaseTest {

    @Test(priority = 1)
    public void loginSuccessTest() throws InterruptedException {
        Thread.sleep(4000);
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        loginSuccessPage.navigateLoginSuccessPage();
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.successLoginMessage());
    }






    @Test(priority = 5, enabled = false)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Validate Login With Valid Email Wrong Password Credentials Test")
    @Story("Story Name: To Check Login With Valid Email Wrong Password Credentials")
    public void doLoginValidEmailWrongPswCredentialsTest() {
//        YourStorePage yourStorePage = new YourStorePage(driver);
//        Faker faker = new Faker();
//        loginPage = yourStorePage.doNavigateLoginPage();
//        String email = prop.getProperty("email");
//        String password = faker.internet().password();
//        loginPage.loginIncorrectCredentials(email, password);
//        Assert.assertTrue(loginPage.getAlertMessage());
    }
}
