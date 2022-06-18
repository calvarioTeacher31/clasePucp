package foundation;

import com.github.javafaker.Faker;
import utilities.Logs;

public class Main {
    public static void main(String[] args) {
        var log = new Logs();
        log.info("Hola mundo");
        log.debug("Soy un debug");
        log.error("Soy un error");

        var faker = new Faker();

        var nombre = faker.name().name();
        var email = faker.internet().emailAddress();
        var edad = faker.number().numberBetween(15, 20);
        var peso = faker.number().randomDouble(2, 30, 60);
        var esHombre = faker.bool().bool();
        var lugar = faker.lordOfTheRings().location();

        log.info(nombre);
        log.info(email);
        log.info(String.valueOf(edad));
        log.info(String.valueOf(peso));
        log.info(String.valueOf(esHombre));
        log.info(lugar);

        //debug -> info -> warning -> error -> fatal
    }
}
