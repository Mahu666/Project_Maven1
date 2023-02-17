import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReadExcelFiles;

import java.io.IOException;

public class ExcelRead extends main {

    //region Locators
    By inputUserNameLocator = By.name("userName");
    By inputPasswordLocator = By.name("password");
    By btnSubmitLocator = By.name("submit");
    //endregion

    //region Variables
    //Route what we find the file excel
    String filePath = "Example.xlsx";
    //endregion

    //region Web Elements
    WebElement inputUserName = driver.findElement(inputUserNameLocator);
    WebElement inputPassword = driver.findElement(inputPasswordLocator);
    WebElement btnSubmit = driver.findElement(btnSubmitLocator);
    //endregion

    public void loginFromExcel() throws IOException, InterruptedException{

        //region Specific Cell and Row
        //Indicates the route of file, name of page, number of row and number of cell from takes the dates.
        String searchUserName = ReadExcelFiles.getCellValue(filePath, "Hoja1", 2,0);
        String searchPassword = ReadExcelFiles.getCellValue(filePath, "Hoja1", 2,1);

        System.out.println("Read dates from file: " + filePath);
        System.out.println("User Name: " + searchUserName);
        System.out.println("Password: " + searchPassword);
        //endregion

        //region Login with dates from excel
        inputUserName.sendKeys(searchUserName);
        inputPassword.sendKeys(searchPassword);
        Thread.sleep(3000);
        btnSubmit.click();
        //endregion
    }

    public void readAllExcel() throws IOException{
        //Route of file Excel
        System.out.println("\n Leer todas las celdas del archivo: " + filePath);

        //Invoke class for read all the dates of Excel
        //Indicate the route of the file and the name of page
        ReadExcelFiles.readExcel(filePath, "Hoja1");
    }

}
