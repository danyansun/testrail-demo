package foodtruck.element.find;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Michelle
 */
public class RepeatFindElementByAccessibility extends RepeatFindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatFindElementByAccessibility.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public MobileElement findElementByAccessibility(String testId) {
        return findElement(MobileBy.AccessibilityId(testId));
    }
}
