package rahulshettyacademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.CheckoutPage;
import rahulshettyacademy.pageObjects.OrderHistoryPage;
import rahulshettyacademy.pageObjects.OrderPage;
import rahulshettyacademy.pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

        String email = "rahulshettyacaffdemy@outlook.com";
        String password = "RahulShetffty#3";
        String productName = "ZARA COAT 3";
        String country = "united kingdom";

        @Test(dataProvider = "getData", groups = { "Purchase" })

        public void submitOrder(HashMap<String, String> map) throws IOException {

                landingPage.loginApplication(map.get("email"), map.get("password"));

                ProductCatalogue productCatalogue = new ProductCatalogue(driver);
                List<WebElement> items = productCatalogue.getProductList();
                productCatalogue.addProductToCard(map.get("productName"));
                productCatalogue.goToCart();

                CartPage cartPage = new CartPage(driver);
                cartPage.confirmSelection(map.get("productName"));
                cartPage.gotoCheckout();

                CheckoutPage checkoutPage = new CheckoutPage(driver);
                checkoutPage.selectCountry(country);

                OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
                orderHistoryPage.confirmOrder();

        }

        @Test(dependsOnMethods = { "submitOrder" })
        public void OrderHistoryTest() {

                landingPage.loginApplication(email, password);
                ProductCatalogue productCatalogue = new ProductCatalogue(driver);
                OrderPage orderPage = productCatalogue.goToOrderPage();
                Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

        }

        @DataProvider
        public Object[][] getData() throws IOException {



                // HashMap<String, String> map = new HashMap<String, String>();
                // map.put("email", "rahulshettyacademy@outlook.com");
                // map.put("password", "RahulShetty#3");
                // map.put("productName", "ZARA COAT 3");

                // HashMap<String, String> map1 = new HashMap<String, String>();
                // map1.put("email", "shetty@gmail.com");
                // map1.put("password", "Iamking@000");
                // map1.put("productName", "ADIDAS ORIGINAL");
                
                List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
                return new Object[][] { { data.get(0) }, { data.get(1) } };

        }

        

}
