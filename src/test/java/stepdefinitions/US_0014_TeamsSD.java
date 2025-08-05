package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;

public class US_0014_TeamsSD {

    AllPages pages =new AllPages();

    @Then("appear to information tittle")
    public void appearToInformationTittle() {
        assert pages.getNewTeamPage()
                .informationTitleIsDisplay();

    }

    @Then("appear to company tittle")
    public void appearToCompanyTittle() {
        assert pages.getNewTeamPage()
                .companyTitleIsDisplay();

    }


    @Then("appear to company name")
    public void appearToCompanyName() {
        assert pages.getNewTeamPage()
                .companyNameIsDisplay();

    }

    @Then("appear to department name tittle")
    public void appearToDepartmentNameTittle() {
        assert pages.getNewTeamPage()
                .departmentNameTitleIsDisplay();
    }

    @Then("appear to department name button")
    public void appearToDepartmentNameButton() {
        assert pages.getNewTeamPage()
                .departmentNameInputIsDisplay();
    }

    @Then("click to department name button")
    public void clickToDepartmentNameButton() {
        assert pages.getNewTeamPage()
                .departmentNameInputIsClickable();
    }

    @Then("appear to department short name tittle")
    public void appearToDepartmentShortNameTittle() {
        assert pages.getNewTeamPage()
                .shortNameTitleIsDisplay();
    }

    @Then("appear to department short name button")
    public void appearToDepartmentShortNameButton() {
        assert pages.getNewTeamPage()
                .shortNameInputIsDisplay();
    }

    @Then("click to department short name button")
    public void clickToDepartmentShortNameButton() {
        assert pages.getNewTeamPage()
                .shortNameInputIsClickable();
    }

    @Then("appear to department type tittle")
    public void appearToDepartmentTypeTittle() {
        assert pages.getNewTeamPage()
                .departmentTypeTitleIsDisplay();
    }


    @Then("appear to department type dropdown menu")
    public void appearToDepartmentTypeDropdownMenu() {
        assert pages.getNewTeamPage()
                .departmentTypeDropDownMenuIsDisplay();
    }

    @Then("click to department type dropdown menu")
    public void clickToDepartmentTypeDropdownMenu() {
        assert pages.getNewTeamPage()
                .departmentTypeDropDownMenuIsClickable();
    }


    @Then("appear to Description tittle")
    public void appearToDescriptionTittle() {
        assert pages.getNewTeamPage()
                .departmentDescriptionTitle();
    }

    @Then("appear to Department Description button")
    public void appearToDepartmentDescriptionButton() {
        assert pages.getNewTeamPage()
                .departmentDescriptionInputIsDisplay();
    }

    @Then("click to Department Description button")
    public void clickToDepartmentDescriptionButton() {
        assert pages.getNewTeamPage()
                .departmentDescriptionInputClikcable();
    }

    @Then("appear to Roles tittle")
    public void appearToRolesTittle() {
        assert pages.getNewTeamPage()
                .rolesTitleIsDisplay();
    }

    @Then("appear to Department Roles button")
    public void appearToDepartmentRolesButton() {
        assert pages.getNewTeamPage()
                .departmentRolesDropDownMenuIsDisplay();
    }

    @Then("click to Department Roles button")
    public void clickToDepartmentRolesButton() {
        assert pages.getNewTeamPage()
                .departmentRolesDropDownMenuIsClickable();
    }


    @Then("appear to Save button")
    public void appearToSaveButton() {
        assert pages.getNewTeamPage()
                .saveButtonIsDisplay();
    }

    @Then("click to Save button")
    public void clickToSaveButton() {
        assert pages.getNewTeamPage()
                .saveButtonIsClickable();
    }

    @Then("appear to Cancel button")
    public void appearToCancelButton() {
        assert pages.getNewTeamPage()
                .cancelButtonIsDisplay();
    }

    @Then("click to Cancel button")
    public void clickToCancelButton() {
        assert pages.getNewTeamPage()
                .cancelButtonIsClickable();
    }

    @And("select to team")
    public void selectToTeam() {
        pages.getNewTeamPage()
                .selectTeamFromDepartmentTypeDropDownMenu();
    }

    @When("real click to department type dropdown menu")
    public void realClickToDepartmentTypeDropdownMenu() {
        pages.getNewTeamPage()
                .selectDepartmentTypeDropDownMenu();
    }

    @Then("real click to Save button with error assertion")
    public void realClickToSaveButton() {
      assert pages.getNewTeamPage()
                .saveButtonClick()
                .setNameErrorMessageIsDisplay();
    }

    @When("real click to department name button")
    public void realClickToDepartmentNameButton() {
        pages.getNewTeamPage()
                .departmentNameInputClick();
    }

    @And("write to this {string} word in department name area")
    public void writeToThisWordInDepartmentNameArea(String arg0) {
        pages.getNewTeamPage()
                .departmentNameInputSendKeys(arg0);

    }

    @Then("real click to Save button with true assertion")
    public void realClickToSaveButtonWithTrueAssertion() {
        assert pages.getNewTeamPage()
                .saveButtonClick()
                .acceptedMessageIsDisplay();
    }


    @And("write to {string} to search by name button")
    public void writeToToSearchByNameButton(String arg0) {
         pages.getNewTeamPage()
                .returnAndSentMainSearchByNameButton(arg0);
    }

    @And("click to mertay tittle")
    public void clickToMertayTittle() {
        pages.getNewTeamPage()
                .clickFirstMertayTeam();
    }

    @Then("click to edit team button and false assertion")
    public void clickToEditTeamButtonAndFalseAssertion() {

        assert  pages.getTeamDetailPage().EditTeamButtonClick().EditTeamTitleIsDisplay();

    }
}
