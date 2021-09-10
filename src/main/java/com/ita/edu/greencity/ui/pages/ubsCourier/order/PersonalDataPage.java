package com.ita.edu.greencity.ui.pages.ubsCourier.order;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubsCourier.order.PersonalDataLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PersonalDataPage extends BasePage {
    private WebElement nameField;
    private WebElement nextButton;
    private WebElement surnameField;
    private WebElement phoneNumberField;
    private WebElement emailField;

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNextButton() {
        return driver.findElement(PersonalDataLocator.NEXT_BUTTON.getPath());
    }

    public WebElement getNameField() {
        return driver.findElement(PersonalDataLocator.PERSONAL_DATA_NAME.getPath());
    }

    public WebElement getSurnameField() {
        return driver.findElement(PersonalDataLocator.PERSONAL_DATA_SURNAME.getPath());
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(PersonalDataLocator.PERSONAL_DATA_PHONE_NUMBER.getPath());
    }

    public WebElement getEmailField() {
        return driver.findElement(PersonalDataLocator.PERSONAL_DATA_EMAIL.getPath());
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

}
