package foodtruck.testcase;

import foodtruck.element.find.FindElementByAccessibilityId;
import foodtruck.util.Constant;

/**
 * @author niki
 */
public class TestFindElementByAccessibilityId extends TestFindElement<FindElementByAccessibilityId>{

    @Override
    protected FindElementByAccessibilityId get() {
        return new FindElementByAccessibilityId(driver);
    }

    @Override
    protected void findWonderTab() {
        t.findElementByAccessibility("wonder_on_home_page");
    }

    @Override
    protected void findRestaurantOnWonderRLP() {
        t.findElementByAccessibility(Constant.RESTAURANT + " restaurant");
    }

    @Override
    protected void findMealOnWonderRDP() {
        t.findElementByAccessibility("XM Test Chips & Salsa meal");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
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
