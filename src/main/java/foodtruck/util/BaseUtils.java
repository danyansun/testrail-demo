package foodtruck.util;

import foodtruck.common.DriverInstance;
import foodtruck.model.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

/**
 * @author Michelle
 */
public class BaseUtils {
    static AppiumDriver<MobileElement> driver = DriverInstance.of().driver;
    static Device device = DriverInstance.of().device;
    protected static final Logger LOGGER = LoggerFactory.getLogger(DriverInstance.class);

    public static void swipeToUp(double distance, int repeats, long delayPerSwipe) {
        if (distance < 0 || distance > 1) {
            throw new Error("scroll distance must be between 0 and 1");
        }
        StopWatch stopWatch=new StopWatch();
        LOGGER.info("----start to swipe----");
        for (int i = 0; i < repeats; i++) {
            new TouchAction<>(driver)
                    .press(point(device.getWidth() / 2, (int) (device.getHeight() * distance)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(delayPerSwipe)))
                    .moveTo(point(device.getWidth() / 2, 0))
                    .release().perform();
        }
        LOGGER.info("controlledSwipe by touchAction time elapsed {}",stopWatch.elapsed()/1000000);
    }

    public static void swipeToUp(int repeats, long delayPerSwipe) {
        swipeToUp(0.5, repeats, delayPerSwipe);
    }
}
