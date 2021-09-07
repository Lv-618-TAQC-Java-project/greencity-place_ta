import com.ita.edu.greencity.ui.pages.HeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestBase extends TestRunner implements Repository {

    @Test
    public void logInWithAdminCredentials() {
        new HeaderPage(driver)
                .clickSignInButton()
                .clearEmailField()
                .setEmailField("howiv47374@nenekbet.com")
                .clearPasswordField()
                .setPasswordField("Test-User123")
                .clickSignInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://ita-social-projects.github.io/GreenCityClient/#/profile/7602");
    }
//    @Test(dataProvider = "adminCredentials")
//    public void verifySearchPlaceholder(String adminEmail, String adminPassword){
//           String result = new HeaderPage(driver).
//                clickSignInButton().
//                clearEmailField().
//                setEmail(adminEmail).
//                clearPasswordField().
//                setPassword(adminPassword).
//                clickSignInButton().
//                clickUserButton().
//                clickUbsAdminButton().
//                getSearchFieldAttribute("placeholder");
//        Assert.assertEquals(result, "Search");
//
//    }
//    @Test(dataProvider = "adminCredentials")
//    public void verifySearchBySearchButton(String adminEmail, String adminPassword){
//        new HeaderPage(driver).
//                clickSignInButton().
//                clearEmailField().
//                setEmail(adminEmail).
//                clearPasswordField().
//                setPassword(adminPassword).
//                clickSignInButton().
//                clickUserButton().
//                clickUbsAdminButton().
//                clickSearchField().
//                setSearchField("1385").
//
//    }
}
