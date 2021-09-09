import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class KovalchukTests extends TestRunner implements Repository{

    @DataProvider(name = "orderDateDataProvider")
    static Object[][] orderDateDataProvider() {
        Object[][] testData = new Object[][]{
                {"1561", "09/09/2021"},
                {"1553", "09/09/2021"},
                {"1469", "31/08/2021"},
                {"1459", "27/08/2021"},
                {"1407", "14/08/2021"}
        };
        return testData;
    }

    @DataProvider(name = "сlientNameDataProvider")
    static Object[][] сlientNameDataProvider(){
        Object[][] testData= new Object[][]{
                {"1561", true},
                {"1553", true},
                {"1469", true},
                {"1459", true},
                {"1407", true}
        };
        return testData;
    }

    @Test(dataProvider = "orderDateDataProvider")
    public void verifyTheDateFormatInTheOrderDate(String input, String expected){
        String result = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .clearSearchField()
                .setSearchField(input)
                .getTableRow()
                .getOrderDate();

        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "сlientNameDataProvider")
    public void verifyTheLenghtInTheNameCustomer(String input, boolean expected){
        boolean result = false;
        String actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .clearSearchField()
                .setSearchField(input)
                .getTableRow()
                .getClientName();
        if(actual.length() < 30){
             result = true;
        }
        Assert.assertEquals(result, expected);
    }

    @AfterMethod
    public void toQuit(){
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/");
        new HomePage(driver)
                .getHeaderPage()
                .logOut();
    }
}
