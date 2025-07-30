package stepdefinitions;


import io.cucumber.java.en.And;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;

public class CommonSD {

    AllPages pages = new AllPages();

    @And("user logins as {string} with password {string}")
    public void userLogins(String username, String password) {
        pages.getLoginPage().userLogins(username, password);
    }
}



