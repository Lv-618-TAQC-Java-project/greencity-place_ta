package com.ita.edu.greencity.ui.locators;

import org.openqa.selenium.By;

public enum HeaderLocator implements BaseLocator{

    SIGN_IN_BUTTON(By.cssSelector("a.header_sign-in-link.tertiary-global-button")),
    LANGUAGE_BUTTON(By.xpath("//ul[@aria-label='language switcher']")),
    RU_LANGUAGE_BUTTON(By.xpath("//span[text()='Ru']")),
    UA_LANGUAGE_BUTTON(By.xpath("//span[text()='Ua']")),
    EN_LANGUAGE_BUTTON(By.xpath("//span[text()='En']")),
    USER_BUTTON(By.xpath("//a[@class='header_user-name']")),
    UBS_ADMIN_BUTTON(By.xpath("//li[@role='navigation to ubs']")),
    UBS_COURIER_BUTTON(By.xpath("//*[contains(text(),'UBS courier')]")),
    SIGN_OUT_BUTTON(By.xpath("//li[@aria-label='sign-out']"));


    private final By path;

    HeaderLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
