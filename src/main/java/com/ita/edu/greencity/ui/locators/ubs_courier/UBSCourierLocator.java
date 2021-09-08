package com.ita.edu.greencity.ui.locators.ubs_courier;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSCourierLocator implements BaseLocator {
    CALL_UP_THE_COURIER_BUTTON(By.xpath("//div[@class = 'main-content']//button[contains(text(),'call-up the courier ')]"));

    private final By path;

    UBSCourierLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
