package technicalExercise;

import Pages.googleHomePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class deliveryToLocationChangeTest extends baseTest {

    @Test(description = "Verify Delivery to Location Change")
    @Severity(SeverityLevel.CRITICAL)
    public void test_Delivery_to_Location_Change() {
        new googleHomePage(driver).step_search_content("amazon home page")
                .step_navigate_amozon_home_page()
                .step_click_to_change_the_country("Spain")
                .verify_the_selected_country("Spain")
                .verifyAssertions();
    }
}
