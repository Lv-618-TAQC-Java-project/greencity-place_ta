package com.ita.edu.greencity.ui.pages;

import com.ita.edu.greencity.ui.pages.ubsAdmin.UBSAdminOrders;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminCommon;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    private HeaderPage headerPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderPage getHeaderPage() {
        if (headerPage == null) {
            headerPage = new HeaderPage(driver);
        }
        return headerPage;
    }

    public UBSAdminCommon navigateToUBSAdminPage() {
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/ubs-admin");
        return new UBSAdminCommon(driver);
    }

    public UBSAdminCommon navigateToUBSOrderTablePage(){
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/ubs-admin/orders");
        return new UBSAdminCommon(driver);
    }
}