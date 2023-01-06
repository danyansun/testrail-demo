package foodtruck.element.find;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author niki
 * UI Selector API
 * 1. text:
 * text(String text)
 * textContains(String text)
 * textMatches(String regex)
 * textStartsWith(String text)
 * 2. content-desc
 * description(String desc)
 * descriptionContains(String desc)
 * descriptionMatches(String regex)
 * descriptionStartsWith(String desc)
 * 3. class
 * className(String className)
 * classNameMatches(String regex)
 * 4. package
 * packageName(String name)
 * packageNameMatches(String regex)
 * 5. index and instance
 * index(int index)
 * instance(int instance)
 * 6. resource-id
 * resourceId(String id)
 * resourceIdMatches(String regex)
 * 7. unique attributes:
 * checked(boolean val)
 * clickable(boolean val)
 * enabled(boolean val)
 * focusable(boolean val)
 * focused(boolean val)
 * longClickable(boolean val)
 * scrollable(boolean val)
 * selected(boolean val)
 */
public class FindElementByAndroidUIAutomator extends FindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindElementByAndroidUIAutomator.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public FindElementByAndroidUIAutomator(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void findElement(String uiautomatorText) {
        findElement(MobileBy.AndroidUIAutomator(uiautomatorText));
    }

    public void findElementByContentDesc(String contentDesc) {
        findElement(String.format("new UiSelector().description(\"%s\")", contentDesc));
    }

    public void findElementByText(String text) {
        findElement(String.format("new UiSelector().text(\"%s\")", text));
    }


}
