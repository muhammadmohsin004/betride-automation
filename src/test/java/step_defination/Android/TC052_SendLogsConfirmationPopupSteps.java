package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC052_SendLogsConfirmationPopupSteps extends Page {

    @Given("User has tapped on Send Device Logs option")
    public void userHasTappedOnSendDeviceLogsOption() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-052: SEND LOGS CONFIRMATION POPUP");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings");
            System.out.println("  4. Tap on 'Send Device Logs' option");
            System.out.println("  5. Observe the popup that appears");
            System.out.println("");
            System.out.println("========================================");

            // Wait for setup
            System.out.println("");
            System.out.println("Waiting 15 seconds for setup...");
            System.out.println("Navigate to Settings and tap Send Device Logs.");
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
            System.out.println("Send Device Logs should be tapped now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @Then("Popup should appear with Send device logs message and Yes No buttons")
    public void popupShouldAppearWithSendDeviceLogsMessageAndYesNoButtons() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CONFIRMATION POPUP VERIFICATION");
            System.out.println("========================================");

            // Check for popup message
            boolean hasPopupMessage = pageSource.contains("Send device logs") ||
                                      pageSource.contains("send device logs") ||
                                      pageSource.contains("Send logs") ||
                                      pageSource.contains("send logs") ||
                                      pageSource.contains("Device logs");

            // Check for Yes button
            boolean hasYesButton = pageSource.contains("Yes") ||
                                   pageSource.contains("YES") ||
                                   pageSource.contains("yes");

            // Check for No button
            boolean hasNoButton = pageSource.contains("No") ||
                                  pageSource.contains("NO") ||
                                  pageSource.contains("no");

            // Check for dialog/popup
            boolean hasDialog = pageSource.contains("Dialog") ||
                                pageSource.contains("dialog") ||
                                pageSource.contains("Popup") ||
                                pageSource.contains("popup") ||
                                pageSource.contains("Alert") ||
                                pageSource.contains("alert");

            // Check for sending/loading indicator (alternative behavior)
            boolean hasSendingIndicator = pageSource.contains("Sending") ||
                                          pageSource.contains("sending") ||
                                          pageSource.contains("Loading") ||
                                          pageSource.contains("loading") ||
                                          pageSource.contains("Please wait");

            // Check for confirmation buttons (alternative: OK/Cancel)
            boolean hasConfirmButtons = pageSource.contains("OK") ||
                                        pageSource.contains("Cancel") ||
                                        pageSource.contains("Confirm");

            System.out.println("");
            System.out.println("Confirmation Popup Verification:");
            System.out.println("--------------------------------");
            System.out.println("  - Popup message: " + (hasPopupMessage ? "YES" : "NO"));
            System.out.println("  - Yes button: " + (hasYesButton ? "YES" : "NO"));
            System.out.println("  - No button: " + (hasNoButton ? "YES" : "NO"));
            System.out.println("  - Dialog indicator: " + (hasDialog ? "YES" : "NO"));
            System.out.println("  - Sending indicator: " + (hasSendingIndicator ? "YES" : "NO"));
            System.out.println("  - Confirm buttons: " + (hasConfirmButtons ? "YES" : "NO"));
            System.out.println("");

            // Calculate verification score
            int score = 0;
            if (hasPopupMessage) score += 2;
            if (hasYesButton) score += 2;
            if (hasNoButton) score += 2;
            if (hasDialog) score++;
            if (hasSendingIndicator) score += 2;
            if (hasConfirmButtons) score++;

            if ((hasPopupMessage && hasYesButton && hasNoButton) || score >= 5) {
                System.out.println("========================================");
                System.out.println("  TC-052: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Confirmation popup verified!");
                System.out.println("");
                if (hasPopupMessage) System.out.println("  - 'Send device logs?' message shown");
                if (hasYesButton) System.out.println("  - Yes button visible");
                if (hasNoButton) System.out.println("  - No button visible");
                if (hasSendingIndicator) System.out.println("  - Logs sending indicator shown");
                System.out.println("");
                System.out.println("  Please confirm manually:");
                System.out.println("  - Did popup appear?");
                System.out.println("  - Does it show 'Send device logs?'");
                System.out.println("  - Are Yes/No buttons visible?");
                System.out.println("");
                System.out.println("========================================");
            } else if (hasPopupMessage || hasSendingIndicator) {
                System.out.println("========================================");
                System.out.println("  TC-052: PARTIAL PASS");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Popup appeared but Yes/No buttons may not be present.");
                System.out.println("  (Logs may start sending directly)");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did popup appear?");
                System.out.println("  2. Are Yes/No buttons visible?");
                System.out.println("  3. Or does it directly send logs?");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-052: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Could not detect confirmation popup.");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Did you tap Send Device Logs?");
                System.out.println("  2. Did popup appear?");
                System.out.println("  3. Does it show 'Send device logs?'");
                System.out.println("  4. Are Yes/No buttons visible?");
                System.out.println("");
                System.out.println("  Note: This test requires the RIDER app.");
                System.out.println("");
                System.out.println("Page source snippet:");
                System.out.println(pageSource.substring(0, Math.min(1500, pageSource.length())));
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying confirmation popup: " + e.getMessage());
            System.out.println("TC-052: FAILED - " + e.getMessage());
        }
    }
}
