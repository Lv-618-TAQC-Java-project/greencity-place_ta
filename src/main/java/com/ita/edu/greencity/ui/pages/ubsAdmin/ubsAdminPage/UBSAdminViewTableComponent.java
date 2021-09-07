package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminViewTableComponentLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class UBSAdminViewTableComponent extends UBSAdminCommon {
    private WebElement checkBoxName;
    private WebElement clearButton;

    public UBSAdminViewTableComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getCheckBoxName() {
        return driver.findElement(UBSAdminViewTableComponentLocator.CHECK_BOX_NAME.getPath());
    }

    public WebElement getClearButton() {
        return driver.findElement(UBSAdminViewTableComponentLocator.CLEAR_BUTTON.getPath());
    }

    public UBSAdminViewTableComponent readCheckBoxName() {
        this.checkBoxName.getText();
        return this;
    }

    public List<String> readAllCheckBoxNames(List<String> result) {
        List<WebElement> list = driver.findElements(UBSAdminViewTableComponentLocator.CHECK_BOX_NAME.getPath());
        for (WebElement element: list) {
            result.add(element.getText());
        }
        return result;
    }

    public UBSAdminViewTableComponent clickClearButton() {
        this.clearButton.click();
        return this;
    }


}
