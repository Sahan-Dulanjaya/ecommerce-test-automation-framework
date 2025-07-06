package ecommercewebsite.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommercewebsite.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='card']")
    List<WebElement> items;

    By itemsBy = By.xpath("//div[@class='card']//b");

    By addToCart = By.xpath(".//i[contains(@class,'shopping-cart')]");

    By toastMessage = By.cssSelector("#toast-container");

    @FindBy(tagName = "ngx-spinner")
    WebElement spinner;

    @FindBy(css = "[routerlink='/dashboard/cart']")
    WebElement cartIcon;

    public List<WebElement> getProductList() {

        waitForElementToAppear(itemsBy);
        return items;

    }

    public WebElement getItemByName(String productName) {

        WebElement prod = items.stream()
                .filter(item -> item.findElement(By.xpath(".//b")).getText().equals(productName)).findFirst()
                .orElse(null);

        return prod;

    }

    public void addProductToCard(String productName){

        WebElement prod = getItemByName(productName);
        System.out.println(prod.getText());
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDissapear(spinner);
        
    }

    public void goToCart(){
        cartIcon.click();
    }


}
