package foodtruck.element.find;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author niki
 */
public class FindElementByAccessibilityId extends FindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindElementByAccessibilityId.class);

    public FindElementByAccessibilityId(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public void findElementByAccessibility(String testId) {
        findElement(MobileBy.AccessibilityId(testId));
    }
}
