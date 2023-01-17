package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.DropDownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User selects options from drop down menu .")
    public void dropDownTest() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        String dropDownUrl = prop.getProperty("dropDownUrl");
        String option1 = prop.getProperty("option1");
        String option2 = prop.getProperty("option2");

        dropDownPage.navigateToPage(dropDownUrl);
        dropDownPage.doDropDownSelect(option1);
        Assert.assertTrue(dropDownPage.getDropDownSelectedTxt(option1));

        dropDownPage.doDropDownSelect(option2);
        Assert.assertTrue(dropDownPage.getDropDownSelectedTxt(option2));
    }
}
