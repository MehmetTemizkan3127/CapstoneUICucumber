package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.JavascriptUtils;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;

import static pages.NewDepartmentPage.staticName;

@Getter
@Setter
public class DepartmentsPage {

    //LOCATES
    private By departmentsButton = By.xpath("//div//ul//li[6]//a[text()='Departments']"); //Profil sayfasinda olmasi gerekirdi bu locate'in
    private By departmentsText = By.xpath("//li//a[text()='Departments']"); //Departments'a tiklayinca departments yazisi
    private By allDepartmentsTitleList = By.xpath("//div[@class='col-9']"); //departman isim/üye sayisi/role kismi list olarak
    private By allDepartmentsList = By.xpath("//div[@class='card-body p-3']"); //departmanlarin hepsi list olarak
    private By allDepartmentNames = By.xpath("//p//div[@class='row']//a"); //Bütün departman kartlarinin isim bölümü(tiklanabilir)
    private By addNewDepartmentButton = By.xpath("//*[@class='btn btn-info float-end text-white']");

    //Object And Varibales
    AllPages pages = new AllPages();
    private WebDriver driver = Driver.getDriver();

    //METHODS
    public DepartmentsPage clickAgainDepartmentsButton(){
        ReusableMethods.visibilityOfElementByWebDriverWait(departmentsButton); //Burada departments locate'inin getter'i gerekli
        ReusableMethods.clickElementByJS(departmentsButton);
        ReusableMethods.waitForSeconds(3);
        return this;
    }

    public List<WebElement> departmentsWithAuthorizedRoles() { //Rol sayisi 0'dan büyük olan department cartlarini bir liste ekleyip o listi döndüren method
        List<WebElement> departmentWithRoleList = new ArrayList<>();
        int roleCount;
        for (WebElement w : driver.findElements(allDepartmentsTitleList)) {
            String text = w.getText();
            text = text.substring(text.length() - 1); //textin son karakteri bana role sayisini veriyor
            roleCount = Integer.parseInt(text);
            if (roleCount > 0) {
                departmentWithRoleList.add(w);
            }
        }
        return departmentWithRoleList;
    }

