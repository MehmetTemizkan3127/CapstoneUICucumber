package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;

public class UserEditSD {

    AllPages pages = new AllPages();

    @When("User clicks on first username from the list")
    public void userClicksOnFirstUsernameFromTheList() {
        pages
                .getUsersPage()
                .openUserDetailPageForFirstUser();
    }

    @Then("Verify that User Detail page is opened")
    public void verifyThatUserDetailPageIsOpened() {
        pages
                .getUserDetailPage()
                .assertUserDetailPageOpens();
    }

    @When("User clicks the + button under Roles section")
    public void userClicksTheButtonUnderRolesSection() {
        pages
                .getUserDetailPage()
                .clickAddNewRoleButton();
    }


    @Then("Verify that select a role window is opened")
    public void verifyThatSelectARoleWindowIsOpened() {
        pages
            .getUserDetailPage()
            .clickOnRolesList()
            .assertSelectARoleWindowOpens();
    }
    @And("User adds a new role from the dropdown")
    public void userAddsANewRoleFromTheDropdown() {
        pages
                .getUserDetailPage()
                .clickOnRolesList()
                .selectARoleFromDropDown();
    }
    @And("User clicks Save button")
    public void userClicksSaveButton() {
        pages
                .getUserDetailPage()
                .clickSaveButton();

    }

    @Then("Verify that the new role is added for user")
    public void verifyThatTheNewRoleIsAddedForUser() {
        pages
                .getUserDetailPage()
                .assertNewRoledAddedForUser();
    }

    @When("User adds a new role for user")
    public void userAddsANewRoleForUser() {
        pages
                .getUsersPage()
                .openUserDetailPageForFirstUser()
                .clickAddNewRoleButton()
                .clickOnRolesList()
                .selectARoleFromDropDown()
                .clickSaveButton();
    }

    @And("User refreshes the profile page")
    public void userRefreshesTheProfilePage() {
        pages
                .getUserDetailPage()
                .refreshUserDetailPage();
    }

    @Then("Verify that the newly added role appears under Roles section")
    public void verifyThatTheNewlyAddedRoleAppearsUnderRolesSection() {
        pages
                .getUserDetailPage()
                .assertNewAddedRoleIsListedUnderRolesSection();
    }

    @Then("Verify that newly added role does not appear under Add New Roles dropdown list")
    public void verifyThatNewlyAddedRoleDoesNotAppearUnderAddNewRolesDropdownList() {
    }

    @When("User finds and clicks the default role")
    public void userFindsAndClicksTheDefaultRole() {
        pages
                .getUserDetailPage()
                .attemptToDeleteDefaultRole();

    }
}
