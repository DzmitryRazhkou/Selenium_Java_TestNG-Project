package com.qa.take_home_webdriver_test.tests;

import com.github.javafaker.Faker;
import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.JavaScriptAlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles JavaScript alerts. ")
    public void javaScriptAlertsTest() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        Faker faker = new Faker();
        String javaScriptAlertsUrl = prop.getProperty("javaScriptAlertsUrl");

        String jsAlertInside = prop.getProperty("jsAlertInsideMsg");
        String jsAlert = prop.getProperty("jsAlert");
        String jsConfirmInside = prop.getProperty("jsConfirmInsideMsg");
        String jsConfirm = prop.getProperty("jsConfirm");
        String JsPromptSendTxt = faker.company().name();
        String jsPromptInsideMsg = prop.getProperty("jsPrompt") + " " + JsPromptSendTxt;

        javaScriptAlertsPage.navigateToPage(javaScriptAlertsUrl);
        javaScriptAlertsPage.clickJSAlert();
        Assert.assertTrue(javaScriptAlertsPage.jsMessage(jsAlertInside) && javaScriptAlertsPage.getAlertMessage(jsAlert));

        javaScriptAlertsPage.clickJSJsConfirm();
        Assert.assertTrue(javaScriptAlertsPage.jsMessage(jsConfirmInside) && javaScriptAlertsPage.getAlertMessage(jsConfirm));

        javaScriptAlertsPage.clickJSPrompt();
        javaScriptAlertsPage.jsPromptSendText(JsPromptSendTxt);
        Assert.assertTrue(javaScriptAlertsPage.getAlertMessage(jsPromptInsideMsg));
    }
}
