import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.LoginPage;

public class SomeTests extends Base implements SomeTestsDataProvider {
    String greenCityUrl = "https://ita-social-projects.github.io/GreenCityClient/#/";

    @BeforeMethod
    public void setUp() {
        driver = initializeDriver();
        driver.get(greenCityUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

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
    public void logInWithAdminCredentials(String adminEmail, String adminPassword) throws InterruptedException {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getSignInButton().click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getSignInButton().click();
        loginPage.getEmailField().clear();
        loginPage.getPasswordField().clear();
        loginPage.getEmailField().sendKeys(adminEmail);
        loginPage.getPasswordField().sendKeys(adminPassword);
        loginPage.getSignInButton().click();
        Thread.sleep(5000);
    }
}
