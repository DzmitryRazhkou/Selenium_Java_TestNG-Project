package com.qa.take_home_webdriver_test.tests;

import com.qa.take_home_webdriver_test.basetest.BaseTest;
import com.qa.take_home_webdriver_test.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {


    @Test(priority = 1, groups = {"Smoke"}, description = "User does drag and drop boxes .")
    public void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        String dragAndDropUrl = prop.getProperty("dragAndDropUrl");
        String boxA_Txt = prop.getProperty("boxA_Txt");
        String boxB_Txt = prop.getProperty("boxB_Txt");

        dragAndDropPage.navigateToPage(dragAndDropUrl);
        dragAndDropPage.doDragAndDrop();
        Assert.assertTrue(dragAndDropPage.validateDragAndDrop(boxA_Txt, boxB_Txt));
    }
}
