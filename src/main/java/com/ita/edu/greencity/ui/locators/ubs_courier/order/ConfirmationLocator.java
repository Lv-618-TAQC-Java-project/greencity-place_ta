package com.ita.edu.greencity.ui.locators.ubs_courier.order;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum ConfirmationLocator implements BaseLocator {
    ORDER_BUTTON(By.xpath("//button[@class= 'primary-global-button btn']"));
    private final By path;

    ConfirmationLocator(By path) {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
