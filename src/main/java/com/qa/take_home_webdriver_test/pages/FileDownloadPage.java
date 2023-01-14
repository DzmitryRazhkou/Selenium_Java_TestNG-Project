package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import com.qa.take_home_webdriver_test.constants.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class FileDownloadPage extends BasePage {

    // PAGE INITIALIZATION:
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By FILE_LINK = By.cssSelector("a[href='download/some-file.txt']");

    // WEB ELEMENTS:
    private WebElement getFileLink() {
        wait.until(ExpectedConditions.elementToBeClickable(FILE_LINK));
        return driver.findElement(FILE_LINK);
    }

    // METHODS:
    public void fileDownload() throws InterruptedException {
        log.info("User clicks on the file link for downloading file. ");
        getFileLink().click();
        log.info("User is waiting for while file download. ");
        Thread.sleep(2000); // We can create a custom waiter here, but for saving time purpose we will leave like that
    }

    //    We could to do the same with Chrome Options, but it is more simple solution:
    public boolean isFileDownloaded(String fileName) {
        File downloadPath = new File(Paths.DOWNLOAD_PATH);
        File[] list = downloadPath.listFiles();
        assert list != null;
        for (File s : list) {
            if (s.getName().contains(fileName)) {
                System.out.println(" =====> The downloaded file name is " + fileName + " <===== ");
                return true;
            }
        }
        return false;
    }

}


