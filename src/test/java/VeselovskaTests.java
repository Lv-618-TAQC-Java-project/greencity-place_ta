import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.HomePage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminTableComponent;

import org.testng.Assert;
import org.testng.annotations.*;


public class VeselovskaTests extends TestRunner{
    String userName = "IvannaTestName";
    String userLastName = "String";
    String userPhoneNumberForDb = "+380938607879";
    String userEmail = "testmail@mail.com";
    String firstCertificate = "22225556";
    String secondCertificate = "22225557";

    @BeforeClass
    public void settingUp(){
        driver.get(propertiesProvider.getBaseUrl());
        new HeaderPage(driver)
                .logIn()
                .getHeaderPage()
                .clickOnUbsCourierButton()
                .clickCallUpTheCourierButton()
                .setNumberOfPackagesOldClothesVolume120Field("4")
                .setFirstCertificateNumber(firstCertificate)
                .clickActivateCertificateButton()
                .clickAddCertificateButton()
                .setSecondCertificateNumber(secondCertificate)
                .clickSecondActivateCertificateButton()
                .clickNextButton()
                .setPersonalData(userName, userLastName, userPhoneNumberForDb, userEmail)
                .clickNextButton()
                .clickOrderButton()
                .acceptAlert()
                .setSuccessfulPaymentCredits();
    }

    @Test
    public void testAmountDueValue(){
        new HomePage(driver)
                .navigateToUBSOrderTablePage()
                .clearSearchField()
                .setSearchField(userName);
        long[] results = new UBSAdminTableComponent(driver)
                .getActualAndExpectedAmountDue();

        Assert.assertEquals(new UBSAdminTableComponent(driver).isAmountDueFloatWithTwoDigits(),true);
        Assert.assertEquals(results[0], results[1]);
    }


    @Test
    public void testOrderCertificatePoints(){
        new HomePage(driver)
                .navigateToUBSOrderTablePage()
                .clearSearchField()
                .setSearchField(userName);

        Assert.assertEquals(new UBSAdminTableComponent(driver).isOrderCertificatePointsPositiveInteger(),true);
    }


    @AfterClass
    private void deleteTestDataFromDatabase() {
        driver.get(propertiesProvider.getBaseUrl());
        new HomePage(driver)
                .getHeaderPage()
                .logOut();

        DataBaseConnection dataBase = new DataBaseConnection();
        dataBase.connectionToDataBase();

        dataBase.DeleteOrderFromAllTable(
                dataBase.findOrderId(userName, userLastName, userPhoneNumberForDb, userEmail));

        dataBase.closeConnection();
    }


}
