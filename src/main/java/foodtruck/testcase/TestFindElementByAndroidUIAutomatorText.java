package foodtruck.testcase;

import foodtruck.element.find.FindElementByAndroidUIAutomator;

/**
 * @author niki
 */
public class TestFindElementByAndroidUIAutomatorText extends TestFindElement<FindElementByAndroidUIAutomator> {

    @Override
    protected FindElementByAndroidUIAutomator get() {
        return new FindElementByAndroidUIAutomator(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElementByText("Wonder");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElement("new UiSelector().textContains(\"App Automation Use ONLY\")");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElementByText("XM Test Chips & Salsa");
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
        t.findElementByText("Add delivery instructions");
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
