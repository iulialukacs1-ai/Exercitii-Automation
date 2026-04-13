import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InteractiuniAvansate {

    WebDriver driver;

    @Test
    public void testDropdownSelect () {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        //selecteaza culoarea Blue
        WebElement selectDropdownLocator = driver.findElement(By.id("oldSelectMenu"));
        Select dropdown = new Select(selectDropdownLocator);

        dropdown.selectByVisibleText("Blue");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //selecteaza culoarea Yellw folosing value
        dropdown.selectByValue("3");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //selecteaza culoare Purple folosing index
        dropdown.selectByIndex(4);

        String selectedOptionText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionText,"Purple", "Optiunea selectata nu este purple");
    }

    @Test
    public void dropdownNew () {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        WebElement dropdwn = driver.findElement(By.className("css-13cymwt-control"));
        dropdwn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement option1 = driver.findElement(By.xpath("//div[text()='Group 1, option1']"));
//input[@data-test='category-01KKVSEJTJKPAPKX17STZ6FHA9']
    }
    @Test
    public void testCheckbox () {
        driver = new ChromeDriver();
        driver.get("https://practicesoftwaretesting.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(), 'MightyCraft Hardware')]/input"));
        checkbox.click();

        checkbox.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, false));
        
        //verificare ca ii selectat
        boolean isCheckboxSelected = checkbox.isSelected();

        if (isCheckboxSelected == true) {
            System.out.println("este selectat, nu e nevoie sa il mai selectam");
        }
        else {
            System.out.println("Nu este selectat, da click");
            checkbox.click();
        }

        isCheckboxSelected = checkbox.isSelected();

        Assert.assertTrue(isCheckboxSelected,"Checkboxul nu este selectat");
    }

    @Test
    public void testUpload () {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");

        WebElement uploadInput = driver.findElement(By.id("uploadFile"));
        uploadInput.sendKeys("file:///Users/iulialukacs/Desktop/Food-Plan-2022-RO.pdf");
    }

    @Test
    public void testButtons () {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actiuni = new Actions(driver);
        actiuni.doubleClick(doubleClickBtn).perform();

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actiuni.contextClick(rightClickBtn).perform();

    }

        @Test
                public void testComplet () {
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/select-menu");

            WebElement selectBlue = driver.findElement(By.id("oldSelectMenu"));
            Select select = new Select(selectBlue);
            select.selectByValue("1");

String selectedOption = select.getFirstSelectedOption().getText();
Assert.assertEquals(selectedOption, "Blue", "Optiunea selectata nu este corecta");

driver.get("https://demoqa.com/buttons");
WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
Actions actiuni = new Actions(driver);

actiuni.doubleClick(doubleClick).perform();

WebElement doubleClickMsg = driver.findElement(By.id("doubleClickMsg"));




        }
    }


