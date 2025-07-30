package pages;


import org.openqa.selenium.By;
import utilities.Driver;


public class LoginPage {

    private By email = By.id("username");
    private By password = By.id("password");
    private  By signInButton = By.xpath("//button[@class='btn btn-primary btn-block mb-4']");

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

    public void clickSignIn (){
       Driver.getDriver().findElement(signInButton).click();
    }
}