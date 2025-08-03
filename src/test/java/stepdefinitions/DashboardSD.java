package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;

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

    @When("user clicks on MySubscriptions")
    public void userClicksOnMySubscriptions() {
        pages.getDashboardPage().clickMySubscriptions();
    }


    @Then("user sees MySubscriptions page")
    public void userSeesMySubscriptionsPage() {
        pages.getDashboardPage().checkMySubscriptions();
    }

    @When("user clicks on MyMemberships")
    public void userClicksOnMyMemberships() {
        pages.getDashboardPage().clickMyMemberships();
    }

    @Then("user sees MyMemberships page")
    public void userSeesMyMembershipsPage() {
        pages.getDashboardPage().checkMyMemberships();
    }


    @When("user clicks on CompanyGroup")
    public void userClicksOnCompanyGroup() {
        pages.getDashboardPage().clickCompanyGroup();
    }

    @Then("user sees CompanyGroup page")
    public void userSeesCompanyGroupPage() {
        pages.getDashboardPage().checkCompanyGroup();
    }

    @When("user clicks on Company")
    public void userClicksOnCompany() {
        pages.getDashboardPage().clickCompany();
    }

    @Then("user sees Company page")
    public void userSeesCompanyPage() {
        pages.getDashboardPage().checkCompany();
    }

    @When("user clicks on Departments")
    public void userClicksOnDepartments() {
        pages.getDashboardPage().clickDepartments();
    }

    @Then("user sees Departments page")
    public void userSeesDepartmentsPage() {
        pages.getDashboardPage().checkDepartments();
    }

    @When("user clicks on RemoteUnits")
    public void userClicksOnRemoteUnits() {
        pages.getDashboardPage().clickRemoteUnits();
    }

    @Then("user sees RemoteUnits page")
    public void userSeesRemoteUnitsPage() {
        pages.getDashboardPage().checkRemoteUnits();
    }

    @When("user clicks on Teams")
    public void userClicksOnTeams() {
        pages.getDashboardPage().clickTeams();
    }

    @Then("user sees Teams page")
    public void userSeesTeamsPage() {
        pages.getDashboardPage().checkTeams();
    }

    @When("user clicks on Users")
    public void userClicksOnUsers() {
        pages.getDashboardPage().clickUsers();
    }

    @Then("user sees Users page")
    public void userSeesUsersPage() {
        pages.getDashboardPage().checkUsers();
    }

    @When("user clicks on Roles")
    public void userClicksOnRoles() {
        pages.getDashboardPage().clickRoles();
    }

    @Then("user sees Roles page")
    public void userSeesRolesPage() {
        pages.getDashboardPage().checkRoles();
    }

    @When("user clicks on Permissions")
    public void userClicksOnPermissions() {
        pages.getDashboardPage().clickPermissions();
    }

    @Then("user sees Permissions page")
    public void userSeesPermissionsPage() {
        pages.getDashboardPage().checkPermissions();
    }

    @When("user clicks on AccessToken")
    public void userClicksOnAccessToken() {
        pages.getDashboardPage().clickAccessToken();
    }

    @Then("user sees AccessToken page")
    public void userSeesAccessTokenPage() {
        pages.getDashboardPage().checkAccessToken();
    }
}

