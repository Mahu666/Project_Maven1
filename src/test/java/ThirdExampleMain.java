import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ThirdExampleMain {

    ThirdExample thirdTest = new ThirdExample();

    @BeforeSuite
    public void beforeTest() {
        main.setUp();
    }

    @Test
    public void Test1() throws InterruptedException {
        //ThirdExample.actionsOnWebElement();
        thirdTest.actions();
        Thread.sleep(300);
    }

    @AfterSuite
    public void afterSuite() {
        thirdTest.clearInput();
        main.closeDriver();
    }

}
