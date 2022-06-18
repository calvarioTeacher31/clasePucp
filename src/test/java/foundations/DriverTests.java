package foundations;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTests extends BaseTest {
    @Test(enabled = false)
    public void getTest() {
        log.info("Yendo al a pagina principal");
        //commonFlows.goToIndex();
    }

    @Test
    public void getUrlTest() {
        log.info("Sacando el url actual");
        var urlActual = driver.getCurrentUrl();

        log.info("Comparando el url actual con el de getCurrentUrl");
        Assert.assertEquals(urlActual, commonFlows.getMainUrl());
    }
}
