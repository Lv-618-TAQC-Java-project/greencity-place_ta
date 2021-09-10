package com.ita.edu.greencity.ui.pages.ubsCourier.order;


import com.ita.edu.greencity.ui.locators.ubsCourier.order.OrderDetailsLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class OrderDetailsPage extends BasePage {

    private WebElement numberOfPackagesOldClothesVolume20;
    private WebElement numberOfPackagesOldClothesVolume120;
    private WebElement numberOfPackagesRecycledMaterialsVolume120;
    private WebElement nextButton;
    private WebElement firstCertificateField;
    private WebElement secondCertificateField;
    private WebElement activateCertificateButton;
    private WebElement secondActivateCertificateButton;
    private WebElement addCertificateButton;


    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getNumberOfPackagesOldClothesVolume20Input() {
        return driver.findElement(OrderDetailsLocator.NUMBER_OF_PACKAGES_OLD_CLOTHES_VOLUME_20.getPath());
    }
    public WebElement getNumberOfPackagesOldClothesVolume120Input() {
        return driver.findElement(OrderDetailsLocator.NUMBER_OF_PACKAGES_OLD_CLOTHES_VOLUME_120.getPath());
    }
    public WebElement getNumberOfPackagesRecycledMaterialsVolume120() {
        return driver.findElement(OrderDetailsLocator.NUMBER_OF_PACKAGES_RECYCLED_MATERIALS_VOLUME_120.getPath());
    }
    public WebElement getNextButton() {
        return driver.findElement(OrderDetailsLocator.NEXT_BUTTON.getPath());
    }

    public OrderDetailsPage setNumberOfPackagesOldClothesVolume20Field(String number) {
        this.getNumberOfPackagesOldClothesVolume20Input().sendKeys(number);
        return this;
    }
    public OrderDetailsPage setNumberOfPackagesOldClothesVolume120Field(String number) {
        this.getNumberOfPackagesOldClothesVolume120Input().sendKeys(number);
        return this;
    }
    public OrderDetailsPage setNumberOfPackagesRecycledMaterialsVolume120(String number) {
        this.getNumberOfPackagesRecycledMaterialsVolume120().sendKeys(number);
        return this;
    }
    public OrderDetailsPage setNumberOfPackages(String oldClothes20,String oldClothes120,String recycledMaterial){
        this.setNumberOfPackagesOldClothesVolume20Field(oldClothes20)
                .setNumberOfPackagesOldClothesVolume120Field(oldClothes120)
                .setNumberOfPackagesRecycledMaterialsVolume120(recycledMaterial);
        return this;
    }
    public PersonalDataPage clickNextButton() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.getNextButton().click();
        return new PersonalDataPage(driver);
    }

    public WebElement getFirstCertificateField() {
        if(firstCertificateField == null){
            return firstCertificateField = driver.findElement(OrderDetailsLocator.FIRST_CERTIFICATE_FIELD.getPath());
        }
        return firstCertificateField;
    }

    public OrderDetailsPage setFirstCertificateNumber(String number){
        getFirstCertificateField().clear();
        getFirstCertificateField().sendKeys(number);
        return this;
    }

    public WebElement getSecondCertificateField() {
        if(secondCertificateField == null){
            return secondCertificateField = driver.findElement(OrderDetailsLocator.SECOND_CERTIFICATE_FIELD.getPath());
        }
        return secondCertificateField;
    }

    public OrderDetailsPage setSecondCertificateNumber(String number){
        getSecondCertificateField().clear();
        getSecondCertificateField().sendKeys(number);
        return this;
    }

    public WebElement getActivateCertificateButton() {
        if(activateCertificateButton == null){
            return activateCertificateButton = driver.findElement(OrderDetailsLocator.ACTIVATE_CERTIFICATE_BUTTON.getPath());
        }
        return activateCertificateButton;
    }

    public OrderDetailsPage clickActivateCertificateButton(){
        getActivateCertificateButton().click();
        return this;
    }

    public WebElement getSecondActivateCertificateButton() {
        if(secondActivateCertificateButton == null){
            return secondActivateCertificateButton = driver.findElement(OrderDetailsLocator.SECOND_ACTIVATE_CERTIFICATE_BUTTON.getPath());
        }
        return secondActivateCertificateButton;
    }

    public OrderDetailsPage clickSecondActivateCertificateButton(){
        getSecondActivateCertificateButton().click();
        return this;
    }

    public WebElement getAddCertificateButton() {
        if(addCertificateButton == null){
            return addCertificateButton = driver.findElement(OrderDetailsLocator.ADD_CERTIFICATE_BUTTON.getPath());
        }
        return addCertificateButton;
    }

    public OrderDetailsPage clickAddCertificateButton() {
        getAddCertificateButton().click();
        return this;
    }

    public PersonalDataPage setOrderDetails(){
        setNumberOfPackagesOldClothesVolume120Field("30")
                .setFirstCertificateNumber("55555555")
                .clickActivateCertificateButton()
                .clickAddCertificateButton()
                .setSecondCertificateNumber("99999999")
                .clickSecondActivateCertificateButton()
                .clickNextButton();
        return new PersonalDataPage(driver);
    }


}