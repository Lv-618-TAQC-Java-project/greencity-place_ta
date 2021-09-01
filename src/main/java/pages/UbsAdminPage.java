package pages;

import elements.LinkElement;
import locators.LoginLocators;
import locators.UbsAdminLocators;
import org.openqa.selenium.WebDriver;

public class UbsAdminPage {
    public WebDriver driver;
    private LinkElement searchField;

    public UbsAdminPage(WebDriver driver) {this.driver = driver;}

    public LinkElement getSearchField() {
        if (searchField == null)
            searchField = new LinkElement(driver, UbsAdminLocators.SEARCH_FIELD.getPath());
        return searchField;
    }
    public UbsAdminPage clickSearchField(){
        this.getSearchField().click();
        return this;
    }
    public UbsAdminPage setSearchField(String text){
        this.getSearchField().sendKeys(text);
        return this;
    }
    public String getSearchFieldAttribute(String attribute){
        return getSearchField().getAttribute(attribute);
    }





}
