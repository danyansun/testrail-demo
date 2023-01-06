package appium.test;

/**
 * @author niki
 */
public class TestExecutor {
    private Env env = Env.UAT;
    private String appPath;
    private int appiumPort = 4723;
    private String udid;

    public TestExecutor(Builder builder) {
        this.env = builder.env;
        this.appPath = builder.appPath;
        this.appiumPort = builder.appiumPort;
        this.udid = builder.udid;
    }

    public static Builder of() {
        return new Builder();
    }

    public static class Builder{
        private Env env;
        private String appPath;
        private int appiumPort = 4723;
        private String udid;

        public Builder env(Env env) {
            this.env = env;
            return this;
        }

        public Builder appPath(String appPath) {
            this.appPath = appPath;
            return this;
        }

        public Builder appiumPort(int appiumPort) {
            this.appiumPort = appiumPort;
            return this;
        }

        public Builder udid(String udid) {
            this.udid = udid;
            return this;
        }

        public TestExecutor build() {
            return new TestExecutor(this);
        }
    }

//    private static class ClassHolder{
//        private static final TestExecutor INSTANCE = new TestExecutor();
//    }
//
//    public static TestExecutor of() {
//        return ClassHolder.INSTANCE;
//    }


}
