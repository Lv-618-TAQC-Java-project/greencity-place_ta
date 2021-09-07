import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class MuravskyiTests extends TestRunner implements Repository {

    /**
     private static OrderService orderService = new OrderService();

     @BeforeClass public void beforeClass() {
     OrdersEntity ordersEntity = new OrdersEntity();
     ordersEntity.setCalcellationComment("This is comment");
     orderService.createOrder(ordersEntity);
     }
     */

    /**
     * TQ-221
     * [UBS admin] Verify that data for "Address" column received from order form.
     */
    @Test
    public void verifyAddressColumnFromOrder() {
        String result = "";
        result = new HeaderPage(driver)
                .logIn("howiv47374@nenekbet.com", "Test-User123")
                .navigateToUBSAdminCommon()
                .clearSearchField()
                .setSearchField("1504")
                .getUbsAdminTableComponent()
                .readAddressCellFirstRow(result);
        Assert.assertEquals(result, "Kiev, Tarasa Shevchenko Blvd, 8, 8,");
    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With English
     */
    @Test
    public void VerifyUIOfDropdownEn() {
        List<String> actual = new ArrayList<>();
        actual = new HeaderPage(driver)
                .logIn("howiv47374@nenekbet.com", "Test-User123")
                .navigateToUBSAdminCommon()
                .clickViewTable()
                .readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, expectedTQ224En);
    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With Ukrainian
     */
    @Test
    public void VerifyUIOfDropdownUa() {
        List<String> actual = new ArrayList<>();
        actual = new HeaderPage(driver)
                .chooseLanguageUa()
                .logIn("howiv47374@nenekbet.com", "Test-User123")
                .navigateToUBSAdminCommon()
                .clickViewTable()
                .readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, expectedTQ224UA);
    }
}
