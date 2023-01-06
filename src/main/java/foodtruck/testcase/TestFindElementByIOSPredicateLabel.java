package foodtruck.testcase;

import foodtruck.element.find.FindElementByIOSPredicate;

/**
 * @author niki
 */
public class TestFindElementByIOSPredicateLabel extends TestFindElement<FindElementByIOSPredicate>{

    @Override
    protected FindElementByIOSPredicate get() {
        return new FindElementByIOSPredicate(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByLabel("wonder_on_home_page");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElementByLabel("App Automation Use ONLY American $$ App Automation Use ONLY");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByLabel("1 XM Test Chips & Salsa Crispy on the outside. Tender, juicy, organic white meat on the inside $33.00");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElementByLabel("ADD — $33.00");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElementByLabel("1 XM Test Chips & Salsa $33.00 MODIFY DELETE");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElementByLabel("Add delivery instructions");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElementByLabel("PICKUP");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElementByLabel("411 Lafayette Ave, Cliffside Park, NJ, 07010");
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
