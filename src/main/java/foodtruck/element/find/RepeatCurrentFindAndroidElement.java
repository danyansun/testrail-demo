package foodtruck.element.find;

import foodtruck.element.pagesource.AndroidElementsSource;
import foodtruck.element.pagesource.VirtualElement;
import foodtruck.util.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Michelle
 */
public class RepeatCurrentFindAndroidElement extends RepeatFindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatCurrentFindAndroidElement.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public void repeatFindElement(String testId) {
        long totalElapsed = 0;
        for (int i = 0; i < count; i++) {
            StopWatch stopWatch = new StopWatch();
            String source = driver.getPageSource();
            AndroidElementsSource androidElementsSource = new AndroidElementsSource(source);
            VirtualElement element = androidElementsSource.findElement(testId);
            totalElapsed = totalElapsed + stopWatch.elapsed();
            LOGGER.info("find element elapsed={} ms", stopWatch.elapsed() / 1000000);
        }
        LOGGER.info("find element average elapsed time = {} ms", totalElapsed / count / 1000000);
    }
}
