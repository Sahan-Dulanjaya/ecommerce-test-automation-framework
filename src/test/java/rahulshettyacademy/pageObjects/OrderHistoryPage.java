package rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderHistoryPage extends AbstractComponents{

    WebDriver driver;

    public OrderHistoryPage(WebDriver driver){
        
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    By visibleText = By.cssSelector(".hero-primary");

    @FindBy(css = ".hero-primary")
    WebElement text;

    public void confirmOrder(){

        waitForElementToAppear(visibleText);
        Assert.assertTrue(text.isDisplayed());

    }

}
