package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {

    //region Variables
    static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static File pathReport = new File("src/reportes/index.html");
    static ExtentTest test = null;
    //endregion

    //Generate file with index.html
    public synchronized static ExtentReports getReporter(){
        if (extent == null){
            ExtentSparkReporter html = new ExtentSparkReporter(pathReport);
            html.config().setDocumentTitle("Test1");
            html.config().setReportName("ProtectAutonomization");
            html.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(html);
        }
        return extent;
    }

    //Starts the test, adding parameters for add the name and a description
    public static synchronized ExtentTest startTest(String testName, String desc){

        try {
            test = getReporter().createTest(testName, desc);
            extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return test;
    }

    public static void flush(){
        extent.flush();
    }

}
