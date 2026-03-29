import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Tema6 {

    //1.Creează un test care:
    //deschide un site
    //deschide un tab nou (WindowType.TAB)
    //accesează alt site în noul tab
    //Afișează titlul ambelor taburi

    WebDriver driver;
    WebDriverWait wait; //

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Exercitiul 1
    @Test(priority = 2)
    public void multipleTabs(){
        // 1. Deschide primul site
            driver.get("https://www.google.com");
    String firstTab = driver.getWindowHandle();
        System.out.println("Titlul primului tab: " + driver.getTitle());

    // 2. Deschide un tab nou și accesează alt site
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wikipedia.org");
        System.out.println("Titlul celui de-al doilea tab: " + driver.getTitle());

    // 3. Revine la primul tab și afișează din nou titlul
        driver.switchTo().window(firstTab);
        System.out.println("Înapoi pe primul tab: " + driver.getTitle());
}
    // Exercitiul 2
    @Test(priority = 3)
    public void navigateBetweenTabs (){
        // 1. Deschide primul site
        driver.get("https://www.google.com");

        // 2. Deschide al doilea tab si acceseaza alt site
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wikipedia.org");

        // 3. Salveaza windowHandles intr-o lista
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // 4. Navigheaza la primul tab si verifica titlul
        driver.switchTo().window(tabs.get(0));
        System.out.println("Titlul primului tab: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Titlul primului tab nu este corect!");

        // 5. Navigheaza la al doilea tab si verifica titlul
        driver.switchTo().window(tabs.get(1));
        System.out.println("Titlul celui de-al doilea tab: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Wikipedia", "Titlul celui de-al doilea tab nu este corect!");
    }
    // Exercitiul 3
    @Test(priority = 4)
    public void testCloseTab() {
        // 1. Deschide primul tab
        driver.get("https://www.google.com");

        // 2. Deschide al doilea tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wikipedia.org");

        // 3. Salveaza handles
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // 4. Inchide al doilea tab (cel activ acum)
        driver.close();

        // 5. Revine pe tabul principal
        driver.switchTo().window(tabs.get(0));

        // 6. Verifica titlul paginii principale
        System.out.println("Titlul tabului principal: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Nu ești pe pagina corectă!");
    }
// Exercitiul 4
    @Test(priority = 5)
    public void testOpenProductInNewTab() {
        // 1. Deschide site-ul si asteapta sa se incarce
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        System.out.println("Titlul in @Test: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Nu ești pe pagina corecta!");

        // 2. Navigheaza direct la categoria Hand Tools
        driver.get("https://practicesoftwaretesting.com/category/hand-tools");

        // 3. Salveaza handle-ul tabului principal
        String mainTab = driver.getWindowHandle();

        // 4. Asteapta sa apara produsele
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='product-name']")));
        String productName = firstProduct.getText();
        System.out.println("Produs gasit: " + productName);

        // 5. Retine URL-ul primului produs
        WebElement productLink = driver.findElement(By.cssSelector("[data-test^='product-']"));
        String productUrl = productLink.getAttribute("href");
        System.out.println("URL produs: " + productUrl);

        // 6. Deschide tab nou si navigheaza la produs
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(productUrl);

        // 7. Verifica titlul in noul tab
        wait.until(ExpectedConditions.titleContains(productName));
        System.out.println("Titlul tabului nou: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(productName),
                "Produsul din tab nou nu corespunde!");

        // 8. Revine pe tabul principal
        driver.switchTo().window(mainTab);

        // 9. Face refresh si verifica pagina
        driver.navigate().refresh();
        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Pagina nu s-a incarcat corect dupa refresh!");
        System.out.println("Test trecut cu succes!");
    }

    //Exercitiul 5
    @Test (priority = -1)
    public void simpleTest1() {
        driver.get("https://demoqa.com/");
        System.out.println("Titlul tabului: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("demosite"));

    }
    @Test(priority = 0)
    public void simpleTest2() {
        driver.get("https://demoqa.com/forms");
        System.out.println("URL-ul curent este" + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demoqa.com/forms"));
    }
    @Test(priority = 1)
    public void simpleTest3() {
        driver.get("https://practicesoftwaretesting.com/");
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='search-query']")));
        System.out.println("Campul de search este vizibil: " + searchInput.isDisplayed());
        Assert.assertTrue(searchInput.isDisplayed(),
                "Campul de search nu este vizibil!");
    }

    @Test(groups = {"smoke"})
    public void testTitluHomepageGroup() {
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        System.out.println("Titlu: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Titlul homepage-ului nu este corect!");
    }

    @Test(groups = {"smoke"})
    public void testButonaLoginGroup() {
        driver.get("https://practicesoftwaretesting.com/");
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='nav-sign-in']")));
        System.out.println("Butonul de login este vizibil: " + loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed(),
                "Butonul de login nu este vizibil!");
    }

    @Test(groups = {"regression"})
    public void testSearchGroup() {
        driver.get("https://practicesoftwaretesting.com/");
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='search-query']")));
        searchInput.sendKeys("Pliers");

        WebElement searchButton = driver.findElement(By.cssSelector("[data-test='search-submit']"));
        searchButton.click();

        WebElement rezultat = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='product-name']")));
        System.out.println("Primul rezultat: " + rezultat.getText());
        Assert.assertTrue(rezultat.getText().toLowerCase().contains("pliers"),
                "Rezultatul cautarii nu contine 'pliers'!");
    }

    @Test(groups = {"regression"})
    public void testUrlHomepageGroup() {
        driver.get("https://practicesoftwaretesting.com/");
        wait.until(ExpectedConditions.urlContains("practicesoftwaretesting"));
        System.out.println("URL: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("practicesoftwaretesting"),
                "URL-ul nu este corect!");
    }

    @Test(groups = {"smoke", "regression"})
    public void testCampSearchVizibilGroup() {
        driver.get("https://practicesoftwaretesting.com/");
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-test='search-query']")));
        System.out.println("Campul de search este vizibil: " + searchInput.isDisplayed());
        Assert.assertTrue(searchInput.isDisplayed(),
                "Campul de search nu este vizibil!");
    }
    @AfterMethod(alwaysRun = true)
public void tearDown() {
    driver.quit();
}


}
