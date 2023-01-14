package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {

    // PAGE INITIALIZATION:
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By DROP_DOWN = By.id("dropdown");

    // WEB ELEMENTS:
    private WebElement getDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(DROP_DOWN));
        return driver.findElement(DROP_DOWN);
    }


    // METHODS:
    public String doDropDownSelect1(String value1) {
        Select dropDown = new Select(getDropDown());
        log.info("User selects the first option from drop down. ");
        dropDown.selectByValue(value1);
        dropDown.getOptions();

        return dropDown.getFirstSelectedOption().getText();
    }

    public String doDropDownSelect2(String value2) {
        Select dropDown = new Select(getDropDown());
        log.info("User selects the second option from drop down. ");
        dropDown.selectByValue(value2);
        dropDown.getOptions();

        return dropDown.getFirstSelectedOption().getText();
    }
}


