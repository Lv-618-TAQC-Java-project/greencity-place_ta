package com.ita.edu.greencity.ui.pages.ubsCourier;

import com.ita.edu.greencity.ui.elements.LinkElement;

import com.ita.edu.greencity.ui.locators.ubsCourier.UBSCourierLocator;
import com.ita.edu.greencity.ui.pages.BasePage;
import com.ita.edu.greencity.ui.pages.ubsCourier.order.OrderDetailsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class UBSCourierPage extends BasePage {
    private LinkElement callUpTheCourier;

    public UBSCourierPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class= 'test']")
    private UBSCourierPage CALL_UP_THE_COURIER_BUTTON;

    public WebElement getCallUpTheCourierButton() {
        return driver.findElement(UBSCourierLocator.CALL_UP_THE_COURIER_BUTTON.getPath());
    }

    public OrderDetailsPage clickCallUpTheCourierButton() {
        getCallUpTheCourierButton().click();
        return new OrderDetailsPage(driver);
    }
}
