package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class USBAdminRowTableComponent extends USBAdminTableComponent {

    private WebElement firstRow;
    private WebElement firstRowAddressField;
    private WebElement mattCell;

    public USBAdminRowTableComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstRow() {
        return driver.findElement(UBSAdminRowTableComponentLocator.FIRST_RAW.getPath());
    }

    public WebElement getMattCell() {
        return driver.findElement(UBSAdminRowTableComponentLocator.MATT_CELL.getPath());
    }

    public WebElement getAddressCellFirstRow() {
        return driver.findElement(UBSAdminRowTableComponentLocator.FIRST_RAW_ADDRESS_CELL.getPath());
    }

    public String readAddressCellFirstRow(String result) {
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
}
