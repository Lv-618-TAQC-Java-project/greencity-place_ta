package com.ita.edu.greencity.ui.pages.ubsCourier.order;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubsCourier.order.PersonalDataLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PersonalDataPage extends BasePage {
    private LinkElement nextButton;
    private LinkElement nameField;
    private LinkElement surnameField;
    private LinkElement phoneNumberField;
    private LinkElement emailField;
    private WebElement firstGarbageAddressButton;

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public PersonalDataPage setEmailField(String s){
        this.getEmailField().sendKeys(s);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        this.clearNameField()
                .setNameField(name)
                .clearSurnameField()
                .setSurnameField(surname)
                .clearPhoneNumberField()
                .setPhoneNumberField(phoneNumber)
                .clearEmailField()
                .setEmailField(email);
        return this;
    }

    public WebElement getFirstGarbageAddressButton() {
        if (firstGarbageAddressButton == null){
            return firstGarbageAddressButton = driver.findElement(PersonalDataLocator.FIRST_GARBAGE_ADDRESS_BUTTON.getPath());
        }
        return firstGarbageAddressButton;
    }

    public PersonalDataPage clickOnFirstGarbageAddressButton(){
        getFirstGarbageAddressButton().click();
        return this;
    }

    public ConfirmationPage setPersonalData(){
        clearEmailField()
                .setEmailField("testmail@mail.com")
                .clickOnFirstGarbageAddressButton()
                .clearNameField()
                .setNameField("ThisNameIsForTest")
                .clickNextButton();
        return new ConfirmationPage(driver);
    }
}