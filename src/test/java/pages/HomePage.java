package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.LoggerUtils;
import utilities.WaitUtils;


/**
 * Page Object for Home Page.
 * Contains actions and validations related to Home Page.
 */
public class HomePage extends BasePage{

	private static final Logger logger = LoggerUtils.getLogger(HomePage.class);

    /**
     * Constructor initializes page elements.
     * @param driver WebDriver instance
     */
    public HomePage(WebDriver driver) {
        super(driver);
        logger.info( "Home Page initialized successfully");
    }
    
    /**
     * Signup / Login navigation link.
     */
    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement signupLoginLink;
    
    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInUser;
	

    /**
     * Clicks Signup/Login link.
     */
    public void clickSignupLogin() {
        logger.info( "Clicking Signup/Login link");
        actions.click(signupLoginLink);
    }

    /**
     * Returns Home Page title.
     * @return Page title
     */
    public String getHomePageTitle() {
        logger.info( "Fetching Home Page title");
        return actions.getPageTitle();
    }

    /**
     * Verifies Signup/Login link is displayed.
     * @return true if link is visible
     */
    public boolean isSignupLoginDisplayed() {
        logger.info("Verifying Signup/Login link visibility");
        return actions.isDisplayed(signupLoginLink);
    }
    
    /**
     * Returns the logged in user's text.
     * @return Logged in username text
     */
    public String getLoggedInUsername() {
    	
    	 logger.info("Verifying logged in user");
    	 WaitUtils.waitForVisibility(driver, loggedInUser);

    	    return loggedInUser.getText().replace("Logged in as", "").trim();
    	
    }
}