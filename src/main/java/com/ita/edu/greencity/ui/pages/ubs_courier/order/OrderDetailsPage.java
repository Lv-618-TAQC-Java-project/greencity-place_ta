package com.ita.edu.greencity.ui.pages.ubs_courier.order;


import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubs_courier.order.OrderDetailsLocator;
import com.ita.edu.greencity.ui.pages.BasePageObject;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OrderDetailsPage extends BasePageObject {

    private LinkElement numberOfPackagesOldClothesVolume20;
    private LinkElement numberOfPackagesOldClothesVolume120;
    private LinkElement numberOfPackagesRecycledMaterialsVolume120;
    private LinkElement nextButton;


    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public LinkElement getNumberOfPackagesOldClothesVolume20Input() {
        if (numberOfPackagesOldClothesVolume20 == null)
            numberOfPackagesOldClothesVolume20 = new LinkElement(driver, OrderDetailsLocator.NUMBER_OF_PACKAGES_OLD_CLOTHES_VOLUME_20.getPath());
        return numberOfPackagesOldClothesVolume20;
    }
    public LinkElement getNumberOfPackagesOldClothesVolume120Input() {
        if (numberOfPackagesOldClothesVolume120 == null)
            numberOfPackagesOldClothesVolume120 = new LinkElement(driver, OrderDetailsLocator.NUMBER_OF_PACKAGES_OLD_CLOTHES_VOLUME_120.getPath());
        return numberOfPackagesOldClothesVolume120;
    }
    public LinkElement getNumberOfPackagesRecycledMaterialsVolume120() {
        if (numberOfPackagesRecycledMaterialsVolume120 == null)
            numberOfPackagesRecycledMaterialsVolume120 = new LinkElement(driver, OrderDetailsLocator.NUMBER_OF_PACKAGES_RECYCLED_MATERIALS_VOLUME_120.getPath());
        return numberOfPackagesRecycledMaterialsVolume120;
    }
    public LinkElement getNextButton() {
        if (nextButton == null)
            nextButton = new LinkElement(driver, OrderDetailsLocator.NEXT_BUTTON.getPath());
        return nextButton;
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
