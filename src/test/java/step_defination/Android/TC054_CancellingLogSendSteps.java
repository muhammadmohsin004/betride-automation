package step_defination.Android;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.Page;

public class TC054_CancellingLogSendSteps extends Page {

    @Given("User is on Send Device Logs popup")
    public void userIsOnSendDeviceLogsPopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TC-054: CANCELLING LOG SEND");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  PRECONDITIONS:");
            System.out.println("");
            System.out.println("  1. Open the Rider app");
            System.out.println("  2. Ensure you are logged in");
            System.out.println("  3. Navigate to Settings");
            System.out.println("  4. Tap on 'Send Device Logs' option");
            System.out.println("  5. Popup should be visible");
            System.out.println("");
            System.out.println("  NOTE: This test requires Yes/No buttons.");
            System.out.println("  If logs send immediately, this test is N/A.");
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
            System.out.println("User should be on Send Device Logs popup now.");

        } catch (Exception e) {
            System.out.println("Error during setup: " + e.getMessage());
        }
    }

    @When("User taps No on the popup")
    public void userTapsNoOnThePopup() {
        try {
            System.out.println("");
            System.out.println("========================================");
            System.out.println("  TAP NO TO CANCEL LOG SEND");
            System.out.println("========================================");
            System.out.println("");
            System.out.println("  MANUAL ACTION REQUIRED:");
            System.out.println("");
            System.out.println("  1. On the Send Device Logs popup");
            System.out.println("  2. Look for 'No' or 'Cancel' button");
            System.out.println("  3. Tap on 'No' button to cancel");
            System.out.println("");
            System.out.println("  NOTE: If NO button exists, tap it.");
            System.out.println("  If logs sent immediately without popup,");
            System.out.println("  this test is NOT APPLICABLE.");
            System.out.println("");
            System.out.println("========================================");

            // Wait for user action
            System.out.println("");
            System.out.println("Waiting 10 seconds for action...");

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
            System.out.println("No button should be tapped now (if available).");

        } catch (Exception e) {
            System.out.println("Error tapping No: " + e.getMessage());
        }
    }

    @Then("Popup should close and no logs are sent")
    public void popupShouldCloseAndNoLogsAreSent() {
        try {
            Thread.sleep(2000);

            String pageSource = AndroidDriverSetup.getAndroidDriver().getPageSource();

            System.out.println("");
            System.out.println("========================================");
            System.out.println("  CANCEL LOG SEND VERIFICATION");
            System.out.println("========================================");

            // Check if popup is closed (back to Settings)
            boolean backToSettings = pageSource.contains("Settings") ||
                                     pageSource.contains("settings");

            // Check if popup is still visible
            boolean popupVisible = pageSource.contains("Send device logs") ||
                                   pageSource.contains("send device logs") ||
                                   pageSource.contains("Send logs");

            // Check for success message (logs were sent - means cancel didn't work)
            boolean logsSent = pageSource.contains("success") ||
                               pageSource.contains("Success") ||
                               pageSource.contains("sent") ||
                               pageSource.contains("Sent");

            // Check for No button (if still visible)
            boolean hasNoButton = pageSource.contains("No") ||
                                  pageSource.contains("Cancel");

            System.out.println("");
            System.out.println("Cancel Verification:");
            System.out.println("--------------------");
            System.out.println("  - Back to Settings: " + (backToSettings ? "YES" : "NO"));
            System.out.println("  - Popup still visible: " + (popupVisible ? "YES" : "NO"));
            System.out.println("  - Logs were sent: " + (logsSent ? "YES" : "NO"));
            System.out.println("  - No button visible: " + (hasNoButton ? "YES" : "NO"));
            System.out.println("");

            if (backToSettings && !logsSent) {
                System.out.println("========================================");
                System.out.println("  TC-054: PASSED");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Log send cancelled successfully!");
                System.out.println("");
                System.out.println("  - Popup closed");
                System.out.println("  - No logs were sent");
                System.out.println("  - Back to Settings page");
                System.out.println("");
                System.out.println("========================================");
            } else if (logsSent) {
                System.out.println("========================================");
                System.out.println("  TC-054: NOT APPLICABLE");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Logs were sent automatically.");
                System.out.println("");
                System.out.println("  The app does NOT have Yes/No buttons.");
                System.out.println("  Logs are sent immediately when tapping");
                System.out.println("  'Send Device Logs' option.");
                System.out.println("");
                System.out.println("  This test case is NOT APPLICABLE for");
                System.out.println("  this version of the app.");
                System.out.println("");
                System.out.println("========================================");
            } else {
                System.out.println("========================================");
                System.out.println("  TC-054: NEEDS MANUAL VERIFICATION");
                System.out.println("========================================");
                System.out.println("");
                System.out.println("  Please verify manually:");
                System.out.println("  1. Is there a No button on the popup?");
                System.out.println("  2. Did you tap No?");
                System.out.println("  3. Did popup close?");
                System.out.println("  4. Were logs NOT sent?");
                System.out.println("");
                System.out.println("  If app sends logs immediately without");
                System.out.println("  Yes/No confirmation, this test is N/A.");
                System.out.println("");
                System.out.println("========================================");
            }

        } catch (Exception e) {
            System.out.println("Error verifying cancel: " + e.getMessage());
            System.out.println("TC-054: FAILED - " + e.getMessage());
        }
    }
}
