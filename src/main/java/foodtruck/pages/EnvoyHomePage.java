package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class EnvoyHomePage extends BasePage {
    private static final String SELECT_ADDRESS = "select address";
    private static final String WONDER_TAB = "wonder_on_home_page";
    private static final String ENVOY_TAB = "envoy_on_home_page";
    private static final String DELIVERY_BUTTON = "delivery_button_on_home_page";
    private static final String PICKUP_BUTTON = "pickup_button_on_home_page";

    public EnvoyHomePage() {
        super(MobileBy.AccessibilityId("MKP_HOME_PAGE"));
    }

    public void clickPickupButton() {
        driver.findElementByAccessibilityId(PICKUP_BUTTON).click();
    }

    public void clickWonderTab() {
        driver.findElementByAccessibilityId(WONDER_TAB).click();
    }

    public void clickRestaurant(String restaurantName) {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(restaurantName + "_on_home_page"))).click();
    }
}
