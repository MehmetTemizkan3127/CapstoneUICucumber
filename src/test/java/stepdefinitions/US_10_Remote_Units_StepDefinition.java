package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.RemoteUnitsPage;
import pages.UsersPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.ReusableMethods.waitForSeconds;

public class US_10_Remote_Units_StepDefinition {
    RemoteUnitsPage remoteUnitsPage = new RemoteUnitsPage();
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();


    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        homePage.login();


    }
    @When("the user enters a valid {string} username in the username field")
    public void the_user_enters_a_valid_username_in_the_username_field(String string) {
        loginPage.enterEmail(ConfigReader.getProperty("usuario"));

    }
    @When("the user enters a valid {string} password in the Password field")
    public void the_user_enters_a_valid_password_in_the_password_field(String string) {
        loginPage.enterPassword(ConfigReader.getProperty("clave"));
    }
    @When("the user clicks on the Sign in button")
    public void the_user_clicks_on_the_sign_in_button() {
loginPage.clickSignIn();
        try {Thread.sleep(2000);} catch (InterruptedException e) {}
    }
    @When("user clicks the Remote Units  menu")
    public void user_clicks_the_remote_units_menu() {
        remoteUnitsPage.dropdown.click();
        waitForSeconds(3);
remoteUnitsPage.remoteunitsign.click();


    }

    @Then("user verify the Remote units page menu")
    public void userVerifyTheRemoteUnitsPageMenu() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        waitForSeconds(3);
        int expectedSize = 35;
        int actualSize=remoteUnitsPage.displayRemotePagelist.size();
        System.out.println("actualSize = " + actualSize);
        Assert.assertEquals(actualSize,expectedSize);
    }

    @And("user closes browser")
    public void userClosesBrowser() {
Driver.closeDriver();
    }
}
