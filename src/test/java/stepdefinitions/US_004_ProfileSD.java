package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AllPages;
import utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class US_004_ProfileSD extends ReusableMethods {

    AllPages pages = new AllPages();

    @When("profile the user clicks on the Change Password button on the right side")
    public void profileTheUserClicksOnTheChangePasswordButtonOnTheRightSide() {
        pages.getProfilePage().clickChangePasswordButton();
    }

    @Then("profile the Change Password section should be displayed")
    public void profileTheChangePasswordSectionShouldBeDisplayed() {
        ReusableMethods.visibilityOfElementByWebDriverWait(pages.getProfilePage().getChangePasswordHeader());
        Assert.assertTrue(pages.getProfilePage().isChangePasswordHeaderVisible());
    }


    @When("profile the user enters {string} in the password field")
    public void profileTheUserEntersInThePasswordField(String password1) {
        pages.getProfilePage().enterNewPassword(password1);
    }

    @And("profile the user re-enters {string} in the confirmation field")
    public void profileTheUserReEntersInTheConfirmationField(String password2) {
        pages.getProfilePage().enterConfirmPassword(password2);
    }

    @And("profile the user clicks on the Confirm button")
    public void profileTheUserClicksOnTheConfirmButton() {
        pages.getProfilePage().clickConfirmButton();
    }

    @Then("profile the message {string} should be displayed in the upper right corner")
    public void profileTheMessageShouldBeDisplayedInTheUpperRightCorner(String expectedMessage) {
        ReusableMethods.waitForSeconds(2); // kısa gecikme
        String actualMessage = pages.getProfilePage().getChangePasswordAlertText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }










//    @And("profile the user enters the email {string}")
//    public void profileTheUserEntersTheEmail(String imail) {
//        waitForVisibility(Driver.getDriver(), loginPage.username, 10);
//        sendKeysMethod(loginPage.username, imail);
//    }
//
//    @And("profile the user enters the password {string}")
//    public void profileTheUserEntersThePassword(String sifre) {
//        waitForVisibility(Driver.getDriver(), loginPage.password, 10);
//        sendKeysMethod(loginPage.password, sifre);
//    }
//
//    @And("profile the user clicks on the sign in button")
//    public void profileTheUserClicksOnTheSignInButton() {
//        clickElement(loginPage.signin);
//    }
//
//    @Then("profile the user clicks on the Profile module in the left corner")
//    public void profileTheUserClicksOnTheProfileModuleInTheLeftCorner() {
//        clickElement(profilePage.profileButtonum);
//    }
//
//    @And("profile the user should be on the Profile module")
//    public void profileTheUserShouldBeOnTheProfileModule() {
//        waitForVisibility(Driver.getDriver(), profilePage.profileButtonum, 10);
//        assertTrue(profilePage.profileButtonum.isDisplayed());
//    }
//
//
//
//
//
//
//
//
//    @Then("profile the message {string} should be displayed")
//    public void profileTheMessageShouldBeDisplayed(String error_message) {
//        waitForVisibility(Driver.getDriver(), profilePage.changePasswordNotSuccessfulAlertProfile, 10);//negatif mesaj
//        assertEquals(error_message, profilePage.changePasswordNotSuccessfulAlertProfile.getText());
//        System.out.println("burasıından sonra ");
//    }
//    @And("the new password should be updated for subsequent login")
//    public void theNewPasswordShouldBeUpdatedForSubsequentLogin() {

}



