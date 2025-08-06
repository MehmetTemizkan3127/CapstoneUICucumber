package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

@Getter
public class EditDepartmentPage {

    private By deleteDepartmentButton = By.xpath("//*[@class='btn btn-danger text-light fw-bold float-end']");
    private By deleteDepartmentButton2 = By.xpath("//button[text()='Delete Department']"); //yedek locate
    private By confirmButton = By.xpath("//button[@class='btn btn-danger']");
    private By cancelButton = By.xpath("//button[@class='btn btn-secondary']");
    private By departmentTypeForUpdate = By.xpath("//div[@class=' css-1dimb5e-singleValue']");
    private By changeImageButton = By.xpath("//input[@class='custom-file-input ms-4']");

    AllPages pages = new AllPages();
    Actions actions = new Actions(getDriver());
    private String savedDepartmentName; //feature'de gönderilen name'i burada kaydediyorum ki sonra dogrulamasi yapmakta kullanabileyim
    public static String staticName;// yukaridaki private Stringi buraya aktarip baska sayfadan cagiriyorum
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public EditDepartmentPage refreshUntilDeleteButtonIsDisplayed() {
        int num = 0;
        while (num < 8) {
            getDriver().navigate().refresh();
            ReusableMethods.waitForSeconds(2);
            if (!getDriver().findElements(By.xpath("//button[text()='Delete Department']")).isEmpty()) {
                break;
            }
            num++;
        }
        return this;
    }

    public EditDepartmentPage enterDepartmentUpdateName(String name) {
        getDriver().findElement(pages.getNewDepartmentPage().getNameField()).clear();
        ReusableMethods.sendKeys(pages.getNewDepartmentPage().getNameField(), name);
        this.savedDepartmentName = name;
        return this;
    }

    public EditDepartmentPage enterDepartmentUpdateShortName(String shortName) {
        getDriver().findElement(pages.getNewDepartmentPage().getShortnameField()).clear();
        ReusableMethods.sendKeys(pages.getNewDepartmentPage().getShortnameField(), shortName);
        return this;
    }

    public EditDepartmentPage selectDepartmentType(String type) {
        ReusableMethods.visibilityOfElementByWebDriverWait(departmentTypeForUpdate);
        actions.click(getDriver().findElement(departmentTypeForUpdate)).perform();
        ReusableMethods.waitForSeconds(2);
        WebElement typeOption = getDriver().findElement(By.xpath(String.format(pages.getNewDepartmentPage().getSelectTypeOrRoleWithText(), type)));
        actions.click(typeOption).perform();
        return this;
    }

    public EditDepartmentPage enterDepartmentDescription(String description) {
        getDriver().findElement(pages.getNewDepartmentPage().getDescriptionField()).clear();
        ReusableMethods.sendKeys(pages.getNewDepartmentPage().getDescriptionField(), description);
        return this;
    }

    public boolean isNewCreatedDepartmentDisplayed() { //Department sayfasinda olmali??
        boolean flag = false;
        ReusableMethods.clickElement(pages.getDepartmentsPage().getDepartmentsButton());
        ReusableMethods.visibilityOfElementsByWebDriverWait(pages.getDepartmentsPage().getDepartmentsButton());
        //wait.until(ExpectedConditions.visibilityOfAllElements(getDriver().findElements(pages.getDepartmentsPage().getDepartmentsButton())));
        List<WebElement> names = getDriver().findElements(pages.getDepartmentsPage().getAllDepartmentNames());
        for (WebElement nameElement : names) {
            if (nameElement.getText().equals(this.savedDepartmentName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean isDeleteButtonVisibleAndClickable() {
        ReusableMethods.visibilityOfElementByWebDriverWait(deleteDepartmentButton);
        return ReusableMethods.isDisplayed(deleteDepartmentButton) & ReusableMethods.isEnabled(deleteDepartmentButton);
    }

    public boolean isChangeImageButtonVisibleAndClickable() {
        ReusableMethods.visibilityOfElementByWebDriverWait(changeImageButton);
        return ReusableMethods.isDisplayed(changeImageButton) & ReusableMethods.isEnabled(changeImageButton);
    }

    public EditDepartmentPage clickDeleteButton() {
        ReusableMethods.clickElementByWebDriverWait(deleteDepartmentButton);
        ReusableMethods.clickElementByJS(deleteDepartmentButton);
        return this;
    }

    public EditDepartmentPage clickConfirmButton() {
        ReusableMethods.clickElementByWebDriverWait(confirmButton);
        ReusableMethods.clickElementByJS(confirmButton);
        ReusableMethods.waitForSeconds(3);
        return this;
    }
}