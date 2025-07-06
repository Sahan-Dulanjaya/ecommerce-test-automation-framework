package rahulshettyacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    public CartPage(WebDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    By visibleItem = By.cssSelector(".cartSection h3");

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartItems;

    @FindBy(xpath = "//div[contains(@class,'subtotal')]//button")
    WebElement checkoutBtn;

    public void confirmSelection(String productName){

        waitForElementToAppear(visibleItem);

        Boolean match = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));

        Assert.assertTrue(match);

    }

    public void gotoCheckout(){

        checkoutBtn.click();

    }



}
