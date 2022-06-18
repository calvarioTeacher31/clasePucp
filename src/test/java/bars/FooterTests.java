package bars;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest {
    @BeforeMethod
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test
    public void twitterTest() {
        var twitterLink = "https://twitter.com/saucelabs";
        /*
        //a[text()='Twitter']
        //a[@target='_blank']
        //a[@rel='noreferrer']
         */

        var twitterButtonLocator = By.xpath("//a[text()='Twitter']");
        var twitterButton = driver.findElement(twitterButtonLocator);

        log.info("Verificando que el boton de twitter sea clickeable");
        Assert.assertTrue(twitterButton.isEnabled());

        log.info("Verificando que el link de twitter sea correcto");
        Assert.assertEquals(twitterButton.getAttribute("href"), twitterLink);
    }
}
