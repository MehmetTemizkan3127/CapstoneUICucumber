package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static utilities.ReusableMethods.*;

public class UsersPage {

    private By parafIcon = By.cssSelector("button.btn.btn-transparent.m-0.me-4.p-1.rounded.border-0");
    private By pageTitle = By.xpath("//div[@id='MainContent']//div[@class='col-4']/h4");
    private By addNewMemberButton = By.xpath("//div//button[text()='+ Add New Member']");
    private By usersList = By.xpath("//div[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr");
    private By usersUsernameList =By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[2]/a");
    private By usersEmailList =By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[3]/div/span");
    private By usersSinceList =By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[4]/div/span");
    private By usersAccessTypeList =By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[5]");
    private By usersStatusList =By.xpath("//*[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr/td[6]");
    private By usersIcon = By.xpath("//div//li[@id='link8']");
    private By changeRole = By.xpath("//div[@class='btn-group show']/ul/li[5]/a[@class='dropdown-item ps-5']");


    //bu method ana sayfaya taşınmalı
    public UsersPage goToUsersPage() {
        clickElement(this.usersIcon);
        return this;
    }
    //bu method ana sayfaya taşınmalı
    public UsersPage changeRoleToClaruswayCompany(){
        visibilityOfElementByWebDriverWait(changeRole);
        if( getTextOfElement(changeRole).contains("Clarusway") ){
            clickElement(changeRole);
        }
        return this;
    }
    public UsersPage openDropDownMenu(){
        clickElement(parafIcon);
        return this;
    }
    public void assertUsersPageOpens() {
        Assert.assertTrue(  getTextOfElement(this.pageTitle).contains("All Members")   );
    }
    public void assertVisibilityOfUsersList() {
        Assert.assertFalse(    waitForVisibilityofElementsByFleuntWait(this.usersList).isEmpty()   );
    }
    public void assertVisibilityOfEmailOfEachUser() {

        List <WebElement> usersEmailList = waitForVisibilityofElementsByFleuntWait(this.usersEmailList);
        for(WebElement w : usersEmailList){
            Assert.assertTrue(w.getText().contains("@") & w.getText().contains(".com"), w.getText() + "is not acceptable"  );
        }
    }
    public void assertVisibilityOfSinceOfEachUser() {

        List <WebElement> userSinceList = waitForVisibilityofElementsByFleuntWait(this.usersSinceList);
        for(WebElement w : userSinceList){
            Assert.assertTrue(  isDateFormatValid(w.getText()), w.getText() + "is not acceptable"  );
        }
    }
    public void assertVisibilityOfAccessTypeOfEachUser() {
        List <WebElement> usersAccessTypeList = waitForVisibilityofElementsByFleuntWait(this.usersAccessTypeList);
        for(WebElement w : usersAccessTypeList){

            System.out.println(w.getText());
            List<String> validAccesType = Arrays.asList("Allowed", "Suspended", "Blocked");
            Assert.assertTrue(  validAccesType.stream().anyMatch(w.getText()::contains), w.getText() + "is not acceptable"  );
        }
    }
    public void assertVisibilityOfStatusOfEachUser() {

        List <WebElement> usersStatusList = waitForVisibilityofElementsByFleuntWait(this.usersStatusList);
        for(WebElement w : usersStatusList){
            System.out.println(w.getText());
          //  Assert.assertTrue(  w.getText(), w.getText() + "is not acceptable"  );
        }
    }

    public boolean isDateFormatValid(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse( date, dateTimeFormatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserDetailPage openUserDetailPageForFirstUser() {
        waitForVisibilityofElementsByFleuntWait(usersUsernameList).getFirst().click();
        return new UserDetailPage();
    }
}