    public boolean areDepartmentCardsDisplayed() {
        List<WebElement> allDepartmentCards = driver.findElements(allDepartmentsList);
        for (WebElement w : allDepartmentCards) {
            if (!w.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAuthorizedRolesDisplayed() { //Rolleri olan dep. kartlarina tiklar roller görünüyor mu kontrol eder
        List<WebElement> allTitles =driver.findElements(allDepartmentsTitleList); // Tüm bilgi /isim/üye/rol sayisi (rol sayısı burada)

        for (int i = 0; i < allTitles.size(); i++) {
            String text = driver.findElements(allDepartmentsTitleList).get(i).getText();
            String lastChar = text.substring(text.length() - 1);
            int roleCount = Integer.parseInt(lastChar);

            if (roleCount > 0) { //Bu for'a sadece rol sayisi 0'dan büyükse girecek
                ReusableMethods.waitForElementToBeClickable(driver,allDepartmentNames,10);
                driver.findElements(allDepartmentNames).get(i).click(); // stale element excp. almamak icin locate'i her seferinde aldim
                ReusableMethods.waitForSeconds(2);
                List<WebElement> allRoles = driver.findElements(pages.getDepartmentDetailPage().getRolesList());
                for (WebElement role : allRoles) {
                    if (!role.isDisplayed()) {
                        return false;
                    }
                }
                driver.navigate().back();
                driver.navigate().refresh();
            }
        }
        return true;
    }

    public boolean areAuthorizedRolesMatched() { //Departman karti üzerindeki rol sayisi ile icindeki rol sayisi eslesiyor mu diye kontrol eder
        List<WebElement> allTitles =driver.findElements(allDepartmentsTitleList);
        List<WebElement> cardNames = driver.findElements(allDepartmentNames);

        for (int i = 0; i < allTitles.size(); i++) {
            String text = allTitles.get(i).getText();
            String lastChar = text.substring(text.length() - 1);
            int roleCount = Integer.parseInt(lastChar);

            if (roleCount > 0) {
                ReusableMethods.waitForElementToBeClickable(driver,By.xpath("//p//div[@class='row']//a"),10);
                cardNames.get(i).click(); //Ilk if'te roleCount 0'dan büyük degil dolayisiyla i=0 iken if'e girmeyecek ve böylece dogru cardname'e tiklayacak
                ReusableMethods.waitForSeconds(1);

                List<WebElement> actualRoles = driver.findElements(pages.getDepartmentDetailPage().getRolesList()); //Kartin icindeki rolleri bir liste atiyorum
                int actualRoleCount = actualRoles.size();
                System.out.println("Expected role count: " + roleCount + " Actual role count: " + actualRoleCount);
                if (roleCount != actualRoleCount) {
                    return false; // eşitlik yoksa test fail
                }
                driver.navigate().back();
                driver.navigate().refresh();
                // refresh sonrasi stale element exception alinca listleri burada yeniden aldim
                allTitles = driver.findElements(allDepartmentsTitleList);
                cardNames = driver.findElements(allDepartmentNames);
            }
        }
        return true;
    }

    public boolean isDepartmentsTextDisplayed() {
        return ReusableMethods.isDisplayed(departmentsText);
    }

    public boolean twoDepartmentWithSameName() { //ayni isimle iki departman olusuyor mu diye kontrol eder

        List<WebElement> namesList = driver.findElements(allDepartmentNames);
        for (int i = 0; i < namesList.size(); i++) {
            for (int j = namesList.size() - 1; j > i; j--) {
                if (namesList.get(i).getText().equals(namesList.get(j).getText())) {
                    return true;
                }
            }
        }
        return false;
    }

    public NewDepartmentPage clickAddNewDepartment() {
        ReusableMethods.clickElement(addNewDepartmentButton);
        return new NewDepartmentPage();
    }

    public DepartmentDetailPage clickDepartmentWithIndex(int index) { //Istenen departmana indexle tiklar
        ReusableMethods.visibilityOfElementsByWebDriverWait(allDepartmentNames);
        List<WebElement> namesList = driver.findElements(allDepartmentNames);
        namesList.get(index).click();
        return new DepartmentDetailPage();
    }

    public DepartmentDetailPage clickNewCreatedDepartment() {
        ReusableMethods.visibilityOfElementsByWebDriverWait(pages.getDepartmentsPage().getAllDepartmentNames());
        List<WebElement> names = driver.findElements(pages.getDepartmentsPage().getAllDepartmentNames());
        for (WebElement nameElement : names) {
            if (nameElement.getText().equals(staticName)) {
                nameElement.click();
                break;
            }
        }
        return new DepartmentDetailPage();
    }

    public boolean isNewCreatedDepartmentDisplayed() { //Department görünüyorsa true döner
        boolean flag = false;
        pages.getDashboardPage().clickOnMenuItem("Departments");
        ReusableMethods.visibilityOfElementsByWebDriverWait(By.xpath("//*[@id=\"link5\"]/a"));
        List<WebElement> names = driver.findElements(allDepartmentNames);
        for (WebElement nameElement : names) {
            System.out.println("staticName = " + staticName);
            if (nameElement.getText().equals(NewDepartmentPage.staticName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean verifyNewCreatedDepartmentNotDisplayed() { //Department görünmüyorsa True döner
        boolean flag = true;
        ReusableMethods.visibilityOfElementsByWebDriverWait(By.xpath("//*[@id=\"link5\"]/a"));
        List<WebElement> names = driver.findElements(By.xpath("//p//div[@class='row']//a"));
        for (WebElement nameElement : names) {
            if (nameElement.getText().equals(NewDepartmentPage.staticName)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void deleteDepartmentWithIndex(int index, int lastIndex) { //Departman isimsiz de olsa verilen indextekini siler
        for (int i = index; i < lastIndex; i++) {
            JavascriptUtils.clickElementByJS(driver.findElements(allDepartmentNames).get(i));
            ReusableMethods.waitForSeconds(3);
            ReusableMethods.clickElement(pages.getDepartmentDetailPage().getEditDepartmentButton());
            ReusableMethods.waitForSeconds(3);
            int num = 0;
            while (num < 5) {
                driver.navigate().refresh();
                ReusableMethods.waitForSeconds(3);
                if (!driver.findElements(By.xpath("//button[text()='Delete Department']")).isEmpty()) {
                    break;
                }
                num++;
            }
            pages.getEditDepartmentPage().clickDeleteButton();
            pages.getEditDepartmentPage().clickConfirmButton();
            ReusableMethods.visibilityOfElementByWebDriverWait(pages.getDepartmentsPage().getDepartmentsText());
        }
    }

}
