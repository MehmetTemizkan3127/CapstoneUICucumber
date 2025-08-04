package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AllPages;
import utilities.ReusableMethods;

public class US_009_EditDepartmentSD {

    AllPages pages = new AllPages();

    @Given("Click on a department that has already been created")
    public void click_on_a_department_that_has_already_been_created() {
        pages.getDepartmentsPage().clickDepartmentWithIndex(0);

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


}
