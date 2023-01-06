package foodtruck.element.find;

import com.google.common.collect.ImmutableMap;
import foodtruck.element.pagesource.CachedElement;
import foodtruck.element.pagesource.CachedElementImpl;
import foodtruck.util.StopWatch;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author Michelle
 */
public class RepeatFindElementByCommand extends RepeatFindElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatFindElementByCommand.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    public CachedElement findElement(String testId) {
        long totalElapsed = 0;
        CachedElement cachedElement = null;
        for (int i = 0; i < count; i++) {
            StopWatch stopWatch = new StopWatch();
            Command command = new Command(driver.getSessionId(), DriverCommand.FIND_ELEMENT
                    , ImmutableMap.of("using", "accessibility id", "value", testId));
            try {

                Response response = driver.getCommandExecutor().execute(command);
                Object respondValue = response.getValue();
                cachedElement = interpretElement(respondValue, driver);
            } catch (IOException e) {
                e.printStackTrace();
            }
            totalElapsed = totalElapsed + stopWatch.elapsed();
            getLogger().info("find element elapsed time = {} ms", stopWatch.elapsed() / 1000000);
        }
        getLogger().info("find element average elapsed time = {} ms", totalElapsed / count / 1000000);
        return cachedElement;
    }

    public static CachedElement interpretElement(Object respondValue, RemoteWebDriver driver) {
        if (respondValue instanceof NoSuchElementException) {
            return null;
        }
        if (respondValue instanceof StaleElementReferenceException) {
            throw (StaleElementReferenceException) respondValue;
        }
        if (respondValue instanceof WebDriverException) {//must filter noSuchElementException first
            throw (WebDriverException) respondValue;
        }
        if (respondValue instanceof RemoteWebElement) {
            return toCachedElement((RemoteWebElement) respondValue, driver);
        }
        if (respondValue instanceof Map<?, ?>) {
            LOGGER.info("respondValue = " + respondValue);
            Map<?, ?> resultAsMap = (Map<?, ?>) respondValue;
            CachedElement element = new CachedElementImpl(resultAsMap);
            element.setId(String.valueOf(resultAsMap.get("ELEMENT")));
            element.setParent(driver);
            element.setFileDetector(driver.getFileDetector());
            return element;
        }
        String message = String.format("unable to interpretElements respondValue Type: %s, respondValue: %s", respondValue.getClass(), respondValue);
        LOGGER.error(message);
        return null;
    }

    private static CachedElement toCachedElement(RemoteWebElement respondValue, RemoteWebDriver driver) {
        CachedElement element = new CachedElementImpl(Collections.EMPTY_MAP);
        element.setId(respondValue.getId());
        element.setParent(driver);
        element.setFileDetector(driver.getFileDetector());
        return element;
    }
}
