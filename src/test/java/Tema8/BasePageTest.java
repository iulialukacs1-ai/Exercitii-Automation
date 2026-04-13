package Tema8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasePageTest {
        WebDriver driver;
        WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }

    @Test
    public void testOpenUrl() {
        BasePage basePage = new BasePage(driver);
        basePage.openUrl("https://the-internet.herokuapp.com/");
        Assert.assertTrue(driver.getTitle().contains("The Internet"),
                "Pagina nu s-a deschis corect!");
        System.out.println("Titlu: " + driver.getTitle());
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage("tomsmith", "SuperSecretPassword!");

        // Verifica ca login-ul a reusit
        wait.until(ExpectedConditions.urlContains("secure"));
        System.out.println("URL dupa login: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"),
                "Login-ul nu a reusit!");
        System.out.println("Login reusit!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



