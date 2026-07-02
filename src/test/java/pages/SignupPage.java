package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.LoggerUtils;
import utilities.WaitUtils;

/**
 * Page Object for Signup Page.
 * Contains registration form actions and validations.
 */
public class SignupPage extends BasePage {

    private static final Logger logger = LoggerUtils.getLogger(SignupPage.class);

    /**
     * Constructor.
     * @param driver WebDriver instance
     */
    public SignupPage(WebDriver driver) {
        super(driver);
        logger.info( "Signup Page initialized successfully");
    }

    /**
     * Account Information header.
     */
    
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement SignUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement SignUpEmailAddress;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement ClicksignUpButton;
    
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement accountInformationHeader;

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "password")
    private WebElement passwordTextbox;

    @FindBy(id = "days")
    private WebElement dayDropdown;

    @FindBy(id = "months")
    private WebElement monthDropdown;

    @FindBy(id = "years")
    private WebElement yearDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement offersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameTextbox;

    @FindBy(id = "last_name")
    private WebElement lastNameTextbox;

    @FindBy(id = "company")
    private WebElement companyTextbox;

    @FindBy(id = "address1")
    private WebElement addressTextbox;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateTextbox;

    @FindBy(id = "city")
    private WebElement cityTextbox;

    @FindBy(id = "zipcode")
    private WebElement zipcodeTextbox;

    @FindBy(id = "mobile_number")
    private WebElement mobileTextbox;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;
    
    @FindBy(xpath="//h2[@data-qa='account-created']")
    private WebElement accountCreatedMsg;
    
    @FindBy(xpath = "//a[@data-qa = 'continue-button']")
    private WebElement continuebutton;
     
    @FindBy(xpath = "//ul[@class ='nav navbar-nav']/li[10]/a/b")
    private WebElement usernameis;
    
    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountLink;
    
    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b")
    private WebElement DeleteAccountconfirmationmsg;
    
    /**
     * Enter user name in signup form.
     * @param name User name
     */
    public void enterSignUpName(String name) {

        logger.info("Entering signup names: {}",name);
        actions.type(SignUpName, name);
    }

    /**
     * Enter email address in signup form.
     * @param email User email
     */
    public void enterSignUpEmail(String email) {

    	logger.info("Entering signup email: {}", email);
        actions.type(SignUpEmailAddress, email);
    }

    /**
     * Click signup button.
     */
    public void clickSignUpButton() {

        logger.info("Clicking signup button");
        actions.click(ClicksignUpButton);
    }
    
    /**
     * Verify Account Information section is displayed.
     *
     * @return true if displayed
     */
    public boolean isAccountInformationDisplayed() {
        logger.info( "Verifying Account Information section");
        return actions.isDisplayed(accountInformationHeader);
    }

    /**
     * Select title as Mr.
     */
    public void selectTitle() {
        logger.info( "Selecting title");
        actions.click(mrRadioButton);
    }

    /**
     * Enter password.
     * @param password Account password
     */
    public void enterPassword(String password) {
        logger.info("Entering password");
        actions.type(passwordTextbox,password);
    }

    /**
     * Select birth day.
     * @param day Day value
     */
    public void selectDay(String day) {
    	logger.info("Selecting Day : {}", day);
        new Select(dayDropdown).selectByVisibleText(day);
    }

    /**
     * Select birth month.
     * @param month Month value
     */
    public void selectMonth(String month) {
    	 logger.info("Selecting Month : {}", month);
        new Select(monthDropdown).selectByVisibleText(month);
    }

    /**
     * Select birth year.
     * @param year Year value
     */
    public void selectYear(String year) {
    	 logger.info("Selecting Year : {}", year);
        new Select(yearDropdown) .selectByVisibleText(year);
    }

    /**
     * Subscribe to newsletter.
     */
    public void selectNewsletter() {
    	logger.info("Selecting Newsletter");
        actions.selectCheckbox(newsletterCheckbox);
    }

    /**
     * Subscribe to special offers.
     */
    public void selectSpecialOffers() {
    	logger.info("Selecting Special Offers");
        actions.selectCheckbox(offersCheckbox);
    }

    /**
     * Enter first name.
     */
    public void enterFirstName(String firstName) {
    	logger.info("Entering First Name : {}", firstName);
        actions.type(firstNameTextbox,firstName);
    }

    /**
     * Enter last name.
     */
    public void enterLastName(String lastName) {
    	logger.info("Entering Last Name : {}", lastName);
        actions.type(lastNameTextbox,lastName);
    }

    /**
     * Enter company name.
     */
    public void enterCompanyName(String companyName) {
    	logger.info("Entering Company Name : {}", companyName);
        actions.type( companyTextbox,companyName);
    }

    /**
     * Enter address.
     */
    public void enterAddressDetails(String address) {
    	logger.info("Entering Address Details : {}", address);
        actions.type(addressTextbox,address);
    }

    /**
     * Select country.
     */
    public void selectCountry(String country) {
    	logger.info("Selecting country : {}", country);
        new Select(countryDropdown) .selectByVisibleText(country);
    }

    /**
     * Enter state.
     */
    public void enterStateDetails(String state) {
    	logger.info("Entering State Details : {}", state);
        actions.type( stateTextbox,state);
    }

    /**
     * Enter city.
     */
    public void enterCityDetails(String city) {
    	logger.info("Selecting City Details : {}", city);
        actions.type( cityTextbox, city);
    }

    /**
     * Enter zipcode.
     */
    public void enterZipcodeDetails(String zipcode) {
    	logger.info("Selecting zipcode Details : {}", zipcode);
        actions.type(zipcodeTextbox,zipcode);
    }

    /**
     * Enter mobile number.
     */
    public void enterMobileDetails(String mobile) {
    	logger.info("Selecting Mobile Details : {}", mobile);
        actions.type( mobileTextbox, mobile);
    }

    /**
     * Complete registration form.
     * @param firstName First name
     * @param lastName Last name
     * @param company Company name
     * @param address Address
     * @param state State
     * @param city City
     * @param zipcode Zipcode
     * @param mobile Mobile number
     */
    public void completeRegistrationForm(String password,String title,String day,String month,String year,
    		String firstName,String lastName,String company,String address,String country,String state,
    		String city,String zip,String mobile) {

        logger.info("Filling Account Registration Form.");
        selectTitle();
        enterPassword(password);
        selectDay(day);
        selectMonth(month);
        selectYear(year);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompanyName(company);
        enterAddressDetails(address);
        selectCountry(country);
        enterStateDetails(state);
        enterCityDetails(city);
        enterZipcodeDetails(zip);
        enterMobileDetails(mobile);
        logger.info("Account Registration Form completed successfully");
    }

    /**
     * Click Create Account button.
     * @return AccountCreatedPage
     */
    public void clickCreateAccount() {
        logger.info("Clicking Create Account button");
        actions.click(createAccountButton);

    }
    
    /**
     * Get Account Creation Message.
     * @return getAccountMessage
     */
    public String getAccountMessage() {
    	logger.info("Getting Account Creation message.");
    	return accountCreatedMsg.getText().trim();
    	
    }
    
    /**
     * Click Continue Button.
     * @return clickContinueButton
     */
    public void clickContinueButton() {
    	logger.info("Clicking on Continue Button.");
    	 actions.click(continuebutton);
    }
    
    /**
     * Get UserName Checked.
     * @return getUserNameChecked
     */
    public String getLoggedInUsername() {
        logger.info("Fetching logged-in username.");
        return usernameis.getText().trim();
    }
    
    /**
     * Click on DeleteAccount Button.
     * @return clickDeleteAccount
     */
    public void clickDeleteAccount() {
    	logger.info("Clicking on Delete Account Button.");
    	 actions.click(deleteAccountLink);
    }
    
    /**
     * Get Delete Account Confirmation Message.
     * @return getDeleteMsg
     */
    public String getDeleteMsg() {
    	logger.info("Getting Delete Account message.");
    	 WaitUtils.waitForVisibility(driver, DeleteAccountconfirmationmsg);
    	return DeleteAccountconfirmationmsg.getText().trim();
    }
    
    /**
     * Get Unique Email Address each time called.
     * @return email
     */
    public String generateUniqueEmail(String emailPrefix) {

        String email = emailPrefix
                + System.currentTimeMillis()
                + "@gmail.com";

        logger.info("Generated unique email : {}", email);

        return email;
    }
}