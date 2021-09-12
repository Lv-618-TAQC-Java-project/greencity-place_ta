import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class NesterovychTest extends TestRunner{

    private final String USER_NAME = "Yurii";
    private final String USER_LAST_NAME = "TestUserSurname";
    private final String USER_PHONE_NUMBER = "0960000000";
    private final String USER_PHONE_NUMBER_FOR_DB = "+38" + USER_PHONE_NUMBER;
    private final String USER_EMAIL = "TestEmailyurii@gmail.com";
    private final String CARD_NUMBER = "4444555566661111";
    private final String CVV = "123";
    private final String CARD_EXPIRE = "1122";


    @Test
    public void VerifyDescendingSortingOfColumnDistrict(){
        List<String> actualResult = new ArrayList<>();
        actualResult = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickSortDistrictButton()
                .clickSortDistrictButton()
                .getUbsAdminTableComponent()
                .getColumnDistrict();

        DataBaseConnection db = new DataBaseConnection();
        db.connectionToDataBase();

        String executeQuery = "select district from ubs_user join address a on ubs_user.address_id = a.id join orders on ubs_user.id = orders.ubs_user_id order by district  desc limit 10;";
        List<String> expectedResult = db.getListFromTable(executeQuery);
        System.out.println("actualResult: ");
        System.out.println(actualResult);
        System.out.println("expectedResult: ");
        System.out.println(expectedResult);

        for (int i = 0; i < actualResult.size(); i++) {
            Assert.assertEquals(actualResult.get(i), expectedResult.get(i));
        }

        db.closeConnection();
    }

    @Test
    public void VerifyAscendingSortingOfColumnDistrict(){
        List<String> actualResult = new ArrayList<>();
        actualResult = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickSortDistrictButton()
                .getUbsAdminTableComponent()
                .getColumnDistrict();

        DataBaseConnection db = new DataBaseConnection();
        db.connectionToDataBase();

        String executeQuery = "select district from ubs_user join address a on ubs_user.address_id = a.id join orders on ubs_user.id = orders.ubs_user_id order by district  limit 10;";
        List<String> expectedResult = db.getListFromTable(executeQuery);
        System.out.println("actualResult: ");
        System.out.println(actualResult);
        System.out.println("expectedResult: ");
        System.out.println(expectedResult);

        for (int i = 0; i < actualResult.size(); i++) {
            Assert.assertEquals(actualResult.get(i), expectedResult.get(i));
        }

        db.closeConnection();
    }

    @Test
    public void VerifyRecipientsEmail() {
        new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickOnUbsCourierButton()
                .clickCallUpTheCourierButton().setNumberOfPackages("2", "2", "2")
                .clickNextButton()
                .setPersonalData(USER_NAME, USER_LAST_NAME, USER_PHONE_NUMBER,USER_EMAIL )
                .clickNextButton()
                .clickOrderButton()
                .acceptAlert()
                .setNumberOfCard(CARD_NUMBER)
                .setCvvOfCard(CVV)
                .setDateOfTheEndCard(CARD_EXPIRE)
                .setEmail(USER_EMAIL)
                .clickPayButton()
                .clickContinueButton();

        DataBaseConnection dataBase = new DataBaseConnection();
        dataBase.connectionToDataBase();
        String [] idAndOrderId = dataBase.findOrderId(USER_NAME, USER_LAST_NAME, USER_PHONE_NUMBER_FOR_DB,USER_EMAIL);
        String orderId = idAndOrderId[0];

        String executeQuery = "select email from ubs_user where id = '" + orderId +"';";
        String actualEmail = dataBase.getElementFromTable(executeQuery);
        String expectedEmail = USER_EMAIL;

        System.out.println("Actual email: ");
        System.out.println(actualEmail);

        System.out.println("Expected email: ");
        System.out.println(expectedEmail);

        dataBase.DeleteOrderFromAllTable(idAndOrderId);

        dataBase.closeConnection();

        Assert.assertEquals(actualEmail, expectedEmail);
    }


}
