package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllPages;
import utilities.ConfigReader;

public class US_015_UsersSD {

    AllPages pages = new AllPages();
    public static int index = Integer.parseInt(ConfigReader.getProperty("indexOfUserList"));

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

    @Then("verify each user has an email")
    public void verifyEachUserHasAnEmail() {
        pages
                .getUsersPage()
                .assertVisibilityOfEmailOfEachUser();
    }

    @Then("Verify that each user has a visible since date")
    public void verifyThatEachUserHasAVisibleSinceDate() {
        pages
                .getUsersPage()
                .assertVisibilityOfSinceOfEachUser();
    }

    @Then("Verify that each user has a visible access type")
    public void verifyThatEachUserHasAVisibleAccessType() {
        pages
                .getUsersPage()
                .assertVisibilityOfAccessTypeOfEachUser();
    }

    @Then("Verify that each user has a visible status")
    public void verifyThatEachUserHasAVisibleStatus() {
        pages
                .getUsersPage()
                .assertVisibilityOfStatusOfEachUser();
    }


}
