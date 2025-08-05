package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.util.List;
import java.util.stream.Collectors;

public class RolesPage {

    private final By collapseMenuIcon = By.cssSelector("svg.icon.icon-xl.fw-bolder[alt='Collapse']");
    private final By rolesMenuLink = By.xpath("//a[contains(., 'Roles')]");
    private final By rolesList = By.cssSelector("button.btn.btn-light.border.w-100.mw-100.text-start");
    private final By breadcrumbRoleDetail = By.xpath("//li[@class='breadcrumb-item active' and text()='Role Detail']");
    private final By permissionsLabels = By.xpath("//label[contains(@class, 'btn') and contains(@class, 'btn-outline-secondary')]");

    public void collapseMenuIfExpanded() {
        List<WebElement> collapseIcons = ReusableMethods.visibilityOfElementsByWebDriverWait(collapseMenuIcon);
        if (!collapseIcons.isEmpty()) {
            collapseIcons.getFirst().click();
        }
    }

    public void navigateToRolesPage() {
        ReusableMethods.waitForSeconds(2);
        ReusableMethods.clickElementByWebDriverWait(rolesMenuLink).click();
    }

    public List<String> getAllRoles() {
        ReusableMethods.waitForSeconds(2);
        List<WebElement> roles = ReusableMethods.visibilityOfElementsByWebDriverWait(rolesList);
        return roles.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public boolean isRoleVisible(String roleName) {
        return getAllRoles().stream()
                .anyMatch(role -> role.equalsIgnoreCase(roleName));
    }

    public boolean isRoleClickable(String roleName) {
        List<WebElement> roles = ReusableMethods.visibilityOfElementsByWebDriverWait(rolesList);
        for (WebElement role : roles) {
            if (role.getText().trim().equalsIgnoreCase(roleName)) {
                return role.isDisplayed() && role.isEnabled();
            }
        }
        return false;
    }

    public void clickRoleByName(String roleName) {
        ReusableMethods.waitForSeconds(2);
        List<WebElement> roles = ReusableMethods.visibilityOfElementsByWebDriverWait(rolesList);
        for (WebElement role : roles) {
            if (role.getText().trim().equalsIgnoreCase(roleName)) {
                ReusableMethods.waitForSeconds(1); // stabilizasyon için
                role.click();
                return;
            }
        }
        throw new RuntimeException("Role not found to click: " + roleName);
    }

    public boolean isRoleDetailPageVisible() {
        List<WebElement> breadcrumb = ReusableMethods.visibilityOfElementsByWebDriverWait(breadcrumbRoleDetail);
        return !breadcrumb.isEmpty() && breadcrumb.getFirst().isDisplayed();
    }

    public List<String> getAllPermissionsForSelectedRole() {
        List<WebElement> permissionElements = ReusableMethods.visibilityOfElementsByWebDriverWait(permissionsLabels);
        return permissionElements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public boolean arePermissionsDisplayed() {
        return !getAllPermissionsForSelectedRole().isEmpty();
    }
}