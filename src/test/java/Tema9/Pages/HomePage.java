package Tema9.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    // HomePage.java
    private By productNames = By.cssSelector("[data-test='product-name']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openApplication() {
        driver.get("https://practicesoftwaretesting.com");
    }

    public void clickOnProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));

        List<WebElement> products = driver.findElements(productNames);
        for (WebElement product : products) {
            if (product.getText().equalsIgnoreCase(productName)) {
                click(product);
                break;
            }
        }
    }
}