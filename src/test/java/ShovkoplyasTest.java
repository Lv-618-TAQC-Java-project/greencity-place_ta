import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShovkoplyasTest extends TestRunner {
    @Test
    public void testSortingDescending(){
        new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUbsCourierButton()
                .clickCallUpTheCourierButton().setNumberOfPackages("2", "2", "2")
                .clickNextButton()
                .setPersonalData("TestNameVolodumur","TestSurnameVolodumur","0938111111","TestEmail@test.com")
                .clickNextButton()
                .clickOrderButton()
                .acceptAlert()
                .setNumberOfCard("4444555566661111")
                .setCvvOfCard("123")
                .setDateOfTheEndCard("1224")
                .setEmail("testEmailCard@gmail.com")
                .clickPayButton()
                .clickContinueButton();
    }
}
