package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class amazonHomePage extends BasePage{

    @FindBy(xpath = "//div[@id=\"nav-global-location-slot\"]")
    WebElement deliverTo;
    @FindBy(xpath = "//h4[text()='Choose your location']")
    WebElement titleLocationPicker;
    @FindBy(xpath = "//span[@class='a-dropdown-container']") ////span[@class='a-dropdown-container'] //select[@id='GLUXCountryList']
    WebElement dropDownSelectCountry;
    @FindBy(xpath = "//button[text()='Done']")
    WebElement btnDone;
    @FindBy (xpath = "//span[@id='glow-ingress-line2']")
    WebElement txtCountry;
    @FindBy (xpath = "//div[@id='glow-toaster-body']")
    WebElement altCountrySelect;
    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    WebElement txtSearchBar;
    @FindBy (xpath = "(//span[contains(text(), 'Instant Email or Text Delivery')])[1]")
    WebElement imgEgiftCard;
    @FindBy (xpath = "//button[@id='gc-mini-design-thumb-15']")
    WebElement imgChange;
    @FindBy (xpath = "(//div[@class='a-section gc-design-image-wrapper'])[1]")
    WebElement imgPreview;
    @FindBy(xpath = "//td[@id='mainImageContainer']")
    WebElement giftCardDesignPreview;
    @FindBy (xpath = "//img[@alt='Thinking of You Flowers']")
    WebElement altText;
    @FindBy (xpath = "//ul[@id='gc-amount-mini-picker']/li[3]") //ul[@id='gc-amount-mini-picker']/li[3]
    WebElement btnValue1;
    @FindBy (xpath = "//button[@id='gc-mini-picker-amount-6']")
    WebElement btnValue2;
    @FindBy (xpath = "//table[@role='presentation']//tr[4]/td[1]//tr[1]/td[1]//span[1]")
    WebElement txtValuePreviewCard;
    @FindBy (xpath = "//div[@class='a-popover-wrapper']//header//button[@class=' a-button-close a-declarative']")
    WebElement btnClose;

    public amazonHomePage(WebDriver driver) {
        super(driver);
    }

    private void click_to_change_the_country(){
        deliverTo.click();
    }

    private  void title_is_visibale(){
        waitUntilVisible(titleLocationPicker);
        titleLocationPicker.isDisplayed();
    }

    private void click_on_the_DropDown(){
        waitUntilVisible(dropDownSelectCountry);
        dropDownSelectCountry.click();
    }

    private void select_a_country(String countryName){
        driver.findElement(By.xpath("//a[text()='"+countryName+"']")).click();
    }

    private void click_on_done_button(){
        btnDone.click();
    }

    private void check_the_selected_country(String countryName){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilVisible(txtCountry);
        softAssert.assertEquals(txtCountry.getText(),countryName);
    }

    private void search_text(String searchEGiftCard){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        txtSearchBar.sendKeys(searchEGiftCard);
        txtSearchBar.sendKeys(Keys.ENTER);
    }
    private void select_e_gift_card(){
        imgEgiftCard.click();
    }
    private void select_a_new_image(){
        imgChange.click();
    }

    private void step_preview_selected_image(){
        imgPreview.click();
    }
    private void verify_preview_selected_image(){
        giftCardDesignPreview.isDisplayed();
        String actualAltText = altText.getAttribute("alt");
        softAssert.assertEquals(actualAltText,"Thinking of You Flowers");

    }

    private void change_the_card_value1(){
        waitUntilVisible(btnValue1);
        btnValue1.click();
    }

    private void verify_the_card_value1(){
        softAssert.assertEquals(txtValuePreviewCard.getText(),"$75.00");
    }

    private void close_preview_window(){
        waitUntilClickable(btnClose);
        btnClose.click();
    }

    //steps
    public amazonHomePage step_click_to_change_the_country(String countryName){
        click_to_change_the_country();
        title_is_visibale();
        click_on_the_DropDown();
        select_a_country(countryName);
        click_on_done_button();
        return this;
    }

    public amazonHomePage verify_the_selected_country(String countryName){
        check_the_selected_country(countryName);
        return this;
    }

    public amazonHomePage step_to_search_content(String searchEGiftCard){
        search_text(searchEGiftCard);
        return this;
    }

    public amazonHomePage step_select_e_gift_card(){
        select_e_gift_card();
        return this;
    }

    public amazonHomePage step_select_a_new_image(){
        select_a_new_image();
        return this;
    }
    public amazonHomePage step_preview_and_verify_selected_image(){
        step_preview_selected_image();
        verify_preview_selected_image();
        close_preview_window();
        return this;
    }

    public amazonHomePage step_change_the_card_value(){
        change_the_card_value1();
        return this;
    }
    public amazonHomePage verify_the_value(){
        step_preview_selected_image();
        verify_the_card_value1();
        close_preview_window();
        return this;
    }

    public void verifyAssertions() {
        softAssert.assertAll(); // Report all assertions
    }
}

