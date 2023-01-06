package foodtruck.testcase;

import foodtruck.element.find.FindElementByAndroidUIAutomator;
import foodtruck.util.Constant;

/**
 * @author niki
 */
public class TestFindElementByAndroidUIAutomatorDesc extends TestFindElement<FindElementByAndroidUIAutomator> {

    @Override
    protected FindElementByAndroidUIAutomator get() {
        return new FindElementByAndroidUIAutomator(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByContentDesc("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByContentDesc(Constant.RESTAURANT + " restaurant");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByContentDesc("XM Test Chips & Salsa meal");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElementByContentDesc("take it button");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByContentDesc("XM Test Chips & Salsa_cart_item");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByContentDesc("address_delivery_instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByContentDesc("PICKUP");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByContentDesc("address_on_mkp_rlp_page");
    }

    @Override
    public void testFindWonderTab() {
        super.testFindWonderTab();
    }

    @Override
    public void testFindRestaurantOnWonderRLP() {
        super.testFindRestaurantOnWonderRLP();
    }

    @Override
    public void testFindMealOnWonderRDP() throws InterruptedException {
        super.testFindMealOnWonderRDP();
    }

    @Override
    public void testFindAddButtonOnWonderMDP() throws InterruptedException {
        super.testFindAddButtonOnWonderMDP();
    }

    @Override
    public void testFindButtonOnShopCartPage() {
        super.testFindButtonOnShopCartPage();
    }

    @Override
    public void testFindButtonOnCheckoutPage() {
        super.testFindButtonOnCheckoutPage();
    }

    @Override
    public void testFindPickupButtonOnEnvoyRDP() {
        super.testFindPickupButtonOnEnvoyRDP();
    }

    @Override
    public void testFindAddressOnEnvoyRDP() {
        super.testFindAddressOnEnvoyRDP();
    }
}
