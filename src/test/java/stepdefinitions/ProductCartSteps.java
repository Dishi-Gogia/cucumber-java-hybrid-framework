package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductsPage;
import utilities.LoggerUtils;


public class ProductCartSteps {

    private static final Logger logger = LoggerUtils.getLogger(ProductCartSteps.class);

    private final ProductsPage productsPage = new ProductsPage(BaseTest.getDriver());
    
    private String currentProduct;

    // ==========================================
    // Navigate to Products
    // ==========================================

    @Given("User clicks Products menu")
    public void user_clicks_products_menu() {

        logger.info("Navigating to Products page.");
        productsPage.clickProductMenu();
    }

    // ==========================================
    // Search Product
    // ==========================================

    @When("User searches product {string}")
    public void user_searches_product(String product) {

    	currentProduct = product;
        logger.info("Searching Product : {}", product);
        productsPage.searchProduct(product);
    }

    // ==========================================
    // Add Product to Cart
    // ==========================================

    @When("User adds searched product to cart")
    public void user_adds_searched_product_to_cart() {

    	logger.info("Adding Product to Cart : {}", currentProduct);
        productsPage.clickAddToCart(currentProduct);
    }

    // ==========================================
    // Open Cart
    // ==========================================

    @When("User clicks View Cart")
    public void user_clicks_view_cart() {

        logger.info("Opening Cart page.");
        productsPage.clickViewCart();
    }

    // ==========================================
    // Verify Product in Cart
    // ==========================================

    @Then("Product {string} should be displayed in cart")
    public void product_should_be_displayed_in_cart(String expectedProduct) {

        logger.info("Verifying Product in Cart.");
        String actualProduct = productsPage.getProductName();
        Assert.assertEquals("Incorrect product present in cart.",expectedProduct,actualProduct);
        logger.info("Product verified successfully.");
    }

    // ==========================================
    // Remove Product
    // ==========================================

    @When("User removes product from cart")
    public void user_removes_product_from_cart() {

        logger.info("Removing Product from Cart.");
        productsPage.clickDeleteProduct();
    }

    // ==========================================
    // Verify Cart Empty
    // ==========================================

    @Then("Cart should become empty")
    public void cart_should_become_empty() {

        logger.info("Verifying Cart is empty.");
        Assert.assertTrue("Cart is not empty.",productsPage.isCartEmpty());
                logger.info("Cart is empty.");
    }
}