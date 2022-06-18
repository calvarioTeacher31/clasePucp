package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.Logs;
import utilities.Utilities;

public class LoginPage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By robotImage = By.className("bot_column");
    private final By errorMessage = By.tagName("h3");
    private final WebDriver driver;
    private final Logs log = new Logs();
    private final Utilities utilities = new Utilities();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageToLoad() {
        utilities.esperarPorSegundosExplicito(driver, robotImage, 5);
    }

    public void fillLoginForm(String username, String password) {
        log.info("Rellenar el username");
        driver.findElement(usernameInput).sendKeys(username);

        log.info("Rellenar el password");
        driver.findElement(passwordInput).sendKeys(password);

        log.info("Hacer click en login");
        driver.findElement(loginButton).click();
    }

    public void verifyErrorMessage(String text) {
        var errorMessageWebElement = driver.findElement(errorMessage);
        log.info("Verificando que el error message esté visible");
        Assert.assertTrue(errorMessageWebElement.isDisplayed());

        log.info("Verificando que el texto del error message esté correcto");
        Assert.assertEquals(errorMessageWebElement.getText(), text);
    }
}
