import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Url extends main {
    //Refactoring WebElement ByName
    By userNameLocalizator = By.name("userName");
    By labelUserNameLocalizator = By.xpath("//font[contains(text(),'User')]");

    public void getUrlPage() throws InterruptedException {
        String myUrl = main.getURL();
        System.out.printf("Url obtenida: " + myUrl);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void localizadorLogin() {
        //region Way Different
        /* //Input User
        WebElement inputUserName = driver.findElement(By.name("userName"));
        WebElement inputUserXpath = driver.findElement(By.xpath("//input[@name='userName']"));
        WebElement inputUserCss = driver.findElement(By.cssSelector("input[name='userName']"));

        //Input Password
        WebElement inputPassName = driver.findElement(By.name("password"));
        WebElement inputPassXpath = driver.findElement(By.name("//input[@name='password']"));
        WebElement inputPassCss = driver.findElement(By.name("input[name='password']"));

        //Button Submit
        WebElement buttonSubmitName = driver.findElement(By.name("submit"));
        WebElement buttonSubmitXpath = driver.findElement(By.name("//input[@name='submit']"));
        WebElement buttonSubmitCss = driver.findElement(By.cssSelector("input[value='Submit']"));
        */
        //endregion
    }

    public void explicitWait() {
        //region Wait explicit 40 sec
        WebDriverWait waitV = new WebDriverWait(driver, 40);
        //Sintaxis use
        waitV.until(ExpectedConditions.elementToBeClickable(userNameLocalizator));
        //endregion
    }

    public void fluentWait() {
        //region Fluent Wait
        long noOfSeconds = 30;
        long noSeconds = 3;
        FluentWait fluentWaits = new FluentWait(driver);
        //Cannot be converted Duration to Long, expression previously(Duration.ofSeconds(30))
        fluentWaits.withTimeout(noOfSeconds, TimeUnit.SECONDS);
        fluentWaits.pollingEvery(noSeconds, TimeUnit.SECONDS);
        fluentWaits.until(ExpectedConditions.elementToBeClickable(userNameLocalizator));
        //endregion
    }

    public void assertExample() {
        //region Asserts

        //Resultado esperado
        String resEsperado = " User Name:";
        //Resultado actual
        String resActual = driver.findElement(labelUserNameLocalizator).getText();
        System.out.println(resActual);

        //Comparación
        Assert.assertEquals(resActual, resEsperado);
        System.out.println(resActual + resEsperado);
        //endregion
    }

    public void softAssertExample() {
        //region Soft

        //Resultado esperado
        String resEsperado = " User Name:";
        //Resultado actual
        String resActual = driver.findElement(labelUserNameLocalizator).getText();
        System.out.println(resActual);

        //Comparación
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resActual, resEsperado);
        softAssert.assertAll();
        System.out.println(resActual + resEsperado);

        //endregion
    }

}
