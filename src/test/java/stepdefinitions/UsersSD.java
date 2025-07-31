package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AllPages;

public class UsersSD {

    AllPages pages = new AllPages();

    @Given("User goes to usersPage")
    public void userGoesToUsersPage() {
        pages
                .getUsersPage()
                .openDropDownMenu()
                .changeRoleToClaruswayCompany()
                .goToUsersPage();
    }

    @Then("verify that  page opened")
    public void verifyThatPageOpened() {
        pages
                .getUsersPage()
                .assertUsersPageOpens();
    }

    @Then("verify userList exists")
    public void verifyUserListExists() {
        pages
                .getUsersPage()
                .assertVisibilityOfUsersList();
    }
}
