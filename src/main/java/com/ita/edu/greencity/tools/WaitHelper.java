package com.ita.edu.greencity.tools;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminTableComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {
    WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibilityOfElementLocated(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
