package rahulshettyacademy.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.CheckoutPage;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.OrderHistoryPage;
import rahulshettyacademy.pageObjects.ProductCatalogue;

public class stepDefinitionImplementation extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws IOException {

        landingPage = launchApplication();
        System.out.println("Navigated to the home page");
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String username, String password) {
        landingPage.loginApplication(username, password);
    }

    @When("^I add a product (.+) to the cart$")
    public void i_add_a_product_to_the_cart(String productName) {

        productCatalogue = new ProductCatalogue(driver);
        List<WebElement> items = productCatalogue.getProductList();
        productCatalogue.addProductToCard(productName);
        productCatalogue.goToCart();

    }

    @And("^I proceed to checkout (.+) and submit the order$")
    public void i_proceed_to_checkout_and_submit_the_order(String productName) {

        CartPage cartPage = new CartPage(driver);
        cartPage.confirmSelection(productName);
        cartPage.gotoCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectCountry("India");

    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String message) {

        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        orderHistoryPage.confirmOrder();
        
    }

}
