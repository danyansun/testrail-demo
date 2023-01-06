package foodtruck.testcase;

import foodtruck.element.find.FindElementByIOSPredicate;

/**
 * @author niki
 */
public class TestFindElementByIOSPredicateMix extends TestFindElement<FindElementByIOSPredicate>{

    @Override
    protected FindElementByIOSPredicate get() {
        return new FindElementByIOSPredicate(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElement("label == 'wonder_on_home_page' AND name == 'wonder_on_home_page'");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElement("label == \"App Automation Use ONLY American $$ App Automation Use ONLY\" AND name == \"App Automation Use ONLY American $$ App Automation Use ONLY\"");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElement("label == \"1 XM Test Chips & Salsa Crispy on the outside. Tender, juicy, organic white meat on the inside $33.00\" AND name == \"XM Test Chips & Salsa meal\"");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElement("label == \"ADD — $33.00\" AND name == \"take it button\"");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElement("label == \"1 XM Test Chips & Salsa $33.00 MODIFY DELETE\" AND name == \"XM Test Chips & Salsa_cart_item\"");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElement("label == \"Add delivery instructions\" AND name == \"address_delivery_instructions\"");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElement("label == \"PICKUP\" AND name == \"PICKUP\"");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElement("label == \"411 Lafayette Ave, Cliffside Park, NJ, 07010\" AND name == \"address_on_mkp_rlp_page\"");
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
