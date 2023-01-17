package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.JavaScriptErrorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptErrorTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles JavaScript error. ")
    public void javaScriptErrorTest() {
        JavaScriptErrorPage javaScriptErrorPage = new JavaScriptErrorPage(driver);
        String javaScriptErrorUrl = prop.getProperty("javaScriptErrorUrl");
        String errorMsg = prop.getProperty("errorMsg");

        javaScriptErrorPage.navigateToPage(javaScriptErrorUrl);
        Assert.assertTrue(javaScriptErrorPage.checkForErrorInLogs(errorMsg));
    }
}
