package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Utility class for capturing screenshots.
 * Used during test failures and reporting.
 */
public class ScreenshotUtils {

    /**
     * Captures screenshot and saves it under screenshots.
     *
     * @param driver   Current WebDriver instance
     * @param testName Scenario/Test name
     * @return Absolute path of captured screenshot
     */
    public static String captureScreenshot(WebDriver driver, String testName) {

        // Create screenshots folder if it doesn't exist
        File screenshotDir = new File("screenshots");

        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        String fileName = testName.replaceAll("\\s+", "_")
                + "_"
                + System.currentTimeMillis()
                + ".png";

        File sourceFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destinationFile = new File(screenshotDir, fileName);

        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Unable to capture screenshot.", e);
        }

        return destinationFile.getAbsolutePath();
    }
    
    
    /**
     * Captures screenshot as byte array.
     * Used for attaching screenshots to Cucumber reports.
     *
     * @param driver Current WebDriver instance
     * @return Screenshot as byte array
     */
    public static byte[] captureScreenshotAsBytes(WebDriver driver) {

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

    }

}