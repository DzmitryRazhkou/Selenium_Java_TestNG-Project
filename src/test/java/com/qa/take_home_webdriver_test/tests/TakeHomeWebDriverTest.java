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

    @Test(priority = 9, groups = {"Smoke"}, description = "User handles dynamic controls .")
    public void dynamicControlsTest() {
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
        String dynamicControlsUrl = prop.getProperty("dynamicControlsUrl");
        String removeMsg = prop.getProperty("removeMsg");
        String addMsg = prop.getProperty("addMsg");
        String enabled = prop.getProperty("enabled");
        String disabled = prop.getProperty("disabled");

        dynamicControlsPage.navigateToPage(dynamicControlsUrl);
        dynamicControlsPage.doClickCheckBox();
        dynamicControlsPage.doRemoveAddCheckBox();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(removeMsg));

        dynamicControlsPage.doRemoveAddCheckBox();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(addMsg));

        dynamicControlsPage.doClickOnEnableDisable();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(enabled));

        dynamicControlsPage.doClickOnEnableDisable();
        Assert.assertTrue(dynamicControlsPage.isMessageDisplayed(disabled));
    }

    @Test(priority = 10, groups = {"Smoke"}, description = "User handles dynamic loading page .")
    public void dynamicLoadingTest() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        String dynamicLoadingUrl = prop.getProperty("dynamicLoadingUrl");
        String helloHeaderTxt = prop.getProperty("helloHeaderTxt");

        dynamicLoadingPage.navigateToPage(dynamicLoadingUrl);
        dynamicLoadingPage.doClickStartBtn();
        Assert.assertTrue(dynamicLoadingPage.isHelloHeaderDisplayed(helloHeaderTxt));
    }

    @Test(priority = 11, groups = {"Smoke"}, description = "User download txt file. ")
    public void fileDownloadTest() throws InterruptedException {
        FileDownloadPage fileDownloadPage = new FileDownloadPage(driver);
        String fileDownloadUrl = prop.getProperty("fileDownloadUrl");
        String fileName = prop.getProperty("fileName");

        fileDownloadPage.navigateToPage(fileDownloadUrl);
        fileDownloadPage.fileDownload();
        Assert.assertTrue(fileDownloadPage.isFileDownloaded(fileName));
    }

    @Test(priority = 12, groups = {"Smoke"}, description = "User upload txt file. ")
    public void fileUploadTest() {
        FileUploadPage fileUploadPage = new FileUploadPage(driver);
        String fileUploadUrl = prop.getProperty("fileUploadUrl");
        String uploadMsg = prop.getProperty("uploadMsg");

        fileUploadPage.navigateToPage(fileUploadUrl);
        fileUploadPage.fileUpload();
        Assert.assertTrue(fileUploadPage.isUploadedMsgDisplayed(uploadMsg));
    }

    @Test(priority = 13, groups = {"Smoke"}, description = "User handles floating menu. ")
    public void floatingMenuTest() {
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        String floatingMenuUrl = prop.getProperty("floatingMenuUrl");

        floatingMenuPage.navigateToPage(floatingMenuUrl);
        floatingMenuPage.scrollDownPage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());

        floatingMenuPage.scrollUpPage();
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed());
    }
}
