package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

public class CommonSD {

    AllPages pages = new AllPages();

    @And("user logins as {string} with password {string}")
    public void userLogins(String username, String password) {

       // pages.getLoginPage().userLogins(ConfigReader.getProperty(username), ConfigReader.getProperty(password ));
    }


}



