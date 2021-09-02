package pages;

import elements.LinkElement;
import locators.LoginLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private LinkElement emailField;
    private LinkElement passwordField;
    private LinkElement signInButton;
    private LinkElement signInWithGoogleButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LinkElement getEmailField() {
        if (emailField == null)
            emailField = new LinkElement(driver, LoginLocators.EMAIL_FIELD.getPath());
        return emailField;
    }

    public LinkElement getPasswordField() {
        if (passwordField == null)
            passwordField = new LinkElement(driver, LoginLocators.PASSWORD_FIELD.getPath());
        return passwordField;
    }

    public LinkElement getSignInButton() {
        if (signInButton == null)
            signInButton = new LinkElement(driver, LoginLocators.SIGN_IN_BUTTON.getPath());
        return signInButton;
    }

    public LinkElement getSignInWithGoogleButton() {
        if (signInWithGoogleButton == null)
            signInWithGoogleButton = new LinkElement(driver, LoginLocators.SIGN_IN_WITH_GOOGLE.getPath());
        return signInWithGoogleButton;
    }

    public LoginPage clearEmailField() {
        this.getEmailField().clear();
        return this;
    }

    public LoginPage setEmail(String email) {
        this.getEmailField().sendKeys(email);
        return this;
    }

    public LoginPage clearPasswordField() {
        this.getPasswordField().clear();
        return this;
    }

    public LoginPage setPassword(String password) {
        this.getPasswordField().sendKeys(password);
        return this;
    }


    public HeaderPage clickSignInButton() {
        this.getSignInButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HeaderPage(driver);
    }
}
