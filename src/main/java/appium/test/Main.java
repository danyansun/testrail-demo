package appium.test;

/**
 * @author niki
 */
public class Main {

    public static void main(String[] args) {
        TestExecutor testExecutor = TestExecutor.of()
            .env(Env.UAT)
            .appiumPort(4723)
            .appPath("")
            .udid("")
            .build();
    }
}
