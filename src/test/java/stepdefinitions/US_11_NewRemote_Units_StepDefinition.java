package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AllPages;
import pages.DashboardPage;
import pages.NewRemoteUnitPage;
import pages.RemoteUnitsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.waitForSeconds;

public class US_11_NewRemote_Units_StepDefinition {
    RemoteUnitsPage remoteUnitsPage=new RemoteUnitsPage();
    NewRemoteUnitPage newAdd =new NewRemoteUnitPage();




    @When("the user clicks on the Add New Remote Unit button")
    public void the_user_clicks_on_the_add_new_remote_unit_button() throws InterruptedException {
        waitForSeconds(3);
        newAdd.AddNewRemoteLink.click();

    }
    @When("the user enters Department Name")
    public void the_user_enters_department_name() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        newAdd.DepartmentNameInput.clear();
        newAdd.DepartmentNameInput.sendKeys(ConfigReader.getProperty("departmaname"));
    }

    @When("the user selects the department type as Remote Unit from the dropdown menu.")
    public void the_user_selects_the_department_type_as_remote_unit_from_the_dropdown_menu() {

        newAdd.DepartmentType.sendKeys("Remote Unit"+ Keys.ENTER);

    }
    @When("the user clicks the Save button")
    public void the_user_clicks_the_save_button() {
        waitForSeconds(2);
        remoteUnitsPage.SaveButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
    @Then("the user verifies that the newly added remote unit displayed under Remote Units.")
    public void the_user_verifies_that_the_newly_added_remote_unit_displayed_under_remote_units() {


        waitForSeconds(3);
        String actualText = newAdd.verifynewremoteunits.getText();
        System.out.println("actualText = " + actualText);
        String expectedDeptName = ConfigReader.getProperty("departmaname");
        System.out.println("expectedDeptName = " + expectedDeptName);

        Assert.assertTrue(actualText.contains(expectedDeptName),
                "Beklenen metin bulunamadı: " + expectedDeptName);
        waitForSeconds(1);
        newAdd.verifynewremoteunits.click();
        waitForSeconds(1);
        //newAdd.editbutton.click();
        waitForSeconds(2);
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        Driver.getDriver().navigate().refresh();
        waitForSeconds(3);
       // newAdd.deletebutton.click();
      //  waitForSeconds(2);
       // newAdd.confirmbutton.click();


    }
}
