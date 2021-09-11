import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.annotations.Test;

public class ShovkoplyasTest extends TestRunner {
    @Test
    public void testSortingDescending(){
        DataBaseConnection b = new DataBaseConnection();


        int order_id = 1595;
        String userName = "TestNameVolodumur";
        String last_name = "TestSurnameVolodumur";
        String phone_number = "+380938111111";
        String executeSearchId = "select id from ubs_user where first_name = '"+userName+"' and last_name ='"+last_name+"' and phone_number = '"+phone_number+"' limit 1;";
        //String result = b.SelectStatement(executeSearchId);

        String str = "select id from orders where id='"+order_id+"';";
        String order_bag_mapping = "DELETE FROM order_bag_mapping WHERE order_id ='"+order_id+"';";
        String order_additional = "delete from order_additional  where orders_id ='"+order_id+"';";
        String certificate = "delete from certificate where order_id ='"+order_id+"';";
        String order_employee = "delete from order_employee where order_id ='"+order_id+"';";
        String payment = "delete from payment where order_id ='"+order_id+"';";
        String MainDeleteOrders = "delete from orders where id ='"+order_id+"';";
        new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUbsCourierButton()
                .clickCallUpTheCourierButton().setNumberOfPackages("2", "2", "2")
                .clickNextButton()
                .setPersonalData(userName,"TestSurnameVolodumur","0938111111","TestEmail@test.com")
                .clickNextButton()
                .clickOrderButton()
                .acceptAlert()
                .setNumberOfCard("4444555566661111")
                .setCvvOfCard("123")
                .setDateOfTheEndCard("1224")
                .setEmail("testEmailCard@gmail.com")
                .clickPayButton()
                .clickContinueButton();
        b.SelectStatement(executeSearchId);
//        b.SelectStatement(order_additional);
//        b.SelectStatement(certificate);
//        b.SelectStatement(order_employee);
//        b.SelectStatement(payment);
//        b.SelectStatement(MainDeleteOrders);
        //b.SelectStatement(str);
    }
}
