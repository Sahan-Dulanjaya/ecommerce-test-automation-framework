/*

package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

    public static void main(String[] args) throws InterruptedException {

        String email = "rahulshettyacademy@outlook.com";
        String password = "RahulShetty#3";
        String productName = "ZARA COAT 3";
        String country = "United States";

        WebDriver driver = new ChromeDriver();

        LandingPage landingPage = new LandingPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/client/");

        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(password);

        driver.findElement(By.id("login")).click();

        w.until(ExpectedConditions
                .refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card']//b"))));

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='card']"));

        WebElement prod = items.stream()
                .filter(item -> item.findElement(By.xpath(".//b")).getText().equals(productName)).findFirst()
                .orElse(null);

        System.out.println(prod.getText());

        prod.findElement(By.xpath(".//i[contains(@class,'shopping-cart')]")).click();

        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));

        w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.tagName("ngx-spinner"))));

        driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();

        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));

        Boolean match = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));

        Assert.assertTrue(match);

        driver.findElement(By.xpath("//div[contains(@class,'subtotal')]//button")).click();

        driver.findElement(By.cssSelector(".form-group input")).sendKeys("unit");

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='ng-star-inserted']")));

        List<WebElement> searchResults = driver.findElements(By.cssSelector("button[class*='ng-star-inserted']"));

        WebElement search = searchResults.stream().filter(searchResult -> searchResult.getText().equalsIgnoreCase(country)).findFirst().orElse(null);

        search.click();

        driver.findElement(By.cssSelector(".action__submit")).click();

        System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());

        Assert.assertTrue(driver.findElement(By.cssSelector(".hero-primary")).isDisplayed());

        driver.quit();

    }

}


*/