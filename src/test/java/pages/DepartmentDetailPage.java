package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.getDriver;

@Getter
public class DepartmentDetailPage {

    //LOCATES
    private By rolesList = By.xpath("//div[@class='col-12']/span"); //Departman kartinin icindeki tüm rolleri alan list
    private By editDepartmentButton = By.xpath("//*[@class='btn btn-info float-end text-white']");
    private By newUserButton = By.xpath("//*[@class='btn btn-info btn-sm mb-3 text-light float-end']");
    private By departmentName = By.xpath("//*[@class='fw-bold fs-4']"); //Bir departman kartina tikladiktan sonra departman adi

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    AllPages pages = new AllPages();

    //Methods
    public EditDepartmentPage clickEditDepartmentButton() {
        ReusableMethods.waitForSeconds(3);
        wait.until(ExpectedConditions.elementToBeClickable(editDepartmentButton));
        ReusableMethods.clickElementByJS(editDepartmentButton);
        ReusableMethods.waitForSeconds(3);
        return new EditDepartmentPage();
    }

    public boolean isEditDepartmentButtonVisibleAndClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(editDepartmentButton));
        return ReusableMethods.isDisplayed(editDepartmentButton) & ReusableMethods.isEnabled(editDepartmentButton);
    }

    public boolean isNewUserButtonVisibleAndClickable() {
        return ReusableMethods.isDisplayed(newUserButton) & ReusableMethods.isEnabled(newUserButton);
    }

    public boolean verifyDepartmentNameAfterClick() { //Tiklanan kartla acilan kartin ayni oldugunu dogrular
        List<WebElement> namesList = getDriver().findElements(pages.getDepartmentsPage().getAllDepartmentNames());
        String actualName = namesList.get(3).getText();
        namesList.get(3).click();
        ReusableMethods.visibilityOfElementByWebDriverWait(departmentName);
        String expectedName = getDriver().findElement(departmentName).getText();
        return actualName.equals(expectedName);
    }


}