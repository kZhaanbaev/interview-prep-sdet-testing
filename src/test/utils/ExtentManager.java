package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ExtentManager {
    WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    //should be initialized in @BeforeSuite
    public void createReport(){
        //initiating extent report
        extentReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports.html");

        //adding some configurations
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("My Report");
        spark.config().setReportName("Report Custom Name");
        extentReports.attachReporter(spark);
    }

    //should be called in @AfterSuite
    public void closeReporter() {
        //closing the extent reporter
        extentReports.flush();
    }

    //should be called in @BeforeMethod
    public ExtentTest createTestReport(WebDriver driver, Method method){
        this.driver = driver;
        extentTest = extentReports.createTest(getCustomTestDescription(method));
        logTestGroups(method);
        return extentTest;
    }

    //should be called in @AfterMethod
    public void closeTestReport(ITestResult result){
        //This will capture the result of the Test and log to extentTest report
        if(result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass("Test PASSED");
        }else if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail("Test FAILED");
            logScreenshot();
            extentTest.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test SKIPPED");
            extentTest.fail(result.getThrowable());
        }
    }

    public void logTestGroups(Method method){
        Test testClass = method.getAnnotation(Test.class);
        for(String e: testClass.groups()){
            extentTest.assignCategory(e);
        }
    }

    public String getCustomTestName(Method method){
        Test testClass = method.getAnnotation(Test.class);

        if(testClass.testName().length() > 0)
            return testClass.testName();
        return method.getName();
    }

    public String getCustomTestDescription(Method method){
        Test testClass = method.getAnnotation(Test.class);

        if(testClass.description().length() > 0)
            return testClass.description();
        return method.getName();
    }

    public void logScreenshot(String title){
        extentTest.info(title,
                MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.takeScreenshot(driver)).build());
    }

    public void logScreenshot(){
        extentTest.info(MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.takeScreenshot(driver)).build());
    }
}
