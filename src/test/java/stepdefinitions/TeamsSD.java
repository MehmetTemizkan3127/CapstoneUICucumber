package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.AllPages;

public class TeamsSD {
    AllPages pages = new AllPages();
    @And("The teams button should appear")
    public void theTeamsButtonShouldAppear() {
      assert  pages
                .getTeamsPage()
                .MainTeamsButtonIsAppear();
    }

    @Then("The teams button should be clickable")
    public void theTeamsButtonShouldBeClickable() {

        assert pages
                .getTeamsPage()
                .MainTeamsButtonIsClickable();
    }

    @Then("add new team button should be appear")
    public void addNewTeamButtonShouldBeAppear() {

        assert pages
                .getTeamsPage()
                .AddNewTeamButtonIsAppear();
    }

    @Then("add new team button should be clickable")
    public void addNewTeamButtonShouldBeClickable() {
        assert pages
                .getTeamsPage()
                .AddNewTeamButtonIsClickable();
    }

    @Then("The teams tittle should appear")
    public void theTeamsTittleShouldAppear() {

        assert pages
                .getTeamsPage()
                .TeamTittleVisibility();
    }

    @Then("The search area should be clickable")
    public void theSearchAreaShouldBeClickable() {

        assert pages
                .getTeamsPage()
                .SearchByNameInputBoxIsClickable();

    }

    @Then("The search area button should be appear")
    public void theSearchAreaButtonShouldBeAppear() {

        assert pages
                .getTeamsPage()
                .SearchByNameInputBoxIsAppear();

    }


}
