package foodtruck.testcase;

import foodtruck.common.DriverInstance;
import foodtruck.element.find.FindElement;
import foodtruck.helpers.UserLoginHelper;
import foodtruck.pages.EnvoyHomePage;
import foodtruck.pages.EnvoyRestaurantDetailPage;
import foodtruck.pages.WonderCheckoutPage;
import foodtruck.pages.WonderHomePage;
import foodtruck.pages.WonderMealDetailPage;
import foodtruck.pages.WonderRestaurantDetailPage;
import foodtruck.pages.WonderShopCartPage;
import foodtruck.properties.SysProperties;
import foodtruck.util.BaseUtils;
import foodtruck.util.Constant;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author niki
 */
public abstract class TestFindElement<T extends FindElement> {
    protected List<Long> sum = new ArrayList<>();
    protected T t;
    protected AppiumDriver<MobileElement> driver;

    protected abstract T get();

    @BeforeClass
    public void initFindElement() {
        this.driver = DriverInstance.of().driver;
        t = get();
        UserLoginHelper userLoginHelper = new UserLoginHelper();
        userLoginHelper.validUserLogin(Constant.EMAIL, Constant.PASSWORD);
    }

    @BeforeMethod
    public void restartApp() {
        driver.activateApp(SysProperties.BUNDLE_ID);
        t.setCount(100);
    }

    @AfterMethod
    public void terminalApp() {
        if (driver != null) {
            driver.terminateApp(SysProperties.BUNDLE_ID);
        }
    }

    @AfterClass
    public void removeApp() {
        if (driver != null) {
            driver.removeApp(SysProperties.BUNDLE_ID);
        }
    }

    protected abstract void findWonderTab();

    @Test
    public void testFindWonderTab() {
        new WonderHomePage();
        findWonderTab();
    }

    protected abstract void findRestaurantOnWonderRLP();

    @Test
    public void testFindRestaurantOnWonderRLP() {
        new WonderHomePage();
        findRestaurantOnWonderRLP();
    }

    protected abstract void findMealOnWonderRDP();

    @Test(invocationCount = 100)
//    @Test
    public void testFindMealOnWonderRDP() throws InterruptedException {
        if (Objects.equals(SysProperties.DEVICE_OS, "android")) {
            t.setCount(1);
        }
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant(Constant.RESTAURANT);
        Thread.sleep(5000);
        BaseUtils.swipeToUp(0.4, 2, 1000);
        findMealOnWonderRDP();
        if (Objects.equals(SysProperties.DEVICE_OS, "android")) {
            sum.add(t.getAvgTime());
            System.out.println(sum);
            System.out.println(sum.stream().reduce(Long::sum).get()/sum.size());
        }
    }

    protected abstract void findAddButtonOnWonderMDP();

    @Test
    public void testFindAddButtonOnWonderMDP() throws InterruptedException {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickRestaurant(Constant.RESTAURANT);
        Thread.sleep(5000);
        BaseUtils.swipeToUp(0.4, 2, 1000);
        WonderRestaurantDetailPage wonderRestaurantDetailPage = new WonderRestaurantDetailPage();
        wonderRestaurantDetailPage.clickMeal("XM Test Chips & Salsa");
        WonderMealDetailPage mealDetailPage = new WonderMealDetailPage();
        findAddButtonOnWonderMDP();
    }

    protected abstract void findButtonOnShopCartPage();

    @Test
    public void testFindButtonOnShopCartPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        findButtonOnShopCartPage();
    }

    protected abstract void findButtonOnCheckoutPage();

    @Test
    public void testFindButtonOnCheckoutPage() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickViewOrder();
        WonderShopCartPage wonderShopCartPage = new WonderShopCartPage();
        wonderShopCartPage.clickCheckoutButton();
        WonderCheckoutPage checkoutPage = new WonderCheckoutPage();
        findButtonOnCheckoutPage();
    }

    protected abstract void findPickupButtonOnEnvoyRDP();

    @Test
    public void testFindPickupButtonOnEnvoyRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        BaseUtils.swipeToUp(0.6, 1, 1000);
        envoyHomePage.clickRestaurant("Automation USE ONLY Marketplace");
        EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
        findPickupButtonOnEnvoyRDP();
    }

//    protected abstract void findBurgersOnEnvoyRLP();
//
//    @Test
//    public void testFindEnvoyRestaurantOnEnvoyRLP() {
//        WonderHomePage wonderHomePage = new WonderHomePage();
//        wonderHomePage.clickEnvoy();
//        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
//        findBurgersOnEnvoyRLP();
//    }

    protected abstract void findAddressOnEnvoyRDP();

    @Test
    public void testFindAddressOnEnvoyRDP() {
        WonderHomePage wonderHomePage = new WonderHomePage();
        wonderHomePage.clickEnvoy();
        EnvoyHomePage envoyHomePage = new EnvoyHomePage();
        BaseUtils.swipeToUp(0.5, 1, 1000);
        envoyHomePage.clickRestaurant("Automation USE ONLY Marketplace");
        EnvoyRestaurantDetailPage envoyRestaurantDetailPage = new EnvoyRestaurantDetailPage();
        findAddressOnEnvoyRDP();
    }
}
