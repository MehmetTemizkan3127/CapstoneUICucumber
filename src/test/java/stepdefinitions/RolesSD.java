package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RolesPage;

import java.util.List;

public class RolesSD {

    RolesPage rolesPage = new RolesPage();

    @When("user expands the left menu if collapsed")
    public void user_expands_the_left_menu_if_collapsed() {
        rolesPage.collapseMenuIfExpanded();
    }

    @When("user clicks the 'Roles' option in the left menu")
    public void user_clicks_the_roles_option_in_the_left_menu() {
        rolesPage.navigateToRolesPage();
    }

    @Then("the list of all roles should be visible on the Roles page")
    public void the_list_of_all_roles_should_be_visible_on_the_roles_page() {
        List<String> roles = rolesPage.getAllRoles();
        System.out.println("Roles on the page:");
        for (String role : roles) {
            System.out.println("- " + role);
        }
        Assert.assertFalse(roles.isEmpty(), "Roles list should not be empty");
    }

    @Then("the role with name {string} should be visible on the Roles page")
    public void the_role_with_name_should_be_visible_on_the_roles_page(String roleName) {
        Assert.assertTrue(rolesPage.isRoleVisible(roleName), "Role not found: " + roleName);
    }

}
