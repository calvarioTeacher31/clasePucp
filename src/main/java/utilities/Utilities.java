package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    private final Logs log = new Logs();

    public void esperarPorSegundosExplicito(WebDriver driver, By locator, int timeout) {
        log.info("Esperando por " + timeout + " segundos");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
