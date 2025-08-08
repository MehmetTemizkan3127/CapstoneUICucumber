package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;


public class LoginPage {

    private By email = By.id("username");
    private By password = By.id("password");
    private By signInButton = By.xpath("//button[@class='btn btn-primary btn-block mb-4']");
    private By logoButton = By.xpath("/html/body/div/div/div/div[1]/a");


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
        ReusableMethods.waitForSeconds(2);
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

    //ClickLogo-Redirect Homepage//

    public void clickLogo() {
        ReusableMethods.waitForSeconds(1);
        Driver.getDriver().findElement(this.logoButton).click();

    }

    public void verifyHomePage() {
        WebElement homePageVerify = Driver.getDriver().findElement(By.xpath("/html/body/div/h1"));
        Assert.assertTrue(homePageVerify.isDisplayed());
    }
    //ClickLogo-Redirect Homepage//


    //ForgotPassword//

    public void forgotPasswordLink() {
        WebElement forgotPasswordLink = Driver.getDriver().findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[3]/div[2]/div/a"));
        forgotPasswordLink.click();
    }

    public void enterUnregisteredEmail() {
        Driver.getDriver().findElement(By.id("email")).sendKeys("invalidEmail@gmail.com");
    }

    public void recoveryPasswordButton() {
        WebElement recoveryPasswordButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"recoveryForm\"]/button"));
        recoveryPasswordButton.click();
    }

    public void displayEmailNotFoundMessage() {
        String text = Driver.getDriver().findElement(By.xpath("//*[@id=\"email-error\"]")).getText();
        Assert.assertEquals(text, "Email is not found!");
    }


    public void enterInvalidEmail() {
        Driver.getDriver().findElement(By.id("email")).sendKeys("invalidEmail.gmail.com");
    }

    public void displayInvalidCredentialsMessage() {
        String text = Driver.getDriver().findElement(By.xpath("//*[@id=\"email-error\"]")).getText();
        Assert.assertEquals(text, "Email format not valid");
    }
}
