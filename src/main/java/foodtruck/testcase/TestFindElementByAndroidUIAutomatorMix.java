package foodtruck.testcase;

import foodtruck.element.find.FindElementByAndroidUIAutomator;

/**
 * @author niki
 */
public class TestFindElementByAndroidUIAutomatorMix extends TestFindElement<FindElementByAndroidUIAutomator> {

    @Override
    protected FindElementByAndroidUIAutomator get() {
        return new FindElementByAndroidUIAutomator(driver);
    }

    @Override
    public void findWonderTab() {
        t.findElement("new UiSelector().className(\"android.view.View\").description(\"wonder_on_home_page\")");
    }

    @Override
    public void findRestaurantOnWonderRLP() {
        t.findElement("new UiSelector().className(\"android.view.ViewGroup\").descriptionContains(\"App Automation Use\")");
    }

    @Override
    public void findMealOnWonderRDP() {
        t.findElement("new UiSelector().className(\"android.widget.TextView\").text(\"XM Test Chips & Salsa\")");
    }

    @Override
    public void findAddButtonOnWonderMDP() {
        t.findElement("new UiSelector().className(\"android.widget.TextView\").description(\"take it button\")");
    }

    @Override
    public void findButtonOnShopCartPage() {
        t.findElement("new UiSelector().className(\"android.widget.TextView\").text(\"XM Test Chips & Salsa\")");
    }

    @Override
    public void findButtonOnCheckoutPage() {
        t.findElement("new UiSelector().description(\"address_delivery_instructions\").text(\"Add delivery instructions\")");
    }

    @Override
    public void findPickupButtonOnEnvoyRDP() {
        t.findElement("new UiSelector().text(\"PICKUP\").description(\"PICKUP\")");
    }

    @Override
    public void findAddressOnEnvoyRDP() {
        t.findElement("new UiSelector().className(\"android.widget.TextView\").description(\"address_on_mkp_rlp_page\")");
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
