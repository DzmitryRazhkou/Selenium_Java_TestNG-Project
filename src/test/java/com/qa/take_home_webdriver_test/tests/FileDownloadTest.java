package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User downloads the txt file. ")
    public void fileDownloadTest() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        String fileDownloadUrl = prop.getProperty("fileDownloadUrl");
        String fileName = prop.getProperty("fileName");

        fileDownloadPage.navigateToPage(fileDownloadUrl);
        fileDownloadPage.fileDownload(fileName);
        Assert.assertTrue(fileDownloadPage.isFileDownloaded(fileName));
    }
}
