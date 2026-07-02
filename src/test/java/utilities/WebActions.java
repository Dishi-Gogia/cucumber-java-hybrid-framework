package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

/**
 * Utility class containing common web actions.
 * Centralizes Selenium interactions and reduces code duplication.
 */
public class WebActions {

    private WebDriver driver;

    /**
     * Constructor
     * @param driver WebDriver instance
     */
    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on an element after waiting for it to be clickable.
     * @param element WebElement to click
     */
    public void click(WebElement element) {
        WaitUtils.waitForClickable(driver,element);
        element.click();
    }

    /**
     * Enter text into a textbox after waiting for visibility.
     * @param element WebElement
     * @param text Text to enter
     */
    public void type(WebElement element, String text) {
        WaitUtils.waitForVisibility(driver,element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get visible text from an element.
     * @param element WebElement
     * @return Element text
     */
    public String getText(WebElement element) {
        WaitUtils.waitForVisibility(driver,element);
        return element.getText();
    }

    /**
     * Verify whether an element is displayed.
     * @param element WebElement
     * @return true if displayed
     */
    public boolean isDisplayed(WebElement element) {
        WaitUtils.waitForVisibility(driver,element);
        return element.isDisplayed();
    }

    /**
     * Get attribute value from an element.
     * @param element WebElement
     * @param attributeName Attribute name
     * @return Attribute value
     */
    public String getAttribute(WebElement element, String attributeName) {
        WaitUtils.waitForVisibility(driver,element);
        return element.getAttribute(attributeName);
    }

    /**
     * Select checkbox if not already selected.
     * @param checkbox Checkbox element
     */
    public void selectCheckbox(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            click(checkbox);
        }
    }

    /**
     * Unselect checkbox if already selected.
     * @param checkbox Checkbox element
     */
    public void unselectCheckbox(WebElement checkbox) {
        if (checkbox.isSelected()) {
            click(checkbox);
        }
    }

    /**
     * Scroll element into view using JavaScript.
     * @param element WebElement
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Get page title.
     * @return Page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get current page URL.
     * @return Current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Hover mouse over an element.
     * @param element WebElement
     */
    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Double-click on an element.
     * @param element WebElement
     */
    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    /**
     * Right-click on an element.
     * @param element WebElement
     */
    public void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
}