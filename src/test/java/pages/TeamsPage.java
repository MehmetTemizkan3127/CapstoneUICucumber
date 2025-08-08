package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TeamsPage {


  private final By MainTeamsButton = By.xpath("//a[normalize-space()='Teams']");
  private final By MenuWider = By.xpath("//div[@id='divCollapseUncollapse']//*[name()='svg']");
  private final By addNewTeamButton = By.xpath("//button[@class='btn btn-info float-end text-white']");
  private final By PageTeamTittle = By.xpath("//button[@class='btn btn-info float-end text-white']");
  private final By searchByNameInputBox = By.xpath("//input[@id=\"search\"]");
  private final By clearFiltersButton = By.xpath("//button[normalize-space()='Clear Filters']");
  private final By teamsTitleTexts = By.xpath("//div[@id='MainContent']//div[2]//div[1]//div[1]//p[1]//div[1]//div[2]//a[1]//b[1]");


public TeamDetailPage TeamsTitleTextsClick(){

  if (Driver.getDriver().findElement(teamsTitleTexts).getText().equals("mertay")) {
    ReusableMethods.clickElement(teamsTitleTexts);
  }else {
    System.out.println(STR."\{Driver.getDriver().findElement(teamsTitleTexts).getText()}this title not equals mertay for this reason try again..");
  }

return new TeamDetailPage();

}


 /* public boolean ElementToBeClickable(By locate){
      try {
          WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
          wait.until(ExpectedConditions.elementToBeClickable(locate));
        return true;
      } catch (Exception e) {
        return false;
      }

  }*/

  public void menuWiderClick(){ //When you click this method getting wide to main menu
    Driver.getDriver().findElement(MenuWider).click();
  }

  public void mainTeamsButtonClick(){ //When you use this method that means click to main menu teams button
    ReusableMethods.clickElementByJS(MainTeamsButton);
  }


  public boolean MainTeamsButtonIsAppear() { //Checking to main menu teams button visibility

    menuWiderClick();
    return ReusableMethods.isDisplayed(MainTeamsButton);

  }

  public boolean MainTeamsButtonIsClickable() {

    menuWiderClick();
    return ReusableMethods.isClickableByWebDriverWait(MainTeamsButton);

  }


  public boolean AddNewTeamButtonIsAppear(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isDisplayed(addNewTeamButton);

  }

  public boolean AddNewTeamButtonIsClickable(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isClickableByWebDriverWait(addNewTeamButton);

  }

  public NewTeamPage addNewTeamButtonClick(){

    menuWiderClick();
    mainTeamsButtonClick();

    ReusableMethods.clickElement(addNewTeamButton);

    return new NewTeamPage();

  }

  public boolean TeamTittleVisibility(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isDisplayed(PageTeamTittle);

  }

  public boolean SearchByNameInputBoxIsClickable(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isClickableByWebDriverWait(searchByNameInputBox);

  }

  public boolean SearchByNameInputBoxIsAppear(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isDisplayed(searchByNameInputBox);

  }

  public boolean ClearFiltersButtonISAppear(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isDisplayed(clearFiltersButton);

  }

  public boolean ClearFiltersButtonISClickable(){

    menuWiderClick();
    mainTeamsButtonClick();

    return ReusableMethods.isClickableByWebDriverWait(clearFiltersButton);

  }

  public TeamsPage theSearchBoxSendKeys(String arg){

    menuWiderClick();
    mainTeamsButtonClick();
    ReusableMethods.clickElementByJS(searchByNameInputBox);
    Driver.getDriver().findElement(searchByNameInputBox).sendKeys(arg);
    ReusableMethods.waitForSeconds(2);

    return this;

  }

  public TeamsPage clearFiltersButtonClick(){

    ReusableMethods.clickElementByJS(clearFiltersButton);

    return this;

  }

  public String theSearchBoxGetAttribute(){

   return  Driver.getDriver().findElement(searchByNameInputBox).getAttribute("value");

  }

  public boolean TheSearchBoxShouldBeClean(){

    menuWiderClick();
    mainTeamsButtonClick();
    theSearchBoxSendKeys("IT");
    clearFiltersButtonClick();
      return theSearchBoxGetAttribute().isEmpty();

  }

  public boolean titlesAreContain1(String arg1){
    List<WebElement> titles = Driver.getDriver().findElements(teamsTitleTexts);

    return titles.stream()
            .map(WebElement::getText)
            .allMatch(text -> text.contains(arg1));
  }





















}
