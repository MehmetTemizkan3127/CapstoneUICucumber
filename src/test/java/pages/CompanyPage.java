package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class CompanyPage {
    AllPages pages = new AllPages();

    // --- Senin locator'ların (Aynen korundu) ---
    public By companyModule = By.xpath("//a[@href='#/company/1724253527891397']");
    public By editButton = By.xpath("//button[@class='btn btn-outline-dark']");
    public By companyNameField = By.xpath("//*[@id=\"name\"]");
    public By emailField = By.xpath("//input[@name='email']");
    public By saveButton = By.xpath("//*[@id=\"MainContent\"]/div[1]/div/div/div[2]/div[5]/div/span/div/button[1]");
    public By successMessage = By.xpath("//div[@class='toast-body' and contains(text(),'Company information successfully updated')]");
    public By errorMessage = By.xpath("//div[contains(@class,'toast') and contains(@class,'bg-danger')]");

    // --- YARDIMCI: Edit modunda açılan gerçek input (değişken bırakıyoruz) ---
    private By companyNameInputEditable = By.xpath("//label[normalize-space()='Name']/following::input[1]");

    // Actions
    public void goToCompanyModule() {
        ReusableMethods.clickElement(companyModule); // senin click
    }

    public void clickEdit() {
        ReusableMethods.clickElement(editButton);
    }

    public void setCompanyName(String name) {
        WebElement isim = ReusableMethods.visibilityOfElementByWebDriverWait(companyNameField);
        isim.click();
        isim.clear();
        ReusableMethods.sendKeys(companyNameField, name);


    }

    public void setEmail(String email) {
        WebElement el = ReusableMethods.visibilityOfElementByWebDriverWait(emailField);
        el.click();
        el.clear();
        ReusableMethods.sendKeys(emailField, email);
    }

    public void clearEmail() {
        Driver.getDriver().findElement(emailField).clear();
    }

    public void clickSave() {
        ReusableMethods.clickElement(saveButton);
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        // Direkt text bekle
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector("div.toast-body"),
                "Company information successfully updated"));

        WebElement message = Driver.getDriver().findElement(By.cssSelector("div.toast-body"));
        String text = message.getText();

        // Kaybolana kadar bekle
        wait.until(ExpectedConditions.invisibilityOf(message));
        return text;
    }

    public String getErrorMessage() {
        ReusableMethods.visibilityOfElementByWebDriverWait(errorMessage);
        return ReusableMethods.getTextOfElement(errorMessage);
    }
}
