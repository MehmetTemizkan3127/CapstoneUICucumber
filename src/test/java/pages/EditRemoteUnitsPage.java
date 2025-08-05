package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditRemoteUnitsPage {
    { PageFactory.initElements(Driver.getDriver(),this);    }
    @FindBy (xpath = "(//b[contains(text(),'AAAAA')])[1]")
    public WebElement editremoteunitsdept;
    @FindBy (xpath = "//button[@class='btn btn-info float-end text-white']")
    public WebElement editRemoteUnitButton;
    @FindBy(id = "name")
    public WebElement DepartmentNameInput;
    @FindBy(xpath = "//button[text()='Delete Department']")
    public WebElement deletebutton;
    @FindBy(xpath = "//button[@class='btn btn-danger']")
    public WebElement confirmbutton;



}
