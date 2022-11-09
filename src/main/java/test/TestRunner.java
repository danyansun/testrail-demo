package test;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author niki
 */
public class TestRunner {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new AllureJunit4());
        Result result = jUnitCore.run(TestAssert.class);
        System.out.println("result.getRunTime() = " + result.getRunTime());
        for (Failure failure : result.getFailures()) {
            System.out.println("failure.toString() = " + failure.toString());
        }
        System.out.println("result.wasSuccessful() = " + result.wasSuccessful());
    }
}
