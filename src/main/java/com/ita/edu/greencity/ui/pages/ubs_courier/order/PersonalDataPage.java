package com.ita.edu.greencity.ui.pages.ubs_courier.order;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubs.courier.order.PersonalDataLocator;
import com.ita.edu.greencity.ui.pages.BasePageObject;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage extends BasePageObject {
    private LinkElement nextButton;
    private LinkElement nameField;
    private LinkElement surnameField;
    private LinkElement phoneNumberField;
    private LinkElement emailField;

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public LinkElement getNextButton() {
        if (nextButton == null)
            nextButton = new LinkElement(driver, PersonalDataLocator.NEXT_BUTTON.getPath());
        return nextButton;
    }

    public LinkElement getNameField() {
        if (nameField == null)
            nameField = new LinkElement(driver, PersonalDataLocator.PERSONAL_DATA_NAME.getPath());
        return nameField;
    }

    public LinkElement getSurnameField() {
        if (surnameField == null)
            surnameField = new LinkElement(driver, PersonalDataLocator.PERSONAL_DATA_SURNAME.getPath());
        return surnameField;
    }

    public LinkElement getPhoneNumberField() {
        if (phoneNumberField == null)
            phoneNumberField = new LinkElement(driver, PersonalDataLocator.PERSONAL_DATA_PHONE_NUMBER.getPath());
        return phoneNumberField;
    }

    public LinkElement getEmailField() {
        if (emailField == null)
            emailField = new LinkElement(driver, PersonalDataLocator.PERSONAL_DATA_EMAIL.getPath());
        return emailField;
    }

    public ConfirmationPage clickNextButton() {
        this.getNextButton().click();
        return new ConfirmationPage(driver);
    }
    public PersonalDataPage setNameField(String s){
        this.getNameField().sendKeys(s);
        return this;
    }
    public PersonalDataPage setSurnameField(String s){
        this.getSurnameField().sendKeys(s);
        return this;
    }
    public PersonalDataPage setPhoneNumberField(String s){
        this.getPhoneNumberField().sendKeys(s);
        return this;
    }
    public PersonalDataPage setEmailField(String s){
        this.getEmailField().sendKeys(s);
        return this;
    }
    public PersonalDataPage clearNameField(){
        this.getNameField().clear();
        return this;
    }
    public PersonalDataPage clearSurnameField(){
        this.getSurnameField().clear();
        return this;
    }
    public PersonalDataPage clearPhoneNumberField(){
        this.getPhoneNumberField().clear();
        return this;
    }
    public PersonalDataPage clearEmailField(){
        this.getEmailField().clear();
        return this;
    }
    public PersonalDataPage setPersonalData(String name,String surname,String phoneNumber,String email){
        new PersonalDataPage(driver)
                .clearNameField()
                .setNameField(name)
                .clearSurnameField()
                .setSurnameField(surname)
                .clearPhoneNumberField()
                .setPhoneNumberField(phoneNumber)
                .clearEmailField()
                .setEmailField(email);
        return this;
    }
    public void waitPage() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
