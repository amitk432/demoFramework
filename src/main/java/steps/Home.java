package steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import utilities.WebDriverManager;

public class Home {
    private final HomePage home;

    public Home() {
        home = new HomePage(WebDriverManager.getDriver());
    }

    @Then("Verify new page contains expected text \\({string} or {string})")
    public void verifyNewPageContainsExpectedTextCongratulationsOrSuccessfullyLoggedIn(String congratulations, String successfullyLoggedIn) {
        Assert.assertTrue(home.verifyLoginSuccessText().contains(congratulations) || home.verifyLoginSuccessText().contains(successfullyLoggedIn));
    }

    @Then("Verify button Log out is displayed on the new page")
    public void verify_button_log_out_is_displayed_on_the_new_page() {
        Assert.assertTrue(home.verifyLogoutButton());
    }
}
