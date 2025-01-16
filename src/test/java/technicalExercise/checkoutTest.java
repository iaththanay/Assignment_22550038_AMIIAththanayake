package technicalExercise;

import Pages.googleHomePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class checkoutTest extends baseTest{

    @Test(description = "Verify select Product")
    @Severity(SeverityLevel.CRITICAL)
    public void test_Delivery_to_Location_Change() {
        new googleHomePage(driver).step_search_content("amazon home page")
                .step_navigate_amozon_home_page()
                .step_to_search_content("samsung tablet")
                .step_view_selected_product()
                .verify_selected_product()
                .step_click_add_to_cart_button()
                .verify_product_successfull_add_to_cart()
                .step_to_click_cart()
                .step_proceed_checkout()
                .verify_step_proceed_checkout()
                .verifyAssertions();
    }
}
