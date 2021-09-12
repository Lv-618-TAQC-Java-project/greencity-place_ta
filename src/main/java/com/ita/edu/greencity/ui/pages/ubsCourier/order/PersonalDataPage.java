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
    private WebElement firstGarbageAddressButton;

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNextButton() {
        return driver.findElement(PersonalDataLocator.NEXT_BUTTON.getPath());
    }

    public WebElement getNameField() {
        return driver.findElement(PersonalDataLocator.PERSONAL_DATA_NAME.getPath());
    }

    public WebElement getSurnameField() {return driver.findElement(PersonalDataLocator.PERSONAL_DATA_SURNAME.getPath());}

    public WebElement getPhoneNumberField() {return driver.findElement(PersonalDataLocator.PERSONAL_DATA_PHONE_NUMBER.getPath());}

    public WebElement getEmailField() {
        return driver.findElement(PersonalDataLocator.PERSONAL_DATA_EMAIL.getPath());
    }

    public ConfirmationPage clickNextButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getNextButton().click();
        return new ConfirmationPage(driver);
    }
    public PersonalDataPage setNameField(String s){
        this.getNameField().clear();
        this.getNameField().sendKeys(s);
        return this;
    }
    public PersonalDataPage setSurnameField(String s){
        this.getSurnameField().clear();
        this.getSurnameField().sendKeys(s);
        return this;
    }
    public PersonalDataPage setPhoneNumberField(String s){
        this.getPhoneNumberField().clear();
        this.getPhoneNumberField().sendKeys(s);
        return this;
    }
    public PersonalDataPage setEmailField(String s){
        this.getEmailField().clear();
        this.getEmailField().sendKeys(s);
        return this;
    }

    public PersonalDataPage setPersonalData(String name,String surname,String phoneNumber,String email){
                 this.setNameField(name)
                .setSurnameField(surname)
                .setPhoneNumberField(phoneNumber)
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
                setEmailField("testmail@mail.com")
                .clickOnFirstGarbageAddressButton()
                .setNameField("ThisNameIsForTest")
                .clickNextButton();
        return new ConfirmationPage(driver);
    }


}