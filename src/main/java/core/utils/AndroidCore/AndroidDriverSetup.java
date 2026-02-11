package core.utils.AndroidCore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AndroidDriverSetup {
    private static final ThreadLocal<AndroidDriver<AndroidElement>> androidDriver = new ThreadLocal<>();

    public static synchronized void androidDriver(String port) throws IOException {
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") +
                "/src/test/java/config/androidconfig.properties")));

        DesiredCapabilities capabilities = CapabilitiesGenerator.getAndroidCapabilities();
        AndroidDriver<AndroidElement> driver;

        if (Boolean.parseBoolean(props.getProperty("browserstack"))) {

            capabilities.setCapability("browserstack.user", props.getProperty("browserStackUser"));
            capabilities.setCapability("browserstack.key", props.getProperty("accessKey"));

            String browserStackURL = "http://hub-cloud.browserstack.com/wd/hub";
            driver = new AndroidDriver<>(new URL(browserStackURL), capabilities);

        } else {
            // ✅ FIXED FOR APPIUM V2 → REMOVE /wd/hub
            String localUrl = "http://127.0.0.1:" + port;
            driver = new AndroidDriver<>(new URL(localUrl), capabilities);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        androidDriver.set(driver);
        System.out.println("Android driver selected successfully\n");
    }

    public static void quitAndroidDriver() {
        try {
            if (androidDriver.get() != null) {
                androidDriver.get().quit();
                androidDriver.remove();
            } else {
                System.out.println("Driver not initialized.");
            }
        } catch (Exception e) {
            System.out.println("Error while quitting driver: " + e.getMessage());
        }
    }

    public static AndroidDriver<AndroidElement> getAndroidDriver() {
        if (androidDriver.get() != null) {
            return androidDriver.get();
        } else {
            throw new IllegalStateException(
                    "Driver not initialized. Call androidDriver() before using getAndroidDriver()");
        }
    }
}
