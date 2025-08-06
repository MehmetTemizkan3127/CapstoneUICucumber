package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;

import static utilities.ReusableMethods.visibilityOfElement;
import static utilities.ReusableMethods.waitForSeconds;

public class DashboardPage {

    private static final By LOGO = By.className("navbar-brand");
    private static final By USER_PAGE_LINK = By.xpath("//*[@id=\"link8\"]");
    private static final By HOME_PAGE_LINK = By.tagName("h1");
    private static final By SIDEBAR = By.id("Sidebar");
    private static final By COLLAPSE_BUTTON = By.className("btnCollapse");
    private static final By MY_SUBSCRIPTIONS = By.xpath("//*[@id=\"link1\"]/a");
    private static final By MY_MEMBERSHIPS = By.xpath("//*[@id=\"link2\"]/a");
    private static final By CHECK_MY_MEMBERSHIPS = By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/h3");
    private static final By COMPANY_GROUP = By.xpath("//*[@id=\"link3\"]/a");
    private static final By CHECK_COMPANY_GROUP = By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div/h2");
    private static final By COMPANY = By.xpath("//*[@id=\"link4\"]/a");
    private static final By CHECK_COMPANY = By.xpath("//*[@id=\"MainContent\"]/div[1]/div/h5");
    private static final By DEPARTMENTS = By.xpath("//*[@id=\"link5\"]/a");
    private static final By REMOTE_UNITS = By.xpath("//*[@id=\"link6\"]/a");
    private static final By TEAMS = By.xpath("//*[@id=\"link7\"]/a");
    private static final By USERS = By.xpath("//*[@id=\"link8\"]/a[@href='#/users']");
    private static final By CHECK_USERS = By.id("search");
    private static final By ROLES = By.xpath("//*[@id=\"link9\"]/a");
    private static final By PERMISSION = By.xpath("//*[@id=\"link10\"]/a");
    private static final By ACCESS_TOKEN = By.xpath("//*[@id=\"link11\"]/a");
    private static final By CHECK_ACCESS_TOKEN = By.xpath("//*[@id=\"MainContent\"]/div[1]/div/h4");
    public static final By HEADER = By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[1]/h3");

    //NIOYATECH Logo Button`un görünürlügü test ediliyor.
    public void checkLogoIsVisible() {
        WebElement logoButton = Driver.getDriver().findElement(LOGO);
        Assert.assertTrue(logoButton.isDisplayed());
    }

    //NIOYATECH Logo Button`un click özelligi dogrulaniyor.
    public void checkLogoIsClickable() {
        WebElement element = Driver.getDriver().findElement(LOGO);
        Assert.assertTrue(element.isEnabled());
    }

    //NIOYATECH Logo butonuna tiklanir.
    public void clickUserPageButton() {
        WebElement element = Driver.getDriver().findElement(USER_PAGE_LINK);
        element.click();
    }

    //Home page ìn acildigi dogrulanir.
    public void checkHomePage() {
        WebElement h1 = Driver.getDriver().findElement(HOME_PAGE_LINK);
        Assert.assertEquals(h1.getText(), "Welcome to QuaSpareparts.com");
    }


    public void clickLogo() {
        WebElement element = Driver.getDriver().findElement(LOGO);
        element.click();
    }


    public void isSideBarVisible() {
        WebElement element = Driver.getDriver().findElement(SIDEBAR);
        Assert.assertTrue(element.isDisplayed());
    }

    public void clickMinimizeSideBar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement btnCollapse = Driver.getDriver().findElement(COLLAPSE_BUTTON);
        js.executeScript("arguments[0].click();", btnCollapse);
    }

    public void isMinimizedSideBarVisible() throws InterruptedException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = Driver.getDriver().findElement(SIDEBAR);
        Assert.assertTrue(element.getAttribute("class").contains("minimize"));
    }

    public void clickMaximizeSideBar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement btnCollapse = Driver.getDriver().findElement(COLLAPSE_BUTTON);
        js.executeScript("arguments[0].click();", btnCollapse);
    }

    public void isMaximizedSideBarVisible() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = Driver.getDriver().findElement(SIDEBAR);
        Assert.assertTrue(element.isDisplayed());
        Assert.assertFalse(element.getAttribute("class").contains("minimize"));
    }

    public void clickMySubscriptions() {
        Driver.getDriver().findElement(MY_SUBSCRIPTIONS).click();
    }

    public void checkMySubscriptions() {
        WebElement element = Driver.getDriver().findElement(HEADER);
        Assert.assertEquals(element.getText(), "My Subscriptions");
    }

    public void clickMyMemberships() {
        Driver.getDriver().findElement(MY_MEMBERSHIPS).click();
    }

    public void checkMyMemberships() {
        WebElement element = Driver.getDriver().findElement(CHECK_MY_MEMBERSHIPS);
        Assert.assertEquals(element.getText(), "My Memberships");
    }

    public void clickCompanyGroup() {
        Driver.getDriver().findElement(COMPANY_GROUP).click();
    }

    public void checkCompanyGroup() {
        WebElement element = Driver.getDriver().findElement(CHECK_COMPANY_GROUP);
        Assert.assertEquals(element.getText(), "Your Company Group");
    }

    public void clickCompany() {
        Driver.getDriver().findElement(COMPANY).click();
    }

    public void checkCompany() {
        WebElement element = Driver.getDriver().findElement(CHECK_COMPANY);
        Assert.assertEquals(element.getText(), "Company Information");
    }

    public void clickDepartments() {
        Driver.getDriver().findElement(DEPARTMENTS).click();
    }

    public void checkDepartments() {
        WebElement element = Driver.getDriver().findElement(HEADER);
        Assert.assertEquals(element.getText(), "Departments");
    }

    public void clickRemoteUnits() {
        Driver.getDriver().findElement(REMOTE_UNITS).click();
    }

    public void checkRemoteUnits() {
        WebElement element = Driver.getDriver().findElement(HEADER);
        Assert.assertEquals(element.getText(), "Remote Units");
    }

    public void clickTeams() {
        Driver.getDriver().findElement(TEAMS).click();
    }

    public void checkTeams() {
        WebElement element = Driver.getDriver().findElement(HEADER);
        Assert.assertEquals(element.getText(), "Teams");
    }

    public void clickUsers() {
        if (visibilityOfElement(USERS).getAttribute("href").contains("users")) {
            Driver.getDriver().findElement(USERS).click();
        }
        waitForSeconds(2);
    }

    public void checkUsers() {
        Driver.getDriver().findElement(CHECK_USERS);

    }

    public void clickRoles() {
        Driver.getDriver().findElement(ROLES).click();
    }

    public void checkRoles() {
        WebElement element = Driver.getDriver().findElement(HEADER);
        Assert.assertEquals(element.getText(), "All Roles");
    }

    public void clickPermissions() {
        Driver.getDriver().findElement(PERMISSION).click();
    }

    public void checkPermissions() {
        WebElement element = Driver.getDriver().findElement(HEADER);
        Assert.assertEquals(element.getText(), "All Permissions");
    }

    public void clickAccessToken() {
        Driver.getDriver().findElement(ACCESS_TOKEN).click();
    }

    public void checkAccessToken() {
        WebElement element = Driver.getDriver().findElement(CHECK_ACCESS_TOKEN);
        Assert.assertEquals(element.getText(), "Add New Access Token");
    }
}

