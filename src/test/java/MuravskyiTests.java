import com.ita.edu.greencity.ui.pages.HeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void verifyAddressColumnFromOrder2() {
        String result = "";
        result = new HeaderPage(driver)
                .logInWithAdminCredentials()
                .clickUserButton()
                .clickUbsAdminButton()
                .clearSearchField()
                .setSearchField("1504")
                .readAddressCellFirstRow(result);
        Assert.assertEquals(result, "Kiev, Tarasa Shevchenko Blvd, 8, 8,");
    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With English
     */
    @Test(dataProvider = "expectedViewTableFieldsTQ224")
    public void VerifyUIOfDropdown(List<String> expectedTQ224En) {
        List<String> actual = new ArrayList<>();
        actual = new HeaderPage(driver).
                logInWithAdminCredentials()
                .chooseLanguageUa()
                .clickUserButton()
                .clickUbsAdminButton()
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
}
