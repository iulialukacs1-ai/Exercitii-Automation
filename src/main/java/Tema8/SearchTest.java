package Tema8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest extends TestCase {
    public SearchTest() {
        super("Search Test");
    }
    @Override
    public void runTest() {
        System.out.println("Running test: " + name);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='search-query']")));
        searchInput.sendKeys("Pliers");

        driver.findElement(By.cssSelector("[data-test='search-submit']")).click();

        WebElement rezultat = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='product-name']")));

        if (rezultat.getText().toLowerCase().contains("pliers")) {
            System.out.println(name + " -> PASSED");
        } else {
            System.out.println(name + " -> FAILED");
        }

        driver.quit();
    }
}
