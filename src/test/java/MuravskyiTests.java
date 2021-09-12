import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MuravskyiTests extends TestRunner {
    String ADDRESSTQ221 = "Kiev, Tarasa Shevchenko Blvd, 8, 8";
    String COMMENT_TO_ADDRESS_CELL_FOR_TQ236 = "This is test comment for test case";
    ArrayList<String> EXPECTEDTQ224EN = new ArrayList<>(Arrays.asList("orderid", "order_status", "order_date", "clientname", "phone_number", "email", "violations",
            "district", "address", "recipient_name", "recipient_phone", "recipient_email", "comment_to_address_for_client", "garbage_bags_120_amount",
            "bo_bags_120_amount", "bo_bags_20_amount", "total_order_sum", "order_certificate_code", "order_certificate_points", "amount_due",
            "comment_for_order_by_client", "payment_system", "date_of_export", "time_of_export", "id_order_from_shop", "receiving_station", "responsible_manager",
            "responsible_logic_man", "responsible_driver", "responsible_navigator", "comments_for_order"));
    ArrayList EXPECTEDTQ224UA = new ArrayList<>(Arrays.asList("Номер замовлення", "Статус замовлення", "Дата замовлення", "Ім’я клієнта", "Телефон", "Email", "Кількість порушень",
            "Ім’я отримувача", "Телефон отримувача", "Email отримувача", "Район", "Адреса", "Коментар до адреси від клієнта", "Кількість пакетів сміття",
            "Кількість пакетів БО (120 л)", "Кількість пакетів БО (20 л)", "№ сертифіката", "Загальна сума знижки", "Оплата", "Коментар клієнта до замовлення",
            "Дата вивезення", "Час вивезення", "Станція приймання", "№ замовлення з магазину", "ВІдповідальний менеджер", "Відповідальний логіст", "ВІдповідальний кур’єр",
            "ВІдповідальний штурман", "ВІдповідальний штурман"));
    /**
     * TQ-221
     */
    @Test
    public void verifyAddressColumnFromOrder() {
        String result = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clearSearchField()
                .setSearchField("1504")
                .getTableRow()
                .getAddressText();
        Assert.assertEquals(result, ADDRESSTQ221);
    }

    /**
     * TQ-224
     */
    @Test
    public void VerifyUIOfDropdownEn() {
        List<String> actual = new ArrayList<>();
        actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickViewTable()
                .readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, EXPECTEDTQ224EN);
    }

    /**
     * TQ-224
     */
    @Test
    public void VerifyUIOfDropdownUa() {
        List<String> actual = new ArrayList<>();
        actual = new HomePage(driver)
                .getHeaderPage()
                .chooseLanguageUa()
                .logIn()
                .navigateToUBSAdminPage()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickViewTable()
                .readAllCheckBoxNames(actual);
        System.out.println(actual);
        Assert.assertEquals(actual, EXPECTEDTQ224UA);
    }


    /**
     * TQ-236
     */
    @Test
    public void VerifyDisplayingCommentColumn() {
        String result = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clearSearchField()
                .setSearchField("1548")
                .getTableRow()
                .getCommentToAddressText();
        Assert.assertEquals(result, COMMENT_TO_ADDRESS_CELL_FOR_TQ236);
    }
}
