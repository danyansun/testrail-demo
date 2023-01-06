package foodtruck.common;

import foodtruck.properties.SysProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Michelle
 */
public class BaseCase {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseCase.class);
    public AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void setupDriver() {
        this.driver = DriverInstance.of().driver;
    }

    @AfterSuite
    public void tearDown() {
        //End the running session
        if (driver != null) {
            driver.terminateApp(SysProperties.BUNDLE_ID);
            driver.quit();
            LOGGER.info("driver quited");
        }
    }
}
