package pages;

import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class TeamDetailPage {


    private final By NewUserButton = By.xpath("//button[@class='btn btn-info btn-sm mb-3 text-light float-end']");
    private final By SearchByNameOrEmailButton = By.xpath("(//input[@id='search'])[2]");
    private final By CheckBox = By.xpath("(//input[@id='search'])[2]");
    private final By AddedSelectorUsers = By.xpath("//button[normalize-space()='Add Selected Users']");
    private final By AddedSuccesText = By.xpath("//button[normalize-space()='Add Selected Users']");
    private final By EditTeamButton = By.xpath("//button[normalize-space()='Edit Team']");
    private final By DeleteTeamButton = By.xpath("//button[normalize-space()='Delete Department']");


    public boolean EditTeamTitleIsDisplay(){
       return ReusableMethods.isDisplayed(DeleteTeamButton);
    }

    public TeamDetailPage EditTeamButtonClick(){
        ReusableMethods.clickElement(EditTeamButton);

            return new TeamDetailPage();
    }

    public void NewUserButtonClick(){
        ReusableMethods.clickElement(NewUserButton);
    }

    public void SearchByNameOrEmailButtonClick(){
        ReusableMethods.clickElement(SearchByNameOrEmailButton);
    }

    public void SearchByNameOrEmailButtonSendKeys(String arg){
        ReusableMethods.sendKeys(SearchByNameOrEmailButton,arg);
    }

    public void CheckBoxClick(){
        ReusableMethods.clickElement(CheckBox);
    }

    public TeamDetailPage AddedSelectorUsersClick(){
        ReusableMethods.clickElement(AddedSelectorUsers);

        return this;
    }

    public boolean AddedSuccesTextMessageAssert(){
        ReusableMethods.waitForSeconds(5);
      return ReusableMethods.isDisplayed(AddedSuccesText);


    }










}
