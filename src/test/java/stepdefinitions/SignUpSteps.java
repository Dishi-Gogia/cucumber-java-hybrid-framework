package stepdefinitions;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignupPage;
import utilities.LoggerUtils;

public class SignUpSteps {

    // Logger instance
    private static final Logger logger =LoggerUtils.getLogger(SignUpSteps.class);
    private String generatedEmail;
    private SignupPage signupPage;
    private HomePage homePage;
    
    /**
     * Navigates to the Signup page.
     */
    @Given("User navigates to the SignUp page")
    public void navigateToSignupPage() {

        logger.info("Navigating to Signup page.");
        homePage = new HomePage(BaseTest.getDriver());
        signupPage = new SignupPage(BaseTest.getDriver());
        homePage.clickSignupLogin();
        logger.info("Signup page opened successfully.");
    }
    
    @When("User enters signup email prefix {string}")
    public void user_enters_signup_email_prefix(String emailPrefix) {

        generatedEmail = signupPage.generateUniqueEmail(emailPrefix);

        signupPage.enterSignUpEmail(generatedEmail);

        signupPage.clickSignUpButton();
    }
    
    @When("User enters signup name {string}")
    public void user_enters_signup_name(String name) {

        signupPage.enterSignUpName(name);
    }

    /**
     * Clicks Continue button after account creation.
     */
    @When("User clicks Continue button")
    public void clickContinueButton() {
        logger.info("Clicking Continue button.");
        signupPage.clickContinueButton();
    }
    
    /**
     * Deletes the registered account.
     */
    @When("User deletes the account")
    public void clickDeleteAccount() {

        logger.info("Deleting user account.");
        signupPage.clickDeleteAccount();
    }

    /**
     * Verifies account deletion.
     */
    @Then("Account should be deleted successfully")
    public void verifyDeleteMessage() {

        logger.info("Verifying account deletion.");
        Assert.assertEquals("ACCOUNT DELETED!", signupPage.getDeleteMsg());
        logger.info("Account deleted successfully.");
    }
    
    @When("User clicks Create Account button")
    public void clickCreateAccount() {

        logger.info("Clicking Create Account.");
        signupPage.clickCreateAccount();
    }
    
    @When("User completes registration with following details")
    public void user_completes_registration_with_following_details(DataTable table) {

        Map<String, String> data = table.asMap(String.class, String.class);
        logger.info("Completing Registration Form.");
        signupPage.completeRegistrationForm(data.get("Password"),
                data.get("Title"), data.get("Day"), data.get("Month"),data.get("Year"),data.get("FirstName"), data.get("LastName"),
                data.get("Company"), data.get("Address"),data.get("Country"),data.get("State"),
                data.get("City"), data.get("ZipCode"), data.get("Mobile"));
    }
    
    @Then("User account should be created successfully")
    public void verifyRegistration() {

        logger.info("Verifying Account Creation.");
        Assert.assertEquals("ACCOUNT CREATED!",signupPage.getAccountMessage());
        logger.info("Account created successfully.");
    }
    
}