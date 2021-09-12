package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
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
    public List<String> getColumnOrderID() {
        List<String>rows = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(UBSAdminTableComponentLocator.COLUMN_ORDER_ID.getPath());
        for (WebElement element: webElements) {
            rows.add(element.getText());
        }
        return rows;
    }

    public List<String> getColumnDistrict() {
        List<String> rows = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(UBSAdminTableComponentLocator.COLUMN_DISTRICT.getPath());
        for (WebElement element: webElements) {
            rows.add(element.getText());
        }
        return rows;
    }



}
