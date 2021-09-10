package com.ita.edu.greencity.ui.pages.ubsCourier;

import com.ita.edu.greencity.ui.elements.LinkElement;
import com.ita.edu.greencity.ui.locators.ubsCourier.UBSCourierLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import com.ita.edu.greencity.ui.pages.ubsCourier.order.OrderDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;



public class ubsCourierPage extends BasePage {
    private LinkElement callUpTheCourier;

    public ubsCourierPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class= 'test']")
    private ubsCourierPage CALL_UP_THE_COURIER_BUTTON;

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