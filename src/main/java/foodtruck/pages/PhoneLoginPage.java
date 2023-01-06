package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class PhoneLoginPage extends BasePage{
    private static final String PHONE_INPUT = "phone_input_on_login_page";
    private static final String LOGIN_WITH_EMAIL = "login_with_email_on_login_page";

    public PhoneLoginPage() {
        super(MobileBy.AccessibilityId(PHONE_INPUT));
    }

    public void clickLoginWithEmail(){
        driver.findElementByAccessibilityId(LOGIN_WITH_EMAIL).click();
    }
}
