package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

import java.util.List;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='All Topics']")
    public WebElement allTopics_dashboard;

    @FindBy(xpath = "//div[text()='Incorrect username/password']")
    public WebElement errorMsg;

    @FindBy(id = "inputArea1")
    public WebElement dosInput;

    @FindBy(xpath = "//button[text()='Add do ']")
    public WebElement addDoBtn;

    @FindBy(xpath = "//button[text()='Enter']")
    public WebElement enterBtn;

    @FindBy(xpath = "//div[@class='row DoAndDontsContent']/div[1]//div[contains(@class, 'col-md-7 txt')]")
    public List<WebElement> allDoElements;

    @FindBy(xpath = "//div[@class='row DoAndDontsContent']/div[2]//div[contains(@class, 'col-md-7 txt')]")
    public List<WebElement> allDontElements;

    @FindBy(xpath = "//button[@class='btn btn-outline-success']")
    public List<WebElement> allLikeBtn;


    public boolean doesStatementExist(String statement){
        for(WebElement element: allDoElements){
            if (getText(element).equalsIgnoreCase(statement))
                return true;
        }
        return false;
    }

    public void addStatement(String statement){
        click(addDoBtn);
        click(dosInput);
        sendKeys(dosInput, statement);
        click(enterBtn);
    }

    public void clickLastLikeBtn(){
        click(allLikeBtn.get(allLikeBtn.size()));
    }

    public boolean isDashboardDisplayed(String dashboardName){
        return driver.findElement(By.xpath("//a/button[text()='" + dashboardName + "']")).isDisplayed();
    }

}
