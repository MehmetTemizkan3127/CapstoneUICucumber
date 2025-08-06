package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AllPages;

import java.util.List;

public class PermissionsSD {

    AllPages allPages = new AllPages();

    @When("the user navigates to the Permissions page")
    public void the_user_navigates_to_the_permissions_page() {
        allPages.getPermissionsPage().navigateToPermissionsPage();
    }

    @Then("all permissions should be visible on the Permissions page")
    public void all_permissions_should_be_visible_on_the_permissions_page() {
        Assert.assertTrue(allPages.getPermissionsPage().arePermissionsVisible(), "Permissions list is empty or not visible!");
    }

    @Then("all permissions should be displayed as a list on the Permissions page")
    public void allPermissionsShouldBeDisplayedAsAListOnThePermissionsPage() {
        List<String> permissions = allPages.getPermissionsPage().getAllPermissions();
        System.out.println("Permissions listed on the page:");
        permissions.forEach(permission -> System.out.println("- " + permission));
        Assert.assertFalse(permissions.isEmpty(), "No permissions were listed.");
    }

    @Then("the total number of permissions should be 94")
    public void the_total_number_of_permissions_should_be_94() {
        List<String> permissions = allPages.getPermissionsPage().getAllPermissions();
        int actualSize = permissions.size();
        System.out.println("Total permissions found: " + actualSize);
        Assert.assertEquals(actualSize, 94, "Expected exactly 94 permissions, but found " + actualSize);
    }

    @Then("the {string} permission is displayed on the Permissions page")
    public void the_permission_is_displayed_on_the_permissions_page(String permission) {
        List<String> permissions = allPages.getPermissionsPage().getAllPermissions();
        Assert.assertTrue(permissions.contains(permission),
                "Permission '" + permission + "' is NOT displayed on the Permissions page.");
    }
}