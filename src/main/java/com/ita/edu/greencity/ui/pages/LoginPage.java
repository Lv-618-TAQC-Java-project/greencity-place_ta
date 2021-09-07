package com.ita.edu.greencity.ui.pages;

import com.ita.edu.greencity.ui.locators.LoginLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;
    private WebElement signInWithGoogleButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailField() {
        return driver.findElement(LoginLocator.EMAIL_FIELD.getPath());
    }

    public WebElement getPasswordField() {
        return driver.findElement(LoginLocator.PASSWORD_FIELD.getPath());
    }

    public WebElement getSignInButton() {
        return driver.findElement(LoginLocator.SIGN_IN_BUTTON.getPath());
    }

    public WebElement getSignInWithGoogleButton() {
        return driver.findElement(LoginLocator.SIGN_IN_WITH_GOOGLE.getPath());
    }

    public LoginPage clearEmailField() {
        getEmailField().clear();
        return this;
    }

    public LoginPage setEmailField(String s) {
        getEmailField().sendKeys(s);
        return this;
    }

    public LoginPage clearPasswordField() {
        getEmailField().clear();
        return this;
    }

    public LoginPage setPasswordField(String s) {
        getPasswordField().sendKeys(s);
        return this;
    }


    public LoginPage clickSignInWithGoogleButton() {
        getSignInWithGoogleButton().click();
        return this;
    }

    public HeaderPage clickSignInButton() {
        getSignInButton().click();
        wainUntilPageIsLoaded();
        return new HeaderPage(driver);
    }

    public void wainUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("profile"));
    }
}
