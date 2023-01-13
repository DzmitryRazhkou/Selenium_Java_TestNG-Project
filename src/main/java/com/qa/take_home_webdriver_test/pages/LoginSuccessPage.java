package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSuccessPage extends BasePage {

    // LOGIN SUCCESS URL:
    private static final String LOGIN_SUCCESS_URL = prop.getProperty("loginSuccessUrl");

    // LOCATORS FOR WEB ELEMENTS:
    private static final By USERNAME_FIELD = By.id(prop.getProperty("userNameLocator"));
    private static final By PASSWORD_FIELD = By.id(prop.getProperty("passwordLocator"));
    private static final By LOGIN_BTN = By.className(prop.getProperty("loginBtnLocator"));
    private static final By SUCCESS_LOGIN_MESSAGE = By.id(prop.getProperty("successLoginMsgLocator"));

    // PAGE INITIALIZATION:
    public LoginSuccessPage(WebDriver driver) {
        super(driver);
    }

    // WEB ELEMENTS:
    private WebElement getUserNameField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(USERNAME_FIELD));
        return driver.findElement(USERNAME_FIELD);
    }

    private WebElement getPasswordField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(PASSWORD_FIELD));
        return driver.findElement(PASSWORD_FIELD);
    }

    private WebElement getLoginBtn() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SUCCESS_LOGIN_MESSAGE));
        return driver.findElement(SUCCESS_LOGIN_MESSAGE);
    }

    private WebElement getSuccessLoginMsg() {
        wait.until(ExpectedConditions.presenceOfElementLocated(LOGIN_BTN));
        return driver.findElement(LOGIN_BTN);
    }

    // METHODS:
    public void navigateLoginSuccessPage() {
        log.info("User navigates on the 'LoginSuccess' page. ");
        driver.navigate().to(LOGIN_SUCCESS_URL);
    }

    public void loginSuccess(String userName, String psw) {
        log.info("User types an username into username field. ");
        getUserNameField().sendKeys(userName);
        log.info("User types an password into password field. ");
        getPasswordField().sendKeys(psw);
        log.info("User clicks on the 'Login' button. ");
        getLoginBtn().click();
    }

    public boolean successLoginMessage() {
        try {
            log.info("User sees an success login message. ");
            System.out.println(" =====> " + getSuccessLoginMsg().getText() + " <===== ");
            return getSuccessLoginMsg().isDisplayed();
        } catch (TimeoutException y) {
            log.warn("Please provide another locator. ");
            return false;
        }
    }
}

