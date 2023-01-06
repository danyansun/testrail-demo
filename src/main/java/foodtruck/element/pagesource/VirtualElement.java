package foodtruck.element.pagesource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class VirtualElement extends CachedElementImpl {
    public final String testID;
    public Bounds rect;
    public int parentingLevel;
    public VirtualElement parent;
    public List<VirtualElement> children = new ArrayList<>();
    public String type;
    private boolean reliable = true;
    private String text;

    public VirtualElement(String testID, Bounds cacheRect) {
        super(cacheRect);
        this.testID = testID;
    }

    public String getText() {
        return text;
    }

    public VirtualElement setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public Optional<String> getCacheTestID() {
        return Optional.ofNullable(testID);
    }

    @Override
    public Optional<String> getCacheText() {
        return Optional.ofNullable(text);
    }

    @Override
    public Bounds getRect() {
        return getCacheRect().orElse(null);
    }

    public VirtualElement setRect(Bounds rect) {
        this.rect = rect;
        return this;
    }

    @Override
    public Optional<Boolean> getCacheDisplayed() {
        return Optional.ofNullable(cacheDisplayed);
    }

    public VirtualElement setCacheDisplayed(Boolean cacheDisplayed) {
        this.cacheDisplayed = cacheDisplayed;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\t%s", parentingLevel, type, testID, rect);
    }


    public void makeUnreliable() {
        reliable = false;
    }

    public boolean isReliable() {
        return reliable;
    }

    public VirtualElement setParentingLevel(int parentingLevel) {
        this.parentingLevel = parentingLevel;
        return this;
    }

    public VirtualElement setType(String type) {
        this.type = type;
        return this;
    }

    public Optional<VirtualElement> getRootScrollView() {
        VirtualElement parentCheck = parent;
        VirtualElement rootScrollView = null;
        while (parentCheck != null) {
            if (parentCheck.type.equals("ScrollView")) {
                rootScrollView = parentCheck;
            }
            parentCheck = parentCheck.parent;
        }
        return Optional.ofNullable(rootScrollView);
    }

    public Optional<VirtualElement> firstParentScrollView() {
        VirtualElement parentCheck = parent;
        while (parentCheck != null) {
            if (parentCheck.type.equals("ScrollView")) {
                return Optional.of(parentCheck);
            }
            parentCheck = parentCheck.parent;
        }
        return Optional.empty();
    }
}