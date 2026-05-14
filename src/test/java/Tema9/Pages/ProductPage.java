package Tema9.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends BasePage {

    // ProductPage.java
    private By productNameLocator = By.cssSelector("[data-test='product-name']");
    private By productPriceLocator = By.cssSelector("[data-test='unit-price']");
    private By addToCartButton = By.cssSelector("[data-test='add-to-cart']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocator));
        return getText(name);
    }

    public double getProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(productPriceLocator));
        String priceText = getText(price).replace("$", "").trim();
        return Double.parseDouble(priceText);
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        click(button);
    }
}