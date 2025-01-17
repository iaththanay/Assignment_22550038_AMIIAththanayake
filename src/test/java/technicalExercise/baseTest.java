package technicalExercise;

import Utils.TakeErrorScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class baseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    private String reportFileName;

    @BeforeSuite
    public void reportGenerationSetUp() {
        extent = new ExtentReports(); // Initialize ExtentReports (basic setup)
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

    }



    @BeforeMethod
    public void startTestFromDescription(ITestResult result) {
        // Fetch test description or use method name
        String testName = result.getMethod().getDescription();
        if (testName == null || testName.isEmpty()) {
            testName = result.getMethod().getMethodName();
        }

        // Start the test in Extent Reports
        test = extent.createTest(testName);

        // Set up the report file name dynamically
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        reportFileName = testName.replaceAll("[^a-zA-Z0-9_ ]", "").replaceAll("\\s+", "_") + "_" + timestamp + ".html";

        // Set up ExtentSparkReporter with the dynamically generated name
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + reportFileName);
        extent.attachReporter(sparkReporter);
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakeErrorScreenShots.takeScreenshot(driver, result.getName());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
