package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(id = "error")
    private WebElement errorText;

    public void enterUsername(String emailID) {
//        System.out.println(usernameField + " " + emailID);
        sendKeys(usernameField, emailID);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public String getErrorText(){
        return getText(errorText);
    }

    public boolean verifyErrorText(){
        return isDisplayed(errorText);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
