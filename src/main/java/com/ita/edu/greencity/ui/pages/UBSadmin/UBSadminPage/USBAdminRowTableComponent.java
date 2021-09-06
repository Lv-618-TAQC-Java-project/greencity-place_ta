package com.ita.edu.greencity.ui.pages.UBSadmin.UBSadminPage;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import com.ita.edu.greencity.ui.pages.UBSadmin.USBAdminCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class USBAdminRowTableComponent extends USBAdminCommon {
    private LinkElement firstRow;
    private LinkElement firstRowAddressField;
    private LinkElement mattCell;

    public USBAdminRowTableComponent(WebDriver driver) {
        super(driver);
    }

    public LinkElement getFirstRow() {
        if (firstRow == null) {
            firstRow = new LinkElement(driver, UBSAdminRowTableComponentLocator.FIRST_RAW.getPath());
        }
        return firstRow;
    }

    public LinkElement getMattCell() {
        if (mattCell == null) {
            mattCell = new LinkElement(driver, UBSAdminRowTableComponentLocator.MATT_CELL.getPath());
        }
        return mattCell;
    }

    public LinkElement getAddressCellFirstRow() {
        if (firstRowAddressField == null) {
            firstRowAddressField = new LinkElement(driver, UBSAdminRowTableComponentLocator.FIRST_RAW_ADDRESS_CELL.getPath());
        }
        return firstRowAddressField;
    }

    public String readAddressCellFirstRow(String result) {
        tableIsLoaded();
        result = getAddressCellFirstRow().getText();
        return result;
    }

    public List<String> parseAllMattCellsIntoList(List<String> result) {
        List<WebElement> webElements = driver.findElements(UBSAdminRowTableComponentLocator.MATT_CELL.getPath());
        for (WebElement e: webElements) {
            result.add(e.getText());
        }
        return result;
    }

    public USBAdminRowTableComponent tableIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(UBSAdminTableComponentLocator.TABLE.getPath()));
        return this;
    }




}
