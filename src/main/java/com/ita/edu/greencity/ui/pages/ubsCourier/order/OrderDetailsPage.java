package com.ita.edu.greencity.ui.pages.ubsCourier.order;


import com.ita.edu.greencity.ui.elements.LinkElement;
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
}
