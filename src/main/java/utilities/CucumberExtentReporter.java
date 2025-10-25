package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberExtentReporter {
    WebDriverManager webDriverManager;
    private static ExtentReports extent = getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setup(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(WebDriverManager.getDriver(), scenario.getName());
            test.get().fail("Scenario Failed: " + scenario.getName(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            WebDriverManager.quitDriver();
        } else {
            test.get().log(Status.PASS, "Scenario Passed: " + scenario.getName());
        }
        extent.flush();
    }

    public class ScreenshotUtil {
        public static String captureScreenshot(WebDriver webDriver, String scenarioName) {
            File src = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + scenarioName + ".png";
            try {
                Files.copy(src.toPath(), new File(screenshotPath).toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return screenshotPath;
        }
    }


    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setReportName("MSIL Automation Results Report");
            sparkReporter.config().setDocumentTitle("MSIL Automation Report");
            sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

//    		extent.setSystemInfo("Application URL",configProp.getProperty("url"));
//    		extent.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
//    		extent.setSystemInfo("Email",configProp.getProperty("validEmail"));
//    		extent.setSystemInfo("Password",configProp.getProperty("validPassword"));
            extent.setSystemInfo("Operating System",System.getProperty("os.name"));
            extent.setSystemInfo("Username",System.getProperty("user.name"));
            extent.setSystemInfo("Java Version",System.getProperty("java.version"));
        }
        return extent;
    }

}