package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static java.lang.StringTemplate.STR;
import static org.yaml.snakeyaml.nodes.Tag.STR;

public class TeamsPage {


  private final By MainTeamsButton = By.xpath("//a[normalize-space()='Teams']");
  private final By MenuWider = By.xpath("//div[@id='divCollapseUncollapse']//*[name()='svg']");
  private final By AddNewTeamButton = By.xpath("//button[@class='btn btn-info float-end text-white']");
  private final By PageTeamTittle = By.xpath("//button[@class='btn btn-info float-end text-white']");
  private final By SearchByNameInputBox = By.xpath("//input[@id=\"search\"]");
  private final By ClearFiltersButton = By.xpath("//button[normalize-space()='Clear Filters']");
  private final By TeamsTitleTexts = By.xpath("//b");


public TeamDetailPage TeamsTitleTextsClick(){

  if (Driver.getDriver().findElement(TeamsTitleTexts).getText().equals("mertay")) {
    ReusableMethods.clickElement(TeamsTitleTexts);
  }else {
//    System.out.println(STR."\{Driver.getDriver().findElement(TeamsTitleTexts).getText()}this title not equals mertay for this reason try again..");
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

  public void MenuWiderClick(){ //When you click this method getting wide to main menu
    Driver.getDriver().findElement(MenuWider).click();
  }

  public void MainTeamsButtonClick(){ //When you use this method that means click to main menu teams button
    ReusableMethods.clickElementByJS(MainTeamsButton);
  }


  public boolean MainTeamsButtonIsAppear() { //Checking to main menu teams button visibility

    MenuWiderClick();
    return ReusableMethods.isDisplayed(MainTeamsButton);

  }

  public boolean MainTeamsButtonIsClickable() {

    MenuWiderClick();
    return ReusableMethods.isClickableByWebDriverWait(MainTeamsButton);

  }


  public boolean AddNewTeamButtonIsAppear(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isDisplayed(AddNewTeamButton);

  }

  public boolean AddNewTeamButtonIsClickable(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isClickableByWebDriverWait(AddNewTeamButton);

  }

  public NewTeamPage AddNewTeamButtonClick(){

    MenuWiderClick();
    MainTeamsButtonClick();

    ReusableMethods.clickElement(AddNewTeamButton);

    return new NewTeamPage();

  }

  public boolean TeamTittleVisibility(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isDisplayed(PageTeamTittle);

  }

  public boolean SearchByNameInputBoxIsClickable(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isClickableByWebDriverWait(SearchByNameInputBox);

  }

  public boolean SearchByNameInputBoxIsAppear(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isDisplayed(SearchByNameInputBox);

  }

  public boolean ClearFiltersButtonISAppear(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isDisplayed(ClearFiltersButton);

  }

  public boolean ClearFiltersButtonISClickable(){

    MenuWiderClick();
    MainTeamsButtonClick();

    return ReusableMethods.isClickableByWebDriverWait(ClearFiltersButton);

  }

  public TeamsPage TheSearchBoxSendKeys(String arg){

    MenuWiderClick();
    MainTeamsButtonClick();
    ReusableMethods.clickElementByJS(SearchByNameInputBox);
    Driver.getDriver().findElement(SearchByNameInputBox).sendKeys(arg);
    ReusableMethods.waitForSeconds(2);

    return this;

  }

  public TeamsPage ClearFiltersButtonClick(){

    ReusableMethods.clickElementByJS(ClearFiltersButton);

    return this;

  }

  public String TheSearchBoxGetAttribute(){

   return  Driver.getDriver().findElement(SearchByNameInputBox).getAttribute("value");

  }

  public boolean TheSearchBoxShouldBeClean(){

    MenuWiderClick();
    MainTeamsButtonClick();
    TheSearchBoxSendKeys("IT");
    ClearFiltersButtonClick();
      return TheSearchBoxGetAttribute().isEmpty();

  }

  public boolean TitlesAreContain1(String arg1){
    List<WebElement> titles = Driver.getDriver().findElements(TeamsTitleTexts);

    return titles.stream()
            .map(WebElement::getText)
            .allMatch(text -> text.contains(arg1));
  }





















}
