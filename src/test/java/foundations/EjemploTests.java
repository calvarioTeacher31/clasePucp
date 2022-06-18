package foundations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Logs;

public class EjemploTests {
    private final Logs log = new Logs();

    @BeforeMethod
    public void setup() {
        log.info("Hola soy before method");
    }

    @Test
    public void ejemplo1Test() {
        log.info("Hola soy test 111111111111");
    }

    @Test
    public void ejemplo2Test() {
        log.info("Hola soy test 22222222");
    }

    @Test
    public void ejemplo3Test() {
        log.info("Hola soy test 33333333");
    }

    @AfterMethod
    public void teardown() {
        log.info("Hola soy teardown");
        log.info("");
        log.info("");
    }
}
