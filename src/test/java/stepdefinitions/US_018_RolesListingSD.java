package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AllPages;

import java.util.List;
import java.util.Map;

public class US_018_RolesListingSD {

    AllPages allPages = new AllPages();

    //US_0018

    //TC_018_001 - Roles sayfasındaki tüm rol isimlerini listeler
    @Then("the list of all roles should be visible on the Roles page")
    public void the_list_of_all_roles_should_be_visible_on_the_roles_page() {
        List<String> roles = allPages.getRolesPage().getAllRoles();
        Assert.assertFalse(roles.isEmpty(), "Roles list should not be empty");
    }

    //TC_018_002 - TC_018_017 - Tüm rollerin görünür oldugunu kontrol eder
    @Then("the following roles should be visible on the Roles page:")
    public void the_following_roles_should_be_visible_on_the_roles_page(DataTable dataTable) {
        List<Map<String, String>> rolesData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rolesData) {
            String roleName = row.get("roleVisibility");
            Assert.assertTrue(allPages.getRolesPage().isRoleVisible(roleName), "Role not found: " + roleName);
        }
    }

}
