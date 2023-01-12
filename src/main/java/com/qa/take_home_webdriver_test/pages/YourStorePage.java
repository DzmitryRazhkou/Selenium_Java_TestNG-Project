package com.qa.take_home_webdriver_test.pages;

import com.qa.take_home_webdriver_test.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class YourStorePage extends BasePage {
    public YourStorePage(WebDriver driver) {
        super(driver);
    }

    //    Validate Your Store Page Logo:
    private WebElement getLogo() {
        By getLogoLocator = By.cssSelector("img[title='naveenopencart']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getLogoLocator));
        return driver.findElement(getLogoLocator);
    }

    public boolean getLogoValidate() {
        try {
            log.info(" =====> Naveen Automation Labs Logo has been displayed <===== ");
            return getLogo().isDisplayed();
        } catch (TimeoutException y) {
            log.warn(" <=== !!! Please provide a right locator !!! ===> ");
            return false;
        }
    }

    //    Validate Title Page:
    public String getYourStorePageTitle() {
        log.info("User validates the title page. ");
        System.out.println(" =====> My Your Page Title Is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

    //    Currency:
    private WebElement getCurrencyBtn() {
        By currencyLocator = By.cssSelector("button[class='btn btn-link dropdown-toggle']");
        wait.until(ExpectedConditions.elementToBeClickable(currencyLocator));
        return driver.findElement(currencyLocator);
    }

    public void getCurrencyList(String currency) {
        By currencyListLocator = By.cssSelector("ul[class='dropdown-menu'] li");
        wait.until(ExpectedConditions.presenceOfElementLocated(currencyListLocator));

        log.info("User clicks on the currency button. ");
        getCurrencyBtn().click();

        List<WebElement> list = driver.findElements(currencyListLocator);
        for (WebElement s : list) {
            if (s.getText().contains(currency)) {
                log.info("User selects a currency from drop down menu. ");
                s.click();
                break;
            }
        }
    }

    public String getCurrencySign() {
        By currencySignLocator = By.cssSelector("button[class='btn btn-link dropdown-toggle'] strong");
        wait.until(ExpectedConditions.presenceOfElementLocated(currencySignLocator));
        return driver.findElement(currencySignLocator).getText();
    }

    //    Contact Us Button:
    private WebElement getPhoneIcon() {
        By phoneIconLocator = By.cssSelector("i[class='fa fa-phone']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneIconLocator));
        return driver.findElement(phoneIconLocator);
    }


    //    My Account:
    private WebElement getMyAccount() {
        By myAccountLocator = By.cssSelector("a[title='My Account']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myAccountLocator));
        return driver.findElement(myAccountLocator);
    }

    private WebElement getRegisterButton() {
        By registerButtonLocator = By.cssSelector("ul[class='dropdown-menu dropdown-menu-right'] li:first-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(registerButtonLocator));
        return driver.findElement(registerButtonLocator);
    }

    private WebElement getLoginButton() {
        By registerButtonLocator = By.cssSelector("ul[class='dropdown-menu dropdown-menu-right'] li:last-of-type");
        wait.until(ExpectedConditions.presenceOfElementLocated(registerButtonLocator));
        return driver.findElement(registerButtonLocator);
    }

    //    Shopping Cart:
    private WebElement getShoppingCartButton() {
        By shoppingCartButtonLocator = By.cssSelector("ul[class='list-inline'] li:nth-of-type(4)");
        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCartButtonLocator));
        return driver.findElement(shoppingCartButtonLocator);
    }


    //    CheckOut:
    private WebElement getCheckoutButton() {
        By checkoutButtonLocator = By.cssSelector("ul[class='list-inline'] li:nth-of-type(5)");
        wait.until(ExpectedConditions.presenceOfElementLocated(checkoutButtonLocator));
        return driver.findElement(checkoutButtonLocator);
    }


    public LoginPage doNavigateLoginPage() {
        log.info("User clicks on the my account button. ");
        getMyAccount().click();
        log.info("User clicks on the login button. ");
        getLoginButton().click();
        log.info("User navigates on the login page. ");
        return new LoginPage(driver);
    }


    //    Navigation Bars:
    public boolean validateNavigationBars(String type) {
        By validateNavigationBarsLocator = By.cssSelector("ul[class='nav navbar-nav'] li");
        wait.until(ExpectedConditions.presenceOfElementLocated(validateNavigationBarsLocator));

        List<WebElement> barsList = driver.findElements(validateNavigationBarsLocator);
        List<String> barsListText = new ArrayList<>();

        for (WebElement s : barsList) {
            if (s.isDisplayed()) {
                barsListText.add(s.getText());
                if (barsListText.contains(type)) {
                    log.info("Navigation bars contains a type of the product");
                    System.out.println(" =====> " + type + " <===== ");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean featured(String product) {
        By featuredLocator = By.cssSelector("div[class='product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12'] div[class='caption'] h4 a");
        wait.until(ExpectedConditions.presenceOfElementLocated(featuredLocator));

        List<WebElement> featuredList = driver.findElements(featuredLocator);
        List<String> featuredListText = new ArrayList<>();

        for (WebElement s : featuredList) {
            if (s.isDisplayed()) {
                featuredListText.add(s.getText());
                if (featuredListText.contains(product)) {
                    log.info("Navigation bars contains a type of the product");
                    System.out.println(" =====> " + product + " <===== ");
                    return true;
                }
            }
        }
        return false;
    }

    public int adsQuantity() {
        By adsLocator = By.cssSelector("div[class='carousel swiper-viewport'] div div img");
        wait.until(ExpectedConditions.presenceOfElementLocated(adsLocator));
        List<WebElement> listOfAds = driver.findElements(adsLocator);
        int quantity = listOfAds.size();
        System.out.println(" =====> The Quantity of Advertise is " + quantity + " Companies. <===== ");
        return quantity;
    }

    public boolean ads(String brand) {
        By adsLocator = By.cssSelector("div[class='carousel swiper-viewport'] div div img");
        wait.until(ExpectedConditions.presenceOfElementLocated(adsLocator));
        List<WebElement> listOfAds = driver.findElements(adsLocator);
        List<String> listOfAdsText = new ArrayList<>();

        for (WebElement s : listOfAds) {
            if (s.isDisplayed()) {
                listOfAdsText.add(s.getAttribute("alt"));
                if (listOfAdsText.contains(brand)) {
                    log.info("Footer contains the certain brand");
                    System.out.println(" =====> " + brand + " <===== ");
                    return true;
                }
            }
        }
        log.error("Footer doesn't contains this brand");
        System.out.println(" =====> Provide the brand from existing list <===== ");
        return false;
    }

    //    Search Feature:
    private WebElement getSearchField() {
        By searchFieldLocator = By.cssSelector("input[name='search']");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchFieldLocator));
        return driver.findElement(searchFieldLocator);
    }

    private WebElement getSearchBtn() {
        By searchBtnLocator = By.cssSelector("span[class='input-group-btn']");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBtnLocator));
        return driver.findElement(searchBtnLocator);
    }

}




