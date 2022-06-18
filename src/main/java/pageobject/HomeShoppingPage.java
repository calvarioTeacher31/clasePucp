package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Logs;
import utilities.Utilities;

public class HomeShoppingPage {
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By buttonsAddToCart = By.className("btn_inventory");
    private final By shoppingCartLabel = By.className("shopping_cart_badge");
    private final By itemsName = By.className("inventory_item_name");
    private final By select = By.className("product_sort_container");
    private final WebDriver driver;
    private final Logs log = new Logs();
    private final Utilities utilities = new Utilities();

    public HomeShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageToLoad() {
        utilities.esperarPorSegundosExplicito(driver, productsTitle, 5);
    }

    public int clickOnAllAddToCartButtons() {
        var buttonList = driver.findElements(buttonsAddToCart);
        for (var button : buttonList) {
            log.info("Haciendo click al button de add to cart");
            button.click();
        }

        return buttonList.size();
    }

    public void verifyItemCounter(int n) {
        var shoppingCartLabelWebElement = driver.findElement(shoppingCartLabel);

        log.info("Verificando que el numero de elementos sea igual al de la lista");
        var numElementos = Integer.parseInt(shoppingCartLabelWebElement.getText());
        Assert.assertEquals(numElementos, n);
    }

    public void selectByValue(String value) {
        var select = new Select(driver.findElement(this.select));

        log.info("Seleccionando alfabético descendente");
        select.selectByValue(value);
    }

    public void verifyFirstItemName(String text) {
        var itemsNameList = driver.findElements(itemsName);

        var firstItemName = itemsNameList.get(0).getText();

        log.info("Comparando el texto del primer item de la lista con el esperado");
        Assert.assertEquals(firstItemName, text);
    }
}
