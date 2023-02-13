package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {

    static ExtentReports extent;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    //Generate file with index.html
    public synchronized static ExtentReports getReporter(){
        File pathReport = new File("src/reportes/index.html");
        if (extent == null){
            ExtentSparkReporter html = new ExtentSparkReporter(pathReport);
            html.config().setDocumentTitle("Test1");
            html.config().setReportName("ProyectoAutomatizacion");
            html.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(html);
        }
        return extent;
    }

    //Starts the test, adding parameters for add the name and a description
    public static synchronized ExtentTest startTest(String testName, String desc){
        ExtentTest test = getReporter().createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

    public static void flush(){
        extent.flush();
    }

}
