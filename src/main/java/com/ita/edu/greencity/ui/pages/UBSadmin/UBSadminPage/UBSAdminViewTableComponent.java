package com.ita.edu.greencity.ui.pages.UBSadmin.UBSadminPage;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminViewTableComponentLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ita.edu.greencity.ui.pages.UBSadmin.USBAdminCommon;

import java.util.List;

public class UBSAdminViewTableComponent extends USBAdminCommon {
    private LinkElement checkBoxName;
    private LinkElement clearButton;

    public UBSAdminViewTableComponent(WebDriver driver) {
        super(driver);
    }

    public LinkElement getCheckBoxName() {
        checkBoxName = new LinkElement(driver, UBSAdminViewTableComponentLocator.CHECK_BOX_NAME.getPath());
        return checkBoxName;
    }

    public LinkElement getClearButton() {
        clearButton = new LinkElement(driver, UBSAdminViewTableComponentLocator.CLEAR_BUTTON.getPath());
        return clearButton;
    }

    public UBSAdminViewTableComponent readCheckBoxName() {
        this.checkBoxName.getText();
        return this;
    }

    public UBSAdminViewTableComponent clickClearButton() {
        this.clearButton.click();
        return this;
    }

    public List<String> readAllCheckBoxNames(List<String> list) {
        List<WebElement> names = driver.findElements(UBSAdminViewTableComponentLocator.CHECK_BOX_NAME.getPath());
        for (WebElement name: names) {
            list.add(name.getText());
        }
        return list;
    }

}
