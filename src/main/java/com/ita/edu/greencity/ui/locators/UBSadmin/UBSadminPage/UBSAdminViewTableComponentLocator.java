package com.ita.edu.greencity.ui.locators.UBSadmin.UBSadminPage;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSAdminViewTableComponentLocator implements BaseLocator {
    CHECK_BOX_NAME(By.xpath("//li[@class='ng-star-inserted']")),
    CLEAR_BUTTON(By.xpath("//ul/button[@class='btn btn-info']"));

    private final By path;

    UBSAdminViewTableComponentLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
