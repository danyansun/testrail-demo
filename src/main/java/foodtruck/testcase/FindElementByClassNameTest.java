package foodtruck.testcase;

import foodtruck.common.BaseCase;
import foodtruck.element.find.RepeatFindElementByClassName;
import foodtruck.pages.WonderHomePage;
import foodtruck.pages.WonderRestaurantDetailPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Michelle
 */
public class FindElementByClassNameTest extends BaseCase {
    RepeatFindElementByClassName repeatFindElementByClassName;

    @BeforeClass
    public void initFindElement() {
        repeatFindElementByClassName = new RepeatFindElementByClassName();
        repeatFindElementByClassName.setCount(20);
    }

    @Test
    public void findRestaurantWithoutLogin() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        repeatFindElementByClassName.findElementByClassName("XCUIElementTypeStaticText");
//        repeatFindElementByClassName.findElementByClassName("android.widget.HorizontalScrollView");
    }

    @Test
    public void findWonderTabWithoutLogin() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        repeatFindElementByClassName.findElementByClassName("android.view.View");
    }

    @Test
    public void findCarouselOnWonderRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        repeatFindElementByClassName.findElementByClassName("android.widget.HorizontalScrollView");
    }

}
