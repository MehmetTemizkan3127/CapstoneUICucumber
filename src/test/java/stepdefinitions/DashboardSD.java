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
    public void userSeesMinimizedSidebar() {
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
}
