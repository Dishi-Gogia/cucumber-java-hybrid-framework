package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.LoggerUtils;

public class LoginSteps {

    private static final Logger logger =LoggerUtils.getLogger(LoginSteps.class);
    private LoginPage loginPage;
    private HomePage homePage;

    /**
     * Navigates to Login page.
     */
    @Given("User navigates to the Login page")
    public void clicklink() {

        logger.info("Navigating to Login Page.");
        homePage = new HomePage(BaseTest.getDriver());
        loginPage = new LoginPage(BaseTest.getDriver());
        homePage.clickSignupLogin();
    }

    /**
     * Enters login username.
     */
    @When("User enters username {string}")
    public void enterUsername(String email) {

        logger.info("Entering Login Username.");
        loginPage.enterLoginEmail(email);
        
    }

    /**
     * Enters login password.
     */
    @When("User enters password {string}")
    public void enterPassword(String password) {

        logger.info("Entering Login Password.");
        loginPage.enterLoginPassword(password);
    }

    /**
     * Clicks Login button.
     */
    @When("User clicks Login button")
    public void clickLogin() {

        logger.info("Performing Login.");
        loginPage.clickLoginButton();
    }

    /**
     * Verifies successful login.
     */
    @Then("User should be logged in successfully {string}")
    public void verifyLogin(String expectedUser) {

        logger.info("Verifying Logged In User.");
        HomePage homePage = new HomePage(BaseTest.getDriver());

        Assert.assertEquals(
                expectedUser,
                homePage.getLoggedInUsername());

        logger.info("Logged in user verified successfully.");
    }

    /**
     * Verifies unsuccessful login.
     */
    @Then("User should not be logged in successfully")
    public void verifyNotLogin() {

        logger.info("Verifying Login Failure.");
        String actualMessage = loginPage.getLoginFailureMessage();
        Assert.assertEquals("Login failure message is incorrect.", "Your email or password is incorrect!",
                actualMessage);
        logger.info("Login failure verified successfully.");
    }
}