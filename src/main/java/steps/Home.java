package steps;

import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.WebDriverManager;

public class Home {
    private final HomePage home;

    public Home() {
        home = new HomePage(WebDriverManager.getDriver());
    }

    @Then("Verify new page contains expected text \\({string} or {string})")
    public void verifyNewPageContainsExpectedTextCongratulationsOrSuccessfullyLoggedIn(String congratulations, String successfullyLoggedIn) {
//        Assert.assertTrue);
        if (home.verifyLoginSuccessText().contains(congratulations) || home.verifyLoginSuccessText().contains(successfullyLoggedIn)) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

    @Then("Verify button Log out is displayed on the new page")
    public void verify_button_log_out_is_displayed_on_the_new_page() {
        if (home.verifyLogoutButton()) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }
}
