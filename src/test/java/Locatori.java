import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Locatori {

    @Test
    public void textBoxTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        String fullNameValue = "Iulia";

        Actions actions = new Actions(driver);

        //identificam elementele din pagina
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement eMail = driver.findElement(By.id("userEmail"));
        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.id("submit"));
        boolean submitDisplayed = submit.isDisplayed();
        boolean submitEnabled = submit.isEnabled();

        Assert.assertTrue(submitDisplayed, "Button is not displayed");
        Assert.assertTrue(submitEnabled, "Button is enabled.");

        System.out.println(submitDisplayed + " " + submitEnabled);


        //completam campurile cu sendKeys
        fullName.sendKeys("Iulia");
        eMail.sendKeys("test@itschool.com");
        currentAdress.sendKeys("Cluj-Napoca");
        permanentAddress.sendKeys("Cluj");


        //dam submit
        actions.scrollToElement(submit).perform();
        submit.click();


        //verificam daca campul output exista?
        WebElement output = driver.findElement(By.id("output"));

        // Assert.assertTrue(output.isDisplayed());

        //Verificam daca campurile sunt completate cum trebuie
        String outputName = driver.findElement(By.id("name")).getText();
        System.out.println(outputName);

        Assert.assertTrue(outputName.contains(fullNameValue), "Output name nu este corect");
    }

    //creeaza un scenariu negativ

    @Test
    public void testScenariuNegativ() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        Actions actions = new Actions(driver);

        //identificam elementele din pagina
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement eMail = driver.findElement(By.id("userEmail"));
        WebElement currentAdress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        WebElement submit = driver.findElement(By.id("submit"));


        //completam campurile cu sendKeys
        fullName.sendKeys("Iulia");
        eMail.sendKeys("test");
        currentAdress.sendKeys("Cluj-Napoca");
        permanentAddress.sendKeys("Cluj");


        //dam submit
        actions.scrollToElement(submit).perform();
        submit.click();

        String classAttribute = eMail.getAttribute("class");

        System.out.println(classAttribute);

        Assert.assertTrue(classAttribute.contains("field-error"));

    }

    @Test
    public void buton() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMe.click();

        WebElement output = driver.findElement(By.id("dynamicClickMessage"));

        boolean outputMessage = output.isDisplayed();
        Assert.assertTrue(outputMessage, "Mesajul nu este displayed");

        String dynamicClickMsg = output.getText();
        Assert.assertEquals(dynamicClickMsg, "You have done a dynamic click", "Message is not correct");

    }

    @Test
    public void switchName() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder = 'Full Name']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));


        fullName.sendKeys("Iulia");
        email.sendKeys("test@gmail.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fullName.clear();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fullName.sendKeys("Tzuki");
    }

    
}
