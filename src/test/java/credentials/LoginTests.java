package credentials;

import base.BaseTest;
import org.testng.annotations.Test;
import pageobject.HomeShoppingPage;
import pageobject.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private HomeShoppingPage homeShoppingPage;

    @Test
    public void loginTest() {
        commonFlows.loginValidUser();

        homeShoppingPage = new HomeShoppingPage(driver);
        homeShoppingPage.waitPageToLoad();
    }

    @Test
    public void invalidUserTest() {
        var username = "locked_out_user";
        var password = "secret_sauce";
        var errorMessageText = "Epic sadface: Sorry, this user has been locked out.";

        loginPage = new LoginPage(driver);

        loginPage.fillLoginForm(username, password);
        loginPage.verifyErrorMessage(errorMessageText);
    }
}
