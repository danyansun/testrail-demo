package foodtruck.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Michelle
 */
public class WonderShopCartPage extends BasePage {
    private static final String CHECK_OUT_BUTTON = "checkout button";
    private static final String BACK_BUTTON = "back_button_on_shop_cart_page";

    public WonderShopCartPage() {
        super(MobileBy.AccessibilityId(CHECK_OUT_BUTTON));
    }

    public void clickCheckoutButton(){
        driver.findElementByAccessibilityId(CHECK_OUT_BUTTON).click();
    }

    public void clickBack() {
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(BACK_BUTTON))).click();
    }
}
