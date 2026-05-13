package April22th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    private By products = By.className("inventory_item");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By cartButton = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnProduct(String name) {
        List<WebElement> items = driver.findElements(products);

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);

            String text = item.findElement(productName).getText();

            if (text.equalsIgnoreCase(name)) {
                item.findElement(productName).click();
                return;
            }
        }
    }

    public String getProductPrice(String name) {
        List<WebElement> items = driver.findElements(products);

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);

            String itemName = item.findElement(productName).getText();

            if (itemName.equalsIgnoreCase(name)) {
                return item.findElement(productPrice).getText();
            }
        }

        return null;
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}
