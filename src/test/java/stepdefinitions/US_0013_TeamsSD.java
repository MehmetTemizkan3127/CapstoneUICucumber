package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;

public class US_0013_TeamsSD {

    AllPages pages = new AllPages();

    @And("The teams button should appear")
    public void theTeamsButtonShouldAppear() {
        assert pages.getTeamsPage()
                .MainTeamsButtonIsAppear();
    }

    @Then("The teams button should be clickable")
    public void theTeamsButtonShouldBeClickable() {

        assert pages.getTeamsPage()
                .MainTeamsButtonIsClickable();
    }

    @Then("add new team button should appear")
    public void addNewTeamButtonShouldBeAppear() {

        assert pages.getTeamsPage()
                .AddNewTeamButtonIsAppear();
    }

    @Then("add new team button should be clickable")
    public void addNewTeamButtonShouldBeClickable() {
        assert pages.getTeamsPage()
                .AddNewTeamButtonIsClickable();
    }

    @Then("The teams tittle should appear")
    public void theTeamsTittleShouldAppear() {

        assert pages.getTeamsPage()
                .TeamTittleVisibility();
    }

    @Then("The search area should be clickable")
    public void theSearchAreaShouldBeClickable() {

        assert pages.getTeamsPage()
                .SearchByNameInputBoxIsClickable();

    }

    @Then("The search area button should appear")
    public void theSearchAreaButtonShouldBeAppear() {

        assert pages.getTeamsPage()
                .SearchByNameInputBoxIsAppear();

    }


    @Then("The clear filters button should appear")
    public void theClearFiltersButtonShouldBeAppear() {

        assert pages.getTeamsPage()
                .ClearFiltersButtonISAppear();


    }

    @Then("The clear filters button should be clickable")
    public void theClearFiltersButtonShouldBeClickable() {

        assert pages.getTeamsPage()
                .ClearFiltersButtonISClickable();

    }

    @Then("The search box should clean")
    public void theSearchBoxShouldClean() {
        assert pages.getTeamsPage()
                .ClearFiltersButtonClick()
                .TheSearchBoxGetAttribute()
                .isEmpty();


    }

    @When("user types {string} into the search box")
    public void userTypesIntoTheSearchBox(String arg0) {

        pages.getTeamsPage()
                .TheSearchBoxSendKeys(arg0);

    }


    @Then("each area title should contain {string}")
    public void eachAreaTitleShouldContain(String arg1) {

        assert pages.getTeamsPage()
                .TitlesAreContain1(arg1);
    }

    @Then("teams title text click")
    public void teamsTitleTextClick() {

        pages.getTeamsPage()
                .TeamsTitleTextsClick();
    }

    @And("click to new user button")
    public void clickToNewUserButton() {
        pages.getTeamDetailPage()
                .NewUserButtonClick();
    }

    @And("click to search by name or email button")
    public void clickToSearchByNameOrEmailButton() {

        pages.getTeamDetailPage()
                .SearchByNameOrEmailButtonClick();
    }

    @And("write to {string} in this area")
    public void writeToInThisArea(String arg0) {

        pages.getTeamDetailPage()
                .SearchByNameOrEmailButtonSendKeys(arg0);

    }

    @And("click to name checkbox")
    public void clickToNameCheckbox() {

        pages.getTeamDetailPage()
                .CheckBoxClick();

    }

    @And("click to add selected users")
    public void clickToAddSelectedUsers() {

       assert pages.getTeamDetailPage()
                .AddedSelectorUsersClick()
                .AddedSuccesTextMessageAssert();


    }

    @Then("Added new team button")
    public void addedNewTeamButton() {

        pages.getTeamsPage().AddNewTeamButtonClick();
    }
}
