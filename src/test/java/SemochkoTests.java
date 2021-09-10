import com.ita.edu.greencity.ui.pages.HeaderPage;
import org.testng.annotations.Test;

public class SemochkoTests extends TestRunner{
    @Test
    public void verifyCertificateCorrectness(){

        new HeaderPage(driver)
                .logIn()
                .clickOnUbsCourierButton()
                .clickCallUpTheCourierButton()
                .setOrderDetails()
                .setPersonalData()
                .clickOrderButton()
                .acceptAlert()
                .setSuccessfulPaymentCredits();
    }
}
