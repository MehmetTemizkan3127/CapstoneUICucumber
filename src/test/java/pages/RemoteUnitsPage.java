package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class RemoteUnitsPage {
    public RemoteUnitsPage() {
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath="//div[@id='divCollapseUncollapse']//*[name()='svg']")
    public WebElement dropdown;

  //  @FindBy(css = "#link6")
    //    public WebElement remoteunitsign;

@FindBy(xpath = "//body/div[@id='root']/div[@class='container']/div[@class='row']/div[@id='MainContent']/div/div/div[@class='row']/div")
    public List<WebElement> displayRemotePagelist;

    @FindBy(xpath = "//button[@class='btn btn-info text-white px-3']")//*[@id='MainContent']/div/div/div/div/div[2]/div[5]/div/span/div/button[1]
    public WebElement SaveButton;

    @FindBy(xpath = "//input[@class='form-control rounded-input search-input']")
    public WebElement searching;

    }



