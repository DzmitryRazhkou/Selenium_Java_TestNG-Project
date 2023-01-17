package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.FloatingMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FloatingMenuTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles floating menu. ")
    public void floatingMenuTest() {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        String floatingMenuUrl = prop.getProperty("floatingMenuUrl");

        floatingMenuPage.navigateToPage(floatingMenuUrl);
        floatingMenuPage.scrollDownPage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());

        floatingMenuPage.scrollUpPage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
    }
}
