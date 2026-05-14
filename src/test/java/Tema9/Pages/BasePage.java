package Tema9.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void typeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        return element.getText();
    }
}


