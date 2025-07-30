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
}