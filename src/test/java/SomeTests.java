import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;


public class SomeTests extends TestRunner implements SomeTestsDataProvider {

    @Test
    public void switchLanguageToUa() throws InterruptedException {
        new HeaderPage(driver).
                clickLanguageButton().
                clickUaLanguage();

    }

    @Test(dataProvider = "adminCredentials")
    public void logInWithAdminCredentials(String adminEmail, String adminPassword) {
        new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://ita-social-projects.github.io/GreenCityClient/#/profile/7602");
    }
    @Test(dataProvider = "adminCredentials")
    public void verifySearchPlaceholder(String adminEmail, String adminPassword){
           String result = new HeaderPage(driver).
                clickSignInButton().
                clearEmailField().
                setEmail(adminEmail).
                clearPasswordField().
                setPassword(adminPassword).
                clickSignInButton().
                clickUserButton().
                clickUbsAdminButton().
                getSearchFieldAttribute("placeholder");
        Assert.assertEquals(result, "Search");

    }
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
