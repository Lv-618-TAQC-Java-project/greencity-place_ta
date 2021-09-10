package com.ita.edu.greencity.ui.pages.ubsCourier.order;

import com.ita.edu.greencity.ui.locators.ubsCourier.order.ConfirmationLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import com.ita.edu.greencity.ui.pages.paymentPage.PaymentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationPage extends BasePage {

    private WebElement orderButton;


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getOrderButton() {
        return driver.findElement(ConfirmationLocator.ORDER_BUTTON.getPath());
    }
    public ConfirmationPage clickOrderButton(){
        this.getOrderButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ConfirmationPage(driver);
    }
    public PaymentPage acceptAlert(){
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PaymentPage(driver);
    }
}
