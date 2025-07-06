package ecommercewebsite.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommercewebsite.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

    WebDriver driver;

    public CheckoutPage(WebDriver driver){

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".form-group input")
    private WebElement countryField;

    @FindBy(css = "button[class*='ng-star-inserted']")
    private List<WebElement> searchResults;

    @FindBy(css = ".action__submit")
    private WebElement orderBtn;

    By visibleItem = By.cssSelector("button[class*='ng-star-inserted']");

    public void selectCountry(String country){

        countryField.sendKeys(country);
        waitForElementToAppear(visibleItem);

        searchResults.stream().forEach(searchResult -> System.out.println(searchResult.getText()));

        WebElement search = searchResults.stream().filter(searchResult -> searchResult.getText().equalsIgnoreCase(country)).findFirst().orElse(null);

        search.click();

        orderBtn.click();

    }

}
