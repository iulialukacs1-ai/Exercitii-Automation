import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Tema2 {
//Tema 2
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    // 1) Deschide un site și îl închide
    @Test
    public void openSite() {
        driver.get("https://github.com/");
    }

    // 2) Verifică titlul paginii
    @Test
    public void verifyTitle() {
        driver.get("https://github.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("GitHub"));
    }

    // 3) Două teste: github.com și apple.com
    @Test
    public void openGithub() {
        driver.get("https://github.com/");
    }

    @Test
    public void openApple() {
        driver.get("https://www.apple.com/");
    }

    // 4) Test care verifică:
    // - titlul nu este null
    // - titlul conține "GitHub"
    @Test
    public void githubTitleChecks() {
        driver.get("https://github.com/");
        String title = driver.getTitle();

        Assert.assertNotNull(title);
        Assert.assertTrue(title.contains("GitHub"));
    }
}


