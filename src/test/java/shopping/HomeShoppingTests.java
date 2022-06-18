package shopping;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomeShoppingPage;

public class HomeShoppingTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod
    public void setup() {
        commonFlows.loginValidUser();
    }

    @Test
    public void addToCartCounterTest() {
        homeShoppingPage = new HomeShoppingPage(driver);
        var itemSize = homeShoppingPage.clickOnAllAddToCartButtons();
        homeShoppingPage.verifyItemCounter(itemSize);
    }

    @Test
    public void selectItemTest() {
        var firstItemNameExpected = "Test.allTheThings() T-Shirt (Red)";

        homeShoppingPage = new HomeShoppingPage(driver);
        homeShoppingPage.selectByValue("za");
        homeShoppingPage.verifyFirstItemName(firstItemNameExpected);
    }
}
