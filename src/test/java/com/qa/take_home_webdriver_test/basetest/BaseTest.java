package com.qa.take_home_webdriver_test.basetest;

import com.qa.take_home_webdriver_test.constants.Paths;
import com.qa.take_home_webdriver_test.utils.BrowserFactory;
import com.qa.take_home_webdriver_test.utils.ConfigReader;
import com.qa.take_home_webdriver_test.utils.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Properties;

@Listeners(com.qa.take_home_webdriver_test.listeners.Listeners.class)
public class BaseTest {
    protected WebDriver driver;
    protected static Properties prop;

    @BeforeSuite
    public void readProperties() {
        System.out.println(" =====> Read Properties Configuration File <===== ");
        prop = ConfigReader.initiateProperties();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browser) {
        System.out.println(" =====> The " + browser + " has been opened <===== ");
        BrowserFactory.setDriver(browser, Boolean.parseBoolean(prop.getProperty("HEADLESS")));
        driver = BrowserFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Paths.PAGE_LOAD_TIMEOUT));
        driver.get(prop.getProperty("base_url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        System.out.println(" =====> Bye Bye ... <===== ");
        if (result.FAILURE == result.getStatus()) {
            ScreenShot.takeScreenshot(driver, result.getMethod().getMethodName());
        }
        if (driver != null) {
            driver.quit();
            BrowserFactory.removeDriver();
        }
    }
}
