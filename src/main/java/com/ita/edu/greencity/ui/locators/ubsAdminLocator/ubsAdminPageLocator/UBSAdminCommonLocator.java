package com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum UBSAdminCommonLocator implements BaseLocator {
    SEARCH_FIELD(By.xpath("//input[@type='text']")),
    VIEW_TABLE_BUTTON(By.xpath("//button[@class='view-table-btn']")),
    SEARCH_ICON(By.xpath("//i[@class='fa fa-search']")),
    TABLE(By.xpath("//table[@role='presentation']")),
    DISPLAY_COUNTER_DROPDOWN(By.xpath("//select[@class = 'display-counter']")),
    DISPLAY_COUNTER_10(By.xpath("//select[@class = 'display-counter']//option[contains(text(),'10')]")),
    DISPLAY_COUNTER_15(By.xpath("//select[@class = 'display-counter']//option[contains(text(),'15')]")),
    DISPLAY_COUNTER_20(By.xpath("//select[@class = 'display-counter']//option[contains(text(),'20')]")),
    SORT_ORDER_NUMBER_BUTTON(By.xpath("//span[text()='orderid']/following-sibling::span/mat-icon")),
    SORT_DISTRICT_BUTTON(By.xpath("//mat-header-cell[9]/div/span[2]/mat-icon"));

    private final By path;

    UBSAdminCommonLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
