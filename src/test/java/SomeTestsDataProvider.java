import org.testng.annotations.DataProvider;

public interface SomeTestsDataProvider {

    @DataProvider(name = "adminCredentials")
    static Object[][] adminCredentials() {
        return new Object[][]{
                {"howiv47374@nenekbet.com", "Test-User123"}
        };
    }
}
