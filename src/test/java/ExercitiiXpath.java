import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class ExercitiiXpath {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- UTIL METHODS ----------
    public void clickStable(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // ---------- TEST 1 ----------
    @Test
    public void primulExercitiu() {

        driver.get("https://demoqa.com/elements/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Elements']")));

        // RADIO BUTTON
        WebElement radioButtons = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        clickStable(radioButtons);

        WebElement yesRadio = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='yesRadio']")));
        yesRadio.click();

        // WEB TABLES
        WebElement webTables = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        clickStable(webTables);

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
        search.sendKeys("Cierra");

        // BUTTONS
        WebElement buttons = driver.findElement(By.xpath("//span[text()='Buttons']"));
        clickStable(buttons);

        WebElement doubleClick = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();

        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClick).perform();

        WebElement links = driver.findElement(By.xpath("//span[text()='Links']"));
        clickStable(links);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("simpleLink")));
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}






