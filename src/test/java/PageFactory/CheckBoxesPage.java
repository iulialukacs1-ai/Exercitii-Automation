package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckBoxesPage {
    WebDriver driver;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    private WebElement checkbox1;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement checkbox2;

    public void CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
       PageFactory.initElements(driver, this);
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }
    public void clickCheckbox2(){
        checkbox2.click();
    }
}
