package com.ita.edu.greencity.ui.pages.ubs_courier.order;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubs_courier.order.ConfirmationLocator;
import com.ita.edu.greencity.ui.locators.ubs_courier.order.OrderDetailsLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import com.ita.edu.greencity.ui.pages.paymentPage.PaymentPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ConfirmationPage extends BasePage {

    private LinkElement orderButton;


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public LinkElement getOrderButton() {
        if (orderButton == null)
            orderButton = new LinkElement(driver, ConfirmationLocator.ORDER_BUTTON.getPath());
        return orderButton;
    }
    public ConfirmationPage clickOrderButton(){
        this.getOrderButton().click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ConfirmationPage(driver);
    }
    public PaymentPage clickAlertButton(){
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PaymentPage(driver);
    }
}