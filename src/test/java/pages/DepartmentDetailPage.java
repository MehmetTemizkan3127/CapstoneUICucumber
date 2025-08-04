package pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DepartmentDetailPage {

    //LOCATES
    private By rolesList = By.xpath("//div[@class='col-12']/span"); //Departman kartinin icindeki tüm rolleri alan list
    private By editDepartmentButton = By.xpath("//*[@class='btn btn-info float-end text-white']");


}
