package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static utilities.ReusableMethods.*;

public class UsersPage {

    Logger logger = LogManager.getLogger(UsersPage.class);

    private By parafIcon = By.cssSelector("button.btn.btn-transparent.m-0.me-4.p-1.rounded.border-0");
    private By userLogInInfo = By.xpath("//div[@class='d-flex justify-content-end']");
    private By pageTitle = By.xpath("//div[@id='MainContent']//div[@class='col-4']/h4");
    private By addNewMemberButton = By.xpath("//div//button[text()='+ Add New Member']");
    private By usersList = By.xpath("//div[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr");
    private By usersUsernameList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[2]/a");
    private By usersEmailList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[3]/div/span");
    private By usersSinceList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[4]/div/span");
    private By usersAccessTypeList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[5]");
    private By usersStatusList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[6]");
    private By usersIcon = By.xpath("//div//li[@id='link8']/a[@href='#/users']");
    private By changeRole = By.xpath("//div[@class='btn-group show']/ul/li[5]/a[@class='dropdown-item ps-5']");


    //bu method ana sayfaya taşınmalı
    public UsersPage goToUsersPage() {
        if (visibilityOfElement(this.usersIcon).getAttribute("href").contains("users")) {
            clickElement(this.usersIcon);
            System.out.println("user page e tıklandı");
        }
        return this;
    }

    //bu method ana sayfaya taşınmalı
    public UsersPage changeRoleToClaruswayCompany() {

        if (visibilityOfElementByWebDriverWait(changeRole).getText().contains("Clarusway")) {
            clickElement(changeRole);
        }
        return this;
    }

    public UsersPage openDropDownMenu() {
        clickElement(parafIcon);
        return this;
    }

    public void assertUsersPageOpens() {
        Assert.assertTrue(getTextOfElement(this.pageTitle).contains("All Members"));
    }

    public void assertVisibilityOfUsersList() {
        Assert.assertFalse(waitForVisibilityofElementsByFleuntWait(this.usersList).isEmpty());
    }

    public void assertVisibilityOfEmailOfEachUser() {

        List<WebElement> usersEmailList = waitForVisibilityofElementsByFleuntWait(this.usersEmailList);
        for (WebElement w : usersEmailList) {
            Assert.assertTrue(w.getText().contains("@") & w.getText().contains(".com"), w.getText() + "is not acceptable");
        }
    }

    public void assertVisibilityOfSinceOfEachUser() {

        List<WebElement> userSinceList = waitForVisibilityofElementsByFleuntWait(this.usersSinceList);
        for (WebElement w : userSinceList) {
            Assert.assertTrue(isDateFormatValid(w.getText()), w.getText() + "is not acceptable");
        }
    }

    public void assertVisibilityOfAccessTypeOfEachUser() {
        List<WebElement> usersAccessTypeList = waitForVisibilityofElementsByFleuntWait(this.usersAccessTypeList);
        for (WebElement w : usersAccessTypeList) {

            System.out.println(w.getText());
            List<String> validAccesType = Arrays.asList("Allowed", "Suspended", "Blocked");
            Assert.assertTrue(validAccesType.stream().anyMatch(w.getText()::contains), w.getText() + "is not acceptable");
        }
    }

    public void assertVisibilityOfStatusOfEachUser() {

        List<WebElement> usersStatusList = waitForVisibilityofElementsByFleuntWait(this.usersStatusList);
        for (WebElement w : usersStatusList) {
            System.out.println(w.getText());
            //  Assert.assertTrue(  w.getText(), w.getText() + "is not acceptable"  );
        }
    }

    public boolean isDateFormatValid(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, dateTimeFormatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserDetailPage openUserDetailPageForFirstUser() {
        waitForVisibilityofElementsByFleuntWait(usersUsernameList).get(0).click();
        logger.info("First user detail page is opened ");
        return new UserDetailPage();
    }

    public void logout() {
        clickElementByJS(this.userLogInInfo);
        Actions action = new Actions(Driver.getDriver());
        action
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .click()
                .perform();
    }
}
