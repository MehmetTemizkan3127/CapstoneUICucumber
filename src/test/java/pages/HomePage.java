package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class HomePage {
    private By loginLink = By.className("login-button");


    public HomePage login() {
        Driver.getDriver().findElement(this.loginLink).click();
        return this;
    }
}
