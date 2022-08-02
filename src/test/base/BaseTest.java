package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.ExtentManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected static ExtentManager reportManager;
    String configFilePath = "src/test/data/config/config.properties";

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver(Method method) {
        initializeDriver(ConfigReader.readProperty(configFilePath, "browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        reportManager.createTestReport(driver, method);

        driver.get(ConfigReader.readProperty(configFilePath, "url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        reportManager.closeTestReport(result);
        driver.close();
    }

    @BeforeSuite(alwaysRun = true)
    public void startReporter() {
        reportManager = new ExtentManager();
        reportManager.createReport();
    }

    @AfterSuite(alwaysRun = true)
    public void closeReporter() {
        reportManager.closeReporter();
    }


    public void initializeDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
        }
    }


}
