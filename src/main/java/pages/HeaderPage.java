package pages;

import elements.LinkElement;
import locators.HeaderLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.UBSadmin.UBSadminPage.UbsAdminPage;

public class HeaderPage extends BasePageObject{
    private LinkElement ecoNews;
    private LinkElement tipsAndTricks;
    private LinkElement places;
    private LinkElement aboutUs;
    private LinkElement mySpace;
    private LinkElement ubsCourier;
    private LinkElement signInButton;
    private LinkElement homeButton;
    private LinkElement languageButton;
    private LinkElement userButton;
    private LinkElement ubsAdminButton;


    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public LinkElement getSignInButton() {
        if (signInButton == null)
            signInButton = new LinkElement(driver, HeaderLocator.SIGN_IN_BUTTON.getPath());
        return signInButton;
    }

    public LinkElement getUserButton(){
        if(userButton == null)
            userButton = new LinkElement(driver, HeaderLocator.USER_BUTTON.getPath());
        return userButton;
    }
    public LinkElement getUbsAdminButton(){
        if(ubsAdminButton == null)
            ubsAdminButton = new LinkElement(driver, HeaderLocator.UBS_ADMIN_BUTTON.getPath());
        return ubsAdminButton;
    }

    public LoginPage clickSignInButton() {
        getSignInButton().click();
        return new LoginPage(driver);
    }


    public HeaderPage clickLanguageButton() {
        getButtonLanguage().click();
        return this;
    }


    public HeaderPage clickUaLanguage() {
        getButtonUa().click();
        return this;
    }

    public HeaderPage clickRuLanguage() {
        getButtonRu().click();
        return this;
    }

    public HeaderPage clickEnLanguage() {
        getButtonEn().click();
        return this;
    }
    public HeaderPage clickUserButton(){
        getUserButton().click();
        return this;
    }

    public UbsAdminPage clickUbsAdminButton(){
        getUbsAdminButton().click();
        return new UbsAdminPage(driver);
    }

    public WebElement getButtonLanguage() {
        return driver.findElement(HeaderLocator.LANGUAGE_BUTTON.getPath());
    }

    public WebElement getButtonUa() {
        return driver.findElement(HeaderLocator.UA_LANGUAGE_BUTTON.getPath());
    }

    public WebElement getButtonRu() {
        return driver.findElement(HeaderLocator.RU_LANGUAGE_BUTTON.getPath());
    }

    public WebElement getButtonEn() {
        return driver.findElement(HeaderLocator.EN_LANGUAGE_BUTTON.getPath());
    }


}


