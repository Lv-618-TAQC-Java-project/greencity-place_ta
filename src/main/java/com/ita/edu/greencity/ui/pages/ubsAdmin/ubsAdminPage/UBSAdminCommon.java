package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminCommonLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UBSAdminCommon extends BasePage {
    private UBSAdminTableComponent ubsAdminTableComponent;
    private UBSAdminViewTableComponent ubsAdminViewTableComponent;
    private UBSAdminRowTableComponentLocator ubsAdminRowTableComponentLocator;

    private WebElement searchField;
    private WebElement searchIcon;
    private WebElement viewTable;

    public UBSAdminCommon(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchField() {
        searchField = driver.findElement(UBSAdminCommonLocator.SEARCH_FIELD.getPath());
        return searchField;
    }

    public WebElement getSearchIcon() {
        searchIcon = driver.findElement(UBSAdminCommonLocator.SEARCH_ICON.getPath());
        return searchIcon;
    }

    public WebElement getViewTable() {
        viewTable = driver.findElement(UBSAdminCommonLocator.VIEW_TABLE_BUTTON.getPath());
        return viewTable;
    }

    public UBSAdminCommon clearSearchField() {
        getSearchField().clear();
        return this;
    }

    public UBSAdminTableComponent getUbsAdminTableComponent() {
        return new UBSAdminTableComponent(driver);
    }

    public UBSAdminCommon setSearchField(String s) {
        tableIsLoaded();
        getSearchField().sendKeys(s);
        return this;
    }

    public UBSAdminViewTableComponent clickViewTable() {
        tableIsLoaded();
        getViewTable().click();
        return new UBSAdminViewTableComponent(driver);
    }

    public UBSAdminTableComponent tableIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UBSAdminTableComponentLocator.TABLE.getPath()));
        return new UBSAdminTableComponent(driver);
    }

}
