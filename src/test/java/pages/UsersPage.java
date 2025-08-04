package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;
import static utilities.ReusableMethods.*;

public class UsersPage {

    //USERS PAGE LOCATES
    private By parafIcon = By.cssSelector("button.btn.btn-transparent.m-0.me-4.p-1.rounded.border-0");
    private By userLogInInfo = By.xpath("//div[@class='d-flex justify-content-end']");
    private By pageTitle = By.xpath("//div[@id='MainContent']//div[@class='col-4']/h4");
    private By addNewMemberButton = By.xpath("//div//button[text()='+ Add New Member']");
    private By usersList = By.xpath("//div[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr");
    private By usersUsernameList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[2]/a");
    private By usersEmailList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[3]/div/span");
    private By usersSinceList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[4]/div/span");
    private By usersAccessTypeList = By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[5]");
    private By usersStatusList = By.xpath("//span[text()='Active']");
    private By usersIcon = By.xpath("//div//li[@id='link8']/a[@href='#/users']");
    private By changeRole = By.xpath("//div[@class='btn-group show']/ul/li[5]/a[@class='dropdown-item ps-5']");

    //NEW USER REGISTRATION WINDOW LOCATES
    private By newUserWindow_title = By.xpath("//div//h5[text()='New User Registration']");
    private By registerButton = By.xpath("//button[text()='Register']");
    private By registerationErrorMessage = By.xpath("//span[text()='Please select a role for the user you will add']");
    private By rolesList = By.xpath("//div[text()='Select Role']/following-sibling::div[@class=' css-19bb58m']");
    private By registerationEmailErrorMessage = By.xpath("//span[text()='Please enter a valid email']");
    private By emailTextArea  = By.xpath("//input[@id='email']");
    private By errorMessage = By.xpath("//p[text()='An error occurred']");
    private By succesfullyRegisteredMessage = By.xpath("//div[@class='toast-header bg-success text-white']//strong");
    private By cancelButton = By.xpath("//button[text()='Close']");


    //bu method ana sayfaya taşınmalı
    public UsersPage goToUsersPage() {
        if (visibilityOfElement(this.usersIcon).getAttribute("href").contains("users")) {
            clickElement(this.usersIcon);
            waitForSeconds(1);
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
            List<String> validAccesType = Arrays.asList("Allowed", "Suspended", "Blocked");
            Assert.assertTrue(validAccesType.stream().anyMatch(w.getText()::contains), w.getText() + "is not acceptable");
        }
    }

    public void assertVisibilityOfStatusOfEachUser() {

        List<WebElement> usersStatusList = waitForVisibilityofElementsByFleuntWait(this.usersStatusList);
        for (WebElement w : usersStatusList) {
            assertEquals(w.getText(), "Active");
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
        System.out.println("First user's detail page is opened ");
        waitForSeconds(2);
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

    public UsersPage addNewMembeer() {
        clickElement(this.addNewMemberButton);
        waitForSeconds(1);
        return this;
    }

    public void assertNewRegistrationWindowIsOpened(String expectedResult) {
        String actualResult = getTextOfElementByJS(this.newUserWindow_title);
        assertEquals(actualResult, expectedResult);
    }

    public UsersPage clickRegisterButton() {
        clickElement(this.registerButton);
        return this;
    }

    public UsersPage assertRegistrationWithOutDataErrorMessage(String expectedResult) {
        getTextOfElementByJS(this.registerationErrorMessage);
        return this;
    }

    public UsersPage selectARoleFromList() {
        waitForVisibilityofElementsByFleuntWait(this.rolesList);
        Actions action = new Actions(Driver.getDriver());
        action
                .click(visibilityOfElement(this.rolesList))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN)
                .click()
                .perform();
        waitForSeconds(2);
        return this;
    }

    public void assertRegistrationWithOutEmailErrorMessage(String expectedResult) {
        assertEquals( getTextOfElementByJS(this.registerationEmailErrorMessage),expectedResult );
    }

    public UsersPage enterEmail(String email) {
        sendKeys(this.emailTextArea,email);
        return this;
    }

    public void assertInvalidEmailErrorMessage(String errorMessage) {
        assertEquals( getTextOfElementByJS(this.errorMessage), errorMessage);
    }
    public UsersPage selectDepartmentFromList() {
        return this;
    }
    public void assertVisibilityRegisterSuccessfullMessageOccur(String expectedResult) {
        assertEquals( getTextOfElementByJS(this.succesfullyRegisteredMessage) , expectedResult);
    }


    public UsersPage clickCancelButton() {
        clickElement(this.cancelButton);
        return this;
    }

    public void assertWindowClosedWithoutSaving() {
        waitForSeconds(2);
        System.out.println("size() = " + visibilityOfElements(this.registerButton).size());
        assertTrue(visibilityOfElements(this.registerButton).size()==0);
        //todo wait koymadan çözemedim, hocaya sor
    }

    public UsersPage refreshPage() {
        ReusableMethods.refreshPage();
        return this;
    }
}
