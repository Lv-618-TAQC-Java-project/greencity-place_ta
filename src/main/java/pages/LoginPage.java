package pages;

import elements.LinkElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    private LinkElement emailField;
    private LinkElement passwordField;
    private LinkElement signInButton;
    private LinkElement signInWithGoogleButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LinkElement getEmailField() {
        if (emailField == null)
            emailField = new LinkElement(driver, emailField);
        return emailField;
    }

    public LinkElement getPasswordField() {
        if (passwordField == null)
            passwordField = new LinkElement(driver, passwordField);
        return passwordField;
    }

    public LinkElement getSignInButton() {
        if (signInButton == null)
            signInButton = new LinkElement(driver, signInButton);
        return signInButton;
    }

    public LoginPage clearEmail() {

        return this;
    }

    public LoginPage setEmail(String email) {
        this.getEmailField().click();
        return this;
    }

    public LoginPage setPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage clearEmailField() {
        this.getEmailField().clear();
        return this;
    }

    public LoginPage clearPasswordField() {
        this.getPasswordField().clear();
        return this;
    }

    public void clickSignInButton() {
        this.getSignInButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getSignInWithGoogleButton() {
        return driver.findElement(signInWithGoogleButton);
    }
}
