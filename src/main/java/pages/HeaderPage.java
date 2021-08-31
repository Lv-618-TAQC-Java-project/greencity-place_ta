package pages;

import elements.LinkElement;
import locators.HeaderLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    private final WebDriver driver;
    private LinkElement ecoNews;
    private LinkElement tipsAndTricks;
    private LinkElement places;
    private LinkElement aboutUs;
    private LinkElement mySpace;
    private LinkElement ubsCourier;
    private LinkElement signInButton;
    private LinkElement homeButton;
    private LinkElement languageButton;


    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public LinkElement getSignInButton() {
        if (signInButton == null)
            signInButton = new LinkElement(driver, HeaderLocator.SIGN_IN_BUTTON.getPath());
        return signInButton;
    }

    public LoginPage clickSignInButton() {
        getSignInButton().click();
        return new LoginPage(driver);
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


