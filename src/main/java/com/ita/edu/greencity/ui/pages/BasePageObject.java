package com.ita.edu.greencity.ui.pages;

import org.openqa.selenium.WebDriver;

public class BasePageObject {
    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
