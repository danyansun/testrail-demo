package foodtruck.testcase;

import foodtruck.common.BaseCase;
import foodtruck.element.find.RepeatFindElementByCommand;
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
public class FindElementByCommandTest extends BaseCase {
    RepeatFindElementByCommand repeatFindElementByCommand;

    @BeforeClass
    public void initFindElement() {
        repeatFindElementByCommand = new RepeatFindElementByCommand();
        repeatFindElementByCommand.setCount(100);
    }

    @Test
    public void findRestaurantWithLogin() {
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin("mm@cc.com", "pwd11111");
        WonderHomePage wonderHomePage = new WonderHomePage();
        repeatFindElementByCommand.findElement("wonder_on_home_page");
    }

    @Test
    public void findRestaurantWithoutLogin() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        repeatFindElementByCommand.findElement("pickup_button_on_home_page");
    }

    @Test
    public void findLoginButton() {
        WelcomePage welcomePage = new WelcomePage();
        repeatFindElementByCommand.findElement("login_button_on_welcome_page");
    }

    @Test
    public void findBurgersOnEnvoyRLP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
//        repeatFindElementByCommand.findElement("Burgers_on_home_page");
        repeatFindElementByCommand.findElement("pickup_button_on_home_page");
    }

    @Test
    public void findElementOnEnvoyRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        envoyHomePage.clickRestaurant("Closed - Marketplace Automation USE ONLY");
        EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
        repeatFindElementByCommand.findElement("address_on_mkp_rlp_page");
    }

    @Test
    public void findRestaurantOnWonderRLP() throws InterruptedException {
        WonderHomePage wonderHomePage = new WonderHomePage();
        Thread.sleep(10000);
        repeatFindElementByCommand.findElement("XM Test Automation Use ONLY restaurant");
    }

    @Test
    public void findWonderTab() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        repeatFindElementByCommand.findElement("wonder_on_home_page");
    }

    @Test
    public void findMealOnWonderRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(1, 2000);
        repeatFindElementByCommand.findElement("XM Test Chips & Salsa meal");
    }

    @Test
    public void findAddButtonOnWonderMDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant("XM Test Automation Use ONLY");
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        BaseUtils.swipeToUp(1, 1000);
        wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
        WonderMealDetailPage mealDetailPage = new WonderMealDetailPage();
        repeatFindElementByCommand.findElement("take it button");
    }

    @Test
    public void findButtonOnShopCartPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        repeatFindElementByCommand.findElement("XM Test Chips & Salsa_cart_item");
    }

    @Test
    public void findButtonOnCheckoutPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        wonderShopCartPage.clickCheckoutButton();
        WonderCheckoutPage checkoutPage = new WonderCheckoutPage();
        repeatFindElementByCommand.findElement("address_delivery_instructions");
    }
}
