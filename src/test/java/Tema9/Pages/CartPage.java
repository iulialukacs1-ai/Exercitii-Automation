package Tema9.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    // CartPage.java
    private By cartNavButton = By.cssSelector("[data-test='nav-cart']");
    private By cartProductNames = By.cssSelector("[data-test='product-title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(cartNavButton));
        click(cartBtn);
    }

    public boolean isProductInCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartProductNames));

        List<WebElement> products = driver.findElements(cartProductNames);
        for (WebElement product : products) {
            if (product.getText().trim().equalsIgnoreCase(productName.trim())) { // adauga .trim()
                return true;
            }
        }
        return false;
    }
        }
