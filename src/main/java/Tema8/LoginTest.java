package Tema8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends TestCase {
    public LoginTest() {
        super("Login Test");
    }

    @Override
    public void runTest() {
        System.out.println("Running test: " + name);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        System.out.println("URL dupa login: " + driver.getCurrentUrl());

        if (driver.getCurrentUrl().contains("secure")) {
            System.out.println(name + " -> PASSED");
        } else {
            System.out.println(name + " -> FAILED");
        }

        driver.quit();
    }
}
