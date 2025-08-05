package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

    public void isMinimizedSideBarVisible() throws InterruptedException {
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

    public void clickMySubscriptions() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link1\"]/a")).click();
    }

    public void checkMySubscriptions() {

        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[1]/h3"));
        Assert.assertEquals(element.getText(), "My Subscriptions");
    }

    public void clickMyMemberships() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link2\"]/a")).click();
    }

    public void checkMyMemberships() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/h3"));
        Assert.assertEquals(element.getText(), "My Memberships");
    }

    public void clickCompanyGroup() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link3\"]/a")).click();
    }

    public void checkCompanyGroup() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/h2"));
        Assert.assertEquals(element.getText(), "Your Company Group");
    }

    public void clickCompany() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link4\"]/a")).click();
    }

    public void checkCompany() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div[1]/div/h5"));
        Assert.assertEquals(element.getText(), "Company Information");
    }

    public void clickDepartments() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link5\"]/a")).click();
    }

    public void checkDepartments() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[1]/h3"));
        Assert.assertEquals(element.getText(), "Departments");
    }

    public void clickRemoteUnits() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link6\"]/a")).click();
    }

    public void checkRemoteUnits() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[1]/h3"));
        Assert.assertEquals(element.getText(), "Remote Units");
    }

    public void clickTeams() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link7\"]/a")).click();
    }

    public void checkTeams() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[1]/h3"));
        Assert.assertEquals(element.getText(), "Teams");
    }

    public void clickUsers() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link8\"]/a")).click();
    }

    public void checkUsers() {
        Driver.getDriver().findElement(By.id("search"));

    }

    public void clickRoles() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link9\"]/a")).click();
    }

    public void checkRoles() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/h3"));
        Assert.assertEquals(element.getText(), "All Roles");
    }

    public void clickPermissions() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link10\"]/a")).click();
    }

    public void checkPermissions() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/h3"));
        Assert.assertEquals(element.getText(), "All Permissions");
    }

    public void clickAccessToken() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"link11\"]/a")).click();
    }

    public void checkAccessToken() {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[@id=\"MainContent\"]/div[1]/div/h4"));
        Assert.assertEquals(element.getText(), "Add New Access Token");
    }
}

