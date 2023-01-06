package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class WonderHomePage extends BasePage {
    private static final String SELECT_ADDRESS = "select address";
    private static final String WONDER_TAB = "wonder_on_home_page";
    private static final String ENVOY_TAB = "envoy_on_home_page";
    private static final String VIEW_ORDER_BUTTON = "view_order_button_on_home_page";

    public WonderHomePage() {
        super(MobileBy.AccessibilityId(WONDER_TAB));
    }

    public void waitRestaurantExist(String restaurantName) {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(restaurantName+" restaurant")));
    }

    public void clickEnvoy() {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(ENVOY_TAB))).click();
//        driver.findElementByAccessibilityId(ENVOY_TAB).click();
    }

    public void clickRestaurant(String restaurantName) {
        driver.findElementByAccessibilityId(restaurantName+" restaurant").click();
    }

    public void clickViewOrder(){
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(VIEW_ORDER_BUTTON))).click();
//        driver.findElementByAccessibilityId(VIEW_ORDER_BUTTON).click();
    }
}
