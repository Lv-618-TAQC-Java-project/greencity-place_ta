import com.ita.edu.greencity.ui.pages.HomePage;
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
        String result = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .clearSearchField()
                .setSearchField("1504")
                .getTableRow()
                .getAddressText();
        Assert.assertEquals(result, ADDRESSTQ221);
    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With English
     */
    @Test
    public void VerifyUIOfDropdownEn() {
        List<String> actual = new ArrayList<>();
        actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .clickViewTable()
                .readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, EXPECTEDTQ224EN);
    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With Ukrainian
     */
    @Test
    public void VerifyUIOfDropdownUa() {
        List<String> actual = new ArrayList<>();
        actual = new HomePage(driver)
                .getHeaderPage()
                .chooseLanguageUa()
                .logIn()
                .navigateToUBSAdminPage()
                .clickViewTable()
                .readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, EXPECTEDTQ224UA);
    }


    /**
     * TQ-236
     * [UBS admin] Verify displaying comment of "Коментар до замовлення від клієнта" column
     */
    @Test
    public void VerifyDisplayingCommentColumn() {
        String result = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .clearSearchField()
                .setSearchField("1548")
                .getTableRow()
                .getCommentToAddressText();
        Assert.assertEquals(result, COMMENT_TO_ADDRESS_CELL_FOR_TQ236);
    }
}
