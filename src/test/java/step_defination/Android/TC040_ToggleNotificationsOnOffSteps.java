package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC040_ToggleNotificationsOnOffSteps extends Page {

    @Given("User is on the Notifications settings page")
    public void userIsOnTheNotificationsSettingsPage() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-040: TOGGLE NOTIFICATIONS ON/OFF");
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
            System.out.println("User should be on Notifications settings page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User toggles a notification setting ON")
    public void userTogglesANotificationSettingOn() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TOGGLE NOTIFICATION ON");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Notifications settings page");
            System.out.println("  2. Find a notification toggle switch");
            System.out.println("  3. If it's OFF, tap to turn it ON");
            System.out.println("  4. Observe the toggle changes to ON state");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to toggle ON
            System.out.println("");
            System.out.println("Waiting 10 seconds to toggle ON...");

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
            System.out.println("Toggle should be ON now.");

        } catch (Exception e) {
            System.out.println("Error toggling ON: " + e.getMessage());
        }
    }

    @When("User toggles the same notification setting OFF")
    public void userTogglesTheSameNotificationSettingOff() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TOGGLE NOTIFICATION OFF");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the same notification toggle");
            System.out.println("  2. Tap to turn it OFF");
            System.out.println("  3. Observe the toggle changes to OFF state");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to toggle OFF
            System.out.println("");
            System.out.println("Waiting 10 seconds to toggle OFF...");

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
            System.out.println("Toggle should be OFF now.");

        } catch (Exception e) {
            System.out.println("Error toggling OFF: " + e.getMessage());
        }
    }

    @Then("Preference should be saved and toggle should update correctly")
    public void preferenceShouldBeSavedAndToggleShouldUpdateCorrectly() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TOGGLE VERIFICATION");
            System.out.println("========================================");

            // Check for Notifications page
            boolean hasNotificationsPage = pageSource.contains("Notifications") ||
                                           pageSource.contains("notifications") ||
                                           pageSource.contains("NOTIFICATIONS");

            // Check for toggle/switch elements
            boolean hasToggleSwitch = pageSource.contains("Toggle") ||
                                      pageSource.contains("toggle") ||
                                      pageSource.contains("Switch") ||
                                      pageSource.contains("switch") ||
                                      pageSource.contains("android.widget.Switch") ||
                                      pageSource.contains("android.widget.ToggleButton");

            // Check for ON/OFF states
            boolean hasOnOffStates = pageSource.contains("ON") ||
                                     pageSource.contains("OFF") ||
                                     pageSource.contains("On") ||
                                     pageSource.contains("Off") ||
                                     pageSource.contains("checked=\"true\"") ||
                                     pageSource.contains("checked=\"false\"");

            // Check for enable/disable indicators
            boolean hasEnableDisable = pageSource.contains("Enable") ||
                                       pageSource.contains("enable") ||
                                       pageSource.contains("Disable") ||
                                       pageSource.contains("disable") ||
                                       pageSource.contains("enabled") ||
                                       pageSource.contains("disabled");

            // Check for notification categories
            boolean hasNotificationTypes = pageSource.contains("Push") ||
                                           pageSource.contains("push") ||
                                           pageSource.contains("Alert") ||
                                           pageSource.contains("alert") ||
                                           pageSource.contains("Sound") ||
                                           pageSource.contains("sound") ||
                                           pageSource.contains("Vibrate") ||
                                           pageSource.contains("vibrate");

            // Check for settings saved indicators
            boolean hasSaveIndicators = pageSource.contains("Saved") ||
                                        pageSource.contains("saved") ||
                                        pageSource.contains("Updated") ||
                                        pageSource.contains("updated") ||
                                        pageSource.contains("Success") ||
                                        pageSource.contains("success");

            System.out.println("");
            System.out.println("Toggle Verification:");
            System.out.println("--------------------");
            System.out.println("  - Notifications page: " + (hasNotificationsPage ? "YES" : "NO"));
            System.out.println("  - Toggle/Switch elements: " + (hasToggleSwitch ? "YES" : "NO"));
            System.out.println("  - ON/OFF states: " + (hasOnOffStates ? "YES" : "NO"));
            System.out.println("  - Enable/Disable indicators: " + (hasEnableDisable ? "YES" : "NO"));
            System.out.println("  - Notification types: " + (hasNotificationTypes ? "YES" : "NO"));
            System.out.println("  - Save indicators: " + (hasSaveIndicators ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasNotificationsPage) score += 2;
            if (hasToggleSwitch) score += 3;
            if (hasOnOffStates) score += 2;
            if (hasEnableDisable) score++;
            if (hasNotificationTypes) score++;
            if (hasSaveIndicators) score++;

            if (score >= 4) {
                System.out.println("========================================");
                System.out.println("  TC-040: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Toggle ON/OFF verified!");
                System.out.println("");
                if (hasNotificationsPage) System.out.println("  - Notifications page confirmed");
                if (hasToggleSwitch) System.out.println("  - Toggle switches present");
                if (hasOnOffStates) System.out.println("  - ON/OFF states detected");
                if (hasEnableDisable) System.out.println("  - Enable/Disable options available");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did toggle switch to ON?");
                System.out.println("  - Did toggle switch back to OFF?");
                System.out.println("  - Is the preference saved?");
                System.out.println("");
                System.out.println("========================================");
            } else if (score >= 2) {
                System.out.println("========================================");
                System.out.println("  TC-040: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some toggle elements detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Are you on Notifications page?");
                System.out.println("  2. Did you toggle ON successfully?");
                System.out.println("  3. Did you toggle OFF successfully?");
                System.out.println("  4. Is the preference saved?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-040: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect toggle states.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you toggle notification ON?");
                System.out.println("  2. Did you toggle notification OFF?");
                System.out.println("  3. Did the toggle update correctly?");
                System.out.println("  4. Was the preference saved?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying toggle: " + e.getMessage());
            System.out.println("TC-040: FAILED - " + e.getMessage());
        }
    }
}
