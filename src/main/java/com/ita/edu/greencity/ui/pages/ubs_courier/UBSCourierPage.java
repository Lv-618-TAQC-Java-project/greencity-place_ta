package com.ita.edu.greencity.ui.pages.ubs_courier;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubs_courier.UBSCourierLocator;
import com.ita.edu.greencity.ui.pages.BasePageObject;
import com.ita.edu.greencity.ui.pages.ubs_courier.order.OrderDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class UBSCourierPage extends BasePageObject {
    private LinkElement callUpTheCourier;

    public UBSCourierPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class= 'test']")
    private UBSCourierPage CALL_UP_THE_COURIER_BUTTON;

    public LinkElement getCallUpTheCourierButton() {
        if (callUpTheCourier == null)
            callUpTheCourier = new LinkElement(driver, UBSCourierLocator.CALL_UP_THE_COURIER_BUTTON.getPath());
        return callUpTheCourier;
    }

    public OrderDetailsPage clickCallUpTheCourierButton() {
        getCallUpTheCourierButton().click();
        return new OrderDetailsPage(driver);
    }
}
