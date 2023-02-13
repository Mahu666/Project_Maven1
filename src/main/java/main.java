import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Scanner;

public class main {

    //region Variables
    static WebDriver driver;
    static String navegador = "Chrome";
    //endregion

    //region ChromeDriver.exe
    //Way to create an object driver by ChromeDriver.exe
    /*
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //why not th 's' on http and www.
        driver.get("http://google.com");
    }
*/
    //endregion

    public static void setUp(){

        //region Maven Chrome
        //Way to create an object driver by Git by repository of Git Maven Chrome
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://google.com");*/
        //String browserName = navegador;

        //Scanner navScan = new Scanner(System.in);
        // String navegado = navScan.nextLine();
        //System.out.println("Introduzca qué navegador abrir: " + navegado);
        //endregion

        //region Switch Navegador
        switch (navegador){

            //region Case Chrome
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://demo.guru99.com/test/newtours/index.php");
                driver.manage().window().maximize();
                //driver.manage().window().minimize();
                driver.manage().window().getPosition();
                //driver.manage().window().fullscreen();
                break;
            //endregion

            //region Case Edge
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get("http://google.com");
                break;
            //endregion

            default:
                System.out.println("Opción escrita incorrecta o vacía.");
        }
        //endregion

    }

    public static void setUpEdge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://google.com");
    }

    //Obtain a CurrentURL
    public static String getURL(){
        String newURL = driver.getCurrentUrl();
        return newURL;
    }

    //Close Driver
    public static void closeDriver(){
        driver.quit();
    }

}
