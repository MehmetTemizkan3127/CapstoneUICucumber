package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;


public class LoginPage {

    private By email = By.id("username");
    private By password = By.id("password");
    private By signInButton = By.xpath("//button[@class='btn btn-primary btn-block mb-4']");

    public LoginPage enterEmail(String email) {
        Driver.getDriver().findElement(this.email).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public void userLogins(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyLogin() {
        WebElement navigationBar = Driver.getDriver().findElement(By.className("navbar-brand"));
        Assert.assertTrue(navigationBar.isDisplayed());
    }


    public void clickSignIn() {
        Driver.getDriver().findElement(signInButton).click();
    }

    public void checkErrorMessage(String message) {
        WebElement errorElement = Driver.getDriver().findElement(By.xpath("/html/body/div/div/div/div[2]/div/h5"));
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorElement.getText(), message);
    }

    public void validateEmailRequired(String elementId) {
        WebElement usernameElement = Driver.getDriver().findElement(By.id(elementId));
        // Check HTML5 browser validation, e.g., <input required>
        Assert.assertFalse(usernameElement.getAttribute("validationMessage").isEmpty());
    }
}
