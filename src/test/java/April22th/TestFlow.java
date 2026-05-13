package April22th;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFlow {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        InventoryPage inventory = new InventoryPage(driver);

        String productName = "Sauce Labs Backpack";

        String priceFromInventory = inventory.getProductPrice(productName);

        inventory.clickOnProduct(productName);

        ProductPage productPage = new ProductPage(driver);

        assert productPage.getProductName().equals(productName);

        String priceFromProduct = productPage.getProductPrice();
        assert priceFromProduct.equals(priceFromInventory);

        productPage.addToCart();
        productPage.goToCart();

        CartPage cart = new CartPage(driver);

        assert cart.isProductInCart(productName);

        System.out.println("Test trecut cu succes!");

        driver.quit();
    }
}
