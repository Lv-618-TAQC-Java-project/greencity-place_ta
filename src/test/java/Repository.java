import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;

public interface Repository {

    ArrayList<String> expectedTQ224En = new ArrayList<>(Arrays.asList("orderid", "order_status", "order_date", "clientname", "phone_number", "email", "violations",
            "district", "address", "recipient_name", "recipient_phone", "recipient_email", "comment_to_address_for_client", "garbage_bags_120_amount",
            "bo_bags_120_amount", "bo_bags_20_amount", "total_order_sum", "order_certificate_code", "order_certificate_points", "amount_due",
            "comment_for_order_by_client", "payment_system", "date_of_export", "time_of_export", "id_order_from_shop", "receiving_station", "responsible_manager",
            "responsible_logic_man", "responsible_driver", "responsible_navigator", "comments_for_order"));

    @DataProvider(name = "expectedViewTableFieldsTQ224")
    static Object[][] expectedViewTableFields() {
        return new Object[][]{
                {"orderid", "order_status", "order_date", "clientname", "phone_number", "email", "violations",
                        "district", "address", "recipient_name", "recipient_phone", "recipient_email", "comment_to_address_for_client", "garbage_bags_120_amount",
                        "bo_bags_120_amount", "bo_bags_20_amount", "total_order_sum", "order_certificate_code", "order_certificate_points", "amount_due",
                        "comment_for_order_by_client", "payment_system", "date_of_export", "time_of_export", "id_order_from_shop", "receiving_station", "responsible_manager",
                        "responsible_logic_man", "responsible_driver", "responsible_navigator", "comments_for_order"}
        };
    }

    @DataProvider(name = "adminCredentials")
    static Object[][] adminCredentials() {
        return new Object[][]{
                {"howiv47374@nenekbet.com", "Test-User123"}
        };
    }


}
