package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import com.ita.edu.greencity.ui.pages.UBSadmin.UBSadminPage.UbsAdminPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum UBSAdminTableComponentLocator implements BaseLocator {
    TABLE(By.xpath("//table[@role='presentation']"));

    private final By path;

    UBSAdminTableComponentLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
