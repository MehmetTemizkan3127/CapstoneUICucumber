package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginSD {

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
}