package foundations;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

public class VerificacionesTests {
    private final Logs log = new Logs();
    private final Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        log.info("Hola soy la precondicion");
    }

    @Test
    public void assertEqualsTest() {
        log.info("Declaro 2 numeros decimales");

        var a = faker.number().randomDouble(2, 10, 15);
        var b = faker.number().randomDouble(2, 8, 12);
        log.debug(String.valueOf(a));
        log.debug(String.valueOf(b));

        log.info("Comparo los 2 numeros a igualar");
        Assert.assertEquals(a, b);

        log.info("Terminando de verificar");
    }

    @Test
    public void assertTrueTest() {
        log.info("Declaro 1 boolean");

        var a = faker.bool().bool();
        log.debug(String.valueOf(a));

        log.info("Comparo que el valor de a sea true");
        Assert.assertTrue(a);

        log.info("Terminando de verificar");
    }

    @Test
    public void variosAssertTest() {
        log.info("Declaro 2 numeros enteros");

        var a = faker.number().numberBetween(4, 5);
        var b = faker.number().numberBetween(4, 512);
        log.debug(String.valueOf(a));
        log.debug(String.valueOf(b));

        log.info("Comparo los 2 numeros a igualar");
        Assert.assertEquals(a, b, "a y b no son iguales");

        log.info("Declaro 1 boolean");

        var esEstudioso = faker.bool().bool();
        log.debug(String.valueOf(esEstudioso));

        log.info("Comparo que el valor de a sea true");
        Assert.assertTrue(esEstudioso, "esEstudioso es false");

        log.info("Terminando de verificar");
    }

    @Test
    public void softAssertTest() {
        log.info("Declaro 2 numeros enteros");
        var a = faker.number().numberBetween(4, 5);
        var b = faker.number().numberBetween(4, 512);
        log.debug(String.valueOf(a));
        log.debug(String.valueOf(b));

        log.info("Declaro 1 boolean");
        var esEstudioso = faker.bool().bool();
        log.debug(String.valueOf(esEstudioso));

        var softAssert = new SoftAssert();

        log.info("Comparo los 2 numeros a igualar");
        softAssert.assertEquals(a, b, "a y b no son iguales");

        log.info("Comparo que el valor de a sea true");
        softAssert.assertTrue(esEstudioso, "esEstudioso es false");

        softAssert.assertAll();

        log.info("Terminando de verificar");
    }

    @AfterMethod
    public void tearDown() {
        log.info("Hola soy la postcondicion");
    }
}
