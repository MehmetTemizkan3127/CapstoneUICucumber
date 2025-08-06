package pages;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;



public class NewTeamPage {


    private final By informationTitle = By.xpath("//h5[normalize-space()='Information']");
    private final By companyTitle = By.xpath("//label[normalize-space()='Company']");
    private final By companyName = By.xpath("(//span[@class='fw-bold'])[3]");
    private final By departmentNameTitle = By.xpath("(//span[@class='fw-bold'])[3]");
    private final By departmentNameInput = By.id("name");
    private final By shortNameTitle = By.xpath("//label[@for='short_name']");
    private final By shortNameInput = By.xpath("//label[@for='short_name']");
    private final By departmentTypeTitle = By.xpath("//label[@for='group_type_id']");
    private final By departmentTypeDropDownMenu = By.xpath("(//div[@class=' css-b62m3t-container'])[1]");
    private final By departmentTypeDropDownMenuList = By.id("react-select-2-listbox");
    private final By departmentDescriptionTitle = By.id("//label[@for='description']");
    private final By departmentDescriptionInput = By.id("//label[@for='description']");
    private final By rolesTitle = By.id("//label[@for='description']");
    private final By departmentRolesDropDownMenu = By.id("(//div[@class=' css-b62m3t-container'])[2]");
    private final By saveButton = By.xpath("//button[normalize-space()='Save']");
    private final By cancelButton = By.xpath("//button[normalize-space()='Cancel']");
    private final By nameErrorMessage =By.xpath("//span[@class='text-danger']");
    private final By acceptedMessage =By.xpath("//div[@class='toast-body']");
    private final By searchByNameButton =By.xpath("//input[@id='search']");
    private final By firstMertayTitle =By.xpath("//body//div[@id='root']//div[@class='row']//div[@class='row']//div[1]//div[1]//div[1]//p[1]//div[1]//div[2]//a[1]//b[1]");



    public void returnAndSentMainSearchByNameButton(String arg){
        Driver.getDriver().navigate().back();
        ReusableMethods.sendKeys(searchByNameButton,arg);
    }

    public TeamDetailPage clickFirstMertayTeam(){

        ReusableMethods.clickElementByWebDriverWait(firstMertayTitle).click();

        return new TeamDetailPage();
    }

    public boolean setNameErrorMessageIsDisplay(){
        return ReusableMethods.visibilityOfElementByWebDriverWait(nameErrorMessage).isDisplayed();
    }

    public boolean acceptedMessageIsDisplay(){
        return ReusableMethods.visibilityOfElementByWebDriverWait(acceptedMessage).isDisplayed();
    }

    public void selectDepartmentTypeDropDownMenu(){
        Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(5));

        WebElement dropdownMenu = Driver.getDriver().findElement(departmentTypeDropDownMenu);
        actions.moveToElement(dropdownMenu).click().perform();
        ReusableMethods.waitForSeconds(2);


    }
    public void selectTeamFromDepartmentTypeDropDownMenu() {


        WebElement dropdown = Driver.getDriver().findElement(By.id("react-select-2-input"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", dropdown);


        WebElement option = Driver.getDriver().findElement(By.xpath("//div[text()='Team']"));
        js.executeScript("arguments[0].click();", option);


    }


    public boolean informationTitleIsDisplay(){

        return ReusableMethods.isDisplayed(informationTitle);
    }

    public boolean companyTitleIsDisplay(){

        return ReusableMethods.isDisplayed(companyTitle);
    }

    public boolean companyNameIsDisplay(){

        return ReusableMethods.isDisplayed(companyName);
    }

    public boolean departmentNameTitleIsDisplay(){

        return ReusableMethods.isDisplayed(departmentNameTitle);
    }

    public boolean departmentNameInputIsDisplay(){

        return ReusableMethods.isDisplayed(departmentNameInput);
    }

    public boolean departmentNameInputIsClickable(){

        return ReusableMethods.isClickableByWebDriverWait(departmentNameInput);
    }

    public boolean shortNameTitleIsDisplay(){

        return ReusableMethods.isDisplayed(shortNameTitle);
    }

    public boolean shortNameInputIsDisplay(){

        return ReusableMethods.isDisplayed(shortNameInput);
    }

    public boolean shortNameInputIsClickable(){

        return ReusableMethods.isClickableByWebDriverWait(shortNameInput);
    }

    public boolean departmentTypeTitleIsDisplay(){

        return ReusableMethods.isDisplayed(departmentTypeTitle);
    }

    public boolean departmentTypeDropDownMenuIsDisplay(){

        return ReusableMethods.isDisplayed(departmentTypeDropDownMenu);
    }

    public boolean departmentTypeDropDownMenuIsClickable(){

        return ReusableMethods.isClickableByWebDriverWait(departmentTypeDropDownMenu);
    }

    public boolean departmentDescriptionTitle(){

        return ReusableMethods.isDisplayed(departmentDescriptionTitle);
    }

    public boolean departmentDescriptionInputIsDisplay(){

        return ReusableMethods.isDisplayed(departmentDescriptionInput);
    }

    public boolean departmentDescriptionInputClikcable(){

        return ReusableMethods.isClickableByWebDriverWait(departmentDescriptionInput);
    }

    public boolean rolesTitleIsDisplay(){

        return ReusableMethods.isDisplayed(rolesTitle);
    }

    public boolean departmentRolesDropDownMenuIsDisplay(){

        return ReusableMethods.isDisplayed(departmentRolesDropDownMenu);
    }

    public boolean departmentRolesDropDownMenuIsClickable(){

        return ReusableMethods.isClickableByWebDriverWait(departmentRolesDropDownMenu);
    }

    public boolean saveButtonIsDisplay(){

        return ReusableMethods.isDisplayed(saveButton);
    }

    public boolean saveButtonIsClickable(){

        return ReusableMethods.isClickableByWebDriverWait(saveButton);
    }

    public boolean cancelButtonIsDisplay(){

        return ReusableMethods.isDisplayed(cancelButton);
    }

    public boolean cancelButtonIsClickable(){

        return ReusableMethods.isClickableByWebDriverWait(cancelButton);
    }

    public NewTeamPage saveButtonClick(){

        ReusableMethods.isClickableByWebDriverWait(saveButton);
        ReusableMethods.clickElement(saveButton);

        return this;
    }

    public void departmentNameInputClick(){

        ReusableMethods.isClickableByWebDriverWait(departmentNameInput);
        ReusableMethods.clickElement(departmentNameInput);

    }

    public void departmentNameInputSendKeys(String arg){

        ReusableMethods.isClickableByWebDriverWait(departmentNameInput);
        ReusableMethods.sendKeys(departmentNameInput,arg);

    }
}