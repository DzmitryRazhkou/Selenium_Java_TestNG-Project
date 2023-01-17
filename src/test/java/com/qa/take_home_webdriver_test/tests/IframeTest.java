package com.qa.take_home_webdriver_test.tests;

import com.github.javafaker.Faker;
import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.IframePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles iframe web element. ")
    public void iframeTest() {
        IframePage iframePage = new IframePage(driver);
        Faker faker = new Faker();
        String iFrameUrl = prop.getProperty("iFrameUrl");
        String existingTxt = prop.getProperty("existingTxt");
        String proposalTxt = faker.country().name();

        iframePage.navigateToPage(iFrameUrl);
        iframePage.closeAlert();
        iframePage.switchToFrame();
        iframePage.sendTxt(existingTxt, proposalTxt);
        Assert.assertEquals(iframePage.getInputBoxTxt(), proposalTxt);
    }
}
