package test;

import appium.DriverInstance;
import appium.SysProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author niki
 */


public class testLogin {
    private static final String LOGIN = "login_button_on_welcome_page";
    private static final String PHONE_INPUT = "phone_input_on_login_page";
    private static final String LOGIN_WITH_EMAIL = "login_with_email_on_login_page";
    private static final String EMAIL_INPUT = "email_input_on_email_login_page";
    private static final String PASSWORD_INPUT = "password_input_on_email_login_page";
    private static final String LOGIN_BUTTON = "login_button_on_email_login_page";
    public static final int DEFAULT_TIME_OUT_IN_SECONDS = 30;

    public static AppiumDriver<MobileElement> driver;

    @BeforeAll
    public static void setupDriver() {
        driver = DriverInstance.of().driver;
        driver.installApp(SysProperties.APP_PATH);
        driver.activateApp(SysProperties.BUNDLE_ID);

    }

    @Test
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("WELCOME_PAGE")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(LOGIN))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("LOGIN_PAGE")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(LOGIN_WITH_EMAIL))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("EMAIL_LOGIN_PAGE")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(EMAIL_INPUT))).sendKeys("nikisun@chancetop.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(PASSWORD_INPUT))).sendKeys("pwd11111");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(LOGIN_BUTTON))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("HOME_PAGE")));
    }

    @AfterAll
    public static void tearDown() {
        //End the running session
        if (driver != null) {
//            driver.terminateApp(SysProperties.BUNDLE_ID);
            driver.removeApp(SysProperties.BUNDLE_ID);
            driver.quit();
        }
    }
}
