package foodtruck.element.find;

import foodtruck.element.pagesource.AndroidElementsSource;
import foodtruck.util.StopWatch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;

/**
 * @author niki
 */
public abstract class FindElement {
    private final AppiumDriver<MobileElement> driver;
    private long count = 100;
    private long avgTime;

    protected abstract Logger getLogger();

    protected FindElement(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected void findElement(By by) {
        long totalElapsed = 0;
        for (int i = 0; i < count; i++) {
            StopWatch stopWatch = new StopWatch();
            driver.findElement(by);
            totalElapsed = totalElapsed + stopWatch.elapsed();
            getLogger().info("find element elapsed time = {} ms", stopWatch.elapsed() / 1000000);
        }
        avgTime = totalElapsed / count / 1000000;
        getLogger().info("find element average elapsed time = {} ms", avgTime);
    }


    protected void findElement(String testId) {
        long totalElapsed = 0;
        for (int i = 0; i < count; i++) {
            StopWatch stopWatch = new StopWatch();
            String source = driver.getPageSource();
            AndroidElementsSource androidElementsSource = new AndroidElementsSource(source);
            androidElementsSource.findElement(testId);
            totalElapsed = totalElapsed + stopWatch.elapsed();
            getLogger().info("find element elapsed time = {} ms", stopWatch.elapsed() / 1000000);
        }
        avgTime = totalElapsed / count / 1000000;
        getLogger().info("find element average elapsed time = {} ms", avgTime);
    }


    public void setCount(long count) {
        this.count = count;
    }

    public long getAvgTime() {
        return avgTime;
    }
}
