package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class RemoteUnitsPage {
    public RemoteUnitsPage() {        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath="//div[@id='divCollapseUncollapse']//*[name()='svg']")
    public WebElement dropdown;

        @FindBy(xpath = "//a[text()='Remote Units']")
        public WebElement remoteunitsign;

@FindBy(xpath = "//body/div[@id='root']/div[@class='container']/div[@class='row']/div[@id='MainContent']/div/div/div[@class='row']/div")
    public List<WebElement> displayRemotePagelist;

    }



