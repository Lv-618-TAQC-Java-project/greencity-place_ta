package pages.UBSadmin;

import elements.ListItemWithImageAndLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePageObject;

public class UBSAdminMenuComponent extends BasePageObject {
    ListItemWithImageAndLink usersButton;
    ListItemWithImageAndLink certificatesButton;
    ListItemWithImageAndLink ordersButton;
    ListItemWithImageAndLink employeesButton;
    ListItemWithImageAndLink documentsButton;
    ListItemWithImageAndLink scheduleButton;

    public UBSAdminMenuComponent(WebDriver driver) {
        super(driver);
        initElement();
    }


    public void initElement() {
        usersButton = new ListItemWithImageAndLink(driver, By.xpath("/html/body/app-root/app-ubs-admin/app-ubs-admin-sidebar/app-ubs-base-sidebar/mat-drawer-container/mat-drawer/div/ul/li[1]"));
        certificatesButton = new ListItemWithImageAndLink(driver, By.xpath("/html/body/app-root/app-ubs-admin/app-ubs-admin-sidebar/app-ubs-base-sidebar/mat-drawer-container/mat-drawer/div/ul/li[2]"));
        ordersButton = new ListItemWithImageAndLink(driver, By.xpath("/html/body/app-root/app-ubs-admin/app-ubs-admin-sidebar/app-ubs-base-sidebar/mat-drawer-container/mat-drawer/div/ul/li[3]"));
        employeesButton = new ListItemWithImageAndLink(driver, By.xpath("/html/body/app-root/app-ubs-admin/app-ubs-admin-sidebar/app-ubs-base-sidebar/mat-drawer-container/mat-drawer/div/ul/li[4]"));
        documentsButton = new ListItemWithImageAndLink(driver, By.xpath("/html/body/app-root/app-ubs-admin/app-ubs-admin-sidebar/app-ubs-base-sidebar/mat-drawer-container/mat-drawer/div/ul/li[5]"));
        scheduleButton = new ListItemWithImageAndLink(driver, By.xpath("/html/body/app-root/app-ubs-admin/app-ubs-admin-sidebar/app-ubs-base-sidebar/mat-drawer-container/mat-drawer/div/ul/li[6]"));
    }

    public UBSAdminUsers clickUsersButton() {
        usersButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UBSAdminUsers(driver);
    }

    public UBSAdminCertificates clickCertificatesButton() {
        certificatesButton.click();
        return new UBSAdminCertificates(driver);
    }

    public UBSAdminOrders clickOrdersButton() {
        ordersButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UBSAdminOrders(driver);
    }

    public UBSAdminEmployees clickEmployeesButton() {
        employeesButton.click();
        return new UBSAdminEmployees(driver);
    }

    public UBSAdminDocuments clickDocumentsButton() {
        documentsButton.click();
        return new UBSAdminDocuments(driver);
    }

    public UBSAdminSchedule clickScheduleButton() {
        scheduleButton.click();
        return new UBSAdminSchedule(driver);
    }
}
