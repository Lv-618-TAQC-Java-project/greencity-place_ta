package pages.UBSadmin.UBSadminPage;

import elements.LinkElement;
import locators.UbsAdminLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UBSadmin.USBAdminCommon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UbsAdminPage extends USBAdminCommon {
    public WebDriverWait wait;
    private LinkElement searchField;
    private LinkElement searchIcon;
    private LinkElement viewTable;
    private LinkElement viewTableCheckBoxName;


    private LinkElement addressField;

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

    public LinkElement getAddressField() {
        if (addressField == null)
            addressField = new LinkElement(driver, UbsAdminLocators.ADDRESS_1485_ORDER.getPath());
        return addressField;
    }

    public LinkElement getViewTable() {
        if (viewTable == null)
            viewTable = new LinkElement(driver, UbsAdminLocators.VIEW_TABLE_BUTTON.getPath());
        return viewTable;
    }

    public LinkElement getViewTableCheckBoxName() {
        if (viewTableCheckBoxName == null)
            viewTableCheckBoxName = new LinkElement(driver, UbsAdminLocators.VIEW_TABLE_CHECKBOX_NAME.getPath());
        return viewTableCheckBoxName;
    }

    public List<String> getTextFromViewTableCheckBoxName(List<String> actual) {
        List<WebElement> get = driver.findElements(By.xpath("//li[@class='ng-star-inserted']"));
        for (WebElement v: get) {
            actual.add(v.getText());
        }
        return actual;
    }

//    public String getTextFromViewTableCheckBoxName(String actual) {
//        actual = this.getViewTableCheckBoxName().getText();
//        return actual;
//    }

    public UbsAdminPage clickViewTable() {
        this.getViewTable().click();
        return this;
    }

    public UbsAdminPage clickSearchIcon() {
        this.getSearchIcon().click();
        return this;
    }

    /**
     * This method is specifically for the test TQ-221.
     */
    public String getAddressOrderId1485() {
        return this.getAddressField().getText();
    }

    public UbsAdminPage waitUntilViewTableIsLoaded() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(UbsAdminLocators.VIEW_TABLE_CHECKBOX_NAME.getPath()));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public UbsAdminPage waitUntilTableIsLoaded() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UbsAdminLocators.TABLE.getPath()));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
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
