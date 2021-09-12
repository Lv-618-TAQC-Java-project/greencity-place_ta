package com.ita.edu.greencity.ui.pages.ubsCourier.order;

import com.ita.edu.greencity.ui.locators.ubsCourier.order.ConfirmationLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import com.ita.edu.greencity.ui.pages.payment.PaymentPage;
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
        return new ConfirmationPage(driver);
    }
    public PaymentPage acceptAlert(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        return new PaymentPage(driver);
    }
}
