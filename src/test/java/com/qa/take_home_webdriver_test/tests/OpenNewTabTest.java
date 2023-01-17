package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.OpenNewTabPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewTabTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles opening a new tab. ")
    public void openNewTabTest() {
        OpenNewTabPage openNewTabPage = new OpenNewTabPage(driver);
        String openNewTabUrl = prop.getProperty("openNewTabUrl");
        String pageTitle = prop.getProperty("pageTitle");

        openNewTabPage.navigateToPage(openNewTabUrl);
        openNewTabPage.clickOnTheLink();
        Assert.assertTrue(openNewTabPage.openNewTab(pageTitle));
    }
}
