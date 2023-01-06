package foodtruck.element.wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author niki
 */
public class WaitElementByAndroidUIAutomator extends WaitElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaitElementByAndroidUIAutomator.class);

    protected WaitElementByAndroidUIAutomator(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public static WaitElementByAndroidUIAutomator instance(AppiumDriver<MobileElement> driver) {
        return new WaitElementByAndroidUIAutomator(driver);
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public WebElement waitElementByContentDesc(String contentDesc) {
        return waitVisibilityOfElementLocated(MobileBy.AndroidUIAutomator(String.format("new UiSelector().description(\"%s\")", contentDesc)));
    }

    public WebElement waitElementByText(String text) {
        return waitVisibilityOfElementLocated(MobileBy.AndroidUIAutomator(String.format("new UiSelector().text(\"%s\")", text)));
    }
}
