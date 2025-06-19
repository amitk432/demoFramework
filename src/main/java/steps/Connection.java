package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.WebDriverManager;

public class Connection {

    public static String BASE_URL = "https://practicetestautomation.com/practice-test-login/";

    @Given("Open page")
    public void open_page() {
        WebDriverManager.getDriver().get(BASE_URL);
    }

    @Then("Close the browser")
    public void closeConnection() {
        WebDriverManager.quitDriver();
    }

    @Then("Wait for {int} seconds")
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
