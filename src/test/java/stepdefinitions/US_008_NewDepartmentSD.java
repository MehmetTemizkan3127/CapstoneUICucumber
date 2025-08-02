package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class US_008_NewDepartmentSD {

    AllPages pages = new AllPages();

    //008_01

    @When("Enter a department name")
    public void enter_a_department_name() {

        ReusableMethods.sendKeys(pages.getNewDepartmentPage().getNameField(), ConfigReader.getProperty("departmentName"));
    }
    @When("Enter a department Short name")
    public void enter_a_department_short_name() {
        ReusableMethods.sendKeys(pages.getNewDepartmentPage().getShortnameField(),"Test department shortname");
    }
    @When("Select a department type - Departmant")
    public void select_a_department_type_departmant() {
        pages.getNewDepartmentPage().selectDepartmentType();
    }

    @When("Enter a department description")
    public void enter_a_department_description() {
        ReusableMethods.sendKeys(pages.getNewDepartmentPage().getDescriptionField(),"Test description");
    }

    @When("Select a departmant role")
    public void select_a_departmant_role() {
        pages.getNewDepartmentPage().selectRoles();
    }

    @When("Click save button")
    public void click_save_button() {
        ReusableMethods.clickElement(pages.getNewDepartmentPage().getSaveButton());
    }
    @Then("Verify that the newly created department is displayed in the department list.")
    public void verify_that_the_newly_created_department_is_displayed_in_the_department_list() {
        Assert.assertTrue(pages.getNewDepartmentPage().isNewCreatedDepartmentDisplayed());
    }

    //008_02













   //TC_008_11
    @Then("User verifies that add new department button is clickable")
    public void user_verifies_that_add_new_department_button_clickable() {
        Assert.assertTrue(ReusableMethods.isEnabled(pages.getDepartmentsPage().getAddNewDepartmentButton()));
    }

    //TC_008_12

    @Given("Click Add New Department button")
    public void click_add_new_department_button() {
        pages.getDepartmentsPage().clickAddNewDepartment();
    }

    @Then("Verify that Department Name field is visible")
    public void verify_that_department_name_field_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getNameField()));

    }

    //TC_008_13
    @Then("Verify that Short Name field is visible")
    public void verify_that_short_name_field_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getShortnameField()));
    }

    //TC_008_14
    @Then("Verify that Department Type field is visible")
    public void verify_that_department_type_field_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getDepartmentTypeField()));
    }

    //TC_008_15
    @Then("Verify that Department Description field is visible")
    public void verify_that_department_description_field_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getDescriptionField()));
    }

    //TC_008_16
    @Then("Verify that Department Roles field is visible")
    public void verify_that_department_roles_field_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getRolesField()));
    }

    //TC_008_17

    @Then("Verify that Save button is visible")
    public void verify_that_save_button_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getSaveButton()));
    }

    @Then("Verify that Save button is clickable")
    public void verify_that_save_button_is_clickable() {
        Assert.assertTrue(ReusableMethods.isEnabled(pages.getNewDepartmentPage().getSaveButton()));
    }


    //TC_008_18
    @Then("Verify that Cancel button is visible")
    public void verify_that_cancel_button_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getCancelButton()));
    }

    //TC_008_19
    @Given("Click cancel")
    public void click_cancel() {
        ReusableMethods.clickElement(pages.getNewDepartmentPage().getCancelButton());
    }

    @Then("Verify that edit button is visible")
    public void verify_that_edit_button_is_visible() {
        Assert.assertTrue(ReusableMethods.isDisplayed(pages.getNewDepartmentPage().getEditButton()));
    }







}
