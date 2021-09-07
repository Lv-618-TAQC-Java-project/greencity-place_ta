package com.ita.edu.greencity.ui.locators;

import org.openqa.selenium.By;

public enum LoginLocator implements BaseLocator {

    EMAIL_FIELD(By.xpath("//input[@name='email']")),
    PASSWORD_FIELD(By.xpath("//input[@name='form-control password-signin']")),
    SIGN_IN_BUTTON(By.xpath("//button[@type='submit']")),
    SIGN_IN_WITH_GOOGLE(By.xpath("//span[@class='google-text-sign-in']"));

    private final By path;

    LoginLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
