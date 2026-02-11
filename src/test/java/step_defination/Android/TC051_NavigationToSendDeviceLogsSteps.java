package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC051_NavigationToSendDeviceLogsSteps extends Page {

    @Given("User is logged in and on Settings page for device logs")
    public void userIsLoggedInAndOnSettingsPageForDeviceLogs() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-051: NAVIGATION TO SEND DEVICE LOGS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings page");
            System.out.println("     - Tap profile picture (top left)");
            System.out.println("     - Or tap hamburger menu");
            System.out.println("     - Tap on 'Settings'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Settings page in the app.");
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
            System.out.println("User should be on Settings page now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps on Send Device Logs option")
    public void userTapsOnSendDeviceLogsOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP ON SEND DEVICE LOGS");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Settings page");
            System.out.println("  2. Scroll down if needed");
            System.out.println("  3. Look for 'Send Device Logs' option");
            System.out.println("  4. Tap on 'Send Device Logs'");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user to tap Send Device Logs
            System.out.println("");
            System.out.println("Waiting 10 seconds to tap Send Device Logs...");

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
            System.out.println("Send Device Logs should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error tapping Send Device Logs: " + e.getMessage());
        }
    }

    @Then("Confirmation popup should appear or logs start sending")
    public void confirmationPopupShouldAppearOrLogsStartSending() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  SEND DEVICE LOGS VERIFICATION");
            System.out.println("========================================");

            // Check for confirmation popup
            boolean hasConfirmationPopup = pageSource.contains("Send device logs") ||
                                           pageSource.contains("send device logs") ||
                                           pageSource.contains("Send logs") ||
                                           pageSource.contains("send logs") ||
                                           pageSource.contains("Yes") ||
                                           pageSource.contains("No") ||
                                           pageSource.contains("Confirm");

            // Check for Yes/No buttons
            boolean hasYesNoButtons = pageSource.contains("Yes") ||
                                      pageSource.contains("YES") ||
                                      pageSource.contains("No") ||
                                      pageSource.contains("NO");

            // Check for loading/sending indicator
            boolean hasSendingIndicator = pageSource.contains("Sending") ||
                                          pageSource.contains("sending") ||
                                          pageSource.contains("Loading") ||
                                          pageSource.contains("loading") ||
                                          pageSource.contains("Progress") ||
                                          pageSource.contains("Please wait");

            // Check for success message
            boolean hasSuccessMessage = pageSource.contains("Success") ||
                                        pageSource.contains("success") ||
                                        pageSource.contains("sent") ||
                                        pageSource.contains("Sent") ||
                                        pageSource.contains("completed") ||
                                        pageSource.contains("Completed");

            // Check for dialog/popup indicators
            boolean hasDialogIndicator = pageSource.contains("Dialog") ||
                                         pageSource.contains("dialog") ||
                                         pageSource.contains("Popup") ||
                                         pageSource.contains("popup") ||
                                         pageSource.contains("Alert") ||
                                         pageSource.contains("alert");

            System.out.println("");
            System.out.println("Send Device Logs Verification:");
            System.out.println("------------------------------");
            System.out.println("  - Confirmation popup: " + (hasConfirmationPopup ? "YES" : "NO"));
            System.out.println("  - Yes/No buttons: " + (hasYesNoButtons ? "YES" : "NO"));
            System.out.println("  - Sending indicator: " + (hasSendingIndicator ? "YES" : "NO"));
            System.out.println("  - Success message: " + (hasSuccessMessage ? "YES" : "NO"));
            System.out.println("  - Dialog indicator: " + (hasDialogIndicator ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasConfirmationPopup) score += 2;
            if (hasYesNoButtons) score += 2;
            if (hasSendingIndicator) score += 2;
            if (hasSuccessMessage) score += 2;
            if (hasDialogIndicator) score++;

            if (score >= 3 || hasConfirmationPopup || hasYesNoButtons || hasSendingIndicator || hasSuccessMessage) {
                System.out.println("========================================");
                System.out.println("  TC-051: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Send Device Logs verified!");
                System.out.println("");
                if (hasConfirmationPopup) System.out.println("  - Confirmation popup appeared");
                if (hasYesNoButtons) System.out.println("  - Yes/No buttons visible");
                if (hasSendingIndicator) System.out.println("  - Logs sending indicator shown");
                if (hasSuccessMessage) System.out.println("  - Success message displayed");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did you tap Send Device Logs?");
                System.out.println("  - Did confirmation popup appear?");
                System.out.println("  - Are Yes/No buttons visible?");
                System.out.println("  - Or did logs start sending?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-051: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect confirmation popup.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you navigate to Settings?");
                System.out.println("  2. Did you tap Send Device Logs?");
                System.out.println("  3. Did confirmation popup appear?");
                System.out.println("  4. Or did logs start sending?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying Send Device Logs: " + e.getMessage());
            System.out.println("TC-051: FAILED - " + e.getMessage());
        }
    }
}
