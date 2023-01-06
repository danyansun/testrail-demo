package foodtruck.testcase;

import foodtruck.common.BaseCase;
import foodtruck.element.find.RepeatCurrentFindAndroidElement;
import foodtruck.helpers.UserLoginHelper;
import foodtruck.pages.EnvoyHomePage;
import foodtruck.pages.EnvoyRestaurantDetailPage;
import foodtruck.pages.WelcomePage;
import foodtruck.pages.WonderCheckoutPage;
import foodtruck.pages.WonderHomePage;
import foodtruck.pages.WonderMealDetailPage;
import foodtruck.pages.WonderRestaurantDetailPage;
import foodtruck.pages.WonderShopCartPage;
import foodtruck.util.BaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Michelle
 */
public class CurrentFindAndroidElementTest extends BaseCase {
    protected static final Logger LOGGER = LoggerFactory.getLogger(CurrentFindAndroidElementTest.class);
    RepeatCurrentFindAndroidElement repeatCurrentFindAndroidElement;

    @BeforeTest
    public void initFindElement() {
        repeatCurrentFindAndroidElement = new RepeatCurrentFindAndroidElement();
        repeatCurrentFindAndroidElement.setCount(20);
    }

    @Test
    public void findAndroidElement() {
        WelcomePage welcomePage = new WelcomePage();
        RepeatCurrentFindAndroidElement findAndroidElement = new RepeatCurrentFindAndroidElement();
        findAndroidElement.repeatFindElement("login_button_on_welcome_page");
    }

    @Test
    public void findWonderTab() {
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin("mm@cc.com", "pwd11111");
        WonderHomePage wonderHomePage = new WonderHomePage();
        RepeatCurrentFindAndroidElement findAndroidElement = new RepeatCurrentFindAndroidElement();
        findAndroidElement.repeatFindElement("wonder_on_home_page");
    }

    @Test
    public void findBurgersOnEnvoyRLP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        RepeatCurrentFindAndroidElement findAndroidElement = new RepeatCurrentFindAndroidElement();
        findAndroidElement.setCount(20);
        findAndroidElement.repeatFindElement("Burgers_on_home_page");
    }

    @Test
    public void findRestaurantOnWonderRLP() throws InterruptedException {
        WonderHomePage wonderHomePage = new WonderHomePage();
        Thread.sleep(10000);
        RepeatCurrentFindAndroidElement findAndroidElement = new RepeatCurrentFindAndroidElement();
        findAndroidElement.setCount(20);
        findAndroidElement.repeatFindElement("XM Test Automation Use ONLY restaurant");
    }

    @Test
    public void findMealOnWonderRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        BaseUtils.swipeToUp(2, 2000);
        RepeatCurrentFindAndroidElement findAndroidElement = new RepeatCurrentFindAndroidElement();
        findAndroidElement.setCount(20);
        findAndroidElement.repeatFindElement("XM Test Chips & Salsa meal");
    }

    @Test
    public void findAddButtonOnWonderMDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(1, 1000);
        wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
        WonderMealDetailPage mealDetailPage = new WonderMealDetailPage();
        repeatCurrentFindAndroidElement.repeatFindElement("take it button");
    }

    @Test
    public void findButtonOnShopCartPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        repeatCurrentFindAndroidElement.repeatFindElement("XM Test Chips & Salsa_cart_item");
    }

    @Test
    public void findButtonOnCheckoutPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        wonderShopCartPage.clickCheckoutButton();
        WonderCheckoutPage checkoutPage = new WonderCheckoutPage();
        repeatCurrentFindAndroidElement.repeatFindElement("address_delivery_instructions");
    }

    @Test
    public void findElementOnEnvoyRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        envoyHomePage.clickRestaurant("Closed - Marketplace Automation USE ONLY");
        EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
        repeatCurrentFindAndroidElement.repeatFindElement("address_on_mkp_rlp_page");
    }
}
