package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

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
