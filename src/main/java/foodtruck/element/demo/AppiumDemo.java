package foodtruck.element.demo;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

/**
 * @author Michelle
 */
public class AppiumDemo {
    private AndroidDriver<WebElement> driver;
    WebDriverWait webDriverWait;
    private List<String> list;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "/Users/michelle.chen/apps/WONDER_2.0.0uatRelease.apk");
//        capabilities.setCapability("appActivity","com.wonder.activity.MainActivity");
//        capabilities.setCapability("appPackage","com.remarkablefoods.consumerQA");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testNothing() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(MobileBy.AccessibilityId("login_button_on_welcome_page")).click();
    }

    @Test
    public void testLogin() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        driver.findElement(MobileBy.AccessibilityId("login_button_on_welcome_page")).click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElement(MobileBy.AccessibilityId("login_with_email_on_login_page")).click();
        driver.findElement(MobileBy.AccessibilityId("email_input_on_email_login_page")).sendKeys("mm@cc.com");
        driver.findElement(MobileBy.AccessibilityId("password_input_on_email_login_page")).sendKeys("pwd11111");
        driver.findElement(MobileBy.AccessibilityId("login_button_on_email_login_page")).click();
        swipeUp();
        takeScreenshot();
        //assertion
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("wonder_on_home_page")));
        Assert.assertTrue(driver.findElementByAccessibilityId("Automation Use ONLY restaurant").isDisplayed());
        Assert.assertEquals(driver.findElementByAccessibilityId("").getAttribute(""), "");
        Assert.assertEquals(driver.findElementByAccessibilityId("").getText(), "");
        Assert.assertEquals(driver.getTitle(), "");
    }

    public void takeScreenshot() {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("page-screenshot.jpg");
        try {
            FileUtils.copyFile(srcFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void swipeUp() {
        Dimension dimension = driver.manage().window().getSize();
        int deviceWidth = dimension.width;
        int deviceHeight = dimension.height;
        new TouchAction<>(driver)
                .press(point(deviceWidth / 2, deviceHeight / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(point(deviceWidth / 2, 0))
                .release().perform();
    }

    @AfterClass
    public void tearDown() {
        //End the running session
        if (driver != null) {
            driver.quit();
        }
    }
}
