package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    By email = By.xpath("//input[@name='email']");
    By password = By.xpath("//input[@name='form-control password-signin']");
    By signInButton = By.xpath("//button[@type='submit']");
    By signInWithGoogleButton = By.xpath("//span[@class='google-text-sign-in']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailField() {
        return driver.findElement(email);
    }

    public WebElement getPasswordField() {
        return driver.findElement(password);
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public WebElement getSignInWithGoogleButton() {
        return driver.findElement(signInWithGoogleButton);
    }
}
