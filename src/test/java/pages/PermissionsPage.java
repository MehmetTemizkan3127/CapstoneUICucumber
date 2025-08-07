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

import static utilities.Driver.getDriver;

public class PermissionsPage {

    private final By permissionsList = By.xpath("//div[contains(@class, 'd-grid') and contains(@class, 'mb-2')]//button[contains(@class, 'btn-outline-secondary')]");

    // Sayfadaki tüm izinleri listeler
    public List<String> getAllPermissions() {
        //ReusableMethods.waitForSeconds(2);
        List<WebElement> permissions = getDriver().findElements(permissionsList);
        return permissions.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    // Permissions sayfasında izinler görünür mü kontrol eder
    public boolean arePermissionsVisible() {
        return !getAllPermissions().isEmpty();
    }

}
