package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.CommonFlows;
import utilities.Logs;

public class BaseTest {
    protected final Logs log = new Logs();
    protected WebDriver driver;
    protected CommonFlows commonFlows;

    @BeforeMethod
    public void setUpBase() {
        log.debug("Inicializando el driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        log.debug("Maximizo la pantalla");
        driver.manage().window().maximize();

        log.debug("Borrando las cookies");
        driver.manage().deleteAllCookies();

        commonFlows = new CommonFlows(driver);
        commonFlows.goToIndex();
    }

    @AfterMethod
    public void tearDownBase() {
        log.debug("Matando al driver");
        driver.quit();
    }
}
