package com.ita.edu.greencity.ui.pages.UBSadmin.UBSadminPage;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.UbsAdminLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ita.edu.greencity.ui.pages.UBSadmin.USBAdminCommon;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UbsAdminPage extends USBAdminCommon {
    private LinkElement searchField;
    private LinkElement searchIcon;
    private LinkElement viewTable;

    public UbsAdminPage(WebDriver driver) {
        super(driver);
    }

    public LinkElement getSearchField() {
        if (searchField == null)
            searchField = new LinkElement(driver, UbsAdminLocators.SEARCH_FIELD.getPath());
        return searchField;
    }

    public UbsAdminPage setSearchField(String text) {
        this.getSearchField().sendKeys(text);
        return this;
    }

    public LinkElement getSearchIcon() {
        if (searchIcon == null)
            searchIcon = new LinkElement(driver, UbsAdminLocators.SEARCH_ICON.getPath());
        return searchIcon;
    }

    public UbsAdminPage clickSearchIcon() {
        this.getSearchIcon().click();
        return this;
    }

    public LinkElement getViewTable() {
        if (viewTable == null)
            viewTable = new LinkElement(driver, UbsAdminLocators.VIEW_TABLE_BUTTON.getPath());
        return viewTable;
    }

    public UbsAdminPage tableIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(UbsAdminLocators.TABLE.getPath()));
        return this;
    }

    public UBSAdminViewTableComponent clickViewTable() {
        tableIsLoaded();
        this.getViewTable().click();
        return new UBSAdminViewTableComponent(driver);
    }


    public UbsAdminPage clearSearchField() {
        this.getSearchField().clear();
        return this;
    }


    public UbsAdminPage clickSearchField() {
        this.getSearchField().click();
        return this;
    }


    public String getSearchFieldAttribute(String attribute) {
        return getSearchField().getAttribute(attribute);
    }


}
