package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.Driver;

public class DashboardPage {

    public void checkLogoIsVisible() {
        WebElement logoButton = Driver.getDriver().findElement(By.className("navbar-brand"));
        Assert.assertTrue(logoButton.isDisplayed());
    }


    public void checkLogoIsClickable() {
        WebElement element = Driver.getDriver().findElement(By.className("navbar-brand"));
        Assert.assertTrue(element.isEnabled());
    }

    public void clickUserPageButton() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"link8\"]"));
        element.click();
    }

    public void checkHomePage() {
        WebElement h1 = Driver.getDriver().findElement(By.tagName("h1"));
        Assert.assertEquals(h1.getText(), "Welcome to QuaSpareparts.com");
    }

    public void clickLogo() {
        WebElement element = Driver.getDriver().findElement(By.className("navbar-brand"));
        element.click();
    }

    public void isSideBarVisible() {
        WebElement element = Driver.getDriver().findElement(By.id("Sidebar"));
        Assert.assertTrue(element.isDisplayed());
    }

    public void clickMinimizeSideBar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement btnCollapse = Driver.getDriver().findElement(By.className("btnCollapse"));
        js.executeScript("arguments[0].click();", btnCollapse);
    }

    public void isMinimizedSideBarVisible() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = Driver.getDriver().findElement(By.id("Sidebar"));
        Assert.assertTrue(element.getAttribute("class").contains("minimize"));
    }

    public void clickMaximizeSideBar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement btnCollapse = Driver.getDriver().findElement(By.className("btnCollapse"));
        js.executeScript("arguments[0].click();", btnCollapse);
    }

    public void isMaximizedSideBarVisible() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = Driver.getDriver().findElement(By.id("Sidebar"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertFalse(element.getAttribute("class").contains("minimize"));
    }
}

