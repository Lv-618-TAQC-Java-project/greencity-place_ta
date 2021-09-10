package com.ita.edu.greencity.ui.locators.ubsCourier.order;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum PersonalDataLocator implements BaseLocator {
    NEXT_BUTTON(By.xpath("/html/body/app-root/app-main/div[2]/app-ubs/app-ubs-order-form/div/mat-horizontal-stepper/div[2]/div[2]/app-ubs-personal-information/div/div/button[2]")),
    PERSONAL_DATA_NAME(By.xpath("//input[@formcontrolname = 'firstName']")),
    PERSONAL_DATA_SURNAME(By.xpath("//input[@formcontrolname = 'lastName']")),
    PERSONAL_DATA_PHONE_NUMBER(By.xpath("//input[@formcontrolname = 'phoneNumber']")),
    PERSONAL_DATA_EMAIL(By.xpath("//input[@formcontrolname = 'email']"));

    private final By path;

    PersonalDataLocator(By path) {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
