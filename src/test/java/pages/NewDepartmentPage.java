package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.getDriver;
//T****
@Getter
public class NewDepartmentPage {

    // Locates
    private By nameField = By.xpath("//*[@id='name']");
    private By shortnameField = By.xpath("//*[@name='short_name']");
    private By departmentTypeField = By.xpath("//div[@id='react-select-2-placeholder']");
    private By selectTypeDepartment = By.xpath("//div[@id='react-select-2-option-2']");
    private By selectTypeRemoteUnite = By.xpath("//div[@id='react-select-2-option-0']");
    private By selectTypeTeam = By.xpath("//div[@id='react-select-2-option-1']");
    private By descriptionField = By.xpath("//input[@name='description']");
    private By saveButton = By.xpath("//*[@class='btn btn-info text-white px-3']");
    private By cancelButton = By.xpath("//*[@class='btn btn-dark']");
    private By editButton = By.xpath("//*[@class='btn btn-outline-dark']");
    private By successMessage = By.xpath("//div[@class='toast-body']/p");
    private By negativeMessage = By.xpath("//span[@class='text-danger']");
    private By selectedRole = By.xpath("//div[@class=' css-9jq23d']");
    private By removeSelectedRole = By.xpath("//div[@role='button']");
    private By rolesField = By.xpath("//input[@id='react-select-3-input']");
    private By roleOption = By.xpath("//div[@id='react-select-3-option-2']");
    private By closeRoleField = By.xpath("(//div[@class=' css-19bb58m'])[2]");
    private By roleOptionWithText = By.xpath("//div[contains(@class, '-option') and text()='Sales Manager']");
    private String selectTypeOrRoleWithText = "//div[contains(@class, '-option') and text()=\"%s\"]";


    //Object and Variables******************
    private String savedDepartmentName;
    private int expectedRoleCount = 0;
    final private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); //intelij final önerdi:)
    final private Actions actions = new Actions(getDriver());
    final private AllPages pages = new AllPages();

    //METHODS********************

    public NewDepartmentPage enterDepartmentName(String name) {
        ReusableMethods.sendKeys(nameField, name);
        this.savedDepartmentName = name;
        return this;
    }

    public NewDepartmentPage enterDepartmentShortName(String shortName) {
        ReusableMethods.sendKeys(shortnameField, shortName);
        return this;
    }

    public NewDepartmentPage selectDepartmentType(String type) {
        ReusableMethods.visibilityOfElementByWebDriverWait(departmentTypeField);
        actions.click(getDriver().findElement(departmentTypeField)).perform();
        ReusableMethods.waitForSeconds(2);
        WebElement typeOption = getDriver().findElement(By.xpath(String.format(selectTypeOrRoleWithText, type)));
        actions.click(typeOption).perform();
        return this;
    }

    public NewDepartmentPage enterDepartmentDescription(String description) {
        ReusableMethods.sendKeys(descriptionField, description);
        return this;
    }

    public NewDepartmentPage selectRoles(String role) {
        ReusableMethods.visibilityOfElementByWebDriverWait(rolesField);
        actions.click(getDriver().findElement(rolesField)).perform();
        ReusableMethods.waitForSeconds(2);
        actions.click(getDriver().findElement(By.xpath(String.format(selectTypeOrRoleWithText, role)))).perform();
        ReusableMethods.waitForSeconds(2);
        actions.click(getDriver().findElement(closeRoleField)).perform();
        return this;
    }

    public NewDepartmentPage clickSaveButton() {
        ReusableMethods.clickElement(saveButton);
        return this;
    }

    public NewDepartmentPage clickCancelButton() {
        ReusableMethods.clickElement(cancelButton);
        return this;
    }

    public NewDepartmentPage selectMultipleRoles(int roleCount) {
        this.expectedRoleCount = roleCount;
        actions.click(getDriver().findElement(rolesField)).perform();
        ReusableMethods.waitForSeconds(2);
        actions.click(getDriver().findElement(roleOptionWithText)).perform();
        ReusableMethods.waitForSeconds(2);
        for (int i = 0; i < roleCount; i++) { //Tab ile istendigi kadar rol sayisi ekleniyor
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.click(getDriver().findElement(closeRoleField)).perform();
        ReusableMethods.waitForSeconds(3);
        return this;
    }

    public NewDepartmentPage removeSelectedRole() {
        ReusableMethods.clickElement(removeSelectedRole);
        return this;
    }

    public NewDepartmentPage selectRolesTwice(String role) {
        ReusableMethods.visibilityOfElementByWebDriverWait(rolesField);
        actions.click(getDriver().findElement(rolesField)).perform();
        ReusableMethods.waitForSeconds(2);
        actions.click(getDriver().findElement(By.xpath(String.format(selectTypeOrRoleWithText, role)))).perform();
        ReusableMethods.waitForSeconds(2);
        return this;
    }


    public boolean isNewCreatedDepartmentDisplayed() {
        boolean flag = false;
        ReusableMethods.clickElement(pages.getDepartmentsPage().getDepartmentsButton());
        wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElements(pages.getDepartmentsPage().getDepartmentsButton())));
        List<WebElement> names = getDriver().findElements(pages.getDepartmentsPage().getAllDepartmentNames());
        for (WebElement nameElement : names) {
            if (nameElement.getText().equals(this.savedDepartmentName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean isMessageDisplayed(By by, String message) {
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(by), message));
        return getDriver().findElement(by).getText().equals(message);
    }

    public boolean isRoleCountMatched() {  // yeni creat edilen department'a eklenen rol sayisi ile dep. icindeki rol sayisinin esitligini dogrular
        ReusableMethods.clickElement(pages.getDepartmentsPage().getDepartmentsButton());
        ReusableMethods.waitForSeconds(2);
        List<WebElement> rolesList = new ArrayList<>();
        for (WebElement w : getDriver().findElements(pages.getDepartmentsPage().getAllDepartmentNames())) {
            if (w.getText().equals(this.savedDepartmentName)) {
                w.click();
                rolesList = getDriver().findElements(pages.getDepartmentDetailPage().getRolesList());
                break;
            }
        }
        return rolesList.size() == this.expectedRoleCount + 1;
    }

    public boolean isSelectedRoleRemovedSuccessfully() {
        try {
            return !getDriver().findElement(selectedRole).isDisplayed();
        } catch (NoSuchElementException e) {
            return true; // Element yoksa, silindi demektir.
        }
    }

    public boolean isSameRoleSelectableAgain(String role) {
        return !getDriver().findElements(By.xpath(String.format(selectTypeOrRoleWithText, role))).isEmpty();
    }

    public boolean isDepartmentNameFieldVisible() {
        return ReusableMethods.isDisplayed(nameField);
    }

    public boolean isShortNameFieldVisible() {
        return ReusableMethods.isDisplayed(shortnameField);
    }

    public boolean isDepartmentTypeFieldVisible() {
        return ReusableMethods.isDisplayed(departmentTypeField);
    }

    public boolean isDepartmentDescriptionFieldVisible() {
        return ReusableMethods.isDisplayed(descriptionField);
    }

    public boolean isDepartmentRolesFieldVisible() {
        return ReusableMethods.isDisplayed(rolesField);
    }

    public boolean isSaveButtonVisible() {
        return ReusableMethods.isDisplayed(saveButton);
    }

    public boolean isSaveButtonClickable() {
        return ReusableMethods.isEnabled(saveButton);
    }

    public boolean isCancelButtonVisible() {
        return ReusableMethods.isDisplayed(cancelButton);
    }

    public boolean isEditButtonVisible() {
        return ReusableMethods.isDisplayed(editButton);
    }
}

