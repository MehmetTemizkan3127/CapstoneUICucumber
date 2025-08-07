package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.EditRemoteUnitsPage;
import pages.RemoteUnitsPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitForSeconds;

public class US_012_EditRemoteUnitsSD {
    RemoteUnitsPage remoteUnitsPage=new RemoteUnitsPage();
    DashboardPage dashboardPage=new DashboardPage();
    EditRemoteUnitsPage editRemoteUnitsPage=new EditRemoteUnitsPage();
    @And("Select any of the available Remote Unite title and click on it.")
    public void selectAnyOfTheAvailableRemoteUniteTitleAndClickOnIt() {
editRemoteUnitsPage.editremoteunitsdept.click();
        waitForSeconds(1);
    }
    @When("the user clicks on the Edit Remote Unit button")
    public void the_user_clicks_on_the_edit_remote_unit_button() {
        waitForSeconds(3);
        editRemoteUnitsPage.editRemoteUnitButton.click();
        waitForSeconds(2);
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        Driver.getDriver().navigate().refresh();
        waitForSeconds(3);
    }
    @When("the user enters new Department Name")
    public void the_user_enters_new_department_name() {
        editRemoteUnitsPage.DepartmentNameInput.clear();
        editRemoteUnitsPage.DepartmentNameInput.sendKeys(ConfigReader.getProperty("Newdepartmaname"));

    }
    @When("user finds and clicks the delete button")
    public void user_finds_and_clicks_the_delete_button() {
        waitForSeconds(2);
editRemoteUnitsPage.deletebutton.click();
    }
    @And("user clicks the Confirm button in the confirmation window")
    public void userClicksTheConfirmButtonInTheConfirmationWindow() {
        waitForSeconds(3);
editRemoteUnitsPage.confirmbutton.click();
    }
    @Then("verify that the delete operation succesfull")
    public void verify_that_the_delete_operation_succesfull() {
        waitForSeconds(2);
dashboardPage.clickOnMenuItem("Remote Units");
remoteUnitsPage.searching.sendKeys(ConfigReader.getProperty("Newdepartmaname"));
System.out.println("remoteUnitsPage.searchResults.size() = " + remoteUnitsPage.searchResults.size());
Assert.assertEquals(0, remoteUnitsPage.searchResults.size()-1,"Aranan departman bulunamadi");


    }




}
