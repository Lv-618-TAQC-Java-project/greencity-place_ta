import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HeaderPage;
import pageObjects.LoginPage;

public class SomeTests extends Base implements SomeTestsDataProvider{
    String greenCityUrl = "https://ita-social-projects.github.io/GreenCityClient/#/";


    @Test
    public void switchLanguages() {
        driver = initializeDriver();
        driver.get(greenCityUrl);
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
    public void logInWithAdminCredentials(String url, String adminEmail, String adminPassword) throws InterruptedException {
        driver = initializeDriver();
        driver.get(url);
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
        driver.quit();
    }
}
