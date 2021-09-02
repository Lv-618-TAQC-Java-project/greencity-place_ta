import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;

import java.util.LinkedList;
import java.util.List;

public class MuravskyiTests extends TestRunner implements SomeTestsDataProvider {

    /**
     * TQ-221
     * [UBS admin] Verify that data for "Address" column received from order form.
     */
    @Test(dataProvider = "adminCredentials")
    public void verifyAddressColumnFromOrder(String adminEmail, String adminPassword) {
        String actualAddress = new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                clearSearchField().
                setSearchField("1485").
//                waitUntilTableIsLoaded().
                getAddressOrderId1485();
        Assert.assertEquals(actualAddress, "Kiev, Tarasa Shevchenko Blvd, 8, 8");
    }

    /**
     * TQ-224
     * [UBS admin]Verify UI of "Вид таблиці" dropdown
     */
    @Test(dataProvider = "adminCredentials")
    public void VerifyUIOfDropdown(String adminEmail, String adminPassword) {
        List<String> actual = new LinkedList<>();
//        String actual = "";
        new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                clickViewTable().
                waitUntilViewTableIsLoaded().
                getTextFromViewTableCheckBoxName(actual);
        System.out.println(actual);
    }

    @Test(dataProvider = "adminCredentials")
    public void verifyAddressColumnFromOrder2(String adminEmail, String adminPassword) {
//        String actualAddress =
                new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                getMenu().
                clickOrdersButton().
                getMenu().
                clickUsersButton();
//                setSearchField("1485").
////                waitUntilTableIsLoaded().
//        getAddressOrderId1485();
//        Assert.assertEquals(actualAddress, "Kiev, Tarasa Shevchenko Blvd, 8, 8");
    }


}
