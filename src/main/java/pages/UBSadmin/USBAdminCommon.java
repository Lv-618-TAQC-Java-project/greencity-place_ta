package pages.UBSadmin;

import org.openqa.selenium.WebDriver;
import pages.BasePageObject;

public abstract class USBAdminCommon extends BasePageObject {
    private UBSAdminHeaderComponent header;
    private UBSAdminMenuComponent menu;

    public USBAdminCommon(WebDriver driver) {
        super(driver);
        header = new UBSAdminHeaderComponent(driver);
        menu = new UBSAdminMenuComponent(driver);
    }

    public UBSAdminHeaderComponent getHeader() {
        return header;
    }

    public UBSAdminMenuComponent getMenu() {
        return menu;
    }
}
