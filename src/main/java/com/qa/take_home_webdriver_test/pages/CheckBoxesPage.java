package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxesPage extends BasePage {

    // PAGE INITIALIZATION:
    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By CHECKBOX_1 = By.cssSelector("input[type='checkbox']:first-of-type");
    private static final By CHECKBOX_2 = By.cssSelector("input[type='checkbox']:last-of-type");


    // WEB ELEMENTS:
    private WebElement getCheckBox_1() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_1));
        return driver.findElement(CHECKBOX_1);
    }

    private WebElement getCheckBox_2() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_2));
        return driver.findElement(CHECKBOX_2);
    }

    // METHODS:
    public boolean validateCheckBox_1() {
        try {
            if (!getCheckBox_1().isSelected() && getCheckBox_1().isDisplayed()) {
                log.info("User clicks on the 'checkbox 1'");
                getCheckBox_1().click();
            } else {
                log.info("User undoes click on the 'checkbox 1'");
                getCheckBox_1().click();
            }
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
        return getCheckBox_1().isSelected() || !getCheckBox_1().isSelected();
    }

    public boolean validateCheckBox_2() {
        try {
            if (!getCheckBox_2().isSelected() && getCheckBox_2().isDisplayed()) {
                log.info("User clicks on the 'checkbox 2'");
                getCheckBox_2().click();
            } else {
                log.info("User undoes click on the 'checkbox 2'");
                getCheckBox_2().click();
            }
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
        return getCheckBox_2().isSelected() || !getCheckBox_2().isSelected();
    }

}


