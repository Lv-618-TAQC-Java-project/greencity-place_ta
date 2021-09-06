package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSAdminRowTableComponentLocator implements BaseLocator {
    FIRST_RAW(By.xpath("//mat-row[@role='row']")),
    FIRST_RAW_ADDRESS_CELL(By.xpath("//mat-cell[contains(@class,'column-address')]/div")),
    MATT_CELL(By.xpath("//mat-cell[contains(@class,'mat-cell')]/div"));

    private final By path;

    UBSAdminRowTableComponentLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
