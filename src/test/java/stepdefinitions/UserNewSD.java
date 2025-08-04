package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;

public class UserNewSD {

    AllPages pages = new AllPages();

    @And("User clicks Add New Member button")
    public void userClicksAddNewMemberButton() {
        pages
                .getUsersPage()
                .addNewMembeer();
    }

    @Then("Verify that title {string} is seen")
    public void verifyThatTitleIsSeen(String expectedResult) {
        pages
                .getUsersPage()
                .assertNewRegistrationWindowIsOpened(expectedResult);
    }

    @When("User clicks Register button")
    public void userClicksRegisterButton() {
        pages
                .getUsersPage()
                .clickRegisterButton();
    }

    @Then("Verify that role error message {string} is occured")
    public void verifyThatRoleErrorMessageIsOccured(String expectedResult) {
        pages
                .getUsersPage()
                .assertRegistrationWithOutDataErrorMessage(expectedResult);
    }
    @When("User selects a department from Deparments dropdown menu")
    public void userSelectsADepartmentFromDeparmentsDropdownMenu() {
        pages
                .getUsersPage()
                .selectDepartmentFromList();
    }
    @And("User selects a role from Roles dropdown menu")
    public void userSelectsARoleFromRolesDropdownMenu() {
        pages
                .getUsersPage()
                .selectARoleFromList();
    }

    @Then("Verify that email error message {string} is occured")
    public void verifyThatEmailErrorMessageIsOccured(String expectedResult) {
        pages
                .getUsersPage()
                .assertRegistrationWithOutEmailErrorMessage(expectedResult);
    }

    @And("User enters {string}")
    public void userEntersEmail(String email) {
        pages
                .getUsersPage()
                .enterEmail(email);
    }

    @Then("Verify that error message {string} is occured")
    public void verifyThatErrorMessageIsOccured(String errorMessage) {
        pages
                .getUsersPage()
                .assertInvalidEmailErrorMessage(errorMessage);
    }


    @Then("Verify that register succesful message {string} is occured")
    public void verifyThatRegisterSuccesfulMessageIsOccured(String expectedResult) {
        pages
                .getUsersPage()
                .assertVisibilityRegisterSuccessfullMessageOccur(expectedResult);
    }


    @When("User clicks Cancel button")
    public void userClicksCancelButton() {
        pages
                .getUsersPage()
                .clickCancelButton();
    }

    @Then("Verify that window closed without saving")
    public void verifyThatWindowClosedWithoutSaving() {
        pages
                .getUsersPage()
                .assertWindowClosedWithoutSaving();
    }

    @And("User creates a new member")
    public void userCreatesANewMember(String email) {
        pages
                .getUsersPage()
                .addNewMembeer()
                .selectDepartmentFromList()
                .selectARoleFromList()
                .enterEmail(email)
                .clickRegisterButton()
                .refreshPage();
    }
}
