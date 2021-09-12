import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminCommon;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SemochkoTests extends TestRunner{
    @Test
    public void verifyCertificateCorrectness(){
        new HeaderPage(driver)
                .logIn();
//                .clickOnUbsCourierButton()
//                .clickCallUpTheCourierButton()
//                .setOrderDetails()
//                .setPersonalData()
//                .clickOrderButton()
//                .acceptAlert()
//                .setSuccessfulPaymentCredits();
        driver.get("https://ita-social-projects.github.io/GreenCityClient/#/ubs-admin/orders");
        String actualResult = new UBSAdminCommon(driver)
                .setSearchField("ThisNameIsForTest")
                .getTextOfCertificateNumber();
        String expectedResult = propertiesProvider.getFirstCertificateNumber()+"; "+propertiesProvider.getSecondCertificateNumber();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
