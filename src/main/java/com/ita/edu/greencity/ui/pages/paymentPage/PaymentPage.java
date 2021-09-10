package com.ita.edu.greencity.ui.pages.paymentPage;

import com.ita.edu.greencity.ui.locators.payment.PaymentPageLocators;
import com.ita.edu.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {

    private WebElement numberOfCard;
    private WebElement dateOfTheEndCard;
    private WebElement cvvOfCard;
    private WebElement email;
    private WebElement pay;
    private WebElement continueButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getNumberOfCard() {
        return driver.findElement(PaymentPageLocators.NUMBER_OF_THE_CARD_INPUT.getPath());
    }

    public PaymentPage setNumberOfCard(String number) {
        getNumberOfCard().sendKeys(number);
        return this;
    }

    private WebElement getPayButton() {
        return driver.findElement(PaymentPageLocators.PAY_BUTTON.getPath());
    }

    public ResultOfPaymentPage clickContinueButton() {
        getContinueButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResultOfPaymentPage(driver);
    }

    public PaymentPage clickPayButton() {
        getPayButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    private WebElement getContinueButton() {
        return driver.findElement(PaymentPageLocators.CONTINUE_BUTTON.getPath());
    }

    private WebElement getDateOfTheEndCard() {
        return driver.findElement(PaymentPageLocators.DATE_OF_THE_END_OF_THE_CARD.getPath());
    }

    public PaymentPage setDateOfTheEndCard(String date) {
       getDateOfTheEndCard().sendKeys(date);
        return this;
    }

    private WebElement getCvvOfCard() {
        return driver.findElement(PaymentPageLocators.CVV_OF_CARD_INPUT.getPath());
    }

    public PaymentPage setCvvOfCard(String cvv) {
        getCvvOfCard().sendKeys(cvv);
        return this;
    }

    public PaymentPage clearNumberOfCardField() {
        getNumberOfCard().clear();
        return this;
    }

    public PaymentPage clearDateOfTheEndCardField() {
        getDateOfTheEndCard().clear();
        return this;
    }

    public PaymentPage clearCvvOfCardField() {
        getCvvOfCard().clear();
        return this;
    }

    private WebElement getEmail() {
        return driver.findElement(PaymentPageLocators.EMAIL_FIELD.getPath());
    }

    public PaymentPage setEmail(String email) {
        getEmail().sendKeys(email);
        return this;
    }

    public PaymentPage clearEmail() {
        getEmail().clear();
        return this;
    }


}