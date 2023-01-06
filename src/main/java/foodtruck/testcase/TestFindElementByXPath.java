package foodtruck.testcase;

import foodtruck.element.find.FindElementByXPath;
import foodtruck.util.Constant;

/**
 * @author niki
 */
public class TestFindElementByXPath extends TestFindElement<FindElementByXPath>{

    @Override
    protected FindElementByXPath get() {
        return new FindElementByXPath(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByDesc("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByDesc(Constant.RESTAURANT + " restaurant");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByDesc("XM Test Chips & Salsa meal");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElementByText("ADD — $33.00");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByText("XM Test Chips & Salsa");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByDesc("address_delivery_instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByText("PICKUP");
    }


    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByText("411 Lafayette Ave, Cliffside Park, NJ, 07010");
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
