import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdExample extends main {

    //region Locators
    static By inputUserNameLocator = By.name("userName");
    static By passUserLocator = By.xpath("//input[@name='password']");
    static By btnSubmitLocator = By.xpath("//input[@name='submit']");
    static By btnFlightsLocator = By.linkText("Flights");

    //endregion

    //region WebElements
    static WebElement inputUserName = driver.findElement(inputUserNameLocator);
    static WebElement passUserPath = driver.findElement(passUserLocator);
    static WebElement btnSubmit = driver.findElement(btnSubmitLocator);
    static WebElement btnFlights = driver.findElement(btnFlightsLocator);


    //endregion

    public static void actionsOnWebElement() throws InterruptedException {

        //region Introduce Text on InputText
        //Click on Input Text
        inputUserName.click();
        Thread.sleep(2000);

        //Send Text to the Input Text
        inputUserName.sendKeys("admin");
        Thread.sleep(2000);
        //endregion

        //region Introduce Text on PassUser
        //Click on PassUser
        passUserPath.click();
        Thread.sleep(3000);

        //Send Text on PassUser
        passUserPath.sendKeys("12345");
        Thread.sleep(3000);
        //endregion

        btnSubmit.click();
        Thread.sleep(3000);

        driver.findElement((By) btnFlightsLocator).click();
        Thread.sleep(2000);

    }

    public static void closeAdd() throws InterruptedException {

        //region Comments about Close() and Quit()
        //Quit() closes the windows and the driver
        //Close() just closes the window
        //endregion

        Thread.sleep(1000);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[8]"))).navigate().back();
        driver.switchTo().defaultContent();
        driver.findElement((By) btnFlightsLocator).click();
        Thread.sleep(2000);

        //region Code that doesn't worked
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,20)");

        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/iframe[8]")));

        //driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[8]")));
        //driver.findElement(By.id("dismiss-button")).click();
        //String variabl;
        //variabl = driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div/div[2]/iframe"))).getCurrentUrl();
        //System.out.println("gggggggggggggggg+TITUKIttttttttttttt´´´´" + variabl);
        //Thread.sleep(5000);

        //String variable2;
        //variable2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/div[2]/div/div/div[3]")).getTagName();
        //System.out.println("*xxxxxxxxxxxxxx+TISSSDDSSSSDIx------------ññññ´" + variable2);
        //Thread.sleep(8000);


        //By btnCloseAddLocator = By.className("ns-7ous4-e-16");
        //WebElement btnClose = driver.findElement(btnCloseAddLocator);
        //btnClose.click();
        //driver.findElement((By) btnCloseAddLocator).click();

        //endregion

    }

    public static void clearInput() {

        //region Clear Texts
        inputUserName.clear();
        passUserPath.clear();
        //endregion

    }

    public static void actions() {

        //region Gets
        String attribute = btnSubmit.getAttribute("name");
        System.out.println("getAttribute: " + attribute);

        String cssValue = btnSubmit.getCssValue("background-color");
        System.out.println("getCssValue: " + cssValue);

        Point location = btnSubmit.getLocation();
        System.out.println("getLocation: " + location);

        Dimension size = btnSubmit.getSize();
        System.out.println("getSize: " + size);

        String tagName = btnSubmit.getTagName();
        System.out.println("getTagName: " + tagName);
        //endregion

    }

}
