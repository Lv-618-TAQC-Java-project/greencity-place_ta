import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.annotations.Test;

public class ShovkoplyasTest /*extends TestRunner*/{
    @Test
    public void testSortingDescending(){
        DataBaseConnection b = new DataBaseConnection();


//        String userName = "TestNameVolodumur";
//        String last_name = "TestSurnameVolodumur";
//        String phone_number = "+380938111111";
//        String gmail = "TestEmail@test.com";
//        String executeSearchId = "select id from ubs_user where first_name = '"+userName+"' and last_name ='"+last_name+"' and phone_number = '"+phone_number+"' limit 1;";
//        String result = b.SelectStatement(executeSearchId);
//        System.out.println(result);
        //String str = "select id from orders where id='"+result+"';";

        /*String order_bag_mapping = "DELETE FROM order_bag_mapping WHERE order_id ='"+str+"';";
        String order_additional = "delete from order_additional  where orders_id ='"+str+"';";
        String certificate = "delete from certificate where order_id ='"+str+"';";
        String order_employee = "delete from order_employee where order_id ='"+str+"';";
        String payment = "delete from payment where order_id ='"+str+"';";
        String MainDeleteOrders = "delete from orders where id ='"+str+"';";*/
       /*new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUbsCourierButton()
                .clickCallUpTheCourierButton().setNumberOfPackages("2", "2", "2")
                .clickNextButton()
                .setPersonalData(userName,last_name,phone_number,gmail)
                .clickNextButton()
                .clickOrderButton()
                .acceptAlert()
                .setNumberOfCard("4444555566661111")
                .setCvvOfCard("123")
                .setDateOfTheEndCard("1224")
                .setEmail("testEmailCard@gmail.com")
                .clickPayButton()
                .clickContinueButton();*/

        //b.DeleteOrderFromAllTable();

        // b.SelectStatement(str);

        String [] str = b.findOrderId("Barak","Obama","+380931234567","test@gmail.com");
        System.out.println(str[0]+ " "+ str[1]);
    }
}
