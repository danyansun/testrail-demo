package foodtruck.element.find;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindElementByXPath extends FindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindElementByXPath.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public FindElementByXPath(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void findElement(String xpathExpress) {
        findElement(MobileBy.xpath(xpathExpress));
    }

    public void findElementByText(String text) {
        findElement(String.format("//*[@text=\"%s\" or @value=\"%s\"]", text, text));
    }

    public void findElementByDesc(String desc) {
        findElement(String.format("//*[@content-desc=\"%s\" or @name=\"%s\"]", desc, desc));
    }
}
