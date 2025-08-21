package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AllPages;
import utilities.ReusableMethods;

public class US_008_NewDepartmentSD {

    AllPages pages = new AllPages();

    @When("Enter a department name {string}")
    public void enter_a_department_name(String name) {
        pages.getNewDepartmentPage()
                .enterDepartmentName(name);
    }

    @When("Enter a department Short name {string}")
    public void enter_a_department_short_name(String shortName) {
        pages.getNewDepartmentPage()
                .enterDepartmentShortName(shortName);
    }

    @When("Select a department type - Departmant")
    public void select_a_department_type_departmant() {
        pages.getNewDepartmentPage()
                .selectDepartmentType("Department");
    }

    @When("Enter a department description {string}")
    public void enter_a_department_description(String description) {
        pages.getNewDepartmentPage()
                .enterDepartmentDescription(description);
    }

    @When("Select a departmant role")
    public void select_a_departmant_role() {
        pages.getNewDepartmentPage()
                .selectRoles("Sales Manager");
    }

    @When("Click save button")
    public void click_save_button() {
        pages.getNewDepartmentPage()
                .clickSaveButton();
    }

    @Then("Verify that the newly created department is displayed in the department list.")
    public void verify_that_the_newly_created_department_is_displayed_in_the_department_list() {
        Assert.assertTrue(pages.getDepartmentsPage()
                .isNewCreatedDepartmentDisplayed());
    }

    @Then("Verify that the message {string} is displayed")
    public void verify_that_the_message_is_displayed(String message) {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isMessageDisplayed(pages.getNewDepartmentPage()
                        .getNegativeMessage(), message));
    }

    @Then("user verifies that the message {string} is displayed")
    public void user_verifies_that_the_message_is_displayed(String message) {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isMessageDisplayed(pages.getNewDepartmentPage()
                        .getSuccessMessage(), message));
    }

    @Then("user verifies that the message {string} is not displayed")
    public void user_verifies_that_the_message_is_not_displayed(String message) {
        Assert.assertFalse(pages.getNewDepartmentPage()
                .isMessageDisplayed(pages.getNewDepartmentPage()
                        .getSuccessMessage(), message));
    }

    @When("Select multiple {int} departmant role")
    public void select_multiple_departmant_role(int roleCount) {
        pages.getNewDepartmentPage()
                .selectMultipleRoles(roleCount);
    }

    @Then("Verify that the count of added roles matches the count of created roles")
    public void verify_that_the_count_of_added_roles_matches_the_count_of_created_roles() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isRoleCountMatched());
    }

    @When("Select a department type - Remote Unit")
    public void select_a_department_type_remote_unit() {
        pages.getNewDepartmentPage()
                .selectDepartmentType("Remote Unit");
    }

    @Then("Verify that the created department is not displayed in the department list")
    public void verify_that_the_created_department_is_not_displayed_in_the_department_list() {
        Assert.assertTrue(pages.getDepartmentsPage()
                .verifyNewCreatedDepartmentNotDisplayed());
    }

    @Given("Remove a selected department role")
    public void remove_a_selected_department_role() {
        pages.getNewDepartmentPage()
                .removeSelectedRole();
    }

    @Then("Verify that a selected department role is removed")
    public void verify_that_a_selected_department_role_is_removed() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isSelectedRoleRemovedSuccessfully());
    }

    @When("Select a departmant role twice")
    public void select_a_departmant_role_twice() {
        pages.getNewDepartmentPage()
                .selectSameRoleTwice("Sales Manager");
    }

    @Then("Verify that the same role cannot be selected again")
    public void verify_that_the_same_role_cannot_be_selected_again() {
        Assert.assertFalse(pages.getNewDepartmentPage()
                .isSameRoleSelectableAgain("Sales Manager"));
    }

    @Given("save the first department name")
    public void save_the_first_department_name() {
       pages.getNewDepartmentPage()
               .getTheFirstDepartmentName();
    }
    @When("create new department with the same name")
    public void create_new_department_with_the_same_name() {
        pages.getNewDepartmentPage()
                .sendSameNameForDepartments();
    }
    @Given("Verify that the department is not created twice with the same name")
    public void verify_that_the_department_is_not_created_twice_with_the_same_name() {
        Assert.assertFalse(pages.getDepartmentsPage()
                .twoDepartmentWithSameName());
    }

    @Then("User verifies that add new department button is clickable")
    public void user_verifies_that_add_new_department_button_clickable() {
        Assert.assertTrue(ReusableMethods.isEnabled(pages.getDepartmentsPage()
                .getAddNewDepartmentButton()));
    }

    @Given("Click Add New Department button")
    public void click_add_new_department_button() {
        pages.getDepartmentsPage()
                .clickAddNewDepartment();
    }

    @Then("Verify that Department Name field is visible")
    public void verify_that_department_name_field_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isDepartmentNameFieldVisible());
    }

    @Then("Verify that Short Name field is visible")
    public void verify_that_short_name_field_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isShortNameFieldVisible());
    }

    @Then("Verify that Department Type field is visible")
    public void verify_that_department_type_field_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isDepartmentTypeFieldVisible());
    }

    @Then("Verify that Department Description field is visible")
    public void verify_that_department_description_field_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isDepartmentDescriptionFieldVisible());
    }

    @Then("Verify that Department Roles field is visible")
    public void verify_that_department_roles_field_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isDepartmentRolesFieldVisible());
    }

    @Then("Verify that Save button is visible")
    public void verify_that_save_button_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isSaveButtonVisible());
    }

    @Then("Verify that Save button is clickable")
    public void verify_that_save_button_is_clickable() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isSaveButtonClickable());
    }

    @Then("Verify that Cancel button is visible")
    public void verify_that_cancel_button_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isCancelButtonVisible());
    }

    @Given("Click cancel")
    public void click_cancel() {
        pages.getNewDepartmentPage()
                .clickCancelButton();
    }

    @Then("Verify that edit button is visible")
    public void verify_that_edit_button_is_visible() {
        Assert.assertTrue(pages.getNewDepartmentPage()
                .isEditButtonVisible());
    }
}
