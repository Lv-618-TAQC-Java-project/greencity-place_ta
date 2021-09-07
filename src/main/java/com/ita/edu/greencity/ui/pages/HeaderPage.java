package com.ita.edu.greencity.ui.pages;

import com.ita.edu.greencity.ui.locators.HeaderLocator;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends BasePage {
    private WebElement ecoNews;
    private WebElement tipsAndTricks;
    private WebElement places;
    private WebElement aboutUs;
    private WebElement mySpace;
    private WebElement ubsCourier;
    private WebElement signInButton;
    private WebElement homeButton;
    private WebElement languageButton;
    private WebElement userButton;
    private WebElement ubsAdminButton;


    public HeaderPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getSignInButton() {
        return driver.findElement(HeaderLocator.SIGN_IN_BUTTON.getPath());
    }


    public WebElement getUserButton() {
        return driver.findElement(HeaderLocator.USER_BUTTON.getPath());
    }


    public WebElement getUbsAdminButton() {
        return driver.findElement(HeaderLocator.UBS_ADMIN_BUTTON.getPath());
    }


    public WebElement getLanguageButton() {
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

    public LoginPage clickSignInButton() {
        getSignInButton().click();
        return new LoginPage(driver);
    }


    public HeaderPage chooseLanguageUa() {
        getLanguageButton().click();
        getButtonUa().click();
        return this;
    }

    public HeaderPage clickUserButton() {
        getUserButton().click();
        return this;
    }

    public UBSAdminCommon clickUbsAdminButton() {
        getUbsAdminButton().click();
        return new UBSAdminCommon(driver);
    }

    public HeaderPage logInWithAdminCredentials() {
        return new HeaderPage(driver).clickSignInButton()
                .clearEmailField()
                .setEmailField("howiv47374@nenekbet.com")
                .clearPasswordField()
                .setPasswordField("Test-User123")
                .clickSignInButton();
    }


}


