//Folosind pagina https://practicesoftwaretesting.com/
//Accesează o categorie de produse.
//Folosește filtrele disponibile.
//Selectează un filtru (ex: brand).
//Verifică faptul că cel puțin două produse conțin numele categoriei selectate.

//Folosind pagina https://practicesoftwaretesting.com/
//Deschide un produs.
//Apasă Add to cart.
//Deschide coșul.
//Verificare:
//produsul apare în coș
//cantitatea este 1.

//Test Case:
//Accesează site-ul.
//Caută produsul Hammer.
//Deschide produsul.
//Adaugă produsul în coș.
//Deschide coșul.
//Verifică:
//produsul este în coș
//cantitatea este 1
//prețul este afișat.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tema5 {
    static WebDriverWait wait;

    public static void scrollToElement(WebElement element) {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }

    @Test
    public static void categoryName () {
       WebDriver driver;
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://practicesoftwaretesting.com/");

       //Accesează o categorie de produse.
       WebElement categories = driver.findElement(By.xpath("//*[@data-test='nav-categories']"));
       categories.click();

       WebElement handTools = driver.findElement(By.xpath("//*[@data-test='nav-hand-tools']"));
       handTools.click();

       //Folosește filtrele disponibile.
       //Selectează un filtru (ex: brand).
       WebElement brandCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='brand_id' and @value='01KKRJERTJ4EZDQPPMCN2PPXJ8']")));
        scrollToElement(brandCheckbox);
        brandCheckbox.click();

   }
}
