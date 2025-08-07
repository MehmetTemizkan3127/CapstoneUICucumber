package stepdefinitions;

import io.cucumber.java.en.*;
import pages.AllPages;
import utilities.ConfigReader;

public class US_016_EditUserSD {

    AllPages pages = new AllPages();
    public static int index = Integer.parseInt(ConfigReader.getProperty("indexOfUserList"));


    @When("User clicks on indexed username from the list")
    public void userClicksOnNdUsernameFromTheList() {
        pages
                .getUsersPage()
                .openUserDetailPageForIndexedUser(index);
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
    @And("User selects a new role from the dropdown")
    public void userSelectsANewRoleFromTheDropdown() {
        pages
                .getUserDetailPage()
                .clickOnRolesList()
                .selectARoleFromDropDown()
                .keepSelectedRole();
    }

    @Then("Verify that the new role is added and {string} message seen")
    public void verifyThatTheNewRoleIsAddedAndMessageSeen(String expectedResult) {
        pages
                .getUserDetailPage()
                .assertNewRoledAddedForUser(expectedResult);
    }

    @When("User adds a new role for user")
    public void userAddsANewRoleForUser() {
        pages
                .getUserDetailPage()
                .clickAddNewRoleButton()
                .clickOnRolesList()
                .selectARoleFromDropDown()
                .keepSelectedRole()
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

    @When("User finds if there is a default role")
    public void userFindsIfThereIsADefaultRole() {
        pages
                .getUserDetailPage()
                .isThereADefaultRole();

    }

    @Then("Verify that default role cannot be removed")
    public void verifyThatDefaultRoleCannotBeRemoved() {
        pages
                .getUserDetailPage()
                .assertDefaultRoleDoesNotHaveThreeDots();
    }

    @When("User clicks Reset Password button")
    public void userClicksResetPasswordButton() {
        pages
                .getUserDetailPage()
                .clickResetPasswordButton();
    }

    @And("User clicks Confirm button")
    public void userClicksConfirmButton() {
        pages
                .getUserDetailPage()
                .clickConfirmButton();
    }

    @Then("Verify that {string} message seen")
    public void verifyThatMessageSeen(String expectedResult) {
        pages
                .getUserDetailPage()
                .assertPasswordReset(expectedResult);
    }

    @Then("keep username and password")
    public void keepUserNameAndNewPassword() {
        pages
                .getUserDetailPage()
                .keepUserNameAndNewPassword();

    }

    @Given("User resets password")
    public void userResetsPassword() {
        pages
                .getUsersPage()
                .openDropDownMenu()
                .goToUsersPage()
                .openUserDetailPageForIndexedUser(index)
                .clickResetPasswordButton()
                .clickConfirmButton()
                .refreshUserDetailPage()
                .keepUserNameAndNewPassword();


    }

    @And("User logs out")
    public void userLogsOut() {
        pages
                .getUsersPage()
                .logout();
    }

    @When("user sets the new role as default")
    public void userSetsTheNewRoleAsDefault() {
        pages
                .getUserDetailPage()
                .setNewRoleAsDefault();
    }

    @Then("Verify that the new default role is displayed correctly")
    public void verifyThatTheNewDefaultRoleIsDisplayedCorrectly() {
        pages
                .getUserDetailPage()
                .assertNewDefaultRoleIsCorrect();
    }

    @When("User clicks cancel button")
    public void userClicksCancelButton() {
        pages
                .getUserDetailPage()
                .clickCancelButton();
    }

    @Then("Verify that the canceled role is not listed under Roles section")
    public void verifyThatTheCanceledRoleIsNotListedUnderRolesSection() {
        pages
                .getUserDetailPage()
                .assertCanceledRoleIsNotListedUnderRolesSection();
    }

    @When("User click save button")
    public void userClickSaveButton() {
        pages
                .getUserDetailPage()
                .clickSaveButton();
    }

    @Then("Verify that adding role error message {string} is occured")
    public void verifyThatAddingRoleErrorMessageIsOccured(String arg0) {
        pages
                .getUserDetailPage()
                .assertSaveErrorWithoutRole();
    }

    @When("User clicks the Pencil Image")
    public void userClicksThePencilImage() {
        pages
                .getUserDetailPage()
                .clickPencilImage();
    }

    @Then("Verify that pencil image is changed into tick and cross buttons")
    public void verifyThatPencilImageIsChangedIntoTickAndCrossButtons() {
        pages
                .getUserDetailPage()
                .assertVisibilityOfTickImage();
    }

    @Then("Verify that email addres cannot be changed")
    public void verifyThatEmailAddresCannotBeChanged() {
        pages
                .getUserDetailPage()
                .assertEmailAddressUnchangeable();
    }

    @And("User deletes username input")
    public void userDeletesUsernameInput() {
        pages
                .getUserDetailPage()
                .deleteUsernameInputArea();
    }

    @Then("Verify that username error message {string} is occured")
    public void verifyThatUsernameErrorMessageIsOccured(String arg0) {
        pages
                .getUserDetailPage()
                .assertUsernameErrorMessageOccurs();
    }

    @Then("Verify that Reset Password window should be opened")
    public void verifyThatResetPasswordWindowShouldBeOpened() {
        pages
                .getUserDetailPage()
                .assertConfirmButtonIsVisible();
    }

    @Then("Verify that select role window is opened")
    public void verifyThatSelectRoleWindowIsOpened() {
        pages
                .getUserDetailPage()
                .assertSelectARoleWindowOpens();
    }
}
