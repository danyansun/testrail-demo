package foodtruck.element.find;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Michelle
 */
public class RepeatFindElementByClassName extends RepeatFindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatFindElementByClassName.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public MobileElement findElementByClassName(String className) {
        return findElement(MobileBy.className(className));
    }
}
