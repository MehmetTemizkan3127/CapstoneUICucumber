package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import java.util.List;
import java.util.stream.Collectors;

public class RolesPage {

    //LOCATOR TANIMLARI
    private final By rolesMenuLink = By.xpath("//a[contains(., 'Roles')]");
    private final By rolesList = By.cssSelector("button.btn.btn-light.border.w-100.mw-100.text-start");
    private final By breadcrumbRoleDetail = By.xpath("//li[@class='breadcrumb-item active' and text()='Role Detail']");
    private final By breadcrumbRoles = By.xpath("//li[@class='breadcrumb-item']//a[text()='Roles']");
    private final By permissionsLabels = By.xpath("//label[contains(@class, 'btn') and contains(@class, 'btn-outline-secondary')]");


    //US_0018

    //TC_018_001 - Roles sayfasındaki tüm rol isimlerini listeler
    public List<String> getAllRoles() {
        //ReusableMethods.waitForSeconds(2);
        List<WebElement> roles = ReusableMethods.visibilityOfElementsByWebDriverWait(rolesList);
        return roles.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    //TC_018_002 - TC_018_017 - Tüm rollerin görünür oldugunu kontrol eder
    public boolean isRoleVisible(String roleName) {
        return getAllRoles().stream()
                .anyMatch(role -> role.equalsIgnoreCase(roleName));
    }



    //US_0019

    //TC_019_001 - TC_019_016 - Belirtilen rolün tiklanabilirligini kontrol eder
    public boolean isRoleClickable(String roleName) {
        List<WebElement> roles = ReusableMethods.visibilityOfElementsByWebDriverWait(rolesList);
        for (WebElement role : roles) {
            if (role.getText().trim().equalsIgnoreCase(roleName)) {
                return role.isDisplayed() && role.isEnabled();
            }
        }
        return false;
    }

    //TC_019_017 - TC_019_032 - İlgili role tiklayarak detay sayfasina gider
    public RolesPage clickRoleByName(String roleName) {
        //ReusableMethods.waitForSeconds(2);
        List<WebElement> roles = ReusableMethods.visibilityOfElementsByWebDriverWait(rolesList);
        for (WebElement role : roles) {
            if (role.getText().trim().equalsIgnoreCase(roleName)) {
                ReusableMethods.waitForSeconds(1);
                try {
                    role.click();
                    ReusableMethods.waitForSeconds(1);
                    return this;
                } catch (Exception e) {
                    throw new RuntimeException("Failed to click role: " + roleName + ". Reason: " + e.getMessage());
                }
            }
        }
        throw new RuntimeException("Role not found to click: " + roleName);
    }

    //TC_019_017 - TC_019_032 - Role Detail (detay) sayfasinin acildigini kontrol eder
    public boolean isRoleDetailPageVisible() {
        List<WebElement> breadcrumb = ReusableMethods.visibilityOfElementsByWebDriverWait(breadcrumbRoleDetail);
        return !breadcrumb.isEmpty() && breadcrumb.get(0).isDisplayed();
    }

    //TC_019_033 - TC_019_048 - Secilen role ait tüm izinleri (permissions) döner
    public List<String> getAllPermissionsForSelectedRole() {
        List<WebElement> permissionElements = ReusableMethods.visibilityOfElementsByWebDriverWait(permissionsLabels);
        return permissionElements.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    //TC_019_033 - TC_019_048 - Role detail sayfasinda izinlerin görüntülenip görüntülenmedigini kontrol eder
    public boolean arePermissionsDisplayed() {
        List<String> permissions = getAllPermissionsForSelectedRole();
        return permissions != null && !permissions.isEmpty();
    }

    //Ortak kullanım - Role Detail sayfasindan geri "Roles" sayfasina dönüş yapar
    public RolesPage navigateBackToRolesFromDetail() {
        WebElement backToRoles = ReusableMethods.clickElementByWebDriverWait(breadcrumbRoles);
        try {
            backToRoles.click();
            ReusableMethods.waitForSeconds(2);
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate back to Roles page. Reason: " + e.getMessage());
        }
        return this;
    }
}
