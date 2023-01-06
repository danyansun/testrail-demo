package foodtruck.element.find;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author niki
 * Available Attributes:
 * name: element's accessibilityId or element's label if accessibilityId is not set
 * value: element's value
 * label: element's label value
 * rect: element's rectangle as a dictionary with the following keys: x, y, width, height
 * type: element's type, string
 * enabled: whether the element is enabled or not, 1/0
 * visible: whether the element is displayed or not, 1/0
 * accessible: whether the element is accessible or not, 1/0
 * accessibilityContainer: whether the element is an accessibility container or not, 1/0
 * Example:
 * 1. type == 'XCUIElementTypeButton' AND value BEGINSWITH[c] 'bla' AND visible == 1
 * ==> find elements of type XCUIElementTypeButton whose value starts with Bla/bla/BLA and which are visible
 * 2. type IN {'XCUIElementTypeIcon','XCUIElementTypeImage'} AND visible == 1
 * ==> find all visible icons and images
 * 3. type == 'XCUIElementTypeCell' AND rect.width > 100
 * ==> find all cells whose width is greater than 100
 * 4. type == 'XCUIElementTypeCheckBox' AND (visible == 1 OR enabled == 1)
 * ==> find all check boxes, which are visible or enabled
 */

public class FindElementByIOSPredicate extends FindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindElementByIOSPredicate.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public FindElementByIOSPredicate(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void findElement(String selector) {
        findElement(MobileBy.iOSNsPredicateString(selector));
    }

    public void findElementByLabel(String label) {
        findElement(String.format("label == \"%s\"", label));
    }

    public void findElementByName(String name) {
        findElement(String.format("name == \"%s\"", name));
    }
}
