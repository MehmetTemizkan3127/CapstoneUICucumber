package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

@Getter
public class NewDepartmentPage {

private By nameField = By.xpath("//*[@id='name']");

private By shortnameField = By.xpath("//*[@name='short_name']");
private By departmentTypeField = By.xpath("//div[@id='react-select-2-placeholder']");
private By selectTypeDepartment = By.xpath("//div[@id='react-select-2-option-2']");//Bu locate ile sondaki indexi degistirip istedigim type'i secebilirim
private By descriptionField = By.xpath("//input[@name='description']");
private By rolesField = By.xpath("//input[@id='react-select-3-input']");
private By roleOption = By.xpath("//div[@id='react-select-3-option-2']");
private By closeRole = By.xpath("(//div[@class=' css-19bb58m'])[2]");
private By roleOptionWithText = By.xpath("//div[contains(@class, '-option') and text()='Sales Manager']"); //Bu locate ile texti degistirip istedigim rolü secebilirim
private By saveButton = By.xpath("//*[@class='btn btn-info text-white px-3']");
private By cancelButton = By.xpath("//*[@class='btn btn-dark']");
private By editButton = By.xpath("//*[@class='btn btn-outline-dark']");


    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    Actions actions = new Actions(getDriver());
    AllPages pages = new AllPages();

public NewDepartmentPage selectDepartmentType(){
    actions.click(getDriver().findElement(departmentTypeField)).perform();
    ReusableMethods.waitForSeconds(2);
    actions.click(getDriver().findElement(selectTypeDepartment)).perform();
    return this;
}

    public NewDepartmentPage selectRoles(){
        actions.click(getDriver().findElement(rolesField)).perform();
        ReusableMethods.waitForSeconds(2);
        actions.click(getDriver().findElement(roleOptionWithText)).perform();
        ReusableMethods.waitForSeconds(2);
        actions.click(getDriver().findElement(closeRole)).perform();
        return this;
    }

    public boolean isNewCreatedDepartmentDisplayed(){
    boolean flag =false;
    ReusableMethods.clickElement(pages.getDepartmentsPage().getDepartmentsButton());
    wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElements(pages.getDepartmentsPage().getDepartmentsButton())));
    List<WebElement>names = getDriver().findElements(pages.getDepartmentsPage().getAllDepartmentNames());
        for (int i = 0; i < names.size() ; i++) {
            if (names.get(i).getText().equals(ConfigReader.getProperty("departmentName"))){
                flag=true;
                break;
            }else
                flag=false;
        }
    return flag;
    }

















}

