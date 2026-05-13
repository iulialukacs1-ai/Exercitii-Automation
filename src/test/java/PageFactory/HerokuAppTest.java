package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HerokuAppTest {

    WebDriver driver;

    @Test
    public void checkboxesTest(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        CheckBoxesPage checkBoxesPage = new CheckBoxesPage();
        checkBoxesPage.clickCheckbox1();
        checkBoxesPage.clickCheckbox2();
    }
}
