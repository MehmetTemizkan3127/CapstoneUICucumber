package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;


import static utilities.ReusableMethods.waitForSeconds;

public class NewRemoteUnitPage {
    public NewRemoteUnitPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    RemoteUnitsPage remoteUnitsPage=new RemoteUnitsPage();
    @FindBy(css = "#link6")
    public WebElement remoteunitsign;
    @FindBy(xpath = "//*[@id='MainContent']/div/div[1]/div[2]/a/button")
    public WebElement AddNewRemoteLink;
    @FindBy(id = "name")
    public WebElement DepartmentNameInput;
    @FindBy(xpath = "//input[@id=\"react-select-2-input\"]")
    public WebElement DepartmentType;
   // @FindBy(xpath = "//button[@class='btn btn-info text-white px-3']")//*[@id='MainContent']/div/div/div/div/div[2]/div[5]/div/span/div/button[1]
  //  public WebElement SaveButton;
@FindBy(xpath = "//b[text()='AAAAA']")//@FindBy(xpath = "//b[contains(text(), 'Ferhat')]")
   public WebElement verifynewremoteunits;

//@FindBy(xpath = "//div[@id='MainContent']/div/div/a/button")
   // public WebElement editbutton;
/*@FindBy(xpath = "//button[text()='Delete Department']")
    public WebElement deletebutton;
@FindBy(xpath = "//button[@class='btn btn-danger']")
public WebElement confirmbutton;
public void newuser(){
    waitForSeconds(3);
    AddNewRemoteLink.click();

    waitForSeconds(2);
    DepartmentNameInput.clear();
    DepartmentNameInput.sendKeys(ConfigReader.getProperty("departmaname"));

    DepartmentType.sendKeys(departmentType + Keys.ENTER);

    waitForSeconds(2);
    remoteUnitsPage.SaveButton.click();
}*/

}




