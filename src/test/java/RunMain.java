import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Scanner;

public class RunMain {
    Url url = new Url();

    @BeforeSuite
    public void beforeTest(){
        main.setUp();
    }

    //Use of TestNG
    @Test
    public void Test() throws InterruptedException {
        url.getUrlPage();
        url.explicitWait();
        url.fluentWait();
        url.softAssertExample();
        //url.assertExample();
    }

    @AfterSuite
    public void afterSuite(){
        main.closeDriver();
    }

}

/*
* class="mouseOut"
* class="userName"
* class="password"
* name="submit"
* XPath
* /html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input
* $x("path_elemento")
* $$("css_selectors_element")
* */