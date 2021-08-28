import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public WebDriver initializeDriver() {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            switch (browserName) {
                case "chrome": {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/webdriver/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                }
                case "ie": {
                    System.setProperty("webdriver.ie.driver", "src/main/resources/webdriver/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid browser");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        actions = new Actions(driver);
        return driver;
    }
}
