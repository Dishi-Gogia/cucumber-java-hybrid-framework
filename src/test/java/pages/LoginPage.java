package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.LoggerUtils;

/**
 * Page Object for Login / Signup page.
 * Contains actions related to user Login.
 */
public class LoginPage extends BasePage {
    private static final Logger logger = LoggerUtils.getLogger(LoginPage.class);

    /**
     * Constructor.
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("Login Page initialized successfully");
    }

    /**
     * Login name textbox.
     */
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;

    /**
     * Login email textbox.
     */
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPassword;

    /**
     * Login button.
     */
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy (xpath = "//p[normalize-space() = 'Your email or password is incorrect!']")
    private WebElement loginFailureMsg;
    
    /**
     * Enter email address for Login
     * @param Email address
     */
    public void enterLoginEmail(String emailadd) {

        logger.info("Entering Email address: {}",emailadd);
        actions.type(loginEmail, emailadd);
    }

    /**
     * Enter password for login form.
     * @param Password 
     */
    public void enterLoginPassword(String password) {

        logger.info("Entering Login email");
        actions.type(loginPassword, password);
    }

    /**
     * Click login button.
     */
    public void clickLoginButton() {

        logger.info("Clicking Login button");
        actions.click(loginButton);
    }

    /**
     * Complete Login form and submit registration request.
     * @param name User name
     * @param email User email
     */
    public void login(String email, String pwd) {

        logger.info( "Starting login process");
        enterLoginEmail(email);
        enterLoginPassword(pwd);
        clickLoginButton();
        logger.info( "Login submitted successfully");
    }
    
    /**
     * Get the Login failure Message.
     */
    public String getLoginFailureMessage() {
    	     return loginFailureMsg.getText().trim();
       }
}