package foodtruck.pages;

import foodtruck.common.DriverInstance;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Michelle
 */
public class BasePage {
    private static final int TIMEOUT = 1;
    private static final int TIMEOUT_LONG = 120;
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait driverWait;
    public WebDriverWait driverLongWait;

    public BasePage(By locator) {
        this.driver = DriverInstance.of().driver;
        this.driverWait = new WebDriverWait(this.driver, TIMEOUT);
        this.driverLongWait = new WebDriverWait(this.driver, TIMEOUT_LONG);
        driverLongWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driverLongWait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId("loading symbol")));
    }
}
