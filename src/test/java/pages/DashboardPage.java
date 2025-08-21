package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class DashboardPage {

    private static final By LOGO = By.className("navbar-brand");
    private static final By USER_PAGE_LINK = By.xpath("//*[@id=\"link8\"]");
    private static final By HOME_PAGE_LINK = By.tagName("h1");
    private static final By SIDEBAR = By.id("Sidebar");
    private static final By COLLAPSE_BUTTON = By.className("btnCollapse");
    private static final String MENU_ITEM = "//li[contains(@class, \"list-group-item\")]/a[text()='{placeholder}']";
    private static final By BREADCRUMB = By.xpath("//li[@class='breadcrumb-item active']");
    public static final By PROFILE_IMAGE = By.xpath("//div[contains(@class, 'avatar')]/ancestor::button[1]");
    public static final By USER_INFO_POPUP = By.xpath("//*[@id=\"Header\"]/div/div/div/ul/li[1]/span/div/table/tbody/tr/td[2]/span[1]");
    public static final By COMPANY_NAME_ON_COMPANY_PAGE = By.xpath("//label[@for='organizations']/following-sibling::span");
    public static final By COMPANY_NAME_ON_HEADER = By.xpath("//*[@id=\"Header\"]/div/div/div/ul/li[1]/span/div/table/tbody/tr/td[2]/span[2]");
    public static final By AVATAR_ON_HEADER = By.xpath("//div[contains(@class, 'avatar')]");
    public static final By USER_INFO_ON_DROPDOWN = By.xpath("//*[@id=\"Header\"]/div/div/div/button/div/table/tbody/tr/td[2]/span[1]");
    public static final By COMPANY_NAME_ON_DROPDOWN = By.xpath("//*[@id=\"Header\"]/div/div/div/button/div/table/tbody/tr/td[2]/span[2]");


    public void checkLogoIsVisible() {
        WebElement logoButton = Driver.getDriver().findElement(LOGO);
        Assert.assertTrue(logoButton.isDisplayed());
    }

    public void checkLogoIsClickable() {
        WebElement element = Driver.getDriver().findElement(LOGO);
        Assert.assertTrue(element.isEnabled());
    }

    public void clickUserPageButton() {
        WebElement element = Driver.getDriver().findElement(USER_PAGE_LINK);
        element.click();
    }

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
        ReusableMethods.waitForSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement btnCollapse = Driver.getDriver().findElement(COLLAPSE_BUTTON);
        js.executeScript("arguments[0].click();", btnCollapse);
    }

    public void isMinimizedSideBarVisible() throws InterruptedException {
        ReusableMethods.waitForSeconds(2);
        WebElement element = Driver.getDriver().findElement(SIDEBAR);
        Assert.assertTrue(element.getAttribute("class").contains("minimize"));
    }

    public void clickMaximizeSideBar() {
        ReusableMethods.waitForSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement btnCollapse = Driver.getDriver().findElement(COLLAPSE_BUTTON);
        js.executeScript("arguments[0].click();", btnCollapse);
    }

    public void isMaximizedSideBarVisible() {
        ReusableMethods.waitForSeconds(2);
        WebElement element = Driver.getDriver().findElement(SIDEBAR);
        Assert.assertTrue(element.isDisplayed());
        Assert.assertFalse(element.getAttribute("class").contains("minimize"));
    }

    //***SIDEBAR Link Click and visibility check ******

    public void clickOnMenuItem(String menuItem) {
        ReusableMethods.waitForSeconds(2);
        WebElement element = Driver.getDriver().findElement(SIDEBAR);
        if(element.getAttribute("class").contains("minimize")) {
            clickMaximizeSideBar();
            ReusableMethods.waitForSeconds(2);
        }
        Driver.getDriver().findElement(By.xpath(MENU_ITEM.replace("{placeholder}", menuItem))).click();
        ReusableMethods.waitForSeconds(2); // Sayfa yukleme zaman aldigi icin sonraki stepler sorunsuz calissin diye wait gerek
    }

    public void checksOnPage(String breadCrumbText) {
        ReusableMethods.waitForSeconds(2);
        WebElement element = Driver.getDriver().findElement(BREADCRUMB);
        Assert.assertEquals(element.getText(), breadCrumbText);
    }

    //*************DropDownMenü***********
    //US003-01

    public void clickProfileImage() {
        Driver.getDriver().findElement(PROFILE_IMAGE).click();
        ReusableMethods.waitForSeconds(1);
    }

    public void checkDisplayUserEmailAndRole() {
        String username = Driver.getDriver().findElement(By.id("username")).getText();
        String defaultRole = Driver.getDriver().findElement(By.className("active-roles-box")).getText();
        String user = username + " | " + defaultRole;
        String userInfoOnPopup = Driver.getDriver()
                .findElement(USER_INFO_POPUP)
                .getText();
        Assert.assertEquals(userInfoOnPopup, user);
    }

    public void checkDisplayUserCompany() {
        String company = Driver.getDriver().findElement(COMPANY_NAME_ON_COMPANY_PAGE).getText();
        String companyOnHeader = Driver.getDriver().findElement(COMPANY_NAME_ON_HEADER).getText();
        Assert.assertEquals(company, companyOnHeader);
    }


    public void checkAvatar() {
        ReusableMethods.waitForSeconds(2);
        String username = Driver.getDriver().findElement(By.id("username")).getText();
        String avatar = Driver.getDriver().findElement(AVATAR_ON_HEADER).getText();
        Assert.assertEquals(username.toUpperCase().charAt(0), avatar.charAt(0));
    }

    public void checkUsernameAndRole() {
        String username = Driver.getDriver().findElement(By.id("username")).getText();
        String defaultRole = Driver.getDriver().findElement(By.className("active-roles-box")).getText();
        String user = username + " | " + defaultRole;
        String userInfoOnHeader = Driver.getDriver().findElement(USER_INFO_ON_DROPDOWN).getText();
        Assert.assertEquals(userInfoOnHeader, user);
    }

    public void checkCompany() {

        String company = Driver.getDriver().findElement(COMPANY_NAME_ON_COMPANY_PAGE).getText();
        String companyOnHeader = Driver.getDriver().findElement(DashboardPage.COMPANY_NAME_ON_DROPDOWN).getText();
        Assert.assertEquals(company, companyOnHeader);
    }

    public void clickOnPopupMenu(String arg0) {
        Driver.getDriver()
                .findElement(By
                        .xpath("//a[@class='dropdown-item'][text()='{placeholder}']"
                                .replace("{placeholder}", arg0)))
                .click();
    }

    //DataTable
    public void checkSideBarLinks(List<Map<String, String>> links) {
        for (Map<String, String> row : links) {
            String linkText = row.get("MenuItem");
            String breadCrumbText = row.get("BreadCrumb");
            clickOnMenuItem(linkText);
            checksOnPage(breadCrumbText);
        }
    }
}

