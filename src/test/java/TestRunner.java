import com.ita.edu.greencity.tools.PropertiesProvider;
import com.ita.edu.greencity.ui.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.*;


public abstract class TestRunner {

    protected WebDriver driver;
    PropertiesProvider propertiesProvider = new PropertiesProvider();

    private void initializeDriver() {
        switch (propertiesProvider.getBrowser()) {
            case "chrome": {
                chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "opera": {
                operadriver().setup();
                driver = new OperaDriver();
                break;
            }
            case "edge": {
                edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid browser");
            }
        }
    }


    @BeforeClass
    public void beforeClass() {
        initializeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void afterClass() {
        if (driver != null) driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        driver.get(propertiesProvider.getBaseUrl());
    }

    @AfterMethod
    public void toQuit() {
        driver.get(propertiesProvider.getBaseUrl());
        new HomePage(driver)
                .getHeaderPage()
                .logOut();
    }

}
