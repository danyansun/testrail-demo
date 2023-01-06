package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class WonderRestaurantDetailPage extends BasePage {
    public static final String PAGE_TEST_ID = "RESTAURANT_DETAIL_PAGE";
    public static final String BACK_BUTTON = "back_button_on_restaurant_detail_page";

    public WonderRestaurantDetailPage() {
        super(MobileBy.AccessibilityId(PAGE_TEST_ID));
    }

    public void clickMeal(String mealName) {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(mealName + " meal"))).click();
//        driver.findElementByAccessibilityId(mealName + " meal").click();
    }

    public void clickBack() {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(BACK_BUTTON))).click();
    }
}
