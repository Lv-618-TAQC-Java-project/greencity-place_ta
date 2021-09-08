package com.ita.edu.greencity.ui.locators;

import org.openqa.selenium.By;

public enum UbsAdminLocators implements BaseLocator{
    SEARCH_FIELD(By.xpath("//input[@type='text']")),
    VIEW_TABLE_BUTTON(By.xpath("//button[@class='view-table-btn']")),
    SEARCH_ICON(By.xpath("//i[@class='fa fa-search']")),
    TABLE(By.xpath("//table[@role='presentation']"));

    private final By path;

    UbsAdminLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}