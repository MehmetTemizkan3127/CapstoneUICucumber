package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

import static utilities.ReusableMethods.*;

public class UsersPage {

    private By parafIcon = By.cssSelector("button.btn.btn-transparent.m-0.me-4.p-1.rounded.border-0");

    private By pageTitle = By.xpath("//div[@id='MainContent']//div[@class='col-4']/h4");

    private By addNewMemberButton = By.xpath("//div//button[text()='+ Add New Member']");

    private By usersList = By.xpath("//div[@id=\"MainContent\"]//table[@class='table table-hover table-sm ReactDataTable']/tbody/tr");

    private By usersIcon = By.xpath("//div//li[@id='link8']");

    private By changeRole = By.xpath("//div[@class='btn-group show']/ul/li[5]/a[@class='dropdown-item ps-5']");


    //bu method ana sayfaya taşınmalı
    public UsersPage goToUsersPage() {
        clickElement(this.usersIcon);
        return new UsersPage();
    }
    public UsersPage openDropDownMenu(){
        clickElement(parafIcon);
        return this;
    }
    public void assertUsersPageOpens() {

        Assert.assertTrue(  getTextOfElement(this.pageTitle).contains("All Members")   );
    }



    public UsersPage changeRoleToClaruswayCompany(){
        visibilityOfElementByWebDriverWait(changeRole);
        if( getTextOfElement(changeRole).contains("Clarusway") ){
            clickElement(changeRole);
        }
        return this;
    }


    public void assertVisibilityOfUsersList() {
        Assert.assertFalse(    visibilityOfElementsByWebDriverWait(this.usersList).isEmpty()   );
    }
}
