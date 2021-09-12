import com.ita.edu.greencity.ui.pages.HomePage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminRowTableComponent;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ShovkoplyasTest extends TestRunner{
    private final int DISPLAY_COUNTER_10 = 10;
    private final int DISPLAY_COUNTER_15 = 15;
    private final int DISPLAY_COUNTER_20 = 20;
    @Test
    public void TestFunctionalityOfDisplayCounterWith10Rows(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        int actualSize = arr.toArray().length;
        Assert.assertEquals(actualSize, DISPLAY_COUNTER_10);
    }
    @Test
    public void TestFunctionalityOfDisplayCounterWith15Rows(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickDisplayCounterDropdown()
                .clickDisplayCounter15()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        int actualSize = arr.toArray().length;
        Assert.assertEquals(actualSize, DISPLAY_COUNTER_15);
    }
    @Test
    public void TestFunctionalityOfDisplayCounterWith20Rows(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickDisplayCounterDropdown()
                .clickDisplayCounter20()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        int actualSize = arr.toArray().length;
        Assert.assertEquals(actualSize, DISPLAY_COUNTER_20);
    }
    @Test
    public void VerifyIsDefaultDescSortingOfColumnOrderNumber(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        System.out.println(arr.toString());
    }
    @Test
    public void VerifyDescSortingOfColumnOrderNumber(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickSortOrderNumberButton()
                .clickSortOrderNumberButton()
                .clickSortOrderNumberButton()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        System.out.println(arr.toString());
    }
    @Test
    public void VerifyAscSortingOfColumnOrderNumber(){
        List<String> arr = new ArrayList<>();
        arr = new HomePage(driver)
                .getHeaderPage()
                .logIn()
                .getHeaderPage()
                .clickUserButton()
                .clickUbsAdminButton()
                .getAdminMenu()
                .getUBSAdminOrders()
                .clickSortOrderNumberButton()
                .getUbsAdminTableComponent()
                .getColumnOrderID();
        System.out.println(arr.toString());
    }
//    @Test
//    public void VerifyRecipientsName(){
//
//    }
    @AfterMethod
    public void toQuit(){
        driver.get(propertiesProvider.getBaseUrl());
        new HomePage(driver)
                .getHeaderPage()
                .logOut();
    }
}