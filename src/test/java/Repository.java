import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;

public interface Repository {

    ArrayList<String> expectedTQ224En = new ArrayList<>(Arrays.asList("orderid", "order_status", "order_date", "clientname", "phone_number", "email", "violations",
            "district", "address", "recipient_name", "recipient_phone", "recipient_email", "comment_to_address_for_client", "garbage_bags_120_amount",
            "bo_bags_120_amount", "bo_bags_20_amount", "total_order_sum", "order_certificate_code", "order_certificate_points", "amount_due",
            "comment_for_order_by_client", "payment_system", "date_of_export", "time_of_export", "id_order_from_shop", "receiving_station", "responsible_manager",
            "responsible_logic_man", "responsible_driver", "responsible_navigator", "comments_for_order"));

    ArrayList expectedTQ224UA = new ArrayList<>(Arrays.asList("Номер замовлення", "Статус замовлення", "Дата замовлення", "Ім’я клієнта", "Телефон", "Email", "Кількість порушень",
            "Ім’я отримувача", "Телефон отримувача", "Email отримувача", "Район", "Адреса", "Коментар до адреси від клієнта", "Кількість пакетів сміття",
            "Кількість пакетів БО (120 л)", "Кількість пакетів БО (20 л)", "№ сертифіката", "Загальна сума знижки", "Оплата", "Коментар клієнта до замовлення",
            "Дата вивезення", "Час вивезення", "Станція приймання", "№ замовлення з магазину", "ВІдповідальний менеджер", "Відповідальний логіст", "ВІдповідальний кур’єр",
            "ВІдповідальний штурман", "ВІдповідальний штурман"));


    @DataProvider(name = "adminCredentials")
    static Object[][] adminCredentials() {
        return new Object[][]{
                {"howiv47374@nenekbet.com", "Test-User123"}
        };
    }
}
