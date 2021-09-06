package com.ita.edu.greencity.ui.pages.UBSadmin.UBSadminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import org.openqa.selenium.WebDriver;
import com.ita.edu.greencity.ui.pages.UBSadmin.USBAdminCommon;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class USBAdminTableComponent extends USBAdminCommon {

    public USBAdminTableComponent(WebDriver driver) {
        super(driver);
    }

    public USBAdminTableComponent tableIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(UBSAdminTableComponentLocator.TABLE.getPath()));
        return this;
    }

}
