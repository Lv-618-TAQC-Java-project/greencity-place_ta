package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSAdminTableComponentLocator implements BaseLocator {
    ROW(By.xpath("//tbody/mat-row[@role='row']")),
    TABLE(By.xpath("//table[contains(@class,'mat-table')]")),
    COLUMN_ORDER_ID(By.xpath("//mat-cell[2]")),
    COLUMN_DISTRICT(By.xpath("//mat-cell[9]"));

    private final By path;

    UBSAdminTableComponentLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
