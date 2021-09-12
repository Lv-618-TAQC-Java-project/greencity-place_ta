import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminCommon;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SemochkoTests extends TestRunner {


    @Test
    public void verifyTwoCertificateViewCorrectness() {
        new HeaderPage(driver)
                .logIn()
                .getHeaderPage()
                .clickOnUbsCourierButton()
                .clickCallUpTheCourierButton()
                .setOrderDetails()
                .setPersonalData()
                .clickOrderButton()
                .acceptAlert()
                .setSuccessfulPaymentCredits();
        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/ubs-admin/orders");
        String actualResult = new UBSAdminCommon(driver)
                .setSearchField("ThisNameIsForTest")
                .getTextOfCertificateNumber();
        String expectedResult = propertiesProvider.getFirstCertificateNumber() + "; " + propertiesProvider.getSecondCertificateNumber();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyCertificateTransferCorrectness() {
        new HeaderPage(driver)
                .logIn()
                .getHeaderPage()
                .clickOnUbsCourierButton()
                .clickCallUpTheCourierButton()
                .setNumberOfPackagesOldClothesVolume120Field("30")
                .setFirstCertificateNumber("55555555")
                .clickActivateCertificateButton()
                .clickNextButton()
                .setPersonalData()
                .clickOrderButton()
                .acceptAlert()
                .setSuccessfulPaymentCredits();
        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/ubs-admin/orders");
        String actualResult = new UBSAdminCommon(driver)
                .setSearchField("ThisNameIsForTest")
                .getTextOfCertificateNumber();
        String expectedResult = propertiesProvider.getFirstCertificateNumber();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterMethod
    private void deleteOrderFromDatabase() {
        String USER_NAME = "ThisNameIsForTest";
        String USER_LAST_NAME = "String";
        String USER_PHONE_NUMBER_FOR_DB = "+380938607879";
        String USER_EMAIL = "testmail@mail.com";

        DataBaseConnection dataBase = new DataBaseConnection();
        dataBase.connectionToDataBase();

        dataBase.DeleteOrderFromAllTable(
                dataBase.findOrderId(USER_NAME, USER_LAST_NAME, USER_PHONE_NUMBER_FOR_DB, USER_EMAIL));

        dataBase.closeConnection();
    }
}
