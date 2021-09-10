package com.ita.edu.greencity.ui.locators.payment;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum PaymentPageLocators  implements BaseLocator {
    NUMBER_OF_THE_CARD_INPUT(By.xpath("//*[@id='f-32']")),
    DATE_OF_THE_END_OF_THE_CARD(By.xpath("//*[@id='f-38']")),
    CVV_OF_CARD_INPUT(By.xpath("//*[@id='f-44']")),
    EMAIL_FIELD(By.xpath("//*[@id='f-55']")),
    PAY_BUTTON(By.xpath("(//button[@type='button'])[3]")),
    CONTINUE_BUTTON(By.xpath("//button[@type='submit']"));

    private final By path;

    PaymentPageLocators(By path){
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}