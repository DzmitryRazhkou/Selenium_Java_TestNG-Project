package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.NotificationMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User handles notification messages. ")
    public void notificationMessageTest() {
        NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
        String notificationMessageUrl = prop.getProperty("notificationMessageUrl");
        String msg1 = prop.getProperty("msg1");
        String msg2 = prop.getProperty("msg2");
        String msg3 = prop.getProperty("msg3");
        String[] messagesList = {msg1, msg2, msg3};
        int times = Integer.parseInt(prop.getProperty("times"));

        notificationMessagePage.navigateToPage(notificationMessageUrl);
        notificationMessagePage.clickOnTheLink();
        Assert.assertTrue(notificationMessagePage.someMsgDisplayed(messagesList, times));
    }
}
