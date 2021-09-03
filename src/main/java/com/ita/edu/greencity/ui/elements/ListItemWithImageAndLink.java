package com.ita.edu.greencity.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListItemWithImageAndLink extends BaseElement{

    public ListItemWithImageAndLink(WebDriver driver, By path) {
        super(driver, path);
    }


    public void click() {
        this.element.findElement(By.xpath(".//a")).click();
    }
}
