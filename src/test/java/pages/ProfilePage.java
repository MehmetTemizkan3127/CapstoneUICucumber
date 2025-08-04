package pages;

import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class ProfilePage extends ReusableMethods {

    AllPages pages = new AllPages();

    private By changePasswordButton = By.xpath("//button[@id='changePasswordButton']");
    private By changePasswordHeader = By.className("text-center");
    private By newPassword1 = By.xpath("//input[@id='newPassword']");
    private By newPassword2 = By.xpath("//input[@id='newPassword2']");

    private By confirmButtonProfile = By.xpath("//button[normalize-space()='Confirm']");
    private By cancelButtonProfile = By.xpath("//*[text()='Cancel']");

    private By changePasswordSuccessfulAlertProfile = By.xpath("//div[@class='toast-body']");
    private By changePasswordNotSuccessfulAlertProfile =
            By.xpath("//div[@class='alert alert-danger alert-dismissible fade show mt-1']");

    // METHODS

    public void clickChangePasswordButton() {
        ReusableMethods.clickElementByJS(changePasswordButton);
    }

    public boolean isChangePasswordHeaderVisible() {
        return ReusableMethods.isDisplayed(changePasswordHeader);
    }

    public By getChangePasswordHeader() {
        return changePasswordHeader;
    }

    public void enterNewPassword(String password) {
        ReusableMethods.sendKeys(newPassword1, password);
    }

    public void enterConfirmPassword(String password) {
        ReusableMethods.sendKeys(newPassword2, password);
    }

    public void clickConfirmButton() {
        ReusableMethods.clickElement(confirmButtonProfile);
    }

    public String getChangePasswordAlertText() {
        if (ReusableMethods.isDisplayed(changePasswordSuccessfulAlertProfile)) {
            return ReusableMethods.getTextOfElement(changePasswordSuccessfulAlertProfile);
        } else if (ReusableMethods.isDisplayed(changePasswordNotSuccessfulAlertProfile)) {
            return ReusableMethods.getTextOfElement(changePasswordNotSuccessfulAlertProfile);
        }
        return "";
    }
}

