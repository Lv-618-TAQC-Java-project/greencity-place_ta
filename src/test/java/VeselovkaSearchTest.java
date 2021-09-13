import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.HomePage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminRowTableComponent;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminTableComponent;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VeselovkaSearchTest extends TestRunner{

    @BeforeMethod
    public void settingUp(){
        new HeaderPage(driver)
                .logIn();
    }

    @Test
    public void testSearchThroughtTable() {
        new HomePage(driver)
                .navigateToUBSOrderTablePage()
                .clearSearchField()
                .setSearchField("1582");

        UBSAdminRowTableComponent row = new UBSAdminTableComponent(driver).getRowById("1582");
        if (row == null)
            Assert.fail();
        else {
            Assert.assertEquals(row.getOrderIdText(), "1582");
        }
    }

    @AfterMethod
    public void toQuit() {
        driver.get(propertiesProvider.getBaseUrl());
        new HomePage(driver)
                .getHeaderPage()
                .logOut();
    }
}
