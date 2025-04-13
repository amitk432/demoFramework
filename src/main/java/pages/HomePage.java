package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//p[@class='has-text-align-center']")
    private WebElement loginSuccessText;

    public void clickLogoutButton() {
        click(logoutButton);
    }

    public boolean verifyLogoutButton() {
        return isDisplayed(logoutButton);
    }

    public String verifyLoginSuccessText(){
        return getText(loginSuccessText);
    }
}
