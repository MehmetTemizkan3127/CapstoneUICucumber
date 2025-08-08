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

    Logger log = LogManager.getLogger(UserDetailPage.class);

    private By pageTitle = By.xpath("//body//div[@class='col']/h4");
    private By addRoleButton = By.xpath("//label[@class='form-label text-secondary']//img[@class='ms-2 cursor-pointer']");
    private By roleWindow_pageTitle = By.xpath("//div[@class='modal fade show']//h5");
    private By roleWindow_DropDownMenu = By.xpath("//div[@class='modal fade show']//div[@class=' css-1xc3v61-indicatorContainer']");
    private By listOfRolesDropDownMenu = By.xpath("//div[@id='react-select-5-listbox']/div");
    private By roleWindow_saveButton = By.cssSelector("button.btn.btn-info.float-end.text-white");
    private By roleWindow_NewRoleAddedMessaged = By.xpath("//p[contains(text(), 'New role added for this user')]");
    private By listOfAddedRoles = By.xpath("//div[@class='row mt-3']//div[@class='col row-cols-1']/span");
    private By defaultRole = By.xpath("//div[@class='row mt-3']//div[@class='col row-cols-1']/span[@class='active-roles-box']");
    private By defaultrole_threeDot = By.xpath("//span[@class='active-roles-box']//div[@class='btn-group dropup']");
    private By roles_threeDot = By.xpath("//div[@class='btn-group dropup']");
    private By dropDownInput = By.xpath("//div[contains(@class,'css-13cymwt-control')]");
    private By selectedRole = By.xpath("//div[@class=' css-1dimb5e-singleValue']");

    private By resetPassword = By.id("changePasswordButton");
    private By confirmResetPassword = By.xpath("//div[@class='modal-body']//button[text()='Confirm']");
    private By resetPasswordSuccessMessage = By.xpath("//div[@class='callout callout-success']//h5[text()='Reset password successfully']");
    private By newResetPasswordText = By.xpath("//div[@class='callout callout-success']//textarea");
    private By username = By.xpath("//div/label[@id='username']");

    private String siblingElementLocate = "//span[text()='{selectedRole}']/following-sibling::div[contains(@class,'btn-group')]//button";
    private By setAsDefaultRoleButton = By.xpath("//div[@class='btn-group dropup show']//a[text()='Set as default role']");
    private By roleWindow_cancelButton = By.xpath("//button[text()='Cancel']");
    private By roleWindow_ErrorMessage = By.xpath("//div[contains(text(),'You can add a role to the user from the profile page.')]");
    private By pencilImage = By.xpath("//button[@class='btn btn-ghost-dark rounded-circle']");
    private By tickImage = By.xpath("//button[@class='btn btn-ghost-primary rounded-circle']");
    private By crossImage = By.xpath("//button[@class='btn btn-ghost-danger rounded-circle']");
    private By emailLabel = By.id("email");
    private By usernameInput = By.id("username");
    private By errorMessage = By.xpath("//span[@class='text-danger']");


    public void assertUserDetailPageOpens() {
        assertEquals(getTextOfElement(pageTitle), "User Detail");
    }

    public UserDetailPage clickAddNewRoleButton() {
        waitForSeconds(1);
        Driver.getDriver().findElement(this.addRoleButton).click();
         return this;
    }

    public UserDetailPage clickOnRolesList() {
        clickElementByJS(this.roleWindow_DropDownMenu);
        return this;
    }

    public void assertSelectARoleWindowOpens() {
        visibilityOfElementsByWebDriverWait(this.roleWindow_pageTitle);
    }

    public UserDetailPage selectARoleFromDropDown() {
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
        waitForSeconds(2);
        ConfigReader.setProperty("selectedRole", getTextOfElement(this.selectedRole));  //todo hatalar sonrası editledim. kontrol et
        waitForSeconds(2);
        return this;
    }

    public UserDetailPage keepSelectedRole() {

       waitForSeconds(2);
        ConfigReader.setProperty("selectedRole", getTextOfElementByJS(this.selectedRole));
        return this;
    }

    public UserDetailPage clickSaveButton() {
        clickElement(roleWindow_saveButton);
        return this;
    }

    public void assertNewRoledAddedForUser(String expectedResult) {
        String actualResult = visibilityOfElementByWebDriverWait(this.roleWindow_NewRoleAddedMessaged).getText();
        assertEquals(actualResult, expectedResult);
        System.out.println("Assertion done. " + actualResult);
    }

    public UserDetailPage refreshUserDetailPage() {
        refreshCurrentPage();
        return this;
    }

    public void assertNewAddedRoleIsListedUnderRolesSection() {

        List<WebElement> rolesList = visibilityOfElementsByWebDriverWait(this.listOfAddedRoles);
        assertTrue(rolesList
                .stream()
                .anyMatch(t -> t.getText().equals(ConfigReader.getProperty("selectedRole")))
        );
    }

    public UserDetailPage isThereADefaultRole() {
        try {
            visibilityOfElementByWebDriverWait(defaultRole);
        } catch (Exception e) {
            log.info("There isn't a Default Role");
        }
        return this;


    }

    public void assertDefaultRoleDoesNotHaveThreeDots() {
        List<WebElement> checkDefaultRole = visibilityOfElements(defaultrole_threeDot);
        assertEquals(checkDefaultRole.size(), 0);
    }

    public UserDetailPage clickResetPasswordButton() {
        clickElement(resetPassword);
        return this;
    }

    public UserDetailPage clickConfirmButton() {
        clickElement(this.confirmResetPassword);
        return this;
    }

    public void assertPasswordReset(String expectedResult) {
        assertEquals(getTextOfElement(this.resetPasswordSuccessMessage), expectedResult);
    }


    public void keepUserNameAndNewPassword() {

        String username = getTextOfElementByJS(this.username);
        String password = getTextOfElement(this.newResetPasswordText);
        System.out.println("New password created: " + password);
        System.out.println("email = " + username);
        ConfigReader.setProperty("username2", username);
        ConfigReader.setProperty("password2", password);
    }

    public void setNewRoleAsDefault() {

        By siblingElementLocate = By.xpath(this.siblingElementLocate.replace("{selectedRole}", ConfigReader.getProperty("selectedRole")));
        clickElementByJS(siblingElementLocate);

        System.out.println("ConfigReader.getProperty(\"selectedRole\") = " + ConfigReader.getProperty("selectedRole"));

        visibilityOfElementByWebDriverWait(this.setAsDefaultRoleButton).click();
    }

    public void assertNewDefaultRoleIsCorrect() {

        WebElement defaultRole = visibilityOfElementByWebDriverWait(this.defaultRole);
        String bgColor = defaultRole.getCssValue("background-color");
        System.out.println("bgColor = " + bgColor);
        // assertEquals(bgColor,);
    }

    public void clickCancelButton() {
        clickElement(this.roleWindow_cancelButton);
    }

    public void assertCanceledRoleIsNotListedUnderRolesSection() {
        List<WebElement> rolesList = visibilityOfElementsByWebDriverWait(this.listOfAddedRoles);
        assertFalse(rolesList
                .stream()
                .anyMatch(t -> t.getText().equals(ConfigReader.getProperty("selectedRole")))
        );
    }

    public void assertSaveErrorWithoutRole() {
        visibilityOfElementByWebDriverWait(this.roleWindow_ErrorMessage);
    }

    public void clickPencilImage() {
        clickElementByJS(this.pencilImage);

    }

    public void assertVisibilityOfTickImage() {
        visibilityOfElementByWebDriverWait(this.tickImage);
        visibilityOfElementByWebDriverWait(this.crossImage);
    }

    public void assertEmailAddressUnchangeable() {
        try{
            sendKeys(this.emailLabel,"test");
            assert  false;
        }
        catch (Exception e){
            assert true;
        }
        finally {
            assertEquals(visibilityOfElement(emailLabel).getTagName(), "label");
        }
    }

    public void deleteUsernameInputArea() {
         WebElement usernameInput = visibilityOfElement(this.usernameInput);
         usernameInput.click();
         waitForSeconds(1);
         usernameInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
         usernameInput.sendKeys(Keys.DELETE);

    }

    public void assertUsernameErrorMessageOccurs() {
        waitForSeconds(2);
        visibilityOfElement(this.errorMessage);
    }

    public void assertConfirmButtonIsVisible() {
        isDisplayed(this.confirmResetPassword);
    }
}
