package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UBSAdminTableComponent extends UBSAdminCommon {
    private List<UBSAdminRowTableComponent> rows;

    public UBSAdminTableComponent(WebDriver driver) {
        super(driver);
    }

    public List<UBSAdminRowTableComponent> getRows() {
        rows = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(UBSAdminTableComponentLocator.ROW.getPath());
        for (WebElement element: webElements) {
            rows.add(new UBSAdminRowTableComponent(driver, element));
        }
        return rows;
    }



}
