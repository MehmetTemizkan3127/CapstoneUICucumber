package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.Driver.getDriver;

public class ReusableMethods {

    // CLICK METHODS------------------------------------------------------------------------------------------------------
    public static void clickElement(By by) {
        Driver.getDriver().findElement(by).click();
    }

    public static WebElement clickElementByWebDriverWait(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(by)));
    }

    public static void clickElementByJS(By by) {
        JavascriptUtils.clickElementByJS(Driver.getDriver().findElement(by));
    }

    // SENDKEYS METHODS------------------------------------------------------------------------------------------------------
    public static void sendKeys(By by, String data) {
        Driver.getDriver().findElement(by).sendKeys(data);
    }

    // ISDISPLAYED / ISVISIBLE  METHODS------------------------------------------------------------------------------------------------------
    public static boolean isDisplayed(By by) {
        return Driver.getDriver().findElement(by).isDisplayed();
    }

    public static WebElement isVisibleByWebDriverWait(By by) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(by)));
    }

    //ISENABLED METHODS------------------------------------------------------------------------------------------------------
    public static boolean isEnabled(By by) {
        return Driver.getDriver().findElement(by).isEnabled();
    }

    //ISSELECTED METHODS------------------------------------------------------------------------------------------------------
    public static boolean isSelected(By by) {
        return Driver.getDriver().findElement(by).isSelected();
    }

    //ISCLICKABLE METHODS------------------------------------------------------------------------------------------------------
    public static boolean isClickableByWebDriverWait(By by) {
        try {
            clickElementByWebDriverWait(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//URL CONTAINS METHOD       * Waits for the current URL to contain the given string.

    public static boolean urlContainsByWebDriverWait(String data) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            return wait.until(ExpectedConditions.urlContains(data));
        } catch (TimeoutException e) {
            return false;
        }
    }

    //GET TEXT OF ELEMENT     * Returns trimmed text of a WebElement.
    public static String getTextOfElement(By by) {
        String text = Driver.getDriver().findElement(by).getText().trim();
        return text;
    }

    //CONVERT ELEMENT TEXT INTO INTEGER    * Extracts and returns an integer from a WebElement's text.  * (e.g. "$1,234" → 1234)
    public static int convertElementTextIntoInteger(WebElement element) {
        String text = element.getText().replaceAll("[^0-9]", "");
        if (text.isEmpty()) {
            throw new NumberFormatException("Element text does not contain any numeric characters: " + element.getText());
        }
        return Integer.parseInt(text);
    }

    //THREAD.SLEEP METHOD
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep was interrupted");
        }
    }

}

