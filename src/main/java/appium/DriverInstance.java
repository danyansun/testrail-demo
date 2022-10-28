package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author niki
 */
public class DriverInstance {

    public AppiumDriver<MobileElement> driver;

    private DriverInstance() {
        initSession();
    }

    private static class Inner {
        private static final DriverInstance INSTANCE = new DriverInstance();
    }

    public static DriverInstance of() {
        return Inner.INSTANCE;
    }

    private void initSession() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", SysProperties.DEVICE_NAME);
        capabilities.setCapability("app", SysProperties.APP_PATH);
        capabilities.setCapability("noReset", "true");
        try {
            if (SysProperties.DEVICE_OS.equalsIgnoreCase("android")) {
                capabilities.setCapability("automationName", "UIAutomator2");
                capabilities.setCapability("platformName", "android");
                capabilities.setCapability("platformVersion", SysProperties.DEVICE_VERSION);
                driver = new AndroidDriver<>(new URL(SysProperties.APPIUM_URL), capabilities);
            } else if (SysProperties.DEVICE_OS.equalsIgnoreCase("ios")) {
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("autoAcceptAlerts", "true");
                capabilities.setCapability("platformVersion", SysProperties.DEVICE_VERSION);
                driver = new IOSDriver<>(new URL(SysProperties.APPIUM_URL), capabilities);
            } else {
                throw new IllegalArgumentException("unknown device os " + SysProperties.DEVICE_OS);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
