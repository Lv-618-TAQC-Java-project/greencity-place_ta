package com.ita.edu.greencity.ui.locators.ubs_courier.order;

import com.ita.edu.greencity.ui.locators.BaseLocator;
import org.openqa.selenium.By;

public enum OrderDetailsLocator implements BaseLocator {
    NUMBER_OF_PACKAGES_OLD_CLOTHES_VOLUME_20(By.xpath("/html/body/app-root/app-main/div[2]/app-ubs/app-ubs-order-form/div/mat-horizontal-stepper/div[2]/div[1]/app-ubs-order-details/div[1]/div/form/div[2]/ul/li[1]/div/input")),
    NUMBER_OF_PACKAGES_OLD_CLOTHES_VOLUME_120(By.xpath("/html/body/app-root/app-main/div[2]/app-ubs/app-ubs-order-form/div/mat-horizontal-stepper/div[2]/div[1]/app-ubs-order-details/div[1]/div/form/div[2]/ul/li[2]/div/input")),
    NUMBER_OF_PACKAGES_RECYCLED_MATERIALS_VOLUME_120(By.xpath("/html/body/app-root/app-main/div[2]/app-ubs/app-ubs-order-form/div/mat-horizontal-stepper/div[2]/div[1]/app-ubs-order-details/div[1]/div/form/div[2]/ul/li[3]/div/input")),
    NEXT_BUTTON(By.xpath("//div[@class = 'w-100 d-flex justify-content-end buttons']//*[@type = 'submit']"));
    //div[@class = 'w-100 d-flex justify-content-end buttons']//*[@type = 'submit']
    private final By path;

    OrderDetailsLocator(By path) {
        this.path = path;
    }
    @Override
    public By getPath() {
        return path;
    }
}
