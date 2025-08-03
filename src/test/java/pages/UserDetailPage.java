package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import static org.testng.Assert.*;
import static utilities.ReusableMethods.*;

public class UserDetailPage {

    private By pageTitle = By.xpath("//body//div[@class='col']/h4");
    private By addRoleButton = By.xpath("//div[@class='col']/label[@class='form-label text-secondary']/img");
    private By roleWindow_fade = By.xpath("//div[@class='modal fade show']");
    private By roleWindow_pageTitle = By.xpath("//div[@class='modal fade show']//h5");
    private By roleWindow_DropDownMenu = By.xpath("//div[@class='modal fade show']//div[@class=' css-1xc3v61-indicatorContainer']");
    private By listOfRolesDropDownMenu = By.xpath("//div[@id='react-select-5-listbox']/div");
    private By roleWindow_saveButton = By.cssSelector("button.btn.btn-info.float-end.text-white");
    private By roleWindow_NewRoleAddedMessaged = By.xpath("//button[text()='New role added for this user successfuly']");
    private By listOfAddedRoles = By.xpath("//div[@class='row mt-3']//div[@class='col row-cols-1']/span");
    private By defaultRole = By.xpath("//div[@class='row mt-3']//div[@class='col row-cols-1']/span[@class='active-roles-box']");

    ///    //div[@class='modal fade show']//div[@class='  css-1xc3v61-indicatorContainer']

    public void assertUserDetailPageOpens() {
        assertEquals(getTextOfElement(pageTitle),"User Detail");
    }

    public UserDetailPage clickAddNewRoleButton() {
        clickElement(addRoleButton);
        return this;
    }
    public UserDetailPage clickOnRolesList() {
        clickElementByJS(roleWindow_DropDownMenu);
        return this;
    }
    public void assertSelectARoleWindowOpens() {
        visibilityOfElementsByWebDriverWait(roleWindow_fade);
        assertTrue(getTextOfElement(roleWindow_pageTitle).contains("Select the role "));
    }
    public UserDetailPage selectARoleFromDropDown() {
        // Dropdown input alanını tıklayıp listeyi aç
        WebElement dropdownInput = Driver.getDriver().findElement(By.xpath("//div[contains(@class,'css-13cymwt-control')]"));
        dropdownInput.click();

// Açılan listeden "Warehouse Personnel" öğesini seç
        WebElement optionToSelect = Driver.getDriver().findElement(By.xpath("//div[@id='react-select-5-listbox']//div[text()='Warehouse Personnel']"));
        optionToSelect.click();
        visibilityOfElementsByWebDriverWait(roleWindow_fade);
        System.out.println(visibilityOfElementByWebDriverWait(listOfRolesDropDownMenu).getText());
        return this;
    }

    public UserDetailPage clickSaveButton() {
        clickElement(roleWindow_saveButton);
        return this;
    }

    public void assertNewRoledAddedForUser() {
        visibilityOfElementByWebDriverWait(this.roleWindow_NewRoleAddedMessaged);
        assertEquals(   getTextOfElement(roleWindow_NewRoleAddedMessaged),"New role added for this user successfuly");
    }

    public UserDetailPage refreshUserDetailPage() {
        refreshPage();
        return this;
    }

    public void assertNewAddedRoleIsListedUnderRolesSection() {
    }

    public UserDetailPage attemptToDeleteDefaultRole() {
        clickElement(defaultRole);
        return this;
    }
}
