import com.ita.edu.greencity.ui.pages.HomePage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminRowTableComponent;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminTableComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShcherbakovTests extends TestRunner {

    @Test
    public void clickCheckboxTest() {
        boolean actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .getTableRow()
                .clickOnCheckbox()
                .isCheckBoxSelected();

        Assert.assertTrue(actual);
    }

    @Test
    public void clickTableHeadCheckboxTest() {
        boolean actual = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .getTableRow()
                .clickTableHeadCheckbox()
                .isTableHeadCheckBoxSelected();

        Assert.assertTrue(actual);
    }

    @Test
    public void verifyIsAllCheckboxesSelected() {
        List<UBSAdminRowTableComponent> rows = new UBSAdminTableComponent(driver).getRows();
        boolean actual = true;

        new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .navigateToUBSAdminPage()
                .getTableRow()
                .clickTableHeadCheckbox()
                .isTableHeadCheckBoxSelected();

        for (UBSAdminRowTableComponent row: rows) {
            if (!row.isCheckBoxSelected()) {
                actual = false;
            }
        }

        Assert.assertTrue(actual);
    }
}
