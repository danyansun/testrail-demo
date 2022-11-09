package test;

import io.qameta.allure.Allure;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * @author niki
 */
public class TestAssert1 {

    @Test
    public void testAssertNotSame() {
        assertNotSame("should not be same Object", new Object(), new Object());
    }

    @Test
    public void testAssertNull() {
        assertNull("should be null", null);
        testAssertNotSame();

    }

    @Test
    public void testAssertSame() {
        Allure.step("hahaha");
        Integer aNumber = Integer.valueOf(768);
        assertSame("should be same", aNumber, 1);
    }

    @Test
    public void testAssertTrue() {
        assertTrue("failure - should be true", true);
    }

}
