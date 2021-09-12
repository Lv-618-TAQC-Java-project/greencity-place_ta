package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSAdminRowTableComponentLocator implements BaseLocator {
    ADDRESS_CELL(By.className("cdk-column-address")),
    COMMENT_TO_ADDRESS_CELL(By.className("cdk-column-comment_for_order_by_client")),
    CHECKBOX(By.xpath("//tbody//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")),
    TABLE_HEAD_CHECKBOX(By.className("cdk-column-select")),
    CHECKING_STATE_OF_TABLE_HEAD_CHECKBOX(By.xpath("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']/input")),
    CHECKING_STATE_OF_CHECKBOX(By.xpath("//tbody//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']/input")),
    ORDERDATE(By.className("cdk-column-order_date")),
    TOTAL_ORDER_SUM(By.className("cdk-column-total_order_sum")),
    ORDER_CERTIFICATE_POINTS(By.className("cdk-column-order_certificate_points")),
    AMOUNT_DUE(By.className("cdk-column-amount_due")),
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
