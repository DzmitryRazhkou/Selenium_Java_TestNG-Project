package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles dynamic loading page .")
    public void dynamicLoadingTest() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        String dynamicLoadingUrl = prop.getProperty("dynamicLoadingUrl");
        String helloHeaderTxt = prop.getProperty("helloHeaderTxt");

        dynamicLoadingPage.navigateToPage(dynamicLoadingUrl);
        dynamicLoadingPage.doClickStartBtn();
        Assert.assertTrue(dynamicLoadingPage.isHelloHeaderDisplayed(helloHeaderTxt));
    }
}
