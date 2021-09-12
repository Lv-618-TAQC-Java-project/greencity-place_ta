import com.ita.edu.greencity.tools.jdbc.DataBaseConnection;
import com.ita.edu.greencity.ui.pages.HeaderPage;
import com.ita.edu.greencity.ui.pages.HomePage;
import com.ita.edu.greencity.ui.pages.MySpacePage;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminRowTableComponent;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminTableComponent;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VeselovskaTests extends TestRunner{

    @BeforeMethod
    public void settingUp(){
        new HeaderPage(driver)
                .logIn();
    }

    @Test
    public void testAmountDueValue(){
        new MySpacePage(driver)
                .getHeaderPage()
                .clickOnUbsCourierButton()
                .clickCallUpTheCourierButton()
                .setNumberOfPackagesOldClothesVolume120Field("30")
                .setFirstCertificateNumber("12121212")
                .clickActivateCertificateButton()
                .clickAddCertificateButton()
                .setSecondCertificateNumber("12345678")
                .clickSecondActivateCertificateButton()
                .clickNextButton()
                .setPersonalData()
                .clickOrderButton()
                .acceptAlert()
                .setSuccessfulPaymentCredits();
        new HomePage(driver)
                .navigateToUBSOrderTablePage()
                .clickDisplayCounterDropdown()
                .clickDisplayCounter20()
                .clearSearchField()
                .setSearchField("ThisNameIsForTest");
        long[] results = getActualAndExpectedAmountDue();

        Assert.assertEquals(isFloatWithTwoDigits(),true);
        Assert.assertEquals(results[0], results[1]);
    }

//    @Test
//    public void testAmountDueValue2(){
//        new HomePage(driver)
//                .navigateToUBSOrderTablePage()
//                .clickDisplayCounterDropdown()
//                .clickDisplayCounter20()
//                .clearSearchField()
//                .setSearchField("IvannaVesTest");
//        long[] results = getActualAndExpectedAmountDue();
//
//        Assert.assertEquals(isFloatWithTwoDigits(),true);
//        Assert.assertEquals(results[0], results[1]);
//    }

    @Test
    public void testOrderCertificatePoints(){

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

//    @AfterMethod
//    private void deleteTestDataFromDatabase() {
//        String userName = "ThisNameIsForTest";
//        String userLastName = "String";
//        String userPhoneNumberForDb = "+380938607879";
//        String userEmail = "testmail@mail.com";
//
//        DataBaseConnection dataBase = new DataBaseConnection();
//        dataBase.connectionToDataBase();
//
//        dataBase.DeleteOrderFromAllTable(
//                dataBase.findOrderId(userName, userLastName, userPhoneNumberForDb, userEmail));
//
//        dataBase.closeConnection();
//    }

    private long[] getActualAndExpectedAmountDue(){
        UBSAdminRowTableComponent rowTableComponent
                = new UBSAdminTableComponent(driver)
                .getRows()
                .get(0);
        long totalOrderSum = rowTableComponent.getTotalOrderSumValue();
        long orderCertificatePoints = rowTableComponent.getOrderCertificatePointsValue();
        long amountDue = Long.parseLong(rowTableComponent.getAmountDue().getText());
        if(totalOrderSum <= orderCertificatePoints)
            return new long[]{amountDue, 0};
        return new long[] {amountDue, totalOrderSum - orderCertificatePoints};
    }

    private boolean isFloatWithTwoDigits(){
        UBSAdminRowTableComponent rowTableComponent
                = new UBSAdminTableComponent(driver)
                .getRows()
                .get(0);
        if(rowTableComponent == null)
            return false;
        String amountDue = rowTableComponent.getAmountDue().getText();
        try {
            Double.parseDouble(amountDue);
        }catch (NumberFormatException e){
            return false;
        }
        if (amountDue.charAt(amountDue.length() - 3) != '.')
            return false;
        return true;
    }
}
