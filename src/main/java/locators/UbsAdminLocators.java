package locators;

import org.openqa.selenium.By;
import pages.UbsAdminPage;

public enum UbsAdminLocators implements BaseLocator{
    SEARCH_FIELD(By.xpath("//input[@type='text']"));
    private final By path;

    UbsAdminLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
