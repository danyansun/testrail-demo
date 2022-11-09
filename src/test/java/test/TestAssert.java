package test;

import io.qameta.allure.Step;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author niki
 */
public class TestAssert {

    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("failure - byte arrays not same", expected, actual);
        testAssertEquals();
        testAssertFalse();
        testAssertNotNull();
    }

    @Test
    @Step("1")
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    @Step("2")
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    @Step("3")
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());
    }


}
