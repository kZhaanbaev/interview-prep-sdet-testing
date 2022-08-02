package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    public void logIn(String username, String password){
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void logIn(){
        emailInput.sendKeys(ConfigReader.readProperty("src/test/data/config/config.properties", "username"));
        passwordInput.sendKeys(ConfigReader.readProperty("src/test/data/config/config.properties", "password"));
        loginBtn.click();
    }
}
