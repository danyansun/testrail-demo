package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class EnvoyRestaurantDetailPage extends BasePage {
    public static final String PAGE_TEST_ID = "MKP_RESTAURANT_DETAIL_PAGE";
    public static final String BACK_BUTTON = "back_button_on_mkp_restaurant_detail_page";

    public EnvoyRestaurantDetailPage() {
        super(MobileBy.AccessibilityId(PAGE_TEST_ID));
    }

    public void clickBack() {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(BACK_BUTTON))).click();
    }
}
