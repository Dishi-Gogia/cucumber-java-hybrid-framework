package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Utility class for handling explicit waits.
 * Provides reusable wait methods across the framework.
 */
public class WaitUtils {

    private static final int TIMEOUT = 10;

    /**
     * Wait until the element is visible.
     * @param element WebElement to wait for
     * @return Visible WebElement
     */
    public static WebElement waitForVisibility(WebDriver driver,WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }
    
    public static WebElement waitForVisibility(WebDriver driver, By locator) {

        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait until the element is clickable.
     * @param element WebElement to wait for
     * @return Clickable WebElement
     */
    public static WebElement waitForClickable(WebDriver driver,WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait until specified text is present in an element.
     * @param locator Element locator
     * @param text Expected text
     * @return true if text is present
     */
    public static boolean waitForTextPresent(WebDriver driver,By locator, String text) {

        return new WebDriverWait( driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /**
     * Wait until URL contains specified text.
     * @param partialUrl Partial URL text
     * @return true if URL contains text
     */
    public static boolean waitForUrlContains(WebDriver driver,String partialUrl) {

        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.urlContains(partialUrl));
    }

    /**
     * Wait until page title contains specified text.
     * @param title Expected title text
     * @return true if title contains text
     */
    public static boolean waitForTitleContains(WebDriver driver,String title) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.titleContains(title));
    }

    /**
     * Wait until element becomes invisible.
     * @param locator Element locator
     * @return true if element becomes invisible
     */
    public static boolean waitForInvisibility(WebDriver driver,By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait until alert is present.
     * @return Alert object
     */
    public static Alert waitForAlert(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Wait until frame is available and switch to it.
     * @param locator Frame locator
     */
    public static void waitForFrameAndSwitch(WebDriver driver,By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    
    
}