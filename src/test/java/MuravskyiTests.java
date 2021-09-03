import com.ita.edu.greencity.tools.jdbc.entity.OrdersEntity;
import com.ita.edu.greencity.tools.jdbc.services.OrderService;
import com.thoughtworks.qdox.model.expression.Or;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.ita.edu.greencity.ui.pages.HeaderPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MuravskyiTests extends TestRunner implements SomeTestsDataProvider {
//    private static OrderService orderService = new OrderService();


//    @BeforeClass
//    public void beforeClass() {
//        OrdersEntity ordersEntity = new OrdersEntity();
//        ordersEntity.setCalcellationComment("This is comment");
//        orderService.createOrder(ordersEntity);
//    }

    /**
     * TQ-221
     * [UBS admin] Verify that data for "Address" column received from order form.
     */
    @Test(dataProvider = "adminCredentials")
    public void verifyAddressColumnFromOrder(String adminEmail, String adminPassword) {
        String actualAddress = "";
        new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                clearSearchField().
                setSearchField("1485");

    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With English
     */
    @Test(dataProvider = "adminCredentials")
    public void VerifyUIOfDropdown(String adminEmail, String adminPassword) {
        ArrayList expectedTQ224 = new ArrayList<>(Arrays.asList("orderid", "order_status", "order_date", "clientname", "phone_number", "email", "violations",
                "district", "address", "recipient_name", "recipient_phone", "recipient_email", "comment_to_address_for_client", "garbage_bags_120_amount",
                "bo_bags_120_amount", "bo_bags_20_amount", "total_order_sum", "order_certificate_code", "order_certificate_points", "amount_due",
                "comment_for_order_by_client", "payment_system", "date_of_export", "time_of_export", "id_order_from_shop", "receiving_station", "responsible_manager",
                "responsible_logic_man", "responsible_driver", "responsible_navigator", "comments_for_order"));
        List<String> actual = new ArrayList<>();
        actual = new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                clickViewTable().
                readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, expectedTQ224);
    }

    /**
     * TQ-224
     * [UBS admin] Verify UI of "Вид таблиці" dropdown
     * With Ukrainian
     */
    @Test(dataProvider = "adminCredentials")
    public void VerifyUIOfDropdownWithUaLanguage(String adminEmail, String adminPassword) {
        ArrayList expectedTQ224UA = new ArrayList<>(Arrays.asList("Номер замовлення", "Статус замовлення", "Дата замовлення", "Ім’я клієнта", "Телефон", "Email", "Кількість порушень",
                "Ім’я отримувача", "Телефон отримувача", "Email отримувача", "Район", "Адреса", "Коментар до адреси від клієнта", "Кількість пакетів сміття",
                "Кількість пакетів БО (120 л)", "Кількість пакетів БО (20 л)", "№ сертифіката", "Загальна сума знижки", "Оплата", "Коментар клієнта до замовлення",
                "Дата вивезення", "Час вивезення", "Станція приймання", "№ замовлення з магазину", "ВІдповідальний менеджер", "Відповідальний логіст", "ВІдповідальний кур’єр",
                "ВІдповідальний штурман", "ВІдповідальний штурман"));
        List<String> actual = new ArrayList<>();
        actual = new HeaderPage(driver).
                switchLanguageToUa().
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                clickViewTable().
                readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, expectedTQ224UA);
    }
}
