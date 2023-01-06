package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class WonderCheckoutPage extends BasePage {
    private static final String MAP = "customer_map_on_mkp_checkout_page";
    private static final String BACK_BUTTON = "back_button_on_checkout_page";

    public WonderCheckoutPage() {
        super(MobileBy.AccessibilityId(MAP));
    }

    public void clickBack() {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(BACK_BUTTON))).click();
    }
}
