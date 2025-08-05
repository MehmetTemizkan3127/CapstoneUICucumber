package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class PermissionsPage {

    private final By permissionsMenuLink = By.xpath("//a[@href='#/permissions' and contains(., 'Permissions')]");
    private final By permissionsList = By.xpath("//div[contains(@class, 'd-grid') and contains(@class, 'mb-2')]//button[contains(@class, 'btn-outline-secondary')]");

    public PermissionsPage navigateToPermissionsPage() {
        ReusableMethods.waitForSeconds(2);
        WebElement element = Driver.getDriver().findElement(permissionsMenuLink);
        scrollAndClick(element);
        return this;
    }

    public List<String> getAllPermissions() {
        ReusableMethods.waitForSeconds(2);
        List<WebElement> permissions = Driver.getDriver().findElements(permissionsList);
        return permissions.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public boolean arePermissionsVisible() {
        return !getAllPermissions().isEmpty();
    }

    // Scroll edip tıklamaya çalışan ortak method
    private void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", element);  // JS ile zorla tıkla
        }
    }
}
