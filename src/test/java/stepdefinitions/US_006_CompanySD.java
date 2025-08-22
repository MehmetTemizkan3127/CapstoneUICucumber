package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.AllPages;

public class US_006_CompanySD {

    AllPages pages = new AllPages();

    @When("User navigates to Company module")
    public void user_navigates_to_company_module() {
        pages.getCompanyPage().goToCompanyModule();
    }

    @When("User clicks Edit button company")
    public void userClicksEditButtonCompany() {
        pages.getCompanyPage().clickEdit();
    }
    @When("User updates Company Name with {string}")
    public void user_updates_company_name_with(String companyname) {
        pages.getCompanyPage().setCompanyName(companyname);   // clear + sendKeys
    }

    @And("User clicks Save button company")
    public void userClicksSaveButtonCompany() {
        pages.getCompanyPage().clickSave();
    }

    @When("User updates new E-mail with {string}")
    public void user_updates_new_e_mail_with(String email) {
        pages.getCompanyPage().setEmail(email);
    }

    @Then("User should see success message {string}")
    public void user_should_see_success_message(String expected) throws InterruptedException {
        String actual = pages.getCompanyPage().getSuccessMessage();
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()),
                "Beklenen başarı mesajı görünmedi. Expected: " + expected + " | Actual: " + actual);
    }


    @Then("User should see error message {string}")
    public void user_should_see_error_message(String expected) {
        String actual = pages.getCompanyPage().getErrorMessage();
        Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()),
                "Beklenen hata mesajı görünmedi. Expected: " + expected + " | Actual: " + actual);
    }



}
