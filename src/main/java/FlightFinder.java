import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.EnumMonthList;
import utilities.ScreenShot;

public class FlightFinder extends main{

    //region Locators for register a Flight
    static By rdbtnRoundTripLocator = By.xpath("//input[@value='roundtrip']");
    static By rdbtnOneWayLocator = By.xpath("//input[@value='oneway']");
    static By listPassengersLocator = By.xpath("//select[@name='passCount']");
    static By listDepartingLocator = By.xpath("//select[@name='fromPort']");
    static By listMonthLocator = By.xpath("//select[@name='fromMonth']");
    static By listDayLocator = By.xpath("//select[@name='fromDay']");
    static By listArrivingLocator = By.xpath("//select[@name='toPort']");
    static By listToMonthLocator = By.xpath("//select[@name='toMonth']");
    static By listToDayLocator = By.xpath("//select[@name='toDay']");
    static By rdbtnEconomyLocator = By.xpath("//input[@value='Coach']");
    static By rdbtnBusinessLocator = By.xpath("//input[@value='Business']");
    static By rdbtnFirstLocator = By.xpath("//input[@value='First']");
    static By listAirlineLocator = By.xpath("//select[@name='airline']");
    static By btnContinue = By.xpath("//input[@name='findFlights']");


    //endregion

    EnumMonthList enumMonthList;
    public void selectFlightType(){
        WebDriverWait waitFlightType = new WebDriverWait(driver, 45);
        waitFlightType.until(ExpectedConditions.elementToBeClickable(rdbtnRoundTripLocator));
        driver.findElement(rdbtnRoundTripLocator).click();
    }

    //los 3 métodos se pueden hacer en 1.
    public void selectPassengerList(){
        Select selectPassenger = new Select(driver.findElement(listPassengersLocator));
        selectPassenger.selectByVisibleText("4");
    }

    public void selectDepartingList(){
        Select selectDeparting = new Select(driver.findElement(listDepartingLocator));
        selectDeparting.selectByIndex(5);
    }

    public void selectMonthList(){
        Select selectMonth = new Select(driver.findElement(listMonthLocator));
        selectMonth.selectByVisibleText(String.valueOf(enumMonthList.December));
        //selectMonth.selectByValue(String.valueOf(enumMonthList.September));
    }

    public void btnContinueClick() throws InterruptedException{
        //Scroll on screen
        driver.findElement(btnContinue).sendKeys(Keys.DOWN);
        ScreenShot.takeScreenShot("Screenshot_", driver);
        Thread.sleep(4000);
        driver.findElement(btnContinue).click();
    }
}
