package foodtruck.element.pagesource;

import io.appium.java_client.MobileElement;

import java.util.Map;
import java.util.Optional;

public class CachedElementImpl extends MobileElement implements CachedElement {
    private Bounds cacheRect;
    private String cacheText;
    protected Boolean cacheDisplayed;
    private String cacheTestID;
//    private final Logger logger = Logger.getLogger(CachedElement.class);

    public CachedElementImpl(Bounds cacheRect) {
        cacheText = null;
        this.cacheRect = cacheRect;
    }

    public CachedElementImpl(Map<?, ?> responseAttributes) {
        cacheText = interpretTextCache(responseAttributes);
        cacheRect = interpretRectCache(responseAttributes);
        cacheDisplayed = interpretDisplayed(responseAttributes);
        cacheTestID = interpretCacheTestID(responseAttributes);
    }

    @Override
    public Bounds getRect() {
        return new Bounds(super.getRect());
    }

    @Override
    public Optional<Bounds> getCacheRect() {
        return Optional.ofNullable(cacheRect);
    }

    @Override
    public Optional<String> getCacheText() {
        return Optional.ofNullable(cacheText);
    }

    @Override
    public Optional<Boolean> getCacheDisplayed() {
        if (cacheDisplayed == null) {
            System.out.println("Fail to read from cache, need fetch again");
        }
        return Optional.ofNullable(cacheDisplayed);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public Optional<String> getCacheTestID() {
        return Optional.ofNullable(cacheTestID);
    }

    private Bounds interpretRectCache(Map<?, ?> responseAttributes) {
        Map<?, ?> rect = (Map<?, ?>) responseAttributes.get("rect");
        return rect == null ? null : new Bounds(rect);
    }

    private String interpretTextCache(Map<?, ?> responseAttributes) {
        return (String) responseAttributes.get("text");
    }

    private String interpretCacheTestID(Map<?, ?> responseAttributes) {
        return (String) responseAttributes.get("attribute/content-desc");
    }

    private Boolean interpretDisplayed(Map<?, ?> responseAttributes) {
        Object displayed = responseAttributes.get("displayed");
        if (displayed == null) {
            return null;
        } else if (displayed instanceof Boolean) {
            return (Boolean) displayed;
        } else if (displayed instanceof String) {
            return Boolean.valueOf((String) displayed);
        } else {
            throw new RuntimeException();
        }
    }
}
