package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleHomePage extends BasePage {

    @FindBy(xpath = "//textarea[@title='Search']")
    WebElement txtSearchBar;
    @FindBy(xpath =  "(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")
    WebElement linkAmazonHomePage;

    public googleHomePage(WebDriver driver) {
        super(driver); // Pass the driver to the BasePage constructor
    }

    private void action_search(String searchAmazonPage) {
        txtSearchBar.sendKeys(searchAmazonPage); // Pass the search content here
        txtSearchBar.sendKeys(Keys.ENTER);
    }
    private void action_click_on_amozon_home_page_link() {
        linkAmazonHomePage.click();
    }

    // Steps
    public googleHomePage step_search_content(String searchAmazonPage) {
        action_search(searchAmazonPage);
        return this;
    }
    public amazonHomePage step_navigate_amozon_home_page(){
        action_click_on_amozon_home_page_link();
        return new amazonHomePage(driver);
    }
}
