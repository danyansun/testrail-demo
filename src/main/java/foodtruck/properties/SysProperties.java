package foodtruck.properties;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Michelle
 */
public class SysProperties {
    public static String DEVICE_OS;
    public static String DEVICE_NAME;
    public static String DEVICE_VERSION;
    public static String APP_PATH;
    public static String APPIUM_URL;
    public static String BUNDLE_ID;

    static {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("sys.properties");
            Properties properties = new Properties();
            properties.load(stream);
            DEVICE_OS = properties.getProperty("device.os");
            APPIUM_URL = properties.getProperty("appium.url");
            if (DEVICE_OS.equalsIgnoreCase("android")) {
                InputStream androidSteam = ClassLoader.getSystemResourceAsStream("android.properties");
                Properties androidProperties = new Properties();
                androidProperties.load(androidSteam);
                DEVICE_NAME = androidProperties.getProperty("device.name");
                DEVICE_VERSION = androidProperties.getProperty("device.version");
                APP_PATH = androidProperties.getProperty("app.path");
                BUNDLE_ID = androidProperties.getProperty("app.bundleId");
            } else {
                InputStream iosStream = ClassLoader.getSystemResourceAsStream("ios.properties");
                Properties iosProperties = new Properties();
                iosProperties.load(iosStream);
                DEVICE_NAME = iosProperties.getProperty("device.name");
                DEVICE_VERSION = iosProperties.getProperty("device.version");
                APP_PATH = iosProperties.getProperty("app.path");
                BUNDLE_ID = iosProperties.getProperty("app.bundleId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
