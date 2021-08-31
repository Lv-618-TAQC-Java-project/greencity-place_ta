package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    protected By path;
    protected WebElement element;
    protected WebDriver driver;

    public BaseElement(WebDriver driver, By path) {
        this.driver = driver;
        this.path = path;
        this.element= driver.findElement(path);
    }

}
