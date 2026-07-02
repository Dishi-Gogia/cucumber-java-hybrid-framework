package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtils;

public class ProductsPage extends BasePage {

    // Logger instance for Products Page
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // ==========================
    // Page Objects
    // ==========================

    // Products menu
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productMenu;

    // Search text box
    @FindBy(id = "search_product")
    private WebElement searchBox;

    // Search button
    @FindBy(id = "submit_search")
    private WebElement searchButton;

    // View Cart button displayed in confirmation popup
    @FindBy(xpath = "//div[@id='cartModal']//a[@href='/view_cart']")
    private WebElement viewCart;

    // Product name displayed in Cart page
    @FindBy(xpath = "//td[@class='cart_description']//a")
    private WebElement productName;

    // Delete product icon in Cart
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private WebElement deleteProduct;

    // Empty cart confirmation message
    @FindBy(xpath = "//b[text()='Cart is empty!']")
    private WebElement cartEmpty;

    // Stores currently searched product name
    private String currentProduct;

    // ==========================
    // Page Methods
    // ==========================

    /**
     * Navigates to the Products page.
     */
    public void clickProductMenu() {

        logger.info("Clicking Products menu.");

        actions.click(productMenu);

        // Wait until Products page is completely loaded
        WaitUtils.waitForUrlContains(driver, "/products");
        WaitUtils.waitForVisibility(driver, searchBox);

        logger.info("Products page loaded successfully.");
    }

    /**
     * Searches for a product using the search box.
     * @param productName Name of the product to search.
     */
    public void searchProduct(String productName) {

        logger.info("Searching Product : {}", productName);

        // Store product name for later use
        currentProduct = productName;

        WaitUtils.waitForVisibility(driver, searchBox);

        // Clear existing text before entering new product
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);

        actions.type(searchBox, productName);

        actions.click(searchButton);

        // Wait until searched product becomes visible
        By productLocator = By.xpath("//div[@class='productinfo text-center']//p[contains(normalize-space(),'"
                        + productName + "')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));

        // Scroll product into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", product);

        logger.info("Product search completed.");
    }

    /**
     * Adds the selected product to the cart.
     * @param productName Product to be added.
     */
    public void clickAddToCart(String productName) {

        logger.info("Current Product = {}", currentProduct);
        logger.info("Inside clickAddToCart()");
        logger.info("Adding Product : {}", productName);

        // Locate product card
        WebElement productCard = driver.findElement( By.xpath("//p[text()='" + productName +
                        "']/ancestor::div[@class='product-image-wrapper']"));

        // Scroll product into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
                        productCard);

        // Scroll slightly upward to avoid overlapping elements
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)");

        // Hover over product to reveal Add to Cart button
        new Actions(driver).moveToElement(productCard).perform();

        // Locate Add to Cart button
        WebElement addToCart = driver.findElement(By.xpath("//p[text()='" + productName +
                        "']/ancestor::div[@class='product-image-wrapper']" +"//a[contains(text(),'Add to cart')]"));

        // Click using JavaScript to avoid interception issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);

        logger.info("Product added successfully.");
    }

    /**
     * Opens the Cart page.
     */
    public void clickViewCart() {

        WaitUtils.waitForVisibility(driver, viewCart);
        actions.click(viewCart);
    }

    /**
     * Returns the product name displayed in the cart.
     * @return Product name.
     */
    public String getProductName() {

        return actions.getText(productName);
    }

    /**
     * Removes the product from the cart.
     */
    public void clickDeleteProduct() {

        logger.info("Deleting Product from Cart.");
        actions.click(deleteProduct);

        // Wait until cart empty message is displayed
        WaitUtils.waitForVisibility(driver, cartEmpty);

        logger.info("Product deleted.");
    }

    /**
     * Verifies whether the cart is empty.
     * @return true if cart is empty, otherwise false.
     */
    public boolean isCartEmpty() {

        WaitUtils.waitForVisibility(driver, cartEmpty);
        return cartEmpty.isDisplayed();
    }

}