import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilities.ExtentReport;

public class FlightFinderMain {

    FlightFinder flightFinder = new FlightFinder();

    @BeforeSuite
    public void beforeTest() {
        ExtentReport.getReporter();
        main.setUp();
    }

    @Test
    public void Test1() throws InterruptedException {
        //Print on window the html
        ExtentReport.startTest("Test de reservar un vuelo", "Se ejecuta test para" +
                "validar que se pueda reservar un vuelo de ida y de regreso");
        ThirdExample.actionsOnWebElement();
        ThirdExample.closeAdd();

        try {
            flightFinder.selectsForm();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread.sleep(2000);
        flightFinder.btnContinueClick();
        Thread.sleep(2000);
    }

    @AfterSuite
    public void afterSuite() {
        main.closeDriver();
        ExtentReport.flush();
    }

}
