package com.ita.edu.greencity.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkElement extends BaseElement {
    public LinkElement(WebDriver driver, By path) {
        super(driver, path);
    }


    public void click() {
        this.element.click();
    }


    public void clear() {
        this.element.clear();
    }


    public void sendKeys(String s) {
        this.element.sendKeys(s);
    }


    public String getAttribute(String attribute){
        return this.element.getAttribute(attribute);
    }


    public String getText() {
        return this.element.getText();
    }

}
