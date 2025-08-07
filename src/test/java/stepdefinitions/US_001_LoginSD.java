package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_001_LoginSD {

    AllPages pages = new AllPages();

    @Given("user goes to homepage")
    public void user_goes_to_homepage() {
        //assert false;//Failed intentionally
        Driver.getDriver().get(ConfigReader.getProperty("homepage"));
    }

    @And("User clicks login link")
    public void userClicksLoginLink() {
        pages.getHomePage().login();
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        pages.getLoginPage().enterEmail(email);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        pages.getLoginPage().enterPassword(password);
    }

    @When("user clicks on Login Button")
    public void user_clicks_on_login_button() {
        pages.getLoginPage().clickSignIn();
    }

    @Then("user validates sign in")
    public void user_validates_sign_in() {
        pages.getLoginPage().verifyLogin();
    }

    @Then("user validates error message {string}")
    public void userValidatesErrorMessage(String message) {
        pages.getLoginPage().checkErrorMessage(message);
    }

    @Then("user validates {string} required message")
    public void userValidatesEmailRequiredMessage(String elementId) {
        pages.getLoginPage().validateEmailRequired(elementId);
    }

    //company logo click on Login page
    @When("The user clicks on the company logo")
    public void theUserClicksOnTheCompanyLogo() {
        pages.getLoginPage().clickLogo();
    }

    @Then("The homepage should be displayed")
    public void theHomepageShouldBeDisplayed() {
        pages.getLoginPage().verifyHomePage();
    }


    @And("The user enters a valid registered email address")
    public void theUserEntersAValidRegisteredEmailAddress() {

    }

    @And("An email should be sent to the user with reset instructions")
    public void anEmailShouldBeSentToTheUserWithResetInstructions() {

    }

    @And("The user enters an unregistered email address")
    public void theUserEntersAnInvalidOrUnregisteredEmailAddress() {
        pages.getLoginPage().enterUnregisteredEmail();
        ReusableMethods.waitForSeconds(2);

    }

    @Then("An error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {

    }

    @And("No reset email should be sent")
    public void noResetEmailShouldBeSent() {

    }

    @When("The user clicks the Forgot Password? link")
    public void theUserClicksTheForgotPasswordLink() {
        pages.getLoginPage().forgotPasswordLink();
    }

    @And("The user clicks on the Recovery My Account button")
    public void theUserClicksOnTheRecoveryMyAccountButton() {
        pages.getLoginPage().recoveryPasswordButton();
    }

    @Then("Email not found message should be displayed")
    public void anEmailNotFoundMessageShouldBeDisplayed() {
        pages.getLoginPage().displayEmailNotFoundMessage();
    }

    @And("The user enters an invalid email address")
    public void theUserEntersAnInvalidEmailAddress() {
        pages.getLoginPage().enterInvalidEmail();
        ReusableMethods.waitForSeconds(2);
    }

    @Then("Invalid credentials message should be displayed")
    public void invalidCredentialsMessageShouldBeDisplayed() {
        pages.getLoginPage().displayInvalidCredentialsMessage();
    }
}