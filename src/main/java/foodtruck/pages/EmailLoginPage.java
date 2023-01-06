package foodtruck.pages;

import io.appium.java_client.MobileBy;

/**
 * @author Michelle
 */
public class EmailLoginPage extends BasePage {
    private static final String EMAIL_INPUT = "email_input_on_email_login_page";
    private static final String PASSWORD_INPUT = "password_input_on_email_login_page";
    private static final String LOGIN_BUTTON = "login_button_on_email_login_page";

    public EmailLoginPage() {
        super(MobileBy.AccessibilityId(EMAIL_INPUT));
    }

    public void loginWithEmail(String userName, String password) {
        driver.findElementByAccessibilityId(EMAIL_INPUT).sendKeys(userName);
        driver.findElementByAccessibilityId(PASSWORD_INPUT).sendKeys(password);
        driver.findElementByAccessibilityId(LOGIN_BUTTON).click();
    }
}
