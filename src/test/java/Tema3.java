import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Tema3 {

    @Test
    public void xpath() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        Actions actions = new Actions(driver);

//===================Exercitiu 1======================//
        //identificam locatorul cu Xpath pentru placeholder

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

        //comletam campul cu "Test"
        firstName.sendKeys("Test");

        //Gaseste campul Last Name folosing XPath bazat pe atributul id

        WebElement LastName = driver.findElement(By.xpath("//input[@id='lastName' ]"));

        //Introdu valoarea “User”
        LastName.sendKeys("User");

        //Gaseste campul Email folosing XPath bazat pe atributul id
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));

        //Introdu textul “test@email.com”
        email.sendKeys("test@gmail.com");

        //Apasa oricare din butoanele radio de la Gender
        WebElement gender = driver.findElement(By.id("gender-radio-3"));
        actions.scrollToElement(gender).perform();
        gender.click();

        //Introdu un numar de telefon in campul pentru Mobile
        WebElement mobileNumber = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        mobileNumber.sendKeys("0764556784");

        //Introdu un text in campul pentru ‘Subjects’
        WebElement subjects = driver.findElement(By.xpath("//input[@class='subjects-auto-complete__input']"));
        subjects.sendKeys("Pisici");

        //Introdu un text in campul pentru ‘Current Address’
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("Locuim pe luna.");

        //Gaseste butonul Submit dupa text si apasa folosind click
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

        //BONUS optional: verifica aparitia pop-up-ului de confirmare si apasa pe butonul Close
        WebElement popup = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']"));
        WebElement close = driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
        close.click();
    }

    @Test
    public void test2() {
        //Creaza un test, pornind de la URL-ul https://demoqa.com/webtables
        //Da click pe butonul ‘Add’
        //Completeaza toate campurile din pop-up-ul care se deschide
        //Da click pe butonul Submit
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/webtables");

        WebElement add = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        add.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Lalala");

        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Test");

        WebElement email = driver.findElement(By.xpath("//input[@class='mr-sm-2 form-control']"));
        email.sendKeys("test@gmail.com");

        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.sendKeys("35");

        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.sendKeys("1111");

        WebElement department = driver.findElement(By.xpath("//input[@placeholder='Department']"));
        department.sendKeys("QA");

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

    }
}

