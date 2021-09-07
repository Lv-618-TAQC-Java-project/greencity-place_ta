import com.ita.edu.greencity.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShcherbakovTests extends TestRunner {

    @Test
    public void clickCheckboxTest() {
        boolean actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminCommon()
                .getUbsAdminRowTableComponent()
                .clickOnCheckbox()
                .isSelectedCheckBox();
        Assert.assertTrue(actual);
    }

}
