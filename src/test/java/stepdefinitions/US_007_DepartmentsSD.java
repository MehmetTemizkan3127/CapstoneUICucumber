package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.AllPages;
import utilities.ReusableMethods;

import static utilities.Driver.getDriver;

public class US_007_DepartmentsSD {

    AllPages pages = new AllPages();

    @Then("User clicks department button")
    public void user_clicks_department_button() {
        pages.getDashboardPage()
                .clickOnMenuItem("Departments");
    }

    @When("User clicks again department button")
    public void user_clicks_again_department_button() {
        pages.getDepartmentsPage()
                .clickAgainDepartmentsButton();
    }

    @Then("Verify that all departments are displayed")
    public void verify_that_all_departments_are_displayed() {
        Assert.assertTrue(pages.getDepartmentsPage()
                .areDepartmentCardsDisplayed());
    }

    @Then("Click on the departments that have authorized roles and Verify that the roles are displayed")
    public void click_on_the_departments_that_have_authorized_roles_and_verify_that_the_roles_are_displayed() {
    Assert.assertTrue(pages.getDepartmentsPage()
            .areAuthorizedRolesDisplayed());
    }

    @When("Verify that the number of roles shown on the department card matches the number of roles listed inside the department")
    public void verify_that_the_number_of_roles_shown_on_the_department_card_matches_the_number_of_roles_listed_inside_the_department() {
        pages.getDepartmentsPage()
                .areAuthorizedRolesMatched();
    }

    @Then("User verifies that the departments are displayed")
    public void user_verifies_that_the_departments_are_displayed() {
        Assert.assertTrue(pages.getDepartmentsPage()
                .isDepartmentsTextDisplayed());
    }
    //DeleteDepartment
    @Then("delete the created department")
    public void delete_the_created_department() {
        pages.getDepartmentsPage().deleteDepartmentWithIndex(0,1);
    }

}
