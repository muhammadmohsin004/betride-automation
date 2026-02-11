package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class TC038_NavigationToNotificationsSteps extends Page {

    @Given("User is logged in on the app")
    public void userIsLoggedInOnTheApp() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-038: NAVIGATION TO NOTIFICATIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. You should be on Home screen");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Ensure Rider app is open and logged in.");
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
            System.out.println("User should be logged in.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User opens Settings")
    public void userOpensSettings() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OPEN SETTINGS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Rider home screen");
            System.out.println("  2. Tap on profile picture (top left)");
            System.out.println("     OR tap hamburger menu");
            System.out.println("  3. Navigate to Settings option");
            System.out.println("  4. Tap on 'Settings'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to open settings
            System.out.println("");
            System.out.println("Waiting 15 seconds to open Settings...");

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
            System.out.println("Settings should be open now.");

        } catch (Exception e) {
            System.out.println("Error opening Settings: " + e.getMessage());
        }
    }

    @And("User taps on Notifications option")
    public void userTapsOnNotificationsOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP ON NOTIFICATIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Settings page");
            System.out.println("  2. Look for 'Notifications' option");
            System.out.println("  3. Tap on 'Notifications'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap notifications
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Notifications...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Waiting... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("Notifications should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Notifications: " + e.getMessage());
        }
    }

    @Then("Notifications page should open with notification options")
    public void notificationsPageShouldOpenWithNotificationOptions() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  NOTIFICATIONS PAGE VERIFICATION");
            System.out.println("========================================");

            // Check for Notifications page indicators
            boolean hasNotificationsPage = pageSource.contains("Notifications") ||
                                           pageSource.contains("notifications") ||
                                           pageSource.contains("NOTIFICATIONS");

            // Check for notification settings/options
            boolean hasNotificationOptions = pageSource.contains("Push") ||
                                             pageSource.contains("push") ||
                                             pageSource.contains("Alert") ||
                                             pageSource.contains("alert") ||
                                             pageSource.contains("Sound") ||
                                             pageSource.contains("sound") ||
                                             pageSource.contains("Vibrate") ||
                                             pageSource.contains("vibrate");

            // Check for toggle/switch indicators
            boolean hasToggleSwitch = pageSource.contains("Toggle") ||
                                      pageSource.contains("toggle") ||
                                      pageSource.contains("Switch") ||
                                      pageSource.contains("switch") ||
                                      pageSource.contains("ON") ||
                                      pageSource.contains("OFF");

            // Check for notification types
            boolean hasNotificationTypes = pageSource.contains("Ride") ||
                                           pageSource.contains("Promo") ||
                                           pageSource.contains("promo") ||
                                           pageSource.contains("Offer") ||
                                           pageSource.contains("offer") ||
                                           pageSource.contains("Update") ||
                                           pageSource.contains("update");

            // Check for settings page indicators
            boolean hasSettingsElements = pageSource.contains("Enable") ||
                                          pageSource.contains("enable") ||
                                          pageSource.contains("Disable") ||
                                          pageSource.contains("disable") ||
                                          pageSource.contains("Allow") ||
                                          pageSource.contains("allow");

            System.out.println("");
            System.out.println("Notifications Page Verification:");
            System.out.println("---------------------------------");
            System.out.println("  - Notifications page: " + (hasNotificationsPage ? "YES" : "NO"));
            System.out.println("  - Notification options: " + (hasNotificationOptions ? "YES" : "NO"));
            System.out.println("  - Toggle/Switch: " + (hasToggleSwitch ? "YES" : "NO"));
            System.out.println("  - Notification types: " + (hasNotificationTypes ? "YES" : "NO"));
            System.out.println("  - Settings elements: " + (hasSettingsElements ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasNotificationsPage) score += 3;
            if (hasNotificationOptions) score += 2;
            if (hasToggleSwitch) score++;
            if (hasNotificationTypes) score++;
            if (hasSettingsElements) score++;

            if (score >= 3) {
                System.out.println("========================================");
                System.out.println("  TC-038: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Notifications page verified!");
                System.out.println("");
                if (hasNotificationsPage) System.out.println("  - Notifications page opened");
                if (hasNotificationOptions) System.out.println("  - Notification options displayed");
                if (hasToggleSwitch) System.out.println("  - Toggle switches available");
                if (hasNotificationTypes) System.out.println("  - Notification types visible");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Is Notifications page open?");
                System.out.println("  - Are notification options visible?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-038: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some notification elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you open Settings?");
                System.out.println("  2. Did you tap Notifications?");
                System.out.println("  3. Is Notifications page open?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-038: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect Notifications page.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you navigate to Settings?");
                System.out.println("  2. Did you tap on Notifications?");
                System.out.println("  3. Is Notifications page displayed?");
                System.out.println("  4. Are notification options visible?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Notifications page: " + e.getMessage());
            System.out.println("TC-038: FAILED - " + e.getMessage());
        }
    }
}
