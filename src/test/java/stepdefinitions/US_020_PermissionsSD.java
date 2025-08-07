package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AllPages;

import java.util.List;
import java.util.Map;

public class US_020_PermissionsSD {

    AllPages allPages = new AllPages();

    // Sayfadaki tüm izinlerin listelendigini dogrular
    @Then("all permissions should be displayed as a list on the Permissions page")
    public void allPermissionsShouldBeDisplayedAsAListOnThePermissionsPage() {
        List<String> permissions = allPages.getPermissionsPage().getAllPermissions();
        System.out.println("Permissions listed on the page:");
        permissions.forEach(permission -> System.out.println("- " + permission));
        Assert.assertFalse(permissions.isEmpty(), "No permissions were listed on the Permissions page.");
    }

    // İzinlerin toplam sayisinin beklenen sayiya esit oldugunu kontrol eder
    @Then("the total number of permissions should be {int}")
    public void the_total_number_of_permissions_should_be(Integer expectedCount) {
        List<String> permissions = allPages.getPermissionsPage().getAllPermissions();
        System.out.println("Number of permissions found: " + permissions.size());
        Assert.assertEquals(permissions.size(), expectedCount.intValue(),
                "The number of permissions on the Permissions page does not match the expected count.");
    }


    @Then("the following permissions are displayed on the Permissions page:")
    public void theFollowingPermissionsAreDisplayedOnThePermissionsPage(DataTable dataTable) {
        List<Map<String, String>> permissionsData = dataTable.asMaps(String.class, String.class);

        List<String> actualPermissions = allPages.getPermissionsPage().getAllPermissions();

        for (Map<String, String> row : permissionsData) {
            String testCaseNo = row.get("testCaseNo");
            String expectedPermission = row.get("permissionVisibility");

            Assert.assertTrue(actualPermissions.contains(expectedPermission),
                    testCaseNo + " - Permission not found on page: " + expectedPermission);
        }
    }
}
