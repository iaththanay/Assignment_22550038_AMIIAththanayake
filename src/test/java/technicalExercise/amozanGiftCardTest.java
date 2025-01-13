package technicalExercise;

import Pages.googleHomePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Amazon Gift Card Purchase")
@Feature("Search and Purchase Features")
public class amozanGiftCardTest extends baseTest {

    @Test(description = "Verify Amazon eGift card purchase flow")
    @Severity(SeverityLevel.CRITICAL)
    public void test_amazon() {
        new googleHomePage(driver).step_search_content("amazon home page")
                .step_navigate_amozon_home_page()
                .step_click_to_change_the_country("Spain")
                .verify_the_selected_country("Spain")
                .step_to_search_content("e gift card Amazon")
                .step_select_e_gift_card();

//                .step_select_a_new_image()
//                .step_preview_and_verify_selected_image()
//                .step_change_the_card_value()
//                .verify_the_value()
//                .verifyAssertions();

    }

}
