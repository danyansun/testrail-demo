package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class WonderMealDetailPage extends BasePage {
    private static final String ADD_BUTTON = "take it button";
    private static final String BACK_BUTTON = "back_button_on_meal_detail_page";

    public WonderMealDetailPage() {
        super(MobileBy.AccessibilityId(ADD_BUTTON));
    }

    public void clickBack() {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(BACK_BUTTON))).click();
    }
}
