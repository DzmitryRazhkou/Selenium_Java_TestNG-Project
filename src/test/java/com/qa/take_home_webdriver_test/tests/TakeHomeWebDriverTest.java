package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TakeHomeWebDriverTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, description = "User with valid credentials can log in successfully.")
    public void loginSuccessTest() {
        String userName = prop.getProperty("userName");
        String password = prop.getProperty("password");
        String loginSuccessUrl = prop.getProperty("loginSuccessUrl");
        String successLoginMessageTxt = prop.getProperty("successLoginMsg");

        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        loginSuccessPage.navigateToPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.successLoginMessage(successLoginMessageTxt));
    }

    @Test(priority = 2, groups = {"Smoke"}, description = "User with invalid credentials can't log in successfully.")
    public void loginFailureTest() {
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        String userName = prop.getProperty("userName").toUpperCase();
        String password = prop.getProperty("password").toLowerCase();
        String loginSuccessUrl = prop.getProperty("loginSuccessUrl");
        String invalidPasswordMessageTxt = prop.getProperty("invalidPassword");

        loginSuccessPage.navigateToPage(loginSuccessUrl);
        loginSuccessPage.loginSuccess(userName, password);
        Assert.assertTrue(loginSuccessPage.invalidPasswordMessage(invalidPasswordMessageTxt));
    }

    @Test(priority = 3, groups = {"Smoke"}, description = "User clicks on the 'checkbox 1' .")
    public void checkBox_1Test() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        String checkBoxUrl = prop.getProperty("checkBoxUrl");

        checkBoxesPage.navigateToPage(checkBoxUrl);
        Assert.assertTrue(checkBoxesPage.validateCheckBox_1());
    }

    @Test(priority = 4, groups = {"Smoke"}, description = "User clicks on the 'checkbox 2' .")
    public void checkBox_2Test() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        String checkBoxUrl = prop.getProperty("checkBoxUrl");

        checkBoxesPage.navigateToPage(checkBoxUrl);
        Assert.assertTrue(checkBoxesPage.validateCheckBox_2());
    }

    @Test(priority = 5, groups = {"Smoke"}, description = "User performs right-click and handles javascript alert .")
    public void contextMenuTest() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        String contextMenuUrl = prop.getProperty("contextMenuUrl");

        contextMenuPage.navigateToPage(contextMenuUrl);
        contextMenuPage.performRightClick();
        String expAlertJSMessage = prop.getProperty("alertJSMessage");
        String actAlertJSMessage = contextMenuPage.handleJSAlert();
        Assert.assertEquals(expAlertJSMessage, actAlertJSMessage);

    }

    @Test(priority = 6, groups = {"Smoke"}, description = "User does drag and drop boxes .")
    public void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        String dragAndDropUrl = prop.getProperty("dragAndDropUrl");
        String boxA_Txt = prop.getProperty("boxA_Txt");
        String boxB_Txt = prop.getProperty("boxB_Txt");

        dragAndDropPage.navigateToPage(dragAndDropUrl);
        dragAndDropPage.doDragAndDrop();
        Assert.assertTrue(dragAndDropPage.validateDragAndDrop(boxA_Txt, boxB_Txt));
    }

    @Test(priority = 7, groups = {"Smoke"}, description = "User selects options from drop down menu .")
    public void dropDownTest() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        String dropDownUrl = prop.getProperty("dropDownUrl");
        String value1 = prop.getProperty("value1");
        String option1 = prop.getProperty("option1");
        String value2 = prop.getProperty("value2");
        String option2 = prop.getProperty("option2");

        dropDownPage.navigateToPage(dropDownUrl);
        String selectOption1 = dropDownPage.doDropDownSelect1(value1);
        Assert.assertEquals(selectOption1, option1);

        String selectOption2 = dropDownPage.doDropDownSelect2(value2);
        Assert.assertEquals(selectOption2, option2);
    }

    @Test(priority = 8, groups = {"Smoke"}, description = "User handles dynamic content .")
    public void dynamicContentTest() {
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);
        String dynamicContentUrl = prop.getProperty("dynamicContentUrl");
        dynamicContentPage.navigateToPage(dynamicContentUrl);

        List<String> imageListBeforeRefreshPage = dynamicContentPage.imagesList();
        List<String> contentListBeforeRefreshPage = dynamicContentPage.contentList();
        dynamicContentPage.refreshPage();

        List<String> imageListAfterRefreshPage = dynamicContentPage.imagesList();
        List<String> contentListAfterRefreshPage = dynamicContentPage.contentList();

        Assert.assertNotEquals(imageListBeforeRefreshPage, imageListAfterRefreshPage);
        Assert.assertNotEquals(contentListBeforeRefreshPage, contentListAfterRefreshPage);
    }
}
