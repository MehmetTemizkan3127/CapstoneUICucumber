package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AllPages;

import java.util.List;
import java.util.Map;

public class US_019_RolesPermissionsSD {
    AllPages allPages = new AllPages();


    //TC_019_001 - TC_019_016 - Belirtilen rolün tiklanabilirligini kontrol eder
    @Then("the following roles should be clickable on the Roles page:")
    public void the_following_roles_should_be_clickable_on_the_roles_page(DataTable dataTable) {
        List<Map<String, String>> rolesData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rolesData) {
            String testCaseNo = row.get("testCaseNo");
            String roleName = row.get("roleClickable");
            Assert.assertTrue(
                    allPages.getRolesPage().isRoleClickable(roleName),
                    testCaseNo + " - Role is not clickable: " + roleName
            );
        }
    }

    //TC_019_017 - TC_019_032 - İlgili role tiklayarak detay sayfasina gider
    @Then("the following roles should navigate to the Role Detail page when clicked:")
    public void the_following_roles_should_navigate_to_the_role_detail_page_when_clicked(DataTable dataTable) {
        List<Map<String, String>> rolesData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rolesData) {
            String testCaseNo = row.get("testCaseNo");
            String roleName = row.get("roleClickable");

            allPages.getRolesPage().clickRoleByName(roleName);

            Assert.assertTrue(
                    allPages.getRolesPage().isRoleDetailPageVisible(),
                    testCaseNo + " - Failed to navigate to Role Detail page for role: " + roleName
            );

            allPages.getRolesPage().navigateBackToRolesFromDetail();
        }
    }

    //TC_019_017 - TC_019_032 - Role Detail (detay) sayfasinin acildigini kontrol eder
    @Then("the following roles detail page should be displayed when clicked:")
    public void the_following_roles_detail_page_should_be_displayed_when_clicked(DataTable dataTable) {
        List<Map<String, String>> rolesData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rolesData) {
            String testCaseNo = row.get("testCaseNo");
            String roleName = row.get("roleDisplay");

            allPages.getRolesPage().clickRoleByName(roleName);

            Assert.assertTrue(
                    allPages.getRolesPage().isRoleDetailPageVisible(),
                    testCaseNo + " - Role Detail page is not displayed for role: " + roleName
            );

            allPages.getRolesPage().navigateBackToRolesFromDetail();
        }
    }

    //TC_019_033 - TC_019_048 - Secilen role ait tüm izinleri (permissions) döner
    @Then("the defined permissions for the following roles should be displayed on the detail page:")
    public void the_defined_permissions_for_the_following_roles_should_be_displayed_on_the_detail_page(DataTable dataTable) {
        List<Map<String, String>> rolesData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rolesData) {
            String testCaseNo = row.get("testCaseNo");
            String roleName = row.get("roleVisibilityPermission");

            allPages.getRolesPage().clickRoleByName(roleName);

            Assert.assertTrue(
                    allPages.getRolesPage().arePermissionsDisplayed(),
                    testCaseNo + " - Permissions are not displayed for role: " + roleName
            );

            allPages.getRolesPage().navigateBackToRolesFromDetail();
        }
    }
}
