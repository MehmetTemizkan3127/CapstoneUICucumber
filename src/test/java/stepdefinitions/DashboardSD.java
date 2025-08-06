package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;

import java.util.List;
import java.util.Map;

public class DashboardSD {
    AllPages pages = new AllPages();

    @When("logo is visible")
    public void logoIsVisible() {
        pages.getDashboardPage().checkLogoIsVisible();
    }

    @Then("logo is enabled")
    public void logoIsClickable() {
        pages.getDashboardPage().checkLogoIsClickable();
    }

    @When("go to userPage")
    public void goToUserPage() {
        pages.getDashboardPage().clickUserPageButton();
    }

    @And("clicks on Logo")
    public void clicksOnLogo() {
        pages.getDashboardPage().clickLogo();
    }

    @Then("user sees Home Page")
    public void userSeesHomePage() {
        pages.getDashboardPage().checkHomePage();
    }


    //****SidebarSD****
    @When("user sees sidebar")
    public void userSeesSidebar() {
        pages.getDashboardPage().isSideBarVisible();
    }

    @And("clicks on minimize icon")
    public void clicksOnMinimizeIcon() {
        pages.getDashboardPage().clickMinimizeSideBar();
    }

    @And("user sees minimized Sidebar")
    public void userSeesMinimizedSidebar() throws InterruptedException {
        pages.getDashboardPage().isMinimizedSideBarVisible();
    }

    @Then("user sees maximized sidebar")
    public void userSeesMaximizedSidebar() {
        pages.getDashboardPage().isMaximizedSideBarVisible();
    }

    @When("user clicks on maximize icon")
    public void user_clicks_on_maximize_icon() {
        pages.getDashboardPage().clickMaximizeSideBar();
    }

    //**** DropDownMenüSD******
    //US003-01
    @When("The user clicks on the profile image")
    public void theUserClicksOnTheProfileImage() {
        pages.getDashboardPage().clickProfileImage();
    }

    @Then("The dropdown menu should display the user's email and role")
    public void theDropdownMenuShouldDisplayTheUserSEmailAndRole() {
        pages.getDashboardPage().checkDisplayUserEmailAndRole();
    }

    @And("The dropdown menu should display the user's company")
    public void theDropdownMenuShouldDisplayTheUserSCompany() {
        pages.getDashboardPage().checkDisplayUserCompany();
    }

    //US003-02
    @And("The user clicks on the {string} option")
    public void theUserClicksOnTheOption(String arg0) {
        pages.getDashboardPage().clickOnPopupMenu(arg0);
    }

    @Then("The user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToTheSubscriptionsPage(String page) {
        //pages.getDashboardPage().checksOnPage(page);
    }

    //US003-03
    @Then("The user should be redirected to the Memberships page")
    public void theUserShouldBeRedirectedToTheMembershipsPage() {

    }

    //US003-03
    @Then("The user should be redirected to the Login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        pages.getDashboardPage().checkHomePage();
    }

    @And("The session should be terminated")
    public void theSessionShouldBeTerminated() {

    }

    //@UserDetailsCheck
    @Then("user sees own avatar")
    public void userSeesOwnAvatar() {
        pages.getDashboardPage().checkAvatar();
    }

    @And("user sees own username and role")
    public void userSeesOwnEmailAddress() {
        pages.getDashboardPage().checkUsernameAndRole();
    }

    @And("user sees own company")
    public void userSeesOwnCompany() {
        pages.getDashboardPage().checkCompany();
    }

    @And("user clicks on MenuItem from the sidebar and sees the BreadCrumb page")
    public void userClicksOnMenuItemFromTheSidebarAndSeesTheBreadCrumbPage(DataTable dataTable) {
        List<Map<String, String>> links = dataTable.asMaps(String.class, String.class);
        pages.getDashboardPage().checkSideBarLinks(links);
    }
}

