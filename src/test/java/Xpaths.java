import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Xpaths {

    @Test
    public void check () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");

        WebElement checkbox = driver.findElement(By.xpath("//span[@role='checkbox']"));
        checkbox.click();

        WebElement text = driver.findElement(By.xpath("//span[contains(text(), 'Home')]"));

        String textHome = text.getText();

        Assert.assertEquals(textHome, "Home", "Mesajul nu este corect");
    }
}

