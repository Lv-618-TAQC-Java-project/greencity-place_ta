package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSAdminRowTableComponentLocator implements BaseLocator {
    ADDRESS_CELL(By.className("cdk-column-address")),
    CHECKBOX(By.xpath("//tbody//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")),
    CHECKING_STATE_OF_CHECKBOX(By.xpath("//tbody//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']/input")),
    ORDERDATE(By.className("cdk-column-order_date")),
    CLIENTNAME(By.className("cdk-column-clientname"));
    private final By path;

    UBSAdminRowTableComponentLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
