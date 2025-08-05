package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AllPages;
import utilities.ReusableMethods;

public class US_009_EditDepartmentSD {

    AllPages pages = new AllPages();

    @Given("Click on a department that has already been created")
    public void click_on_a_department_that_has_already_been_created() {
        pages.getDepartmentsPage().clickDepartmentWithIndex(3);

    }
    @When("Click Edit Department button")
    public void click_edit_department_button() {
        pages.getDepartmentDetailPage().clickEditDepartmentButton();
    }

    @When("refresh page until page loads")
    public void refresh_page_until_page_loads() {
        pages.getEditDepartmentPage().refreshUntilDeleteButtonIsDisplayed();
    }

    @When("Update the name field {string}")
    public void update_the_name_field(String name) {
        pages.getEditDepartmentPage().enterDepartmentUpdateName(name);

    }
    @When("Update the short name field {string}")
    public void update_the_short_name_field(String shortName) {
        pages.getEditDepartmentPage().enterDepartmentUpdateShortName(shortName);
    }
    @When("Update description field {string}")
    public void update_description_field(String description) {
        pages.getEditDepartmentPage().enterDepartmentDescription(description);

    }
    @Then("Verify that the information has been updated")
    public void verify_that_the_information_has_been_updated() {
        Assert.assertTrue(pages.getEditDepartmentPage().isNewCreatedDepartmentDisplayed());
    }

    @Then("Verify that Edit Department button visible and clickable")
    public void verify_that_edit_department_button_visible_and_clickable() {
        Assert.assertTrue(pages.getDepartmentDetailPage().isEditDepartmentButtonVisibleAndClickable());
    }

    @Then("Verify that New User button visible and clickable")
    public void verify_that_new_user_button_visible_and_clickable() {
        Assert.assertTrue(pages.getDepartmentDetailPage().isNewUserButtonVisibleAndClickable());
    }

    @Then("Verify that you are redirected to the correct department after clicking on it")
    public void verify_that_you_are_redirected_to_the_correct_department_after_clicking_on_it() {
        Assert.assertTrue(pages.getDepartmentDetailPage().verifyDepartmentNameAfterClick());
    }

    @Given("Create a new department with the name {string}, short name {string}, type {string}, description {string}, role {string}")
    public void create_a_new_department_with_the_name_short_name_type_description_role(String name, String shortName, String department, String description, String role) {
        pages.getNewDepartmentPage().createANewDepartment(name,shortName,department,description,role);
    }

    @When("Click created department")
    public void click_created_department() {
        pages.getDepartmentsPage().clickNewCreatedDepartment();
    }

    @When("Select a department type -  as a Remote Unit")
    public void select_a_department_type_as_a_remote_unit() {
        pages.getEditDepartmentPage().selectDepartmentType("Remote Unit");
    }

    @Then("Verify that Delete Department button is visible and clickable")
    public void verify_that_delete_department_button_is_visible_and_clickable() {
        Assert.assertTrue(pages.getEditDepartmentPage().isDeleteButtonVisibleAndClickable());
    }

    @When("Click Delete Department button")
    public void click_delete_department_button() {
        pages.getEditDepartmentPage().clickDeleteButton();
    }

    @When("Click Confirm")
    public void click_confirm() {
        pages.getEditDepartmentPage().clickConfirmButton();

    }

    @Then("Verify that Change image button is visible and clickable")
    public void verify_that_change_image_button_is_visible_and_clickable() {
        Assert.assertTrue(pages.getEditDepartmentPage().isChangeImageButtonVisibleAndClickable());
    }

}
