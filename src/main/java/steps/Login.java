package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;
import utilities.WebDriverManager;

public class Login {

    private LoginPage loginPage;

    public Login() {
        loginPage = new LoginPage(WebDriverManager.getDriver());
    }

    @Then("Type {string} into Username field")
    public void type_username_into_username_field(String username) {
        loginPage.enterUsername(username);
    }

    @Then("Type {string} into Password field")
    public void type_password_into_password_field(String password) {
        loginPage.enterPassword(password);
    }

    @Then("Push Submit button")
    public void push_submit_button() {
        loginPage.clickSubmitButton();
    }

    @Then("Verify new page URL contains {string}")
    public void verify_new_page_url(String testURL) {
        Assert.assertEquals(loginPage.getcurrentUrl(), testURL);
    }

    @Then("Verify error message is displayed")
    public void verifyErrorMessageIsDisplayedForIncorrectUsername() {
        Assert.assertTrue(loginPage.verifyErrorText());
    }

    @Then("Verify error message text is Your username is invalid!")
    public void verifyErrorMessageTextIsYourUsernameIsInvalid() {
        Assert.assertEquals(loginPage.getErrorText(), "Your username is invalid!");
    }

    @Then("Verify error message text is Your password is invalid!")
    public void verifyErrorMessageTextIsYourPasswordIsInvalid() {
        Assert.assertEquals(loginPage.getErrorText(), "Your password is invalid!");
    }
}
