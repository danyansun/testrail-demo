package test;

import appium.DriverInstance;
import appium.SysProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * @author niki
 */

@Epic("this is a test for user login")
@Story("this is a test story")
public class TestLogin {
    private static final String LOGIN = "login_button_on_welcome_page";
    private static final String PHONE_INPUT = "phone_input_on_login_page";
    private static final String LOGIN_WITH_EMAIL = "login_with_email_on_login_page";
    private static final String EMAIL_INPUT = "email_input_on_email_login_page";
    private static final String PASSWORD_INPUT = "password_input_on_email_login_page";
    private static final String LOGIN_BUTTON = "login_button_on_email_login_page";
    private static final String CONTINUE_BUTTON = "continue_button_on_login_page";
    private static final String CODE_INPUT = "code_input";
    public static final int DEFAULT_TIME_OUT_IN_SECONDS = 30;

    public static AppiumDriver<MobileElement> driver;

    //    @BeforeAll
    @BeforeClass
    public static void setupDriver() {
        driver = DriverInstance.of().driver;
        driver.installApp(SysProperties.APP_PATH);

    }

    @Before
    public void presetApp() {
        driver.activateApp(SysProperties.BUNDLE_ID);
    }

    //    @Test
    @Test
    @DisplayName("login by email and password")
    @Description("user login test")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS);
        redirectToWelcomePage(wait);
        takeScreenshot();
        redirectToLoginPage(wait);
        takeScreenshot();
        redirectToEmailLoginPage(wait);
        takeScreenshot();
        enterUserAndPassword(wait);
        redirectToHomePage(wait);
        takeScreenshot();

    }

    @Test
    @DisplayName("login by phone")
    @Description("user login by phone")
    @Issue("432")
    @TmsLink("test-2")
    public void loginByPhone() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS);
        redirectToWelcomePage(wait);
        takeScreenshot();
        redirectToLoginPage(wait);
        takeScreenshot();
        enterPhoneToHomePage(wait);
        takeScreenshot();

    }

    @Step("redirect to welcome page")
    private void redirectToWelcomePage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("WELCOME_PAGE")));
        takeScreenshot("welcome_page");

    }

    @Step("redirect to login page")
    private void redirectToLoginPage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(LOGIN))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("LOGIN_PAGE")));
        takeScreenshot("login_page");
    }

    @Step("redirect to email login page")
    private void redirectToEmailLoginPage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(LOGIN_WITH_EMAIL))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("EMAIL_LOGIN_PAGE")));
        takeScreenshot("email_login_page");
    }

    @Step("enter username and password")
    private void enterUserAndPassword(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(EMAIL_INPUT))).sendKeys("nikisun@chancetop.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(PASSWORD_INPUT))).sendKeys("pwd11111");
    }

    @Step("enter phone")
    private void enterPhoneToHomePage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(PHONE_INPUT))).sendKeys("4103562000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(CONTINUE_BUTTON))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(CODE_INPUT))).click();
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("HOME_PAGE")));
        takeScreenshot("home_page");
    }


    @Step("redirect to home page")
    private void redirectToHomePage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(LOGIN_BUTTON))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("HOME_PAGE")));
        takeScreenshot("home_page");
    }

    private void takeScreenshot(String name) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String savePath = "build/allure-results/attachments/";
        Properties properties = new Properties();
        String savePath = properties.getProperty("allure.results.directory", "allure-results/");

        File targetFle = new File(savePath + name + ".jpg");
        try {
            FileUtils.copyFile(file, targetFle);
            Allure.addAttachment("My attachment", FileUtils.openInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }

    @After
    public void tearApp() {
        driver.resetApp();
    }

    //    @AfterAll
    @AfterClass
    public static void tearDown() {
        //End the running session
        if (driver != null) {
//            driver.terminateApp(SysProperties.BUNDLE_ID);
            driver.removeApp(SysProperties.BUNDLE_ID);
//            driver.quit();
        }
    }
}
