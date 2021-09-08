package com.ita.edu.greencity.ui.pages.paymentPage;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.PaymentPageLocators;
import com.ita.edu.greencity.ui.pages.BasePageObject;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePageObject {

    private LinkElement numberOfCard;
    private LinkElement dateOfTheEndCard;
    private LinkElement cvvOfCard;
    private LinkElement email;
    private LinkElement pay;
    private LinkElement continueButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private LinkElement getNumberOfCard() {
        if (numberOfCard == null)
            numberOfCard = new LinkElement(driver, PaymentPageLocators.NUMBER_OF_THE_CARD_INPUT.getPath());
        return numberOfCard;
    }

    public PaymentPage setNumberOfCard(String number) {
        this.getNumberOfCard().sendKeys(number);
        return this;
    }

    private LinkElement getPayButton() {
        if (pay == null)
            pay = new LinkElement(driver, PaymentPageLocators.PAY_BUTTON.getPath());
        return pay;
    }

    public ResultOfPaymentPage clickContinueButton() {
        this.getContinueButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResultOfPaymentPage(driver);
    }

    private LinkElement getContinueButton() {
        if (continueButton == null)
            continueButton = new LinkElement(driver, PaymentPageLocators.CONTINUE_BUTTON.getPath());
        return continueButton;
    }

    private LinkElement getDateOfTheEndCard() {
        if (dateOfTheEndCard == null)
            dateOfTheEndCard = new LinkElement(driver, PaymentPageLocators.DATE_OF_THE_END_OF_THE_CARD.getPath());
        return dateOfTheEndCard;
    }

    public PaymentPage setDateOfTheEndCard(String date) {
        this.getDateOfTheEndCard().sendKeys(date);
        return this;
    }

    private LinkElement getCvvOfCard() {
        if (cvvOfCard == null)
            cvvOfCard = new LinkElement(driver, PaymentPageLocators.CVV_OF_CARD_INPUT.getPath());
        return cvvOfCard;
    }

    public PaymentPage setCvvOfCard(String cvv) {
        this.getCvvOfCard().sendKeys(cvv);
        return this;
    }

    public PaymentPage clearNumberOfCardField() {
        this.getNumberOfCard().clear();
        return this;
    }

    public PaymentPage clearDateOfTheEndCardField() {
        this.getDateOfTheEndCard().clear();
        return this;
    }

    public PaymentPage clearCvvOfCardField() {
        this.getCvvOfCard().clear();
        return this;
    }

    private LinkElement getEmail() {
        if (email == null)
            email = new LinkElement(driver, PaymentPageLocators.EMAIL_FIELD.getPath());
        return email;
    }

    public PaymentPage setEmail(String email) {
        this.getEmail().sendKeys(email);
        return this;
    }

    public PaymentPage clearEmail() {
        this.getEmail().clear();
        return this;
    }


}