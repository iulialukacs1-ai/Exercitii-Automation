package Tema8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginServiceTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        User user = new User("tomsmith", "SuperSecretPassword!");

        // Verifica ca username si password nu sunt null
        Assert.assertNotNull(user.getUsername(), "Username-ul este null!");
        Assert.assertNotNull(user.getPassword(), "Password-ul este null!");

        // Verifica valorile
        Assert.assertEquals(user.getUsername(), "tomsmith", "Username-ul nu este corect!");
        Assert.assertEquals(user.getPassword(), "SuperSecretPassword!", "Password-ul nu este corect!");

        // Apeleaza LoginService
        LoginService loginService = new LoginService();
        loginService.login(user);

        System.out.println("Test trecut cu succes!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
