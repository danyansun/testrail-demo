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
public class WaitElementByIOSPredicate extends WaitElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaitElementByIOSPredicate.class);

    protected WaitElementByIOSPredicate(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public static WaitElementByIOSPredicate instance(AppiumDriver<MobileElement> driver) {
        return new WaitElementByIOSPredicate(driver);
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public WebElement waitElement(String selector) {
        return waitVisibilityOfElementLocated(MobileBy.iOSNsPredicateString(selector));
    }

    public WebElement waitElementByLabel(String label) {
        return waitVisibilityOfElementLocated(MobileBy.iOSNsPredicateString(String.format("label == '%s'", label)));
    }

    public WebElement waitElementByName(String name) {
        return waitVisibilityOfElementLocated(MobileBy.iOSNsPredicateString(String.format("name == '%s'", name)));
    }

}
