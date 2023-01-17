package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles dynamic controls. ")
    public void dynamicControlsTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        String dynamicControlsUrl = prop.getProperty("dynamicControlsUrl");
        String removeMsg = prop.getProperty("removeMsg");
        String addMsg = prop.getProperty("addMsg");
        String enabled = prop.getProperty("enabled");
        String disabled = prop.getProperty("disabled");

        dynamicControlsPage.navigateToPage(dynamicControlsUrl);
        dynamicControlsPage.doClickCheckBox();
        dynamicControlsPage.doRemoveAddCheckBox();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(removeMsg));

        dynamicControlsPage.doRemoveAddCheckBox();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(addMsg));

        dynamicControlsPage.doClickOnEnableDisable();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(enabled));

        dynamicControlsPage.doClickOnEnableDisable();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(disabled));
    }
}
