import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DirectTests extends TestRunner {
    private WebDriverWait wait;

    //TQ-221
    @Test
    public void verifyAddressColumnFromOrder() {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("a.header_sign-in-link.tertiary-global-button")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("howiv47374@nenekbet.com");
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).clear();
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).click();
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).sendKeys("Test-User123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@class='header_user-name']")).click();
        driver.findElement(By.xpath("//li[@role='navigation to ubs']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1468");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='1468']")));
        WebElement address = driver.findElement(By.xpath("//mat-cell[@class='mat-cell cdk-cell column.field cdk-column-address mat-column-address ng-star-inserted']"));
        String expectedAddress = "Kiev, Tarasa Shevchenko Blvd, 8, 8,"; // Кома має бути чи ні
        Assert.assertEquals(address.getText(), expectedAddress);
    }


    //TQ-224 [UBS admin]Verify UI of "Вид таблиці" dropdown
    @Test
    public void VerifyUIOfDropdown() {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("a.header_sign-in-link.tertiary-global-button")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("howiv47374@nenekbet.com");
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).clear();
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).click();
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).sendKeys("Test-User123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@class='header_user-name']")).click();
        driver.findElement(By.xpath("//li[@role='navigation to ubs']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='ng-star-inserted']")));
        driver.findElement(By.xpath("//button[@class='view-table-btn']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//li[@class='ng-star-inserted']"));
        for (WebElement e : list) {
            System.out.println(e.getText());
        }
        // Де мокап англ?
    }


    //TQ-219 [UBS admin] Verify that data for "Коментар до адреси від клієнта" column received from order form.
    @Test
    public void VerifyDataForColumnReceivedFromOrderForm() {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("a.header_sign-in-link.tertiary-global-button")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("howiv47374@nenekbet.com");
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).clear();
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).click();
        driver.findElement(By.xpath("//input[@name='form-control password-signin']")).sendKeys("Test-User123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@class='header_user-name']")).click();
        driver.findElement(By.xpath("//li[@role='navigation to ubs']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1470");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='1470']")));
        WebElement actualComment = driver.findElement(By.xpath("//mat-cell[@class='mat-cell cdk-cell column.field cdk-column-comment_for_order_by_client mat-column-comment_for_order_by_client ng-star-inserted'] /div /span"));
        String expected = "This is test comment for test case \"Коментар до адреси від клієнта\"";
        Assert.assertEquals(actualComment.getText(), expected);
    }
}
