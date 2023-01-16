package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MouseHoverPage extends BasePage {

    // PAGE INITIALIZATION:
    public MouseHoverPage(WebDriver driver) {
        super(driver);
    }

    // LOCATORS FOR WEB ELEMENTS:
    private static final By USERS = By.xpath("(//div[@class='figure'])");
    private static final By USERS_TXT = By.xpath("(//div[@class='figcaption'])");

    // WEB ELEMENTS:

    // METHODS:
    public boolean areCaptionsDisplayed() {
        List<WebElement> figures = driver.findElements(USERS);
        Actions act = new Actions(driver);
        boolean displayed = true;
        //Mouse over in every element
        //if at least one caption is not displayed, the function will return false
        for (int i = 1; i <= figures.size(); i++) {
            WebElement fig = driver.findElement(By.xpath(USERS + "[" + i + "]"));
            act.moveToElement(fig);
            WebElement figCap = driver.findElement(By.xpath(USERS_TXT + "[" + i + "]"));
            if (figCap.isDisplayed() && displayed) {
                displayed = figCap.isDisplayed();
            }
        }
        return displayed;
    }

    public void f(){
        List<WebElement> figures = driver.findElements(USERS);
        for (int i = 1; i <= figures.size(); i++) {
            System.out.println(figures.size());
            }
        }
}



