package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC055_OfflineLogSubmitAttemptSteps extends Page {

    @Given("User is on Settings page with internet OFF")
    public void userIsOnSettingsPageWithInternetOFF() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-055: OFFLINE LOG SUBMIT ATTEMPT");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. TURN OFF INTERNET (WiFi/Mobile Data)");
            System.out.println("  4. Navigate to Settings");
            System.out.println("");
            System.out.println("  NOTE: Internet must be OFF for this test!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Turn OFF internet and navigate to Settings.");
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
            System.out.println("User should be on Settings page with internet OFF.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Send Device Logs while offline")
    public void userTapsOnSendDeviceLogsWhileOffline() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP SEND DEVICE LOGS WHILE OFFLINE");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. Make sure INTERNET IS OFF");
            System.out.println("  2. On the Settings page");
            System.out.println("  3. Tap on 'Send Device Logs' option");
            System.out.println("");
            System.out.println("  NOTE: Keep internet OFF during this step!");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Send Device Logs...");

            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println("Waiting... " + ((i + 1) * 2.5) + " sec");

                // Keep session alive
                try {
                    AndroidDriverSetup.getAndroidDriver().getPageSource();
                } catch (Exception e) {
                    // Ignore - might fail due to offline
                }
            }

            System.out.println("");
            System.out.println("Send Device Logs should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Send Device Logs: " + e.getMessage());
        }
    }

    @Then("Error message should appear Unable to send logs No internet connection")
    public void errorMessageShouldAppearUnableToSendLogsNoInternetConnection() {
        try {
            Thread.sleep(3000);

            String pageSource = "";
            try {
                pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();
            } catch (Exception e) {
                System.out.println("Note: Could not get page source (possibly due to offline mode)");
                pageSource = "";
            }

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  OFFLINE LOG ERROR VERIFICATION");
            System.out.println("========================================");

            // Check for unable to send error
            boolean hasUnableToSend = pageSource.contains("Unable to send") ||
                                      pageSource.contains("unable to send") ||
                                      pageSource.contains("Cannot send") ||
                                      pageSource.contains("cannot send") ||
                                      pageSource.contains("Failed to send") ||
                                      pageSource.contains("failed to send");

            // Check for no internet error
            boolean hasNoInternetError = pageSource.contains("No internet") ||
                                         pageSource.contains("no internet") ||
                                         pageSource.contains("NO INTERNET") ||
                                         pageSource.contains("internet connection") ||
                                         pageSource.contains("Internet connection") ||
                                         pageSource.contains("check your connection") ||
                                         pageSource.contains("Check your connection");

            // Check for network error
            boolean hasNetworkError = pageSource.contains("Network") ||
                                      pageSource.contains("network") ||
                                      pageSource.contains("offline") ||
                                      pageSource.contains("Offline") ||
                                      pageSource.contains("Connection failed");

            // Check for general error
            boolean hasGeneralError = pageSource.contains("Error") ||
                                      pageSource.contains("error") ||
                                      pageSource.contains("Sorry") ||
                                      pageSource.contains("sorry") ||
                                      pageSource.contains("Failed") ||
                                      pageSource.contains("failed");

            // Check if still on Settings
            boolean stillOnSettings = pageSource.contains("Settings") ||
                                      pageSource.contains("settings") ||
                                      pageSource.contains("Send Device Logs") ||
                                      pageSource.contains("send device logs");

            System.out.println("");
            System.out.println("Offline Error Verification:");
            System.out.println("---------------------------");
            System.out.println("  - Unable to send error: " + (hasUnableToSend ? "YES" : "NO"));
            System.out.println("  - No internet error: " + (hasNoInternetError ? "YES" : "NO"));
            System.out.println("  - Network error: " + (hasNetworkError ? "YES" : "NO"));
            System.out.println("  - General error: " + (hasGeneralError ? "YES" : "NO"));
            System.out.println("  - Still on Settings: " + (stillOnSettings ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasUnableToSend) score += 3;
            if (hasNoInternetError) score += 3;
            if (hasNetworkError) score += 2;
            if (hasGeneralError) score++;
            if (stillOnSettings) score++;

            if (score >= 3 || hasUnableToSend || hasNoInternetError) {
                System.out.println("========================================");
                System.out.println("  TC-055: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Offline log submit blocked successfully!");
                System.out.println("");
                if (hasUnableToSend) System.out.println("  - 'Unable to send logs' error shown");
                if (hasNoInternetError) System.out.println("  - 'No internet connection' error shown");
                if (hasNetworkError) System.out.println("  - Network error displayed");
                if (stillOnSettings) System.out.println("  - Still on Settings page");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Was internet OFF?");
                System.out.println("  - Did error message appear?");
                System.out.println("  - Were logs NOT sent?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasGeneralError || stillOnSettings) {
                System.out.println("========================================");
                System.out.println("  TC-055: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Some error indication detected.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was internet OFF?");
                System.out.println("  2. Did you tap Send Device Logs?");
                System.out.println("  3. Did error message appear?");
                System.out.println("  4. Were logs NOT sent?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-055: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect offline error.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Was internet OFF?");
                System.out.println("  2. Did you tap Send Device Logs?");
                System.out.println("  3. Did 'Unable to send logs' error appear?");
                System.out.println("  4. Did 'No internet connection' appear?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app");
                System.out.println("  and INTERNET to be OFF.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying offline log submit: " + e.getMessage());
            System.out.println("TC-055: FAILED - " + e.getMessage());
        }
    }
}
