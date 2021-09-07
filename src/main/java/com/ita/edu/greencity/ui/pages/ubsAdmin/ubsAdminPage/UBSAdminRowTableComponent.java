package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminRowTableComponentLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class UBSAdminRowTableComponent {
    private final WebDriver driver;
    private final WebElement item;

    public UBSAdminRowTableComponent(WebDriver driver, WebElement item) {
        this.driver = driver;
        this.item = item;
    }

    public WebElement getCheckbox() {
        return driver.findElement(UBSAdminRowTableComponentLocator.CHECKBOX.getPath());
    }

    public WebElement forCheckingCheckboxState() {
        return driver.findElement(UBSAdminRowTableComponentLocator.CHECKING_STATE_OF_CHECKBOX.getPath());
    }

    public boolean isSelectedCheckBox() {
        return forCheckingCheckboxState().isSelected();
    }

    public UBSAdminRowTableComponent clickOnCheckbox() {
        getCheckbox().click();
        return this;
    }

    public String getOrderIdText() {
        return item.findElement(By.className("cdk-column-orderid")).getText();
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

    public String getAddressText() {
        return item.findElement(UBSAdminRowTableComponentLocator.ADDRESS_CELL.getPath()).getText();
    }

    public WebElement getRecipientName() {
        return item.findElement(By.className("cdk-column-recipient_name"));
    }

    public WebElement getRecipientPhone() {
        return item.findElement(By.className("cdk-column-recipient_phone"));
    }

    public WebElement getRecipientEmail() {
        return item.findElement(By.className("cdk-column-recipient_email"));
    }

    public WebElement getCommentToAddressToClient() {
        return item.findElement(By.className("cdk-column-comment_to_address_for_client"));
    }

    public WebElement getGarbageBags120Amount() {
        return item.findElement(By.className("cdk-column-garbage_bags_120_amount"));
    }

    public WebElement getBoBags120Amount() {
        return item.findElement(By.className("cdk-column-bo_bags_120_amount"));
    }

    public WebElement getBoBags20Amount() {
        return item.findElement(By.className("cdk-column-bo_bags_20_amount"));
    }

    public WebElement getTotalOrderSum() {
        return item.findElement(By.className("cdk-column-total_order_sum"));
    }

    public WebElement getOrderCertificateCode() {
        return item.findElement(By.className("cdk-column-order_certificate_code"));
    }

    public WebElement getOrderCertificatePoints() {
        return item.findElement(By.className("cdk-column-order_certificate_points"));
    }

    public WebElement getAmountDue() {
        return item.findElement(By.className("cdk-column-amount_due"));
    }

    public WebElement getCommentForOrderByClient() {
        return item.findElement(By.className("cdk-column-comment_for_order_by_client"));
    }

    public WebElement getPaymentSystem() {
        return item.findElement(By.className("cdk-column-payment_system"));
    }

    public WebElement getDateOfExport() {
        return item.findElement(By.className("cdk-column-date_of_export"));
    }

    public WebElement getTimeOfExport() {
        return item.findElement(By.className("cdk-column-time_of_export"));
    }

    public WebElement getIdOrderFromShop() {
        return item.findElement(By.className("cdk-column-id_order_from_shop"));
    }

    public WebElement getReceivingStation() {
        return item.findElement(By.className("cdk-column-receiving_station"));
    }

    public WebElement getResponsibleManager() {
        return item.findElement(By.className("cdk-column-responsible_manager"));
    }
}
