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

    @Then("profile the message {string} should be displayed")
    public void profileTheMessageShouldBeDisplayed(String errorMessage) {

        ReusableMethods.waitForSeconds(2); // kısa gecikme
        String actualMessage = pages.getProfilePage().getNotChangePasswordAlertText();
        Assert.assertEquals(errorMessage, actualMessage);




    }


}

