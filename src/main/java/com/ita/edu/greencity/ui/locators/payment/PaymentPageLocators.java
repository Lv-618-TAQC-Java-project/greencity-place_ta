package com.ita.edu.greencity.ui.locators;

import org.openqa.selenium.By;

public enum PaymentPageLocators  implements BaseLocator{
    NUMBER_OF_THE_CARD_INPUT(By.xpath("//*[@id='f-32']")),
    DATE_OF_THE_END_OF_THE_CARD(By.xpath("//*[@id='f-38']")),
    CVV_OF_CARD_INPUT(By.xpath("//*[@id='f-44']")),
    EMAIL_FIELD(By.xpath("//*[@id='f-55']")),
    PAY_BUTTON(By.xpath("//*[@id=/'f/']/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[3]/button")),
    CONTINUE_BUTTON(By.xpath("/html/body/div[2]/form/div/button"));

    private final By path;

    PaymentPageLocators(By path){
        this.path = path;
    }

    @Override
    public By getPath() {
        return null;
    }
}