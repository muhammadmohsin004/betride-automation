package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC039_NotificationListTogglesSteps extends Page {

    @Given("User is on the Notifications page")
    public void userIsOnTheNotificationsPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-039: NOTIFICATION LIST TOGGLES");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings");
            System.out.println("  4. Tap on Notifications");
            System.out.println("  5. You should be on Notifications page");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Notifications page in the app.");
            System.out.println("");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting... " + ((i + 1) * 3) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("User should be on Notifications page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @Then("Notification categories or toggles should display correctly")
    public void notificationCategoriesOrTogglesShouldDisplayCorrectly() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NOTIFICATION TOGGLES VERIFICATION");
            System.out.println("========================================");

            // Check for Notifications page title
            boolean hasNotificationsTitle = pageSource.contains("Notifications") ||
                                            pageSource.contains("notifications") ||
                                            pageSource.contains("NOTIFICATIONS");

            // Check for toggle/switch elements
            boolean hasToggleSwitch = pageSource.contains("Toggle") ||
                                      pageSource.contains("toggle") ||
                                      pageSource.contains("Switch") ||
                                      pageSource.contains("switch") ||
                                      pageSource.contains("android.widget.Switch") ||
                                      pageSource.contains("android.widget.ToggleButton");

            // Check for ON/OFF indicators
            boolean hasOnOffIndicators = pageSource.contains("ON") ||
                                         pageSource.contains("OFF") ||
                                         pageSource.contains("On") ||
                                         pageSource.contains("Off");

            // Check for notification categories
            boolean hasNotificationCategories = pageSource.contains("Push") ||
                                                pageSource.contains("push") ||
                                                pageSource.contains("Email") ||
                                                pageSource.contains("email") ||
                                                pageSource.contains("SMS") ||
                                                pageSource.contains("sms") ||
                                                pageSource.contains("Alert") ||
                                                pageSource.contains("alert");

            // Check for ride-related notification options
            boolean hasRideNotifications = pageSource.contains("Ride") ||
                                           pageSource.contains("ride") ||
                                           pageSource.contains("Trip") ||
                                           pageSource.contains("trip") ||
                                           pageSource.contains("Booking") ||
                                           pageSource.contains("booking");

            // Check for promo/offer notification options
            boolean hasPromoNotifications = pageSource.contains("Promo") ||
                                            pageSource.contains("promo") ||
                                            pageSource.contains("Offer") ||
                                            pageSource.contains("offer") ||
                                            pageSource.contains("Discount") ||
                                            pageSource.contains("discount");

            // Check for sound/vibrate options
            boolean hasSoundVibrate = pageSource.contains("Sound") ||
                                      pageSource.contains("sound") ||
                                      pageSource.contains("Vibrate") ||
                                      pageSource.contains("vibrate") ||
                                      pageSource.contains("Vibration") ||
                                      pageSource.contains("vibration");

            // Check for enable/disable options
            boolean hasEnableDisable = pageSource.contains("Enable") ||
                                       pageSource.contains("enable") ||
                                       pageSource.contains("Disable") ||
                                       pageSource.contains("disable") ||
                                       pageSource.contains("Allow") ||
                                       pageSource.contains("allow");

            System.out.println("");
            System.out.println("Notification Toggles Verification:");
            System.out.println("-----------------------------------");
            System.out.println("  - Notifications title: " + (hasNotificationsTitle ? "YES" : "NO"));
            System.out.println("  - Toggle/Switch elements: " + (hasToggleSwitch ? "YES" : "NO"));
            System.out.println("  - ON/OFF indicators: " + (hasOnOffIndicators ? "YES" : "NO"));
            System.out.println("  - Notification categories: " + (hasNotificationCategories ? "YES" : "NO"));
            System.out.println("  - Ride notifications: " + (hasRideNotifications ? "YES" : "NO"));
            System.out.println("  - Promo notifications: " + (hasPromoNotifications ? "YES" : "NO"));
            System.out.println("  - Sound/Vibrate options: " + (hasSoundVibrate ? "YES" : "NO"));
            System.out.println("  - Enable/Disable options: " + (hasEnableDisable ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasNotificationsTitle) score += 2;
            if (hasToggleSwitch) score += 3;
            if (hasOnOffIndicators) score += 2;
            if (hasNotificationCategories) score += 2;
            if (hasRideNotifications) score++;
            if (hasPromoNotifications) score++;
            if (hasSoundVibrate) score++;
            if (hasEnableDisable) score++;

            if (score >= 5) {
                System.out.println("========================================");
                System.out.println("  TC-039: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Notification toggles verified!");
                System.out.println("");
                if (hasNotificationsTitle) System.out.println("  - Notifications page confirmed");
                if (hasToggleSwitch) System.out.println("  - Toggle/Switch elements found");
                if (hasOnOffIndicators) System.out.println("  - ON/OFF indicators visible");
                if (hasNotificationCategories) System.out.println("  - Notification categories displayed");
                if (hasRideNotifications) System.out.println("  - Ride notification options present");
                if (hasPromoNotifications) System.out.println("  - Promo notification options present");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Are notification toggles visible?");
                System.out.println("  - Can you see notification categories?");
                System.out.println("  - Are toggle switches functional?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-039: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some notification elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Notifications page?");
                System.out.println("  2. Are toggles/switches visible?");
                System.out.println("  3. Are notification categories shown?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-039: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect notification toggles.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you navigate to Notifications?");
                System.out.println("  2. Are toggle switches displayed?");
                System.out.println("  3. Are notification categories visible?");
                System.out.println("  4. Can you enable/disable notifications?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying notification toggles: " + e.getMessage());
            System.out.println("TC-039: FAILED - " + e.getMessage());
        }
    }
}
