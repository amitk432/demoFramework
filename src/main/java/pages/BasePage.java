package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public String getcurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Properly-cased convenience method so callers using getCurrentUrl() compile.
     * The project previously had a method named getcurrentUrl() (lowercase 'c'),
     * which caused a compile error because Java is case-sensitive.
     */
    public String getCurrentUrl() {
        return getcurrentUrl();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}
