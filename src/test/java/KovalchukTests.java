import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.HomePage;
import com.ita.edu.greencity.ui.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class KovalchukTests extends TestRunner implements Repository{
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
    @AfterMethod
    public void toQuit(){
        driver.navigate().to("https://ita-social-projects.github.io/GreenCityClient/#/");
        new HomePage(driver)
            .getHeaderPage()
                .logOut();
    }

}
