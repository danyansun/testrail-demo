package foodtruck.element.wait;

import foodtruck.util.StopWatch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

/**
 * @author niki
 */
public abstract class WaitElement {
    protected final AppiumDriver<MobileElement> driver;

    protected WaitElement(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected abstract Logger getLogger();

    public WebElement waitVisibilityOfElementLocated(By by) {
        WebElement webElement;
        StopWatch stopWatch = new StopWatch();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        getLogger().info("wait element elapsed time = {} ms", stopWatch.elapsed() / 1000000);
        return webElement;
    }

}
