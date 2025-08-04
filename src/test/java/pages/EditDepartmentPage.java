package pages;

import lombok.Getter;
import org.openqa.selenium.By;
@Getter
public class EditDepartmentPage {


    private By deleteDepartmentButton = By.xpath("//*[@class='btn btn-danger text-light fw-bold float-end']");
    private By confirmButton = By.xpath("//button[@class='btn btn-danger']");
    private By cancelButton = By.xpath("//button[@class='btn btn-secondary']");
}
