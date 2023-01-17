package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User checks/unchecks checkboxes.")
    public void checkBoxTest() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        String checkBoxUrl = prop.getProperty("checkBoxUrl");

        checkBoxesPage.navigateToPage(checkBoxUrl);
        Assert.assertTrue(checkBoxesPage.clickCheckBox1());
        Assert.assertTrue(checkBoxesPage.clickCheckBox2());
    }

}
