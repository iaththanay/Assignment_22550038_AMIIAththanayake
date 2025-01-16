package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected SoftAssert softAssert; // Declare SoftAssert
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver; // Assign the driver passed from the baseTest
        PageFactory.initElements(driver, this);
        this.softAssert = new SoftAssert(); // Initialize SoftAssert
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // Utility method for explicit waits
    protected WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to wait until an element is clickable
    protected WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
