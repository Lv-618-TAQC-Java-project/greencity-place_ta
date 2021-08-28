package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    public WebDriver driver;

    By signInButton = By.cssSelector("a.header_sign-in-link.tertiary-global-button");
    By btnLanguage = By.xpath("//ul[@aria-label='language switcher']");
    By btnRu = By.xpath("//span[text()='Ru']");
    By btnUa = By.xpath("//span[text()='Ua']");
    By btnEn = By.xpath("//span[text()='En']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    public WebElement getButtonLanguage() {
        return driver.findElement(btnLanguage);
    }

    public WebElement getButtonUa() {
        return driver.findElement(btnUa);
    }

    public WebElement getButtonRu() {
        return driver.findElement(btnRu);
    }

    public WebElement getButtonEn() {
        return driver.findElement(btnEn);
    }


}


