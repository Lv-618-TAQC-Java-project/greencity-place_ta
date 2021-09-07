package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public final class UBSAdminRowTableComponent {
    private final WebDriver driver;
    private final WebElement item;

//    private WebElement firstRow;
//    private WebElement firstRowAddressField;
//    private WebElement mattCell;
//    private WebElement orderId;

    public UBSAdminRowTableComponent(WebDriver driver, WebElement element) {
        this.driver = driver;
        item = element;
    }

    public WebElement getOrderId() {
        return item.findElement(By.className("cdk-column-orderid"));
    }

    public WebElement getOrderStatus() {
        return item.findElement(By.className("cdk-column-order_status"));
    }

    public WebElement getOrderDate() {
        return item.findElement(By.className("dk-column-order_date"));
    }

    public WebElement getClientName() {
        return item.findElement(By.className("cdk-column-clientname"));
    }

    public WebElement getPhoneNumber() {
        return item.findElement(By.className("cdk-column-phone_number"));
    }

    public WebElement getEmail() {
        return item.findElement(By.className("cdk-column-email"));
    }

    public WebElement getViolations() {
        return item.findElement(By.className("cdk-column-violations"));
    }

    public WebElement getDistrict() {
        return item.findElement(By.className("cdk-column-district"));
    }

    public WebElement getAddress() {
        return item.findElement(By.className("cdk-column-address"));
    }

    public WebElement getRecipientName() {
        return item.findElement(By.className("cdk-column-recipient_name"));
    }
}
