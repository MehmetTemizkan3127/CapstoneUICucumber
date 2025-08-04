package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static utilities.Driver.getDriver;

@Getter
public class DepartmentsPage {

    //LOCATES
    private By departmentsButton = By.xpath("//div//ul//li[6]//a[text()='Departments']"); //Profil sayfasinda olmasi gerekirdi bu locate'in
    private By departmentsText = By.xpath("//li//a[text()='Departments']"); //Departments'a tiklayinca departments yazisi
    private By allDepartmentsTitleList = By.xpath("//div[@class='col-9']"); //departman isim/üye sayisi/role kismi list olarak
    private By allDepartmentsList = By.xpath("//div[@class='card-body p-3']"); //departmanlarin hepsi list olarak
    private By allDepartmentNames = By.xpath("//p//div[@class='row']//a"); //Bütün departman kartlarinin isim bölümü(tiklanabilir)
    private By texts = By.xpath("(//div[@class='col-9']/text()[4])");
    private By addNewDepartmentButton = By.xpath("//*[@class='btn btn-info float-end text-white']");

    //Object And Varibales
    AllPages pages = new AllPages();

    //METHODS

    public void clickDepartments() {
        Driver.getDriver().findElement(By.xpath("//div//ul//li[6]//a[text()='Departments']")).click();
    }

    public List<WebElement> departmentsWithAuthorizedRoles() { //Rol sayisi 0'dan büyük olan department cartlarini bir liste ekleyip o listi döndüren method
        List<WebElement> departmentWithRoleList = new ArrayList<>();
        int roleCount;
        for (WebElement w : getDriver().findElements(allDepartmentsTitleList)) {
            String text = w.getText();
            text = text.substring(text.length() - 1); //textin son karakteri bana role sayisini veriyor
            roleCount = Integer.parseInt(text);
            if (roleCount > 0) {
                departmentWithRoleList.add(w);
            }
        }
        return departmentWithRoleList;
    }

    //TC07_01

    public boolean areDepartmentCardsDisplayed() {
        List<WebElement> allDepartmentCards = Driver.getDriver().findElements(allDepartmentsList);
        for (WebElement w : allDepartmentCards) {
            if (!w.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    //007_02

    public boolean areAuthorizedRolesDisplayed() { //Rolleri olan dep. kartlarina tiklar roller görünüyor mu kontrol eder
        List<WebElement> allTitles = Driver.getDriver().findElements(allDepartmentsTitleList); // Tüm bilgi /isim/üye/rol sayisi (rol sayısı burada)

        for (int i = 0; i < allTitles.size(); i++) {
            String text = Driver.getDriver().findElements(allDepartmentsTitleList).get(i).getText();
            String lastChar = text.substring(text.length() - 1);
            int roleCount = Integer.parseInt(lastChar);

            if (roleCount > 0) { //Bu for'a sadece rol sayisi 0'dan büyükse girecek
                Driver.getDriver().findElements(allDepartmentNames).get(i).click(); // stale element excp. almamak icin locate'i her seferinde aldim
                ReusableMethods.waitForSeconds(2);
                List<WebElement> allRoles = Driver.getDriver().findElements(pages.getDepartmentDetailPage().getRolesList());
                for (WebElement role : allRoles) {
                    if (!role.isDisplayed()) {
                        return false;
                    }
                }
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().refresh();
            }
        }
        return true;
    }

    //TC_007_03

    public boolean areAuthorizedRolesMatched() { //Departman karti üzerindeki rol sayisi ile icindeki rol sayisi eslesiyor mu diye kontrol eder
        List<WebElement> allTitles = Driver.getDriver().findElements(allDepartmentsTitleList);
        List<WebElement> cardNames = Driver.getDriver().findElements(allDepartmentNames);

        for (int i = 0; i < allTitles.size(); i++) {
            String text = allTitles.get(i).getText();
            String lastChar = text.substring(text.length() - 1);
            int roleCount = Integer.parseInt(lastChar);

            if (roleCount > 0) {
                System.out.println("i = " + i);
                cardNames.get(i).click(); //Ilk if'te roleCount 0'dan büyük degil dolayisiyla i=0 iken if'e girmeyecek ve böylece dogru cardname'e tiklayacak
                ReusableMethods.waitForSeconds(1);

                List<WebElement> actualRoles = Driver.getDriver().findElements(pages.getDepartmentDetailPage().getRolesList()); //Kartin icindeki rolleri bir liste atiyorum
                int actualRoleCount = actualRoles.size();
                System.out.println("Expected role count: " + roleCount + " Actual role count: " + actualRoleCount);
                if (roleCount != actualRoleCount) {
                    return false; // eşitlik yoksa test fail
                }
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().refresh();
                // refresh sonrasi stale element exception alinca listleri burada yeniden aldim
                allTitles = Driver.getDriver().findElements(allDepartmentsTitleList);
                cardNames = Driver.getDriver().findElements(allDepartmentNames);
            }
        }
        return true;
    }

    //TC_007_04
    public boolean isDepartmentsTextDisplayed() {
        return ReusableMethods.isDisplayed(departmentsText);
    }

    //TC_008_10
    public boolean twoDepartmentWithSameName(){ //ayni isimle iki departman olusuyor mu diye kontrol eder

        List<WebElement>namesList = getDriver().findElements(allDepartmentNames);
        for (int i = 0; i < namesList.size() ; i++) {
            for (int j = namesList.size()-1; j > i ; j--) {
                if (namesList.get(i).getText().equals(namesList.get(j).getText())){
                    return true;
                }
            }
        }
        return false;
    }

    //TC_008_12
    public NewDepartmentPage clickAddNewDepartment() {
        ReusableMethods.clickElement(addNewDepartmentButton);
        return new NewDepartmentPage();
    }

    public void deleteDepartmentWithIndex(int index, int lastIndex) { //Departman isimsiz de olsa verilen indextekini siler
        for (int i = index; i < lastIndex; i++) {
            JavascriptUtils.clickElementByJS(getDriver().findElements(allDepartmentNames).get(index));
            ReusableMethods.waitForSeconds(3);
            ReusableMethods.clickElement(pages.getDepartmentDetailPage().getEditDepartmentButton());
            ReusableMethods.waitForSeconds(3);
            getDriver().navigate().refresh();
            ReusableMethods.waitForSeconds(3);
            ReusableMethods.visibilityOfElementByWebDriverWait(pages.getEditDepartmentPage().getDeleteDepartmentButton());
            ReusableMethods.clickElement(pages.getEditDepartmentPage().getDeleteDepartmentButton());
            ReusableMethods.visibilityOfElementByWebDriverWait(pages.getEditDepartmentPage().getConfirmButton());
            ReusableMethods.clickElement(pages.getEditDepartmentPage().getConfirmButton());
            ReusableMethods.visibilityOfElementByWebDriverWait(pages.getDepartmentsPage().getDepartmentsText());
        }
    }

    public DepartmentDetailPage clickDepartmentWithIndex(int index){ //Istenen departmana indexle tiklar
        List<WebElement>namesList = getDriver().findElements(allDepartmentNames);
        namesList.get(index).click();
        return new DepartmentDetailPage();
    }


}
