package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NewRemoteUnitPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class US_11_NewRemote_Units_StepDefinition {
NewRemoteUnitPage newAdd=new NewRemoteUnitPage();

    @When("the user clicks on the Add New Remote Unit button")
    public void the_user_clicks_on_the_add_new_remote_unit_button() throws InterruptedException {

        newAdd.AddNewRemoteLink.click();

    }
    @When("the user enters Department Name")
    public void the_user_enters_department_name() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        newAdd.DepartmentNameInput.clear();
        newAdd.DepartmentNameInput.sendKeys(ConfigReader.getProperty("departmaname"));
    }

    @When("the user selects the department type as Remote Unit from the dropdown menu.")
    public void the_user_selects_the_department_type_as_remote_unit_from_the_dropdown_menu() {

        newAdd.DepartmentType.sendKeys("Remote Unit");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
    @When("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {

    }
    @Then("the user verifies that the newly added remote unit displayed under Remote Units.")
    public void the_user_verifies_that_the_newly_added_remote_unit_displayed_under_remote_units() {

    }
    @Then("delete created Remote unit")
    public void delete_created_remote_unit() {

    }
}
