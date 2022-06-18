package utilities;

import org.openqa.selenium.WebDriver;
import pageobject.HomeShoppingPage;
import pageobject.LoginPage;

public class CommonFlows {
    private final WebDriver driver;
    private final String mainUrl = "https://www.saucedemo.com/";

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var loginPage = new LoginPage(driver);

        driver.get(mainUrl);
        loginPage.waitPageToLoad();
    }

    public void loginValidUser() {
        goToIndex();

        var loginPage = new LoginPage(driver);
        var homeShoppingPage = new HomeShoppingPage(driver);

        var username = "standard_user";
        var password = "secret_sauce";

        loginPage.fillLoginForm(username, password);
        homeShoppingPage.waitPageToLoad();
    }

    public String getMainUrl() {
        return mainUrl;
    }
}
