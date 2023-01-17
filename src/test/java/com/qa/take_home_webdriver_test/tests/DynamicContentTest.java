package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.DynamicContentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicContentTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles dynamic content. ")
    public void dynamicContentTest() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        String dynamicContentUrl = prop.getProperty("dynamicContentUrl");
        dynamicContentPage.navigateToPage(dynamicContentUrl);

        List<String> imageListBeforeRefreshPage = dynamicContentPage.imagesList();
        List<String> contentListBeforeRefreshPage = dynamicContentPage.contentList();
        dynamicContentPage.refreshPage();

        List<String> imageListAfterRefreshPage = dynamicContentPage.imagesList();
        List<String> contentListAfterRefreshPage = dynamicContentPage.contentList();

        Assert.assertNotEquals(imageListBeforeRefreshPage, imageListAfterRefreshPage);
        Assert.assertNotEquals(contentListBeforeRefreshPage, contentListAfterRefreshPage);
    }
}
