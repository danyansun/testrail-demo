package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class WelcomePage extends BasePage {
    private static final String GET_START_BUTTON = "get started button";
    private static final String LOGIN_BUTTON = "login_button_on_welcome_page";

    public WelcomePage() {
        super(MobileBy.AccessibilityId(LOGIN_BUTTON));
    }

    public void clickIamNewButton() {
        driver.findElementByAccessibilityId(GET_START_BUTTON).click();
    }

    public void clickLoginButton() {
        driver.findElementByAccessibilityId(LOGIN_BUTTON).click();
    }
}
