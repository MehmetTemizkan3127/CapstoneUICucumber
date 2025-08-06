package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AllPages;
import pages.RolesPage;

import java.util.List;

public class RolesSD {

    AllPages allPages = new AllPages();

    /*
    @When("user expands the left menu if collapsed")
    public void user_expands_the_left_menu_if_collapsed() {
        allPages.getRolesPage().collapseMenuIfExpanded();
    }
*/

    @When("user clicks the {string} option in the left menu")
    public void userClicksMenuOption(String option) {
        switch (option.toLowerCase()) {
            case "roles":
                allPages.getRolesPage().navigateToRolesPage();
                break;
            case "permissions":
                allPages.getPermissionsPage().navigateToPermissionsPage();
                break;
            default:
                throw new IllegalArgumentException("Unknown menu option: " + option);
        }
    }

    @Then("the list of all roles should be visible on the Roles page")
    public void the_list_of_all_roles_should_be_visible_on_the_roles_page() {
        List<String> roles = allPages.getRolesPage().getAllRoles();
        System.out.println("Roles on the page:");
        roles.forEach(role -> System.out.println("- " + role));
        Assert.assertFalse(roles.isEmpty(), "Roles list should not be empty");
    }

    @Then("the role with name {string} should be visible on the Roles page")
    public void the_role_with_name_should_be_visible_on_the_roles_page(String roleName) {
        Assert.assertTrue(allPages.getRolesPage().isRoleVisible(roleName), "Role not found: " + roleName);
    }

    @Then("the role with name {string} should be clickable on the Roles page")
    public void the_role_with_name_should_be_clickable_on_the_roles_page(String roleName) {
        Assert.assertTrue(allPages.getRolesPage().isRoleClickable(roleName), "Role is not clickable: " + roleName);
    }

    @When("the user clicks the {string} role on the Roles page")
    public void the_user_clicks_the_role_on_the_roles_page(String roleName) {
        allPages.getRolesPage().clickRoleByName(roleName);
    }

    @Then("the Role Detail page should be displayed")
    public void the_role_detail_page_should_be_displayed() {
        Assert.assertTrue(allPages.getRolesPage().isRoleDetailPageVisible(), "Role Detail page was not displayed!");
    }

    @Then("the defined permissions for the role should be displayed")
    public void the_defined_permissions_for_the_role_should_be_displayed() {
        Assert.assertTrue(allPages.getRolesPage().arePermissionsDisplayed(), "No defined permissions are displayed for the selected role.");
    }
}