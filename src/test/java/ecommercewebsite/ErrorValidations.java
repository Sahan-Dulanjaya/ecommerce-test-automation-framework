package ecommercewebsite;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ecommercewebsite.TestComponents.BaseTest;
import ecommercewebsite.TestComponents.Retry;
import ecommercewebsite.pageObjects.CartPage;
import ecommercewebsite.pageObjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

    @Test(groups={"ErrorHandling"}, retryAnalyzer = Retry.class)

    public void loginErrorValidation() throws IOException {

        landingPage.loginApplication("anshdgfgdkaa@gmail.com", "sgaga");
        Assert.assertEquals("Incorect email or password.", landingPage.getErrorMessage());

    }

    @Test

    public void productErrorValidation() throws IOException {

        String email = "rahulshettyacademy@outlook.com";
        String password = "RahulShetty#3";
        String productName = "ZARA COAT 3";
        String country = "united kingdom";

        landingPage.loginApplication(email, password);

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> items = productCatalogue.getProductList();
        productCatalogue.addProductToCard(productName);
        productCatalogue.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.confirmSelection(productName);
        cartPage.gotoCheckout();
        Assert.assertFalse(false);
    }

}