package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;
import java.util.stream.Collectors;

public class RolesPage {

    private final By collapseMenuIcon = By.cssSelector("svg.icon.icon-xl.fw-bolder[alt='Collapse']");
    private final By rolesMenuLink = By.xpath("//a[normalize-space()='Roles']");
    private final By rolesList = By.xpath("//div[contains(@class, 'col-lg-4') and contains(@class, 'd-grid')]//button[contains(@class, 'btn') and contains(@class, 'btn-light')]");

    public void collapseMenuIfExpanded() {
        List<WebElement> collapseIcons = Driver.getDriver().findElements(collapseMenuIcon);
        if (!collapseIcons.isEmpty()) {
            collapseIcons.get(0).click();
        }
    }

    public void navigateToRolesPage() {
        Driver.getDriver().findElement(rolesMenuLink).click();
    }

    public List<String> getAllRoles() {
        List<WebElement> roles = Driver.getDriver().findElements(rolesList);
        return roles.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public boolean isRoleVisible(String roleName) {
        return getAllRoles().stream()
                .anyMatch(role -> role.equalsIgnoreCase(roleName));
    }

}
