package locators;

import org.openqa.selenium.By;

public enum UbsAdminLocators implements BaseLocator{
    SEARCH_FIELD(By.xpath("//input[@type='text']")),
    VIEW_TABLE_BUTTON(By.xpath("//button[@class='view-table-btn']")),
    VIEW_TABLE_CHECKBOX_NAME(By.xpath("//li[@class='ng-star-inserted']")),
    SEARCH_ICON(By.xpath("//i[@class='fa fa-search']")),


    TABLE(By.xpath("\"//table[@role='presentation']\"")),
    ADDRESS_1485_ORDER(By.xpath("//mat-cell[contains(@class,'column-address')]/div/span")); // Address field for orderId 1485 after search

    private final By path;

    UbsAdminLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
