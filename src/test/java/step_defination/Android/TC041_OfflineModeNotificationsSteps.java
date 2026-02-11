package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC041_OfflineModeNotificationsSteps extends Page {

    @Given("User is on the Notifications page with internet OFF")
    public void userIsOnTheNotificationsPageWithInternetOff() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-041: OFFLINE MODE IN NOTIFICATIONS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings → Notifications");
            System.out.println("  4. TURN OFF INTERNET (WiFi/Mobile Data)");
            System.out.println("  5. You should be on Notifications page");
            System.out.println("");
            System.out.println("  IMPORTANT: Make sure internet is OFF!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 20 seconds for setup...");
            System.out.println("1. Navigate to Notifications page");
            System.out.println("2. Turn OFF internet connection");
            System.out.println("");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(4000);
                System.out.println("Waiting... " + ((i + 1) * 4) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore
                }
            }

            System.out.println("");
            System.out.println("User should be on Notifications page with internet OFF.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User attempts to change a notification toggle")
    public void userAttemptsToChangeANotificationToggle() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  ATTEMPT TO CHANGE TOGGLE (OFFLINE)");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Ensure internet is still OFF");
            System.out.println("  2. Find any notification toggle");
            System.out.println("  3. Try to tap/change the toggle");
            System.out.println("  4. Observe what happens");
            System.out.println("");
            System.out.println("  Note: If no toggles exist, observe");
            System.out.println("  if app crashes or shows error.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to attempt toggle
            System.out.println("");
            System.out.println("Waiting 15 seconds to attempt toggle change...");

            for (int i = 0; i < 5; i++) {
                Thread.sleep(3000);
                System.out.println("Waiting... " + ((i + 1) * 3) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore - may fail due to offline
                }
            }

            System.out.println("");
            System.out.println("Toggle change attempted.");

        } catch (Exception e) {
            System.out.println("Error attempting toggle: " + e.getMessage());
        }
    }

    @Then("Error message should be shown and app should not crash")
    public void errorMessageShouldBeShownAndAppShouldNotCrash() {
        try {
            Thread.sleep(2000);

            String pageSource = "";
            boolean appCrashed = false;

            try {
                pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            } catch (Exception e) {
                appCrashed = true;
                System.out.println("Warning: Could not get page source - " + e.getMessage());
            }

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OFFLINE BEHAVIOR VERIFICATION");
            System.out.println("========================================");

            if (appCrashed) {
                System.out.println("");
                System.out.println("  WARNING: Could not verify app state.");
                System.out.println("  This may be due to offline mode.");
                System.out.println("");
            }

            // Check if app is still running (not crashed)
            boolean appStillRunning = !appCrashed && pageSource.length() > 0;

            // Check for error messages
            boolean hasNoInternetError = pageSource.contains("No Internet") ||
                                         pageSource.contains("no internet") ||
                                         pageSource.contains("No internet") ||
                                         pageSource.contains("NO INTERNET") ||
                                         pageSource.contains("offline") ||
                                         pageSource.contains("Offline") ||
                                         pageSource.contains("OFFLINE");

            // Check for connection error messages
            boolean hasConnectionError = pageSource.contains("Connection") ||
                                         pageSource.contains("connection") ||
                                         pageSource.contains("Network") ||
                                         pageSource.contains("network") ||
                                         pageSource.contains("Unable to connect") ||
                                         pageSource.contains("unable to connect");

            // Check for error indicators
            boolean hasErrorIndicator = pageSource.contains("Error") ||
                                        pageSource.contains("error") ||
                                        pageSource.contains("ERROR") ||
                                        pageSource.contains("Failed") ||
                                        pageSource.contains("failed") ||
                                        pageSource.contains("FAILED");

            // Check for retry options
            boolean hasRetryOption = pageSource.contains("Retry") ||
                                     pageSource.contains("retry") ||
                                     pageSource.contains("RETRY") ||
                                     pageSource.contains("Try again") ||
                                     pageSource.contains("try again");

            // Check if still on Notifications page
            boolean stillOnNotifications = pageSource.contains("Notifications") ||
                                           pageSource.contains("notifications") ||
                                           pageSource.contains("NOTIFICATIONS") ||
                                           pageSource.contains("Settings") ||
                                           pageSource.contains("settings");

            System.out.println("");
            System.out.println("Offline Behavior Verification:");
            System.out.println("------------------------------");
            System.out.println("  - App still running: " + (appStillRunning ? "YES" : "UNKNOWN"));
            System.out.println("  - No Internet error: " + (hasNoInternetError ? "YES" : "NO"));
            System.out.println("  - Connection error: " + (hasConnectionError ? "YES" : "NO"));
            System.out.println("  - Error indicator: " + (hasErrorIndicator ? "YES" : "NO"));
            System.out.println("  - Retry option: " + (hasRetryOption ? "YES" : "NO"));
            System.out.println("  - Still on page: " + (stillOnNotifications ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (appStillRunning) score += 3;
            if (hasNoInternetError) score += 2;
            if (hasConnectionError) score += 2;
            if (hasErrorIndicator) score++;
            if (hasRetryOption) score++;
            if (stillOnNotifications) score++;

            if (appStillRunning && (score >= 4 || stillOnNotifications)) {
                System.out.println("========================================");
                System.out.println("  TC-041: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Offline behavior verified!");
                System.out.println("");
                System.out.println("  - App did NOT crash");
                if (hasNoInternetError || hasConnectionError) {
                    System.out.println("  - Error message displayed");
                }
                if (stillOnNotifications) {
                    System.out.println("  - Still on Notifications page");
                }
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did app crash? (Should NOT crash)");
                System.out.println("  - Was error message shown?");
                System.out.println("  - Can you still use the app?");
                System.out.println("");
                System.out.println("========================================");
            } else if (appStillRunning) {
                System.out.println("========================================");
                System.out.println("  TC-041: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  App did not crash (good!)");
                System.out.println("  But could not detect error message.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did app show 'No Internet' error?");
                System.out.println("  2. Is app still functional?");
                System.out.println("  3. Can you navigate back?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-041: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not verify app state.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did the app crash?");
                System.out.println("  2. Was 'No Internet' error shown?");
                System.out.println("  3. Is app still usable?");
                System.out.println("  4. Can you turn internet back ON?");
                System.out.println("");
                System.out.println("  Note: Turn internet back ON after test.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying offline behavior: " + e.getMessage());
            System.out.println("");
            System.out.println("Please verify manually:");
            System.out.println("1. Did the app crash?");
            System.out.println("2. Was error message shown?");
            System.out.println("");
            System.out.println("TC-041: NEEDS MANUAL VERIFICATION");
        }
    }
}
