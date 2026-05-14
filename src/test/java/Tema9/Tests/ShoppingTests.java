package Tema9.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Tema9.Pages.CartPage;
import Tema9.Pages.HomePage;
import Tema9.Pages.ProductPage;

public class ShoppingTests {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    // Test 1 - Adaugare produs in cos
    @Test
    public void addProductToCartTest() {
        homePage.openApplication();
        homePage.clickOnProduct("Claw Hammer with Shock Reduction Grip");

        String productName = productPage.getProductName();
        System.out.println("Nume produs: '" + productName + "'"); // adauga asta

        productPage.addToCart();

        cartPage.openCart();

        Assert.assertTrue(cartPage.isProductInCart(productName),
                "Produsul " + productName + " nu se afla in cos!");
    }

    // Test 2 - Verificare detalii produs
    @Test
    public void verifyProductDetailsTest() {
        homePage.openApplication();
        homePage.clickOnProduct("Claw Hammer with Shock Reduction Grip");

        String productName = productPage.getProductName();
        double productPrice = productPage.getProductPrice();

        Assert.assertFalse(productName.isEmpty(),
                "Numele produsului este gol!");
        Assert.assertTrue(productPrice > 0,
                "Pretul produsului nu este mai mare decat 0!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}