import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;


public class SomeTests extends TestRunner implements SomeTestsDataProvider {



    @Test
    public void switchLanguages() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getButtonLanguage().click();
        headerPage.getButtonUa().click();
        headerPage.getButtonLanguage().click();
        headerPage.getButtonRu().click();
        headerPage.getButtonLanguage().click();
        headerPage.getButtonEn().click();
        driver.quit();
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
}
