package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.UBSAdminCommonLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UBSAdminCommon extends BasePage {
    private USBAdminTableComponent usbAdminTableComponent;
    private UBSAdminViewTableComponent ubsAdminViewTableComponent;
    private UBSAdminRowTableComponentLocator ubsAdminRowTableComponentLocator;

    private WebElement searchField;
    private WebElement searchIcon;
    private WebElement viewTable;

    public UBSAdminCommon(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchField() {
        return driver.findElement(UBSAdminCommonLocator.SEARCH_FIELD.getPath());
    }

    public WebElement getSearchIcon() {
        return driver.findElement(UBSAdminCommonLocator.SEARCH_ICON.getPath());
    }

    public WebElement getViewTable() {
        return driver.findElement(UBSAdminCommonLocator.VIEW_TABLE_BUTTON.getPath());
    }

    public UBSAdminCommon clearSearchField() {
        getSearchField().clear();
        return this;
    }

    public USBAdminRowTableComponent setSearchField(String s) {
        tableIsLoaded();
        getSearchField().sendKeys(s);
        return new USBAdminRowTableComponent(driver);
    }

    public UBSAdminViewTableComponent clickViewTable() {
        tableIsLoaded();
        getViewTable().click();
        return new UBSAdminViewTableComponent(driver);
    }

    public USBAdminTableComponent tableIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UBSAdminTableComponentLocator.TABLE.getPath()));
        return new USBAdminTableComponent(driver);
    }

}
