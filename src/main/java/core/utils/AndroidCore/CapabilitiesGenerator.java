package core.utils.AndroidCore;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Properties;

public class CapabilitiesGenerator {

    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
    public static ThreadLocal<Collection<String>> tags = new ThreadLocal<>();

    public static int getAnyFreePort() throws IOException {
        ServerSocket s = new ServerSocket(0);
        s.close();
        return s.getLocalPort();
    }

    public static DesiredCapabilities getAndroidCapabilities() throws IOException {

        Properties androidconfig = new Properties();
        androidconfig.load(Files.newInputStream(
                Paths.get(System.getProperty("user.dir") + "/src/test/java/config/androidconfig.properties")
        ));

        DesiredCapabilities cap = new DesiredCapabilities();
        String appDir = System.getProperty("user.dir") + "/apk/";

        if (Boolean.parseBoolean(androidconfig.getProperty("browserstack"))) {

            // BrowserStack capabilities
            cap.setCapability("browserstack.user", androidconfig.getProperty("browserStackUser"));
            cap.setCapability("browserstack.key", androidconfig.getProperty("accessKey"));

            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, androidconfig.getProperty("browserstackDevice"));
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidconfig.getProperty("browserstackOS"));
            cap.setCapability(MobileCapabilityType.APP, androidconfig.getProperty("browserstackAppId"));

        } else {

            // ---- LOCAL DEVICE CAPABILITIES ----
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, androidconfig.getProperty("platformName"));
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidconfig.getProperty("platformVersion"));
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, androidconfig.getProperty("deviceName"));

            // 🔥 FIXED: Appium Android driver requires UiAutomator2
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

            // Load APK only if androidapk is specified (skip if staging APK already installed)
            String androidApk = androidconfig.getProperty("androidapk");
            if (androidApk != null && !androidApk.trim().isEmpty()) {
                cap.setCapability(MobileCapabilityType.APP, appDir + androidApk.trim());
            }

            // Auto permissions
            cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            String appPackage = androidconfig.getProperty("appPackage");
            String appActivity = androidconfig.getProperty("appActivity");

            if (appPackage != null && !appPackage.trim().isEmpty()) {
                cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage.trim());
            }
            if (appActivity != null && !appActivity.trim().isEmpty()) {
                cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity.trim());
            }

        }

        // Common capabilities
        cap.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, true);
        cap.setCapability(MobileCapabilityType.FULL_RESET, false);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

        return cap;
    }



}
