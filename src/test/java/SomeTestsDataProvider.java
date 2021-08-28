import org.testng.annotations.DataProvider;

public interface SomeTestsDataProvider {

    @DataProvider(name = "adminCredentials")
    public static Object[][] adminCredentials() {
        return new Object[][]{
                {"https://ita-social-projects.github.io/GreenCityClient/#/", "howiv47374@nenekbet.com", "Test-User123"}
        };
    }
}
