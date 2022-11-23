package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.util.PropertiesUtils;
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

@Epic("this is a test for app launch")
@Story("this is a test story")
public class TestLaunch {
    private static final String GET_STARTED = "get started button";
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

    //@Test
    @Test
    @DisplayName("launch app")
    @Description("app launch test")
    public void launch() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS);
        redirectToWelcomePage(wait);
        takeScreenshot();

    }

    @Test
    @DisplayName("login by app get started")
    @Description("app get started")
    public void getStarted() {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIME_OUT_IN_SECONDS);
        redirectToWelcomePage(wait);
        takeScreenshot();
        redirectToLocationStartPage(wait);

    }

    @Step("redirect to welcome page")
    private void redirectToWelcomePage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("WELCOME_PAGE")));
        takeScreenshot("welcome_page");

    }

    @Step("redirect to location start page")
    private void redirectToLocationStartPage(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(GET_STARTED))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(" LOCATION_START_PAGE")));
        takeScreenshot("location_start_page");

    }

    private void takeScreenshot(String name) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Properties properties = PropertiesUtils.loadAllureProperties();
        String savePath = properties.getProperty("allure.results.directory", "allure-results");
        File targetFle = new File(savePath + "/" + name + ".jpg");
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
