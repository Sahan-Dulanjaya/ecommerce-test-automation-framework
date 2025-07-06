package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageObjects.OrderPage;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {

        this.driver = driver;

    }

    @FindBy(css = "button[routerlink='/dashboard/myorders']")
    WebElement OrderHistoryBtn;

    By OrderBtn = By.cssSelector("button[routerlink='/dashboard/myorders']");

    public OrderPage goToOrderPage(){

        waitForElementToAppear(OrderBtn);
        OrderHistoryBtn.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions
                .refreshed(ExpectedConditions.visibilityOfElementLocated(findBy)));

    }

    public void waitForElementToDissapear(WebElement findBy){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.invisibilityOf(findBy));
    }

}
