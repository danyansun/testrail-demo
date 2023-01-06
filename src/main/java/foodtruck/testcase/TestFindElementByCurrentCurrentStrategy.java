package foodtruck.testcase;

import foodtruck.element.find.FindElementByCurrent;
import foodtruck.util.Constant;

/**
 * @author niki
 */
public class TestFindElementByCurrentCurrentStrategy extends TestFindElement<FindElementByCurrent> {

    @Override
    protected FindElementByCurrent get() {
        return new FindElementByCurrent(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByAccessibility("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByAccessibility(Constant.RESTAURANT + " restaurant");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByAccessibility("XM Test Chips & Salsa meal");
    }

    @Override
    public void findAddButtonOnWonderMDP(){
        t.findElementByAccessibility("take it button");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByAccessibility("XM Test Chips & Salsa_cart_item");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByAccessibility("address_delivery_instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByAccessibility("PICKUP");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByAccessibility("address_on_mkp_rlp_page");
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
