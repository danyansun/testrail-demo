package foodtruck.testcase;

import foodtruck.common.BaseCase;
import foodtruck.element.find.RepeatFindElementByAccessibility;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Michelle
 */
public class FindElementByAccessibilityIdTest extends BaseCase {
    RepeatFindElementByAccessibility repeatFindElementByAccessibility;

    @BeforeClass
    public void initFindElement() {
        repeatFindElementByAccessibility = new RepeatFindElementByAccessibility();
        repeatFindElementByAccessibility.setCount(100);
    }

    @Test
    public void findRestaurantWithLogin() {
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin("mm@cc.com", "pwd11111");
        WonderHomePage wonderHomePage = new WonderHomePage();
        repeatFindElementByAccessibility.findElementByAccessibility("wonder_on_home_page");
    }

    @Test
    public void findRestaurantWithoutLogin() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        repeatFindElementByAccessibility.findElementByAccessibility("pickup_button_on_home_page");
    }

    @Test
    public void findLoginButton() {
        WelcomePage welcomePage = new WelcomePage();
        repeatFindElementByAccessibility.findElementByAccessibility("login_button_on_welcome_page");
    }

    @Test
    public void findBurgersOnEnvoyRLP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        repeatFindElementByAccessibility.findElementByAccessibility("Burgers_on_home_page");
    }

    @Test
    public void findElementOnEnvoyRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        envoyHomePage.clickRestaurant("Closed - Marketplace Automation USE ONLY");
        EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
        repeatFindElementByAccessibility.findElementByAccessibility("address_on_mkp_rlp_page");
    }

    @Test
    public void findRestaurantOnWonderRLP() throws InterruptedException {
        WonderHomePage wonderHomePage = new WonderHomePage();
        Thread.sleep(10000);
        repeatFindElementByAccessibility.findElementByAccessibility("XM Test Automation Use ONLY restaurant");
    }

    @Test
    public void findWonderTab() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        repeatFindElementByAccessibility.findElementByAccessibility("wonder_on_home_page");
    }

    @Test
    public void findMealOnWonderRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(1, 2000);
        repeatFindElementByAccessibility.findElementByAccessibility("XM Test Chips & Salsa meal");
    }

    @Test
    public void findAddButtonOnWonderMDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(1, 1000);
        wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
        WonderMealDetailPage mealDetailPage = new WonderMealDetailPage();
        repeatFindElementByAccessibility.findElementByAccessibility("take it button");
    }

    @Test
    public void findButtonOnShopCartPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        repeatFindElementByAccessibility.findElementByAccessibility("XM Test Chips & Salsa_cart_item");
    }

    @Test
    public void findButtonOnCheckoutPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        wonderShopCartPage.clickCheckoutButton();
        WonderCheckoutPage checkoutPage = new WonderCheckoutPage();
        repeatFindElementByAccessibility.findElementByAccessibility("address_delivery_instructions");
    }
}
