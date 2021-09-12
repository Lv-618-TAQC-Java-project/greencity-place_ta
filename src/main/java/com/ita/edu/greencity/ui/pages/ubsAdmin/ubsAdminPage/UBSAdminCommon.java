package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.tools.WaitHelper;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminCommonLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.UBSAdminMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UBSAdminCommon extends BasePage {

    private WaitHelper waitHelper;
    private UBSAdminTableComponent ubsAdminTableComponent;
    private UBSAdminViewTableComponent ubsAdminViewTableComponent;
    private UBSAdminRowTableComponentLocator ubsAdminRowTableComponentLocator;

    private WebElement searchField;
    private WebElement searchIcon;
    private WebElement viewTable;
    private WebElement displayCounterDropdown;
    private WebElement displayCounter10;
    private WebElement displayCounter15;
    private WebElement displayCounter20;

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

    public WebElement getDisplayCounterDropdown() {
        displayCounterDropdown = driver.findElement(UBSAdminCommonLocator.DISPLAY_COUNTER_DROPDOWN.getPath());
        return displayCounterDropdown;
    }
    public WebElement getDisplayCounter10() {
        displayCounter10 = driver.findElement(UBSAdminCommonLocator.DISPLAY_COUNTER_10.getPath());
        return displayCounterDropdown;
    }
    public WebElement getDisplayCounter15() {
        displayCounter15 = driver.findElement(UBSAdminCommonLocator.DISPLAY_COUNTER_15.getPath());
        return displayCounterDropdown;
    }
    public WebElement getDisplayCounter20() {
        displayCounter20 = driver.findElement(UBSAdminCommonLocator.DISPLAY_COUNTER_20.getPath());
        return displayCounterDropdown;
    }
    public WebElement getSortOrderNumberButton(){
        return driver.findElement(UBSAdminCommonLocator.SORT_ORDER_NUMBER_BUTTON.getPath());
    }

    public WebElement getSortDistrictButton(){
        return driver.findElement(UBSAdminCommonLocator.SORT_DISTRICT_BUTTON.getPath());
    }

    public UBSAdminCommon clearSearchField() {
        getSearchField().clear();
        return this;
    }

    public UBSAdminTableComponent getUbsAdminTableComponent() {
        return new UBSAdminTableComponent(driver);
    }

    public UBSAdminRowTableComponent getTableRow() {
        tableIsLoaded();
        return new UBSAdminRowTableComponent(driver, driver.findElement(UBSAdminTableComponentLocator.ROW.getPath()));
    }

    public UBSAdminMenuComponent getAdminMenu() {
        return new UBSAdminMenuComponent(driver);
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

    public void tableIsLoaded() {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForVisibilityOfElementLocated(UBSAdminTableComponentLocator.TABLE.getPath());
    }

    public UBSAdminCommon clickDisplayCounterDropdown() {
        getDisplayCounterDropdown().click();
        return this;
    }

    public UBSAdminCommon clickDisplayCounter10() {
        getDisplayCounter10().click();
        tableIsLoaded();
        return this;
    }

    public UBSAdminCommon clickDisplayCounter15() {
        getDisplayCounter15().click();
        tableIsLoaded();
        return this;
    }

    public UBSAdminCommon clickDisplayCounter20() {
        getDisplayCounter20().click();
        tableIsLoaded();
        return this;
    }

    public UBSAdminCommon clickSortDistrictButton(){
        getSortDistrictButton().click();
        tableIsLoaded();
        return this;
    }


    public UBSAdminCommon clickSortOrderNumberButton(){
        getSortOrderNumberButton().click();
        tableIsLoaded();
        return this;
    }

}
