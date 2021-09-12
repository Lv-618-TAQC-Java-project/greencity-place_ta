import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShovkoplyasTest extends TestRunner{
    private final int DISPLAY_COUNTER_10 = 10;
    private final int DISPLAY_COUNTER_15 = 15;
    private final int DISPLAY_COUNTER_20 = 20;
    private final String USER_NAME = "TestNameVolodumur";
    private final String USER_LAST_NAME = "TestSurnameVolodumur";
    private final String USER_PHONE_NUMBER = "0938111111";
    private final String USER_PHONE_NUMBER_FOR_DB = "+38" + USER_PHONE_NUMBER;
    private final String USER_EMAIL = "TestEmail@gmail.com";
    private final String CARD_NUMBER = "4444555566661111";
    private final String CVV = "123";
    private final String CARD_EXPIRE = "1122";

    @Test
    public void TestFunctionalityOfDisplayCounterWith10Rows(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        int actualSize = arr.toArray().length;
        Assert.assertEquals(actualSize, DISPLAY_COUNTER_10);
    }
    @Test
    public void TestFunctionalityOfDisplayCounterWith15Rows(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickDisplayCounterDropdown()
                .clickDisplayCounter15()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        int actualSize = arr.toArray().length;
        Assert.assertEquals(actualSize, DISPLAY_COUNTER_15);
    }
    @Test
    public void TestFunctionalityOfDisplayCounterWith20Rows(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickDisplayCounterDropdown()
                .clickDisplayCounter20()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        int actualSize = arr.toArray().length;
        Assert.assertEquals(actualSize, DISPLAY_COUNTER_20);
    }
    @Test
    public void VerifyIsDefaultDescSortingOfColumnOrderNumber(){
        List<String> actual = new ArrayList<>();
        actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .getUbsAdminTableComponent()
                .getColumnOrderID();

        DataBaseConnection db = new DataBaseConnection();
        db.connectionToDataBase();

        String executeQuery = "select id from orders order by id desc limit 10;";
        List<String> expected = db.getListFromTable(executeQuery);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(actual.get(i), expected.get(i));
        }

        db.closeConnection();
    }
    @Test
    public void VerifyDescSortingOfColumnOrderNumber(){
        List<String> actual = new ArrayList<>();
        actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickSortOrderNumberButton()
                .clickSortOrderNumberButton()
                .getUbsAdminTableComponent()
                .getColumnOrderID();

        DataBaseConnection db = new DataBaseConnection();
        db.connectionToDataBase();

        String executeQuery = "select id from orders order by id desc limit 10;";
        List<String> expected = db.getListFromTable(executeQuery);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(actual.get(i), expected.get(i));
        }

        db.closeConnection();
    }
    @Test
    public void VerifyAscSortingOfColumnOrderNumber(){
        List<String> actual;
        actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickSortOrderNumberButton()
                .getUbsAdminTableComponent()
                .getColumnOrderID();

        DataBaseConnection db = new DataBaseConnection();
        db.connectionToDataBase();

        String executeQuery = "select id from orders order by id limit 10;";
        List<String> expected = db.getListFromTable(executeQuery);
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(actual.get(i), expected.get(i));
        }

        db.closeConnection();
    }
    @Test
    public void VerifyRecipientsName() {
        new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUbsCourierButton()
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
        //get user

        DataBaseConnection dataBase = new DataBaseConnection();
        dataBase.connectionToDataBase();
        String [] idAndOrderId = dataBase.findOrderId(USER_NAME, USER_LAST_NAME, USER_PHONE_NUMBER_FOR_DB,USER_EMAIL);
        String orderId = idAndOrderId[0];

        String executeQuery = "select first_name from ubs_user where id = '" + orderId +"';";
        String actualFirstName = dataBase.getElementFromTable(executeQuery);
        String expecterFirstName = USER_NAME;
        System.out.println(actualFirstName);
        System.out.println(expecterFirstName);

        dataBase.DeleteOrderFromAllTable(idAndOrderId);

        dataBase.closeConnection();

        Assert.assertEquals(actualFirstName, expecterFirstName);
    }

    @AfterMethod
    public void toQuit() {
        driver.get(propertiesProvider.getBaseUrl());
        new HomePage(driver)
                .getHeaderPage()
                .logOut();
    }


}