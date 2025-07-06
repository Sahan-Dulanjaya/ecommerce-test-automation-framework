package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

    WebDriver driver;

    public LandingPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // WebElement userEmail = driver.findElement(By.id("userEmail"));

    //PageFactory
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(css = "div[class='toast-bottom-right toast-container']")
    WebElement errorMsg;

    By errorToast = By.cssSelector("div[class='toast-bottom-right toast-container']");

    public void loginApplication(String email, String password){

        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        login.click();

    }

    public String getErrorMessage(){

        waitForElementToAppear(errorToast);
        return errorMsg.getText();

    }

    public void goTo(){
        
        driver.get("https://rahulshettyacademy.com/client/");

    }

}
