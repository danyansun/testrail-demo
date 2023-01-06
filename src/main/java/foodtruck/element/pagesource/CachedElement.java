package foodtruck.element.pagesource;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

/**
 * @author Cheffey
 */
public interface CachedElement extends WebElement, TakesScreenshot {
    Optional<Bounds> getCacheRect();

    Optional<String> getCacheText();

    Optional<Boolean> getCacheDisplayed();

    String getId();

    void setId(String id);

    void setParent(RemoteWebDriver driver);

    void setFileDetector(FileDetector detector);

    Bounds getRect();

    Optional<String> getCacheTestID();
}
