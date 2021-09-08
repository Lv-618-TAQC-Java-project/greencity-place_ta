package com.ita.edu.greencity.ui.pages.ubs_courier.order;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubs_courier.order.OrderDetailsLocator;
import com.ita.edu.greencity.ui.pages.BasePageObject;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePageObject {



    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void waitPage() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
