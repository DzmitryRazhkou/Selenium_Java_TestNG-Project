package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User uploads the txt file. ")
    public void fileUploadTest() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        String fileUploadUrl = prop.getProperty("fileUploadUrl");
        String uploadMsg = prop.getProperty("uploadMsg");

        fileUploadPage.navigateToPage(fileUploadUrl);
        fileUploadPage.fileUpload();
        Assert.assertTrue(fileUploadPage.isUploadedMsgDisplayed(uploadMsg));
    }
}
