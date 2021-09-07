package com.ita.edu.greencity.ui.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private WebDriver driver;
    private LoginPage loginPage;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
