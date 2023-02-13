import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelReadMain {

    ExcelRead excelRead = new ExcelRead();

    @BeforeSuite
    public void beforeTest(){
        main.setUp();
    }

    @Test
    public void TestReadExcel() throws InterruptedException, IOException {
        excelRead.loginFromExcel();
        Thread.sleep(3000);
        excelRead.readAllExcel();
    }

    @AfterSuite
    public void afterSuite(){
        main.closeDriver();
    }


}
