package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    public LoginTest(){
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(testName = "Login test" ,description = "Verify admin can successfully log in with right credentials", groups = {"smokeTest", "regression"})
    public void test01(){
        logScreenshot("Login Page");
        loginPage.logIn();

        Assert.assertTrue(homePage.allTopics_dashboard.isDisplayed());
    }

    @Test(description = "Verify error message is displayed when password is wrong", groups = {"regression"})
    public void test02(){
        loginPage.logIn("admin@yahoo.com", "wrong password");
        logScreenshot("Login Page");

        Assert.assertTrue(homePage.errorMsg.isDisplayed());
    }
}
