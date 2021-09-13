package com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage;

import com.ita.edu.greencity.ui.locators.ubsAdminLocator.ubsAdminPageLocator.UBSAdminTableComponentLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminRowTableComponent;
import com.ita.edu.greencity.ui.pages.ubsAdmin.ubsAdminPage.UBSAdminCommon;
import java.util.ArrayList;
import java.util.List;

public class UBSAdminTableComponent extends UBSAdminCommon {
    private List<UBSAdminRowTableComponent> rows;

    public UBSAdminTableComponent(WebDriver driver) {
        super(driver);
    }

    public List<UBSAdminRowTableComponent> getRows() {
        rows = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(UBSAdminTableComponentLocator.ROW.getPath());
        for (WebElement element: webElements) {
            rows.add(new UBSAdminRowTableComponent(driver, element));
        }
        return rows;
    }
    public List<String> getColumnOrderID() {
        List<String>rows = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(UBSAdminTableComponentLocator.COLUMN_ORDER_ID.getPath());
        for (WebElement element: webElements) {
            rows.add(element.getText());
        }
        return rows;
    }

    public List<String> getColumnDistrict() {
        List<String> rows = new ArrayList<>();
        List<WebElement> webElements = driver.findElements(UBSAdminTableComponentLocator.COLUMN_DISTRICT.getPath());
        for (WebElement element: webElements) {
            rows.add(element.getText());
        }
        return rows;
    }

    public UBSAdminRowTableComponent getRowById(String id){
        getRows();
        if(rows.size() == 0)
            return null;
        for (UBSAdminRowTableComponent row : rows) {
            if (row.getOrderIdText().equals(id))
                return row;
        }
        return null;
    }

    public long[] getActualAndExpectedAmountDue(){
        UBSAdminRowTableComponent rowTableComponent
                = this
                .getRows()
                .get(0);
        long totalOrderSum = rowTableComponent.getTotalOrderSumValue();
        long orderCertificatePoints = rowTableComponent.getOrderCertificatePointsValue();
        long amountDue = Long.parseLong(rowTableComponent.getAmountDue().getText());
        if(totalOrderSum <= orderCertificatePoints)
            return new long[]{amountDue, 0};
        return new long[] {amountDue, totalOrderSum - orderCertificatePoints};
    }

    public boolean isAmountDueFloatWithTwoDigits(){
        UBSAdminRowTableComponent rowTableComponent
                = this
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

    public boolean isOrderCertificatePointsPositiveInteger(){
        UBSAdminRowTableComponent rowTableComponent
                = this
                .getRows()
                .get(0);
        if(rowTableComponent == null)
            return false;
        String orderCertificatePoints = rowTableComponent.getOrderCertificatePoints().getText();
        try {
            if (Integer.parseInt(orderCertificatePoints) < 0)
                return false;
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
