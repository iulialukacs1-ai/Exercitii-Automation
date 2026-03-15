import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Tema4 {

    WebDriver driver;
    WebDriverWait wait;

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @BeforeMethod
    public void openHomePage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkTitleAndLogo () {
        // 2. Verifică titlul paginii
        String expectedTitle = "Practice Software Testing - Toolshop - v5.0";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titlul paginii NU este corect!");

        // 3. Verifică dacă logo-ul este vizibil
        WebElement gearIcon = driver.findElement(By.cssSelector("g.gear"));
        Assert.assertTrue(gearIcon.isDisplayed(), "Logo-ul NU este vizibil!");

        System.out.println("Logo-ul este vizibil");

    }

    @Test
    public void productSearch() {

        WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-query")));

        scrollToElement(searchbar);

        searchbar.click();
        searchbar.sendKeys("hammer");
        searchbar.sendKeys(Keys.ENTER);

        // Așteaptă să apară termenul căutat
        WebElement searchTerm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='search-term']")));
        Assert.assertEquals(searchTerm.getText(), "hammer");

        // 1. Așteaptă ca produsele să fie PREZENTE în DOM
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-md-9']")));

        // 2. Scroll până la primul produs
        scrollToElement(firstProduct);

        // 3. verificăm că este vizibil
        Assert.assertTrue(firstProduct.isDisplayed(), "Nu există produse vizibile în listă!");

        System.out.println("Produsele sunt vizibile");
    }

    @Test
    public void openProduct (){

        //-Așteaptă încărcarea produselor.
        WebElement listProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='card']")));

        //-Apasă pe primul produs din listă.
        listProducts.click();

        //Verifică dacă:
        //-imaginea produsului este vizibilă
        //-butonul Add to cart este vizibil.
        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='figure-img img-fluid']")));
        Assert.assertTrue(productImage.isDisplayed(), "Imaginea NU este vizibilă!");

        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-add-to-cart']")));
        Assert.assertTrue(addToCart.isDisplayed(),"Add to cart nu este vizibil");

        System.out.println("Imaginea este vizibila");
        System.out.println("Butonul 'Add to cart' este vizibil");
    }

    @Test
    public void filters () {
        //-Selectează un filtru (ex: brand sau categorie)
        WebElement brandCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='brand_id' and @value='01KKRJERTJ4EZDQPPMCN2PPXJ8']")));

        // Scroll până la el
        scrollToElement(brandCheckbox);
        brandCheckbox.click();

        //-Așteaptă actualizarea listei.
        WebElement listLoaded = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test='filter_completed']")));

        //-Verifică dacă produsele afișate respectă filtrul.
        // Creez un array de WebElemente cu 0 elemente.
        WebElement[] products = new WebElement[0];

        // cauta brandul în interiorul fiecărui card de produs.
        for (WebElement product : products) {
            WebElement brandElement = product.findElement(By.xpath(".//*[@data-test='product-brand']"));

            String brandText = brandElement.getText().trim();

            Assert.assertEquals(brandText, "MightyCraft Hardware", "Produsul NU aparține brandului filtrat!");

            System.out.println("Toate prdusele afisate sunt filtrate corespunzator.");
        }
    }
}


