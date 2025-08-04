package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class NewRemoteUnitPage {
    public NewRemoteUnitPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "#link6")
    public WebElement remoteunitsign;
    @FindBy(xpath = "//*[@id='MainContent']/div/div[1]/div[2]/a/button")
    public WebElement AddNewRemoteLink;
    @FindBy(id = "name")
    public WebElement DepartmentNameInput;
    @FindBy(xpath = "//input[@id=\"react-select-2-input\"]")
    public WebElement DepartmentType;
    @FindBy(xpath = "//button[@class='btn btn-info text-white px-3']")//*[@id='MainContent']/div/div/div/div/div[2]/div[5]/div/span/div/button[1]
    public WebElement SaveButton;
@FindBy(xpath = "//b[text()='AAAAA']")//@FindBy(xpath = "//b[contains(text(), 'Ferhat')]")
   public WebElement verifynewremoteunits;

@FindBy(xpath = "//div[@id='MainContent']/div/div/a/button")
    public WebElement editbutton;


    }


