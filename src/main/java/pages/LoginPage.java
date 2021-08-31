package pages;

import org.apache.maven.plugin.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    By email = By.xpath("//input[@name='email']");
    By password = By.xpath("//input[@name='form-control password-signin']");
    By signInButtonl = By.xpath("//button[@type='submit']");
    By signInWithGoogleButton = By.xpath("//span[@class='google-text-sign-in']");

    WebElement emailField;
    WebElement passwordField;
    WebElement signInButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailField() {
        emailField = driver.findElement(email);
        return emailField;
    }

    public WebElement getPasswordField() {
        passwordField = driver.findElement(password);
        return passwordField;
    }

    public WebElement getSignInButton() {
        signInButton = driver.findElement(signInButtonl);
        return signInButton;
    }

    public LoginPage setEmail(String email) {
        this.getEmailField().sendKeys(email);
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
