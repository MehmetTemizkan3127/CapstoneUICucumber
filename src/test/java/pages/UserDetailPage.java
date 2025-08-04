package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigReader;
import utilities.Driver;


import java.util.List;

import static org.testng.Assert.*;
import static utilities.ReusableMethods.*;

public class UserDetailPage {

    Logger logger = LogManager.getLogger(UserDetailPage.class);

    private By pageTitle = By.xpath("//body//div[@class='col']/h4");
    private By addRoleButton = By.xpath("//div[@class='col']/label[@class='form-label text-secondary']/img");
    private By roleWindow_fade = By.xpath("//div[@class='modal fade show']");
    private By roleWindow_pageTitle = By.xpath("//div[@class='modal fade show']//h5");
    private By roleWindow_DropDownMenu = By.xpath("//div[@class='modal fade show']//div[@class=' css-1xc3v61-indicatorContainer']");
    private By listOfRolesDropDownMenu = By.xpath("//div[@id='react-select-5-listbox']/div");
    private By roleWindow_saveButton = By.cssSelector("button.btn.btn-info.float-end.text-white");
    private By roleWindow_NewRoleAddedMessaged = By.xpath("//p[contains(text(), 'New role added for this user')]");
    private By listOfAddedRoles = By.xpath("//div[@class='row mt-3']//div[@class='col row-cols-1']/span");
    private By defaultRole = By.xpath("//div[@class='row mt-3']//div[@class='col row-cols-1']/span[@class='active-roles-box']");
    private By defaultrole_threeDot = By.xpath("//span[@class='active-roles-box']//div[@class='btn-group dropup']");
    private By roles_threeDot = By.xpath("//div[@class='btn-group dropup']");

    private By resetPassword = By.id("changePasswordButton");
    private By confirmResetPassword = By.xpath("//div[@class='modal-body']//button[text()='Confirm']");
    private By resetPasswordSuccessMessage = By.xpath("//div[@class='callout callout-success']//h5[text()='Reset password successfully']");
    private By newResetPasswordText  = By.xpath("//div[@class='callout callout-success']//textarea");


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

        Actions action = new Actions(Driver.getDriver());
        action.click(dropdownInput)
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .perform();


        waitForSeconds(5);
        return this;
    }

    public UserDetailPage clickSaveButton() {
        clickElement(roleWindow_saveButton);
        return this;
    }

    public void assertNewRoledAddedForUser(String expectedResult) {
        String actualResult = visibilityOfElementByWebDriverWait(this.roleWindow_NewRoleAddedMessaged).getText();
        assertEquals(   actualResult,expectedResult);
        System.out.println("Assertion done. " + actualResult);
    }

    public UserDetailPage refreshUserDetailPage() {
        refreshPage();
        return this;
    }

    public void assertNewAddedRoleIsListedUnderRolesSection() {
    }

    public UserDetailPage isThereADefaultRole() {
        try {
            visibilityOfElementByWebDriverWait(defaultRole);
        }
        catch (Exception e){
            System.out.println("There isn't a Default Role");
        }
        return this;


    }

    public UserDetailPage assertDefaultRoleDoesNotHaveThreeDots() {

        System.out.println("DefaultRole is " + getTextOfElement(defaultRole));
        WebElement defaultRole = visibilityOfElementByWebDriverWait(this.defaultRole);
        List<WebElement> checkDefaultRole = Driver.getDriver().findElements(defaultrole_threeDot);
//        String bgColor = defaultRole.getCssValue("background-color");
//        System.out.println("bgColor = " + bgColor);
        assertEquals (checkDefaultRole.size(),0);
        System.out.println("Assertion done. Default role cannot be deleted ");
        return this;

    }

    public UserDetailPage clickResetPasswordButton() {
        clickElement(resetPassword);
        System.out.println("Clicked Reset Password button");
        return this;
    }

    public UserDetailPage clickConfirmButton() {
        clickElement(this.confirmResetPassword);
        System.out.println("Clicked Confirm button");
        return this;
    }

    public UserDetailPage assertPasswordReset(String expectedResult) {
        assertEquals(getTextOfElement(this.resetPasswordSuccessMessage),expectedResult);
        System.out.println("Assertion done.  "  + getTextOfElement(this.resetPasswordSuccessMessage));
        return this;
    }


    public UserDetailPage keepNewPassword() {

        String password = getTextOfElement(this.newResetPasswordText);
        System.out.println("New password created: " + password);
        ConfigReader.setProperty("password2",password);

        System.out.println("Config e password2 set edildi " + ConfigReader.getProperty("password2"));

        return this;

    }


}
