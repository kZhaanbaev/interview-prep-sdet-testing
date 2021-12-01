package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import data.testData.DataProviders;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Screenshot;

import java.util.ArrayList;
import java.util.List;

public class HomeTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    HomeTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.logIn();
    }

    @Test(description = "Verify user can add a statement", groups = {"regression", "smokeTest"})
    public void test01(){
        String testStatement = "Always be confident in your answers";

        homePage.addStatement(testStatement);
        Assert.assertTrue(homePage.doesStatementExist(testStatement));
    }

    @Test(description = "Verify Like Button is increasing number of likes", groups = "regression")
    public void test02(){
        int initialCount = Integer.parseInt(homePage.getText(homePage.allLikeBtn.get(homePage.allLikeBtn.size()-1)));
        homePage.click(homePage.allLikeBtn.get(homePage.allLikeBtn.size()-1));

        int latestCount = Integer.parseInt(homePage.getText(homePage.allLikeBtn.get(homePage.allLikeBtn.size()-1)));

        Assert.assertTrue(initialCount + 1 == latestCount);
    }

    @Test(description = "Verify all dashboards are displayed", dataProviderClass = DataProviders.class, dataProvider = "dashboards", groups = {"regression"})
    public void test03(String dashboardName){
        Assert.assertTrue(homePage.isDashboardDisplayed(dashboardName));
    }

}
